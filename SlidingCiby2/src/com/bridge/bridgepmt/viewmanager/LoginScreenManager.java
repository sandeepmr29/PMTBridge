package com.bridge.bridgepmt.viewmanager;

import android.content.Context;
import android.util.Log;
import android.view.View.OnClickListener;

import com.bridge.bridgepmt.interfaces.LoginScreenManagerForgotListner;
import com.bridge.bridgepmt.interfaces.LoginScreenManagerListner;
import com.bridge.bridgepmt.interfaces.LoginScreenModelManagerListner;
import com.bridge.bridgepmt.interfaces.LoginScreenmodelManagerForgotListner;
import com.bridge.bridgepmt.model.ForgotScreenReturn;
import com.bridge.bridgepmt.model.User;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.modelmanager.LoginScreenModelManager;



public class LoginScreenManager implements LoginScreenModelManagerListner ,LoginScreenmodelManagerForgotListner
{
	public LoginScreenManagerListner iLoginScreenManagerListner;
	public LoginScreenManagerForgotListner iLoginScreenManagerForgotListner;
//	 private String userName;
//	 private String passWord;
//	 private String Email;
	
  public  LoginScreenManager()
  {
//	  userName=username;
//	  passWord=password;
//	  this.iLoginScreenManagerListner=loginScreenManagerListner;
		
  }
   
//  public LoginScreenManager(String email) 
//  {
////	  Email=email;
//  }

public void loginUser(Context mContext,String username, String password)
	{
		LoginScreenModelManager loginScreenModelManager = new LoginScreenModelManager();
		loginScreenModelManager.iLoginScreenModelManageListner=LoginScreenManager.this;
		loginScreenModelManager.loginProcess(mContext,username,password);
	
	}

public void forgotPassword(Context mContext,String email)
{
	LoginScreenModelManager loginScreenModelManager = new LoginScreenModelManager();
	loginScreenModelManager.iLoginScreenmodelManagerForgotListner=LoginScreenManager.this;
	loginScreenModelManager.ForgotPasswordProcess(mContext,email);

}

@Override
public void onDidFinished(LoginScreenReturn loginDetails) 
{
	iLoginScreenManagerListner.onDidFinished(loginDetails);	
	
}

@Override
public void onDidFinished(ForgotScreenReturn forgotScreenReturn) 
{
	iLoginScreenManagerForgotListner.onDidFinished(forgotScreenReturn);
	
}







}
