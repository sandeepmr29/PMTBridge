package com.bridge.bridgepmt.fragments;


import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebIconDatabase.IconListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.ListAdapter;
import com.bridge.bridgepmt.interfaces.ListOfProjectsManagerListner;
import com.bridge.bridgepmt.model.ListOfProjectScreenReturns;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.bridge.bridgepmt.viewmanager.ListOfProjectsManager;


public class ListOfProjectsFragments extends Fragment implements ListOfProjectsManagerListner
{
	 ListView listView;
	 /**declaring the object of list Adapter class  */
		private ListAdapter mListAdapter;
//	 ProjectDetails projectDetails; 
	 Context  mContext;
	 ArrayList<ProjectDetails> projectdetails;
	 String ifGetRequest ="get";
	
	 public ListOfProjectsFragments() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_projectlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        
	        
	        return view;
	    }

	 
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			
			loadList();
			
			

			
	 }

	 
	private void loadList() 
	{

		 ListOfProjectsManager listOfProjectsManager = new ListOfProjectsManager();
		 listOfProjectsManager.IListOfProjectsManagerListner=ListOfProjectsFragments.this;
		 listOfProjectsManager.projectList(mContext,ifGetRequest);
		
	}

	@Override
	 public void onDidFinished(ListOfProjectScreenReturns Projectdetails) {
	  // TODO Auto-generated method stub
	  Log.e("id",Projectdetails.getStatus());
	  projectdetails=Projectdetails.getProjects();
	  if(projectdetails!=null)
	  {
	   mListAdapter = new ListAdapter(getActivity(),
	        R.layout.projectlistrw, projectdetails, getActivity());
	  
	  listView.setAdapter(mListAdapter);
	  }
	  
	  
	 }
	
	
	

}
