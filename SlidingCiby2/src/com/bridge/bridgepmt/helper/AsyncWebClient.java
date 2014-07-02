package com.bridge.bridgepmt.helper;





import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;

import com.bridge.bridgepmt.utilities.SMConstants;
import com.bridge.bridgepmt.utilities.SMUtility;


import android.os.AsyncTask;
import android.util.Log;


//public class AsyncWebClient extends AsyncTask<String, Void, String> {
//
//	private AsyncWebHandler httpWebHandler;
//	public AsyncWebClient(AsyncWebHandler httpWebHandler){
//		this.httpWebHandler = httpWebHandler;
//		
////		Listner interfaceclass;
//		
//	}
//
//
//	@Override
//	protected String doInBackground(String... arg0) {
//		InputStream inputStream = null;
//		String result = "";
//////		ArrayList<LocationDetailsInfo>details;
//		try {
//			// create HttpClient
//			HttpClient httpclient = new DefaultHttpClient();
//
//			// make the http request
//			HttpResponse httpResponse = httpclient.execute(httpWebHandler.postHttpRequestMethod());
//
//			// receive response as inputStream
//			inputStream = httpResponse.getEntity().getContent();
//
//			// convert inputstream to string
//			if(inputStream != null)
//			{
//				result = convertInputStreamToString(inputStream);
//
//				Log.e("result",result);
//			}
//			
//	
//			
//			else
//				result = "Did not work!";
//
//		} catch (Exception e) {
//			Log.e("Network Call", "Error");
//		}
//
//		return result;
//	}
//	@Override
//	protected void onPostExecute(String result) {
//		httpWebHandler.onResponse(result);
////		interfaceclass.onDidFinish(details);
//	}
//
//	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
//	        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
//	        String line = "";
//	        String result = "";
//	        while((line = bufferedReader.readLine()) != null)
//	            result += line;
//
//	        inputStream.close();
//	        return result;
//
//	    }
//}

public class AsyncWebClient extends AsyncTask<String, Void, String> {
	


	private AsyncWebHandler httpWebHandler;
	
	public AsyncWebClient(AsyncWebHandler httpWebHandler){
		this.httpWebHandler = httpWebHandler;	
	}
	

	
	@Override
	protected String doInBackground(String... params) 
	{
		InputStream is = null;

		 HttpClient httpclient = new DefaultHttpClient();
		 
		 try 
		 {
			 
			HttpResponse httpResponse = httpclient.execute(httpWebHandler.postHttpRequestMethod());
		    HttpEntity entity = httpResponse.getEntity();
		    

		    
		    
		    is = entity.getContent();
	        String contentAsString = getString(is);
	        Log.e("response", contentAsString);
	        
	        return contentAsString;
	        



			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
			 return null;
		 }

		
	}
	
	
	public static String getString(InputStream is) throws IOException
	 {
		  Writer writer = new StringWriter();
	         char[] buffer = new char[1024];
	         try {
	             Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	             int n;
	             while ((n = reader.read(buffer)) != -1) {
	                 writer.write(buffer, 0, n);
	             }
	         } finally {
	             is.close();
	         }

	         return writer.toString(); 

	

	}


	protected void onPostExecute(String contentAsString) {
		httpWebHandler.onResponse(contentAsString);

	}
	
	
	



}
