package com.bridge.bridgepmt.viewmanager;

import android.content.Context;

import com.bridge.bridgepmt.fragments.ListOfProjectsFragments;
import com.bridge.bridgepmt.interfaces.ListOfProjectsManagerListner;
import com.bridge.bridgepmt.interfaces.ListOfProjectsModelmanagerListner;
import com.bridge.bridgepmt.model.ListOfProjectScreenReturns;
import com.bridge.bridgepmt.modelmanager.ListOfProjectsModelManager;
import com.bridge.bridgepmt.modelmanager.LoginScreenModelManager;





public class ListOfProjectsManager implements ListOfProjectsModelmanagerListner
{
  public ListOfProjectsManagerListner IListOfProjectsManagerListner;
	
	public  ListOfProjectsManager()
	{
		
	}

	public void projectList(Context mContext, String ifGetRequest) 
	{

//		LoginScreenModelManager loginScreenModelManager = new LoginScreenModelManager();
//		loginScreenModelManager.iLoginScreenmodelManagerForgotListner=ListOfProjectsManager.this;
//		loginScreenModelManager.projectList(mContext);
		
//		
		 ListOfProjectsModelManager listOfProjectsModelManager = new ListOfProjectsModelManager();
		 listOfProjectsModelManager.IListOfProjectsModelmanagerListner=ListOfProjectsManager.this;
		 listOfProjectsModelManager.projectList(mContext,ifGetRequest);


		
	}

	@Override
	public void onDidFinished(ListOfProjectScreenReturns Projectdetails) 
	{
		IListOfProjectsManagerListner.onDidFinished(Projectdetails);
		
	}

}
