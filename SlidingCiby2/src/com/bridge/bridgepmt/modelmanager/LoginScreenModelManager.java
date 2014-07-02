package com.bridge.bridgepmt.modelmanager;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.helper.AsyncWebHandler;
import com.bridge.bridgepmt.interfaces.LoginScreenModelManagerListner;
import com.bridge.bridgepmt.model.User;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.google.gson.Gson;


public class LoginScreenModelManager 
{
	public LoginScreenModelManagerListner iLoginScreenModelManageListner;
	Context mcontext;
	 private String UserName;
	 private String PassWord;
	

	
	public LoginScreenModelManager(String userName, String passWord) 
	{
		UserName=userName;
		PassWord=passWord;
		
	}
	
	public void loginProcess(final Context mContext) 
	{
		
		Log.e("login process","Login process")
;		new AsyncWebHandler() {
			
			@Override
			public HttpUriRequest postHttpRequestMethod() 
			{
				Log.e("result","username" );
				
				HttpPost httppost = new HttpPost("http://10.0.0.113:8080/api/login");
					 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
					 nameValuePairs.add(new BasicNameValuePair("username",UserName));
			         nameValuePairs.add(new BasicNameValuePair("password",PassWord));
			         try {
						httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			         catch(Exception e)
			         {
			        	 Log.e("Error", "Error");
			         }


					
				

				return httppost;
			}
			
			@Override
			public void onResponse(String result) 
			{
				
				LoginScreenReturn  loginScreenReturn = null;
				
				Gson gson = new Gson();
				try
				{
					loginScreenReturn=gson.fromJson(result,LoginScreenReturn.class);
					Log.e("WAt","wat");
				}
				catch(Exception e)
				{
					Log.e("error", e.getMessage());
				}
				
				iLoginScreenModelManageListner.onDidFinished(loginScreenReturn);
				
			}
		}.execute();
		
		
	}

}
