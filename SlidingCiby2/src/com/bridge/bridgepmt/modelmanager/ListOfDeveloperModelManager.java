package com.bridge.bridgepmt.modelmanager;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.helper.AsyncWebHandlerForGetApi;
import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.interfaces.ListOfDevelopersModelManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.model.ListOfProjectScreenReturns;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.google.gson.Gson;

public class ListOfDeveloperModelManager
{
	public ListOfDeveloperManagerListner  iListOfDeveloManagerListner;
	 List<Developerdetails> developerDetails;
	 public  ListOfDeveloperModelManager()
		{
			
		}

	 public void  developerList(Context mContext, String ifGetRequest) 
		{
		
		 
		 new AsyncWebHandlerForGetApi() {

				@Override
				public HttpUriRequest getHttpRequestMethod() {
					
					
					HttpGet httpget = new HttpGet("http://10.0.0.113:8080/api/activedevelopers/"+Bridgepmt.getProjectid()+"/"
							+Bridgepmt.getClientid()+"/"+Bridgepmt.getAccessToken());
					return httpget;
					
				}

				@Override
				public void ongetResponse(String result) 
				{
					ListOfDeveloperScreenReturns listOfDeveloperScreenReturns = null;
					
					Gson gson = new Gson();
					  try {
						  listOfDeveloperScreenReturns=gson.fromJson(result, ListOfDeveloperScreenReturns.class);
//						 developerDetails= listOfDeveloperScreenReturns.getProjects();
						 
//						 IListOfProjectsModelmanagerListner.onDidFinished(listOfProjectScreenReturns);
                         iListOfDeveloManagerListner.developersListFinished(listOfDeveloperScreenReturns);
					  } catch (Exception ex) {
					   
					   Log.e("error", ex.getMessage());
					   
					  }
					
				}
				
			}.execute(ifGetRequest);
		}
		
	
	}
	

