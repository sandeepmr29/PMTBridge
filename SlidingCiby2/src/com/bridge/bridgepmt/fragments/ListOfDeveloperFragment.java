package com.bridge.bridgepmt.fragments;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.viewmanager.ListOfDeveloperManager;
import com.bridge.bridgepmt.viewmanager.ListOfProjectsManager;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListOfDeveloperFragment extends Fragment implements ListOfDeveloperManagerListner
{
	 ListView listView;
	 Context  mContext;
	 String ifGetRequest ="get";

	 public ListOfDeveloperFragment() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_developerlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        
	        
	        return view;
	    }
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			
			loadDevelopersList();
			
			

			
	 }

	private void loadDevelopersList() 
	{
		 ListOfDeveloperManager listOfDeveloperManager = new ListOfDeveloperManager();
		 listOfDeveloperManager.IListOfDeveloperManagerListner=ListOfDeveloperFragment.this;
		 listOfDeveloperManager.developers(mContext,ifGetRequest);
		
	}

}
