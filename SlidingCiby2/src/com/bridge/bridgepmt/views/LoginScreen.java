package com.bridge.bridgepmt.views;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.interfaces.LoginScreenManagerListner;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.viewmanager.LoginScreenManager;


import android.R.string;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;



public class LoginScreen extends Activity implements LoginScreenManagerListner
{
	/**declaring this class*/
	Context mContext;
	EditText metUsername;
	EditText metPassword;
	Button   mbtnlogin;
	
	
	
	
	
	
	/** On create for loading the UI  **/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        
        mContext=this;
        
        initActivityViews();
       
        
        
    }
    
    
    private void initActivityViews() 
    {
    	metUsername=(EditText)findViewById(R.id.etusername);
    	metPassword=(EditText)findViewById(R.id.etpassword);
    	mbtnlogin=(Button)findViewById(R.id.btnlogin);
    	
    	
    	mbtnlogin.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
			
				
				 /**  
		         * object of view manager and triggers the method in view manager to trigger 
		         * the service call.. 
		         * **/
		        LoginScreenManager loginScreenManager = new LoginScreenManager(metUsername.getText().toString(),metPassword.getText().toString(),LoginScreen.this);
		        loginScreenManager.iLoginScreenManagerListner=LoginScreen.this;
		        loginScreenManager.loginUser(mContext);
		        
		        
		        
				
			}
		});
		
	}



	@Override
	public void onDidFinished(LoginScreenReturn loginDetails) {
		
		String name =loginDetails.getUser().getName();
	    Log.e("Name", name);
	    
//	    if(loginDetails != null)
//	    {
//	    	 /** pass the latitude and longitude value through intent to GoogleMap.Class 
//             * via put extra
//             * */
//             Intent in = new Intent(getApplicationContext(), .class);
//             in.putExtra("KEY_LAT", lat);
//             in.putExtra("KEY_LONG", lng);
//             startActivity(in);
//	    }
	    
	    
	    
	}

}
