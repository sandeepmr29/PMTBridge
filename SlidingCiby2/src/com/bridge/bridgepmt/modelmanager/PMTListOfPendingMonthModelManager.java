package com.bridge.bridgepmt.modelmanager;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.helper.AsyncWebHandlerForGetApi;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.viewmanager.ListOfDeveloperManager;
import com.google.gson.Gson;

public class PMTListOfPendingMonthModelManager {

	 public PMTListOfPenMonthManagerListner IPMTListOfPenMonthManagerListner;
	 
	 public  PMTListOfPendingMonthModelManager()
		{
			
		}

	public void pendingMonth(Context mContext, String ifGetRequest) 
	{
		 new AsyncWebHandlerForGetApi() {

				@Override
				public HttpUriRequest getHttpRequestMethod() {
					HttpGet httpget = new HttpGet("http://10.0.0.113:8080/api/pendingmonths/1/2");
					return httpget;
					
				}

				@Override
				public void ongetResponse(String result) 
				{
					ListOfDeveloperScreenReturns listOfDeveloperScreenReturns = null;
					
					Gson gson = new Gson();
					  try {
						 
					  } catch (Exception ex) {
					   
					   Log.e("error", ex.getMessage());
					   
					  }
					
				}
				
			}.execute(ifGetRequest);
		
	}

}
