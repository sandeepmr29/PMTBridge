package com.bridge.bridgepmt.helper;

import java.io.UnsupportedEncodingException;

import org.apache.http.client.methods.HttpUriRequest;







public abstract class AsyncWebHandler 
{
	public abstract HttpUriRequest postHttpRequestMethod() throws UnsupportedEncodingException;
	 public abstract void onResponse(String result);
	 public void execute( String method){
	  new AsyncWebClient(this).execute(method);
	 }
	
	
	

}
