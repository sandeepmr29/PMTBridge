package com.bridge.bridgepmt.interfaces;

import com.bridge.bridgepmt.model.ForgotScreenReturn;
import com.bridge.bridgepmt.model.User;
import com.bridge.bridgepmt.model.LoginScreenReturn;

public interface LoginScreenModelManagerListner 
{
	void onDidFinished(LoginScreenReturn loginDetails);


}
