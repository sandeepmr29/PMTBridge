package com.bridge.bridgepmt.modelmanager;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.helper.AsyncWebHandlerForGetApi;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.model.PMTListOfPendingMonthScreenReturns;
import com.bridge.bridgepmt.model.PendingMonthdetails;
import com.google.gson.Gson;

public class PMTListOfPendingMonthModelManager {

	 public PMTListOfPenMonthManagerListner IPMTListOfPenMonthManagerListner;
	 List<PendingMonthdetails> pendingmonthDetails;
	 
	 public  PMTListOfPendingMonthModelManager()
		{
			
		}

	public void pendingMonth(Context mContext, String ifGetRequest) 
	{
		 new AsyncWebHandlerForGetApi() {

				@Override
				public HttpUriRequest getHttpRequestMethod() {
					HttpGet httpget = new HttpGet("http://10.0.0.113:8080/api/pendingmonths/"+Bridgepmt.getClientid()+"/"+Bridgepmt.getDeveloperid());
					return httpget;
					
				}

				@Override
				public void ongetResponse(String result) 
				{
					PMTListOfPendingMonthScreenReturns pMTListOfPendingMonthScreenReturns = null;
					
					Gson gson = new Gson();
					  try {
						  pMTListOfPendingMonthScreenReturns=gson.fromJson(result, PMTListOfPendingMonthScreenReturns.class);
//							 developerDetails= listOfDeveloperScreenReturns.getProjects();
							 
//							 IListOfProjectsModelmanagerListner.onDidFinished(listOfProjectScreenReturns);
						  IPMTListOfPenMonthManagerListner.pendingmonthListFinished(pMTListOfPendingMonthScreenReturns);
					  } catch (Exception ex) {
					   
					   Log.e("error", ex.getMessage());
					   
					  }
					
				}
				
			}.execute(ifGetRequest);
		
	}

}
