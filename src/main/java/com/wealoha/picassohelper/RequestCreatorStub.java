package com.wealoha.picassohelper;

import java.io.IOException;
import java.util.List;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso.Priority;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

/**
 * 
 * 
 * @author javamonk
 * @createTime 2015年7月17日 上午10:12:32
 */
public interface RequestCreatorStub {
	
	public RequestCreatorStub centerCrop();

	public RequestCreatorStub centerInside();

	public RequestCreatorStub config(Config config);

	public boolean equals(Object arg0);

	public RequestCreatorStub error(Drawable errorDrawable);

	public RequestCreatorStub error(int errorResId);

	public void fetch();

	public void fetch(Callback arg0);

	public RequestCreatorStub fit();

	public Bitmap get() throws IOException;

	public int hashCode();

	public void into(ImageView arg0, Callback arg1);

	public void into(ImageView target);

	public void into(RemoteViews remoteViews, int viewId, int notificationId,
			Notification notification);

	public void into(RemoteViews remoteViews, int viewId, int[] appWidgetIds);

	public void into(Target arg0);

	public RequestCreatorStub memoryPolicy(MemoryPolicy arg0,
			MemoryPolicy... arg1);

	public RequestCreatorStub networkPolicy(NetworkPolicy arg0,
			NetworkPolicy... arg1);

	public RequestCreatorStub noFade();

	public RequestCreatorStub noPlaceholder();

	public RequestCreatorStub onlyScaleDown();

	public RequestCreatorStub placeholder(Drawable placeholderDrawable);

	public RequestCreatorStub placeholder(int placeholderResId);

	public RequestCreatorStub priority(Priority priority);

	public RequestCreatorStub resize(int targetWidth, int targetHeight);

	public RequestCreatorStub resizeDimen(int targetWidthResId,
			int targetHeightResId);

	public RequestCreatorStub rotate(float degrees, float pivotX, float pivotY);

	public RequestCreatorStub rotate(float degrees);

	public RequestCreatorStub skipMemoryCache();

	public RequestCreatorStub stableKey(String stableKey);

	public RequestCreatorStub tag(Object tag);

	public String toString();

	public RequestCreatorStub transform(
			List<? extends Transformation> transformations);

	public RequestCreatorStub transform(Transformation transformation);

}
