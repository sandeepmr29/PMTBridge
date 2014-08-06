package com.bridge.bridgepmt.views;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.fragments.FragmentChangeActivity;
import com.bridge.bridgepmt.interfaces.LoginScreenManagerForgotListner;
import com.bridge.bridgepmt.interfaces.LoginScreenManagerListner;
import com.bridge.bridgepmt.model.ForgotScreenReturn;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.utilities.SMUtility;
import com.bridge.bridgepmt.viewmanager.LoginScreenManager;

import android.R.string;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class LoginScreen extends Activity implements LoginScreenManagerListner,LoginScreenManagerForgotListner
{
	/**declaring this class*/
	Context         mContext;
	EditText        metUsername;
	EditText        metPassword;
	TextView        mtvlogin;
	ProgressDialog  pd;
	TextView        mtvforgotpassword;
	String method = "post";
	
	/** On create for loading the UI  **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mContext=this;
   
        initActivityViews();
    
    }
    
    
    private void initActivityViews() 
    {
    	metUsername = (EditText)findViewById(R.id.etusername);
    	metPassword = (EditText)findViewById(R.id.etpassword);
    	mtvlogin   = (TextView)findViewById(R.id.tvlogin);
    	mtvforgotpassword = (TextView)findViewById(R.id.tvforgotpassword);
    	
    

    	 pd = new ProgressDialog(LoginScreen.this);
    		
			pd.setMessage("loading");
    	
    	
    	
    	mtvforgotpassword.setOnClickListener(new View.OnClickListener() 
    	{
			
			@Override
			public void onClick(View v)
			{
				  showForgotPasswordAlertDialog();

				
			}
		});
    	
    	
    	mtvlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
			   
				pd.show();
				pd.setContentView(R.layout.custom_prgressdailog);
				
				if(SMUtility.isCredentialsnull(LoginScreen.this, metUsername.getText().toString(), metPassword.getText().toString())==true)
				{
					if(SMUtility.isNetworkAvailable(LoginScreen.this)==true)
					{
				
						/**  
				         * object of view manager and triggers the method in view manager to trigger 
				         * the service call.. 
				         * **/
				        LoginScreenManager loginScreenManager = new LoginScreenManager();
				        loginScreenManager.iLoginScreenManagerListner=LoginScreen.this;
				        loginScreenManager.loginUser(mContext,metUsername.getText().toString(),metPassword.getText().toString(),method);						 
				        
					}
					else
					{
						SMUtility.buildAlertMessage(mContext, getResources().getString(R.string.NoInternetConnection));
						pd.dismiss();
					}
				
				}
				else
				{
					SMUtility.buildAlertMessage(mContext, getResources().getString(R.string.InvalidUsernameOrPassword));
					pd.dismiss();
				}
				
			}
			
		});
		
	}



	protected void showForgotPasswordAlertDialog() 
	{
		 final Dialog dialog = new Dialog(LoginScreen.this);
	       dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
	                        //tell the Dialog to use the dialog.xml as it's layout description
	                        dialog.setContentView(R.layout.forgotpassword_layout);
	               
	         
	                         TextView txt = (TextView) dialog.findViewById(R.id.textView1);
	                         final EditText meditTextDialogUserInput =(EditText) dialog.findViewById(R.id.editTextDialogUserInput);
	                  
	         
	                        Button dialogButton = (Button) dialog.findViewById(R.id.btn_reset);
	         
	                        dialogButton.setOnClickListener(new OnClickListener() {
	                            @Override
	                            public void onClick(View v) 
	                            {
//	                                dialog.dismiss();
	                            	pd.show();
	                            	pd.setContentView(R.layout.custom_prgressdailog);
	                            	
	                            	if(SMUtility.isEmail(LoginScreen.this, meditTextDialogUserInput.getText().toString())==true)
	                				{
	                            	/**  
	        				         * object of view manager and triggers the method in view manager to trigger 
	        				         * the service call.. 
	        				         * **/
	        				        LoginScreenManager loginScreenManager = new LoginScreenManager();
	        				        loginScreenManager.iLoginScreenManagerForgotListner=LoginScreen.this;
	        				        loginScreenManager.forgotPassword(mContext,meditTextDialogUserInput.getText().toString(),method);						 
	        				        
	                				}
	                            	else
	                				{
	                					SMUtility.buildAlertMessage(mContext, getResources().getString(R.string.EmailCannotBeNull));
	                					pd.dismiss();
	                				}
	                            	
	                            	
	                            }
	                        });
	         
	                        dialog.show();

		
	}


	@Override
	public void onDidFinished(LoginScreenReturn loginDetails) {
		
   
	    if(loginDetails != null)
	    {
	    	
	    		if(loginDetails.getStatus().equals("success"))
		    	{
	    			 Bridgepmt.setClientid(loginDetails.getUser().getId());
	    			 Bridgepmt.setAccessToken(loginDetails.getUser().getAccessToken());
		    		
		    		 Intent in = new Intent(getApplicationContext(), FragmentChangeActivity.class);
		             startActivity(in);
		             finish();
		    	}
		    	else
		    	{
		    		
		    		SMUtility.buildAlertMessage(mContext, getResources().getString(R.string.InvalidUsernameOrPassword));
					
		    	}
	    	}
	    	
	    	
	    	
	    	pd.dismiss();
            
	   
	
	    
	}


	@Override
	public void onDidFinished(ForgotScreenReturn forgotScreenReturn) 
	{
		 if(forgotScreenReturn != null)
		    {
			  if(forgotScreenReturn.getStatus() != null )
			  {
				  if(forgotScreenReturn.getStatus().equals("failure") )
			    	{
			    		 Toast.makeText(mContext,"fail", 
			    	                Toast.LENGTH_SHORT).show();
			    		 
			    	}
			  }
			    	 else
			    	 {
			    		 if(forgotScreenReturn.getForgot().getStatus().equals("success"))
				    	 {
				    		 Toast.makeText(mContext,"success", 
				    	                Toast.LENGTH_SHORT).show();
				    	 } 
			    	 }
			    	
		    	
		    }
		 pd.dismiss();
		
	}

}
