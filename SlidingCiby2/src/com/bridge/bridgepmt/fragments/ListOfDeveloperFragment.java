package com.bridge.bridgepmt.fragments;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.ListAdapter;
import com.bridge.bridgepmt.adapters.PMTDevelopersListAdapter;
import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.bridge.bridgepmt.viewmanager.ListOfDeveloperManager;

public class ListOfDeveloperFragment extends Fragment implements ListOfDeveloperManagerListner
{
	 ListView listView;
	 Context  mContext;
	 String ifGetRequest ="get";
		private PMTDevelopersListAdapter mListAdapter;
	 ArrayList<Developerdetails> developerdetails;
	 Bundle c;
	 String id;
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
	     c=getArguments();
         id=c.getString("id");
         Log.e("project id",id);
			loadDevelopersList();
			
			

			
	 }

	private void loadDevelopersList() 
	{
		 ListOfDeveloperManager listOfDeveloperManager = new ListOfDeveloperManager();
		 listOfDeveloperManager.IListOfDeveloperManagerListner=ListOfDeveloperFragment.this;
		 listOfDeveloperManager.developers(mContext,ifGetRequest);
		
	}

	@Override
	public void developersListFinished(
			ListOfDeveloperScreenReturns mListofDevelopers) {
		// TODO Auto-generated method stub
		Log.e("ststaus",mListofDevelopers.getStatus());
		
		
		  developerdetails=mListofDevelopers.getDevelopers();
		  if(developerdetails!=null)
		  {
		   mListAdapter = new PMTDevelopersListAdapter(getActivity(),
		        R.layout.developerlistrw, developerdetails, getActivity());
		  
		  listView.setAdapter(mListAdapter);
	}
	}


}
