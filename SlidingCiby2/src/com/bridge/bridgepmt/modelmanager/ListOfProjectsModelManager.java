package com.bridge.bridgepmt.modelmanager;

import java.util.List;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

import android.content.Context;
import android.util.Log;

import com.bridge.bridgepmt.helper.AsyncWebHandlerForGetApi;
import com.bridge.bridgepmt.interfaces.ListOfProjectsModelmanagerListner;
import com.bridge.bridgepmt.model.ListOfProjectScreenReturns;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.google.gson.Gson;

public class ListOfProjectsModelManager 
{
	 public ListOfProjectsModelmanagerListner IListOfProjectsModelmanagerListner;
	 List<ProjectDetails> projectDetails;
	 public  ListOfProjectsModelManager()
		{
			
		}

	public void projectList(Context mContext, String ifGetRequest)
	{
		new AsyncWebHandlerForGetApi() {
			
			@Override
			public void ongetResponse(String result) 
			{
				ListOfProjectScreenReturns listOfProjectScreenReturns = null;
				
				 /**Convert it to gson */
				Gson gson = new Gson();
				  try {
					  listOfProjectScreenReturns=gson.fromJson(result, ListOfProjectScreenReturns.class);
					 projectDetails= listOfProjectScreenReturns.getProjects();
					 
					 IListOfProjectsModelmanagerListner.onDidFinished(listOfProjectScreenReturns);

				  } catch (Exception ex) {
				   
				   Log.e("error", ex.getMessage());
				   
				  }
			}
			
			@Override
			public HttpUriRequest getHttpRequestMethod() {
				HttpGet httpget = new HttpGet("http://10.0.0.113:8080/api/activeprojects/745");
				return httpget;
			}
//			IListOfProjectsModelmanagerListner.onDidFinished(projectDetails);


		}.execute(ifGetRequest);
		

	}

}
