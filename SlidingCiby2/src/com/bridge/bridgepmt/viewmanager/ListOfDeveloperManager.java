package com.bridge.bridgepmt.viewmanager;

import android.content.Context;

import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.interfaces.ListOfDevelopersModelManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.modelmanager.ListOfDeveloperModelManager;
import com.bridge.bridgepmt.modelmanager.ListOfProjectsModelManager;


public class ListOfDeveloperManager implements ListOfDeveloperManagerListner
{
	 public ListOfDeveloperManagerListner IListOfDeveloperManagerListner;
	 
	 public  ListOfDeveloperManager()
		{
			
		}

	public void developers(Context mContext, String ifGetRequest) 
	{
//		
		 ListOfDeveloperModelManager listOfDeveloperModelManager = new ListOfDeveloperModelManager();
		 listOfDeveloperModelManager.iListOfDeveloManagerListner=ListOfDeveloperManager.this;
		 listOfDeveloperModelManager.developerList(mContext,ifGetRequest);

	}

	@Override
	public void developersListFinished(
			ListOfDeveloperScreenReturns mListofDevelopers) {
		// TODO Auto-generated method stub
		IListOfDeveloperManagerListner.developersListFinished(mListofDevelopers);
	}



}
