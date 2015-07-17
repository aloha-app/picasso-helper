package com.wealoha.picassohelper;

import android.app.DownloadManager;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * Helper class for Picasso, support Mirrors url
 * Created by javamonk on 15-7-16.
 */
public class PicassoHelper {

    private final Picasso picasso;

    public PicassoHelper(Picasso picasso) {
        this.picasso = picasso;
        Timber.tag("PicassoHelper");
    }

    /**
     * Use returned {@link RequestCreatorStub} as usual.
     * The {@link RequestCreatorStub#into(ImageView)} will auto retry mirrors url when fail.
     *
     * @param stableKey cache key for url and mirrors
     * @param url
     * @param mirrors can be null/empty
     * @return
     */
    public RequestCreatorStub load(final String stableKey, String url, List<String> mirrors) {
        RequestCreator creator =  picasso.load(url) //
                .stableKey(stableKey);
        final RequestCreatorDelegate delegate = new RequestCreatorDelegate(creator);
        if (mirrors == null || mirrors.size() == 0) {
            // no mirrors, no retry need
			return  delegate;
        }
        final List<String> mirrorsCopy = new ArrayList<>(mirrors);
        // method and args called for picasso
        final List<Method> methodsList = new ArrayList<>();
        final List<Object[]> argsList = new ArrayList<>();
        return (RequestCreatorStub) Proxy.newProxyInstance(getClass().getClassLoader(), //
        		new Class[]{ RequestCreatorStub.class }, //
                new InvocationHandler(){

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        Timber.d("record method and args: %s", method.getName());
                        methodsList.add(method);
                        argsList.add(args);

                        if ("into".equals(method.getName()) && args != null && args.length == 1 && args[0].getClass().equals(ImageView.class)) {
                            // hack into(ImageView)
                            Timber.d("proxy into(ImageView) call");
                            Callback cb = new Callback() {

                                @Override
                                public void onSuccess() {

                                }

                                @Override
                                public void onError() {
                                    reloadNextUrl(stableKey, mirrorsCopy, methodsList, argsList);
                                }
                            };
                            // find in Delegate for same method with extra param
                            Method m = RequestCreatorDelegate.class.getMethod("into", ImageView.class, Callback.class);
                            return m.invoke(delegate, new Object[] { args[0], cb });
                        }
                    	// Method m = RequestCreatorDelegate.class.getMethod(method.getName(), method.getParameterTypes());
                        return method.invoke(delegate, args);
                    }
                });
    }

    private void reloadNextUrl(final String stableKey, final List<String> mirrors, final List<Method> methodsList, final List<Object[]> argsList) {
        if (mirrors.size() == 0) {
            // no more mirrors to try
            return;
        }
        String nextUrl = mirrors.remove(0);
        RequestCreator creator = picasso.load(Uri.parse(nextUrl)).stableKey(stableKey);

       final RequestCreatorDelegate delegate = new RequestCreatorDelegate(creator);

        try {
            for (int i = 0; i < methodsList.size(); i++) {
                Method method = methodsList.get(i);
                Object[] args = argsList.get(i);
                if ("into".equals(method.getName()) && args != null && args.length == 1 && args[0].getClass().equals(ImageView.class)) {
                    // hack into(ImageView)
                    Timber.d("proxy into(ImageView) call");

                    Callback cb = new Callback() {

                        @Override
                        public void onSuccess() {

                        }

                        @Override
                        public void onError() {
                            reloadNextUrl(stableKey, mirrors, methodsList, argsList);
                        }
                    };
                    Method m = RequestCreatorDelegate.class.getMethod("into", ImageView.class, Callback.class);
                    m.invoke(delegate, new Object[] { args[0], cb });
                } else {
                	// Method m = RequestCreatorDelegate.class.getMethod(method.getName(), method.getParameterTypes());
                    method.invoke(delegate, args);
                }
            }
        } catch (NoSuchMethodException e) {
        	Timber.w(e, "method invocation fail");
        } catch (IllegalAccessException e) {
            Timber.w(e, "method invocation fail");
        } catch (InvocationTargetException e) {
            Timber.w(e, "method invocation fail");
        }
    }
}
