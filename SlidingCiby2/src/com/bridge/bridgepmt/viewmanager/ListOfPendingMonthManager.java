package com.bridge.bridgepmt.viewmanager;

import android.content.Context;

import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.model.PMTListOfPendingMonthScreenReturns;
import com.bridge.bridgepmt.modelmanager.PMTListOfPendingMonthModelManager;

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


	@Override
	public void pendingmonthListFinished(
			PMTListOfPendingMonthScreenReturns pMTListOfPendingMonthScreenReturns) 
	{
		IPMTListOfPenMonthManagerListner.pendingmonthListFinished(pMTListOfPendingMonthScreenReturns);
		
	}

}
