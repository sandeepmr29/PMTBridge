package com.bridge.bridgepmt.viewmanager;

import android.content.Context;

import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.interfaces.ListOfDevelopersModelManagerListner;
import com.bridge.bridgepmt.modelmanager.ListOfDeveloperModelManager;
import com.bridge.bridgepmt.modelmanager.ListOfProjectsModelManager;


public class ListOfDeveloperManager implements ListOfDevelopersModelManagerListner
{
	 public ListOfDeveloperManagerListner IListOfDeveloperManagerListner;
	 
	 public  ListOfDeveloperManager()
		{
			
		}

	public void developers(Context mContext, String ifGetRequest) 
	{
//		
		 ListOfDeveloperModelManager listOfDeveloperModelManager = new ListOfDeveloperModelManager();
		 listOfDeveloperModelManager.IListOfDevelopersModelManagerListner=ListOfDeveloperManager.this;
		 listOfDeveloperModelManager.projectList(mContext,ifGetRequest);

	}

}
