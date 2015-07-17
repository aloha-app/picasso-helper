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
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Target;
import com.squareup.picasso.Transformation;

/**
 * A delegate class for {@link RequestCreator}
 * 
 * @author javamonk
 * @createTime 2015年7月17日 上午10:48:15
 */
public class RequestCreatorDelegate implements RequestCreatorStub {

	private final RequestCreator delegate;
	public RequestCreatorDelegate(RequestCreator requestCreator) {
		this.delegate = requestCreator;
	}
	public RequestCreatorStub centerCrop() {
		delegate.centerCrop();
		return this;
	}
	public RequestCreatorStub centerInside() {
		delegate.centerInside();
		return this;
	}
	public RequestCreatorDelegate config(Config config) {
		delegate.config(config);
		return this;
	}
	public boolean equals(Object obj) {
		return delegate.equals(obj);
	}
	public RequestCreatorDelegate error(Drawable errorDrawable) {
		delegate.error(errorDrawable);
		return this;
	}
	public RequestCreatorDelegate error(int errorResId) {
		delegate.error(errorResId);
		return this;
	}
	public void fetch() {
		delegate.fetch();
	}
	public void fetch(Callback arg0) {
		delegate.fetch(arg0);
	}
	public RequestCreatorStub fit() {
		delegate.fit();
		return this;
	}
	public Bitmap get() throws IOException {
		return delegate.get();
	}
	public int hashCode() {
		return delegate.hashCode();
	}
	public void into(ImageView arg0, Callback arg1) {
		delegate.into(arg0, arg1);
	}
	public void into(ImageView target) {
		delegate.into(target);
	}
	public void into(RemoteViews remoteViews, int viewId, int notificationId,
			Notification notification) {
		delegate.into(remoteViews, viewId, notificationId, notification);
	}
	public void into(RemoteViews remoteViews, int viewId, int[] appWidgetIds) {
		delegate.into(remoteViews, viewId, appWidgetIds);
	}
	public void into(Target arg0) {
		delegate.into(arg0);
	}
	public RequestCreatorStub memoryPolicy(MemoryPolicy arg0, MemoryPolicy... arg1) {
		delegate.memoryPolicy(arg0, arg1);
		return this;
	}
	public RequestCreatorStub networkPolicy(NetworkPolicy arg0,
			NetworkPolicy... arg1) {
		delegate.networkPolicy(arg0, arg1);
		return this;
	}
	public RequestCreatorStub noFade() {
		delegate.noFade();
		return this;
	}
	public RequestCreatorStub noPlaceholder() {
		delegate.noPlaceholder();
		return this;
	}
	public RequestCreatorStub onlyScaleDown() {
		delegate.onlyScaleDown();
		return this;
	}
	public RequestCreatorStub placeholder(Drawable placeholderDrawable) {
		delegate.placeholder(placeholderDrawable);
		return this;
	}
	public RequestCreatorStub placeholder(int placeholderResId) {
		delegate.placeholder(placeholderResId);
		return this;
	}
	public RequestCreatorStub priority(Priority priority) {
		delegate.priority(priority);
		return this;
	}
	public RequestCreatorStub resize(int targetWidth, int targetHeight) {
		delegate.resize(targetWidth, targetHeight);
		return this;
	}
	public RequestCreatorStub resizeDimen(int targetWidthResId,
			int targetHeightResId) {
		delegate.resizeDimen(targetWidthResId, targetHeightResId);
		return this;
	}
	public RequestCreatorStub rotate(float degrees, float pivotX, float pivotY) {
		delegate.rotate(degrees, pivotX, pivotY);
		return this;
	}
	public RequestCreatorStub rotate(float degrees) {
		delegate.rotate(degrees);
		return this;
	}
	public RequestCreatorStub skipMemoryCache() {
		delegate.skipMemoryCache();
		return this;
	}
	public RequestCreatorStub stableKey(String stableKey) {
		delegate.stableKey(stableKey);
		return this;
	}
	public RequestCreatorStub tag(Object tag) {
		delegate.tag(tag);
		return this;
	}
	public String toString() {
		return delegate.toString();
	}
	public RequestCreatorStub transform(
			List<? extends Transformation> transformations) {
		delegate.transform(transformations);
		return this;
	}
	public RequestCreatorStub transform(Transformation transformation) {
		delegate.transform(transformation);
		return this;
	}
	
}
