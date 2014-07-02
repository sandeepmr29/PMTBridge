package com.bridge.bridgepmt.helper;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpUriRequest;





public abstract class AsyncWebHandler 
{
	public abstract HttpUriRequest postHttpRequestMethod() throws UnsupportedEncodingException;
	public abstract void onResponse(String result);
	public void execute(){
		new AsyncWebClient(this).execute();
	}

	
//	public abstract HttpUriRequest getHttpRequestMethod();
//	public abstract void onResponse(String result);
//	public void execute(){
//		new AsyncWebClient(this).execute();
//	}
}
