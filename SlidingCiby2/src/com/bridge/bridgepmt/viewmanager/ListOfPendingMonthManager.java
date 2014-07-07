package com.bridge.bridgepmt.viewmanager;

import com.bridge.bridgepmt.interfaces.ListOfProjectsManagerListner;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.modelmanager.ListOfDeveloperModelManager;
import com.bridge.bridgepmt.modelmanager.PMTListOfPendingMonthModelManager;

import android.content.Context;

public class ListOfPendingMonthManager implements PMTListOfPenMonthManagerListner{
	 public PMTListOfPenMonthManagerListner IPMTListOfPenMonthManagerListner;

	 public  ListOfPendingMonthManager()
		{
			
		}

	
	public void pendingMonth(Context mContext, String ifGetRequest) 
	{
		 PMTListOfPendingMonthModelManager pMTListOfPendingMonthModelManager = new PMTListOfPendingMonthModelManager();
		 pMTListOfPendingMonthModelManager.IPMTListOfPenMonthManagerListner=ListOfPendingMonthManager.this;
		 pMTListOfPendingMonthModelManager.pendingMonth(mContext,ifGetRequest);
		
	}

}
