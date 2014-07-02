package com.bridge.bridgepmt.viewmanager;

import android.content.Context;
import android.util.Log;
import android.view.View.OnClickListener;

import com.bridge.bridgepmt.interfaces.LoginScreenManagerListner;
import com.bridge.bridgepmt.interfaces.LoginScreenModelManagerListner;
import com.bridge.bridgepmt.model.User;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.modelmanager.LoginScreenModelManager;



public class LoginScreenManager implements LoginScreenModelManagerListner
{
	public LoginScreenManagerListner iLoginScreenManagerListner;
	 private String userName;
	 private String passWord;
	
  public  LoginScreenManager(String username, String password,LoginScreenManagerListner loginScreenManagerListner)
  {
	  userName=username;
	  passWord=password;
	  this.iLoginScreenManagerListner=loginScreenManagerListner;
		
  }
  
  
  public void loginUser(Context mContext)
	{
		LoginScreenModelManager loginScreenModelManager = new LoginScreenModelManager(userName,passWord);
		loginScreenModelManager.iLoginScreenModelManageListner=LoginScreenManager.this;
		loginScreenModelManager.loginProcess(mContext);
	
	}


@Override
public void onDidFinished(LoginScreenReturn loginDetails) 
{
	String name =loginDetails.getUser().getName();
	Log.e("ans", name);
	
	iLoginScreenManagerListner.onDidFinished(loginDetails);	
	
}







}
