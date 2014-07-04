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
import com.bridge.bridgepmt.interfaces.ListOfProjectsModelmanagerListner;
import com.bridge.bridgepmt.interfaces.LoginScreenModelManagerListner;
import com.bridge.bridgepmt.interfaces.LoginScreenmodelManagerForgotListner;
import com.bridge.bridgepmt.model.ForgotScreenReturn;
import com.bridge.bridgepmt.model.User;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.google.gson.Gson;


public class LoginScreenModelManager 
{
	public LoginScreenModelManagerListner iLoginScreenModelManageListner;
	public LoginScreenmodelManagerForgotListner iLoginScreenmodelManagerForgotListner;
	 public ListOfProjectsModelmanagerListner IListOfProjectsModelmanagerListner;
	
	Context mcontext;
//	 private String UserName;
//	 private String PassWord;
//	 private String Email;
	

	
	public LoginScreenModelManager() 
	{
//		UserName=userName;
//		PassWord=passWord;
		
	}
	
//	public LoginScreenModelManager(String email2) 
//	{
//		Email=email2;
//
//	}

	public void loginProcess(final Context mContext,final String username, final String password) 
	{
		
		Log.e("login process","Login process");		
		new AsyncWebHandler() {
			
			@Override
			public HttpUriRequest postHttpRequestMethod() 
			{
				Log.e("result","username" );
				
				HttpPost httppost = new HttpPost("http://10.0.0.113:8080/api/login");
					 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
					 nameValuePairs.add(new BasicNameValuePair("username",username));
			         nameValuePairs.add(new BasicNameValuePair("password",password));
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
	
	public void ForgotPasswordProcess(final Context mContext,final String email) 
	{
		new AsyncWebHandler() 
		{

			@Override
			public HttpUriRequest postHttpRequestMethod()
					throws UnsupportedEncodingException 
					{
				
				HttpPost httppost = new HttpPost("http://10.0.0.113:8080/api/forgotPassword");
				 List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
				 nameValuePairs.add(new BasicNameValuePair("email",email));
				
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
				Log.e("forgotpassword",result);
				ForgotScreenReturn  forgotScreenReturn = null;
				
				Gson gson = new Gson();
				try
				{
					forgotScreenReturn=gson.fromJson(result,ForgotScreenReturn.class);
					Log.e("WAt","wat");
				}
				catch(Exception e)
				{
					Log.e("error", e.getMessage());
				}
				
				iLoginScreenmodelManagerForgotListner.onDidFinished(forgotScreenReturn);
				
				
			}
			
		}.execute();
		
		
	}

	
	

}
