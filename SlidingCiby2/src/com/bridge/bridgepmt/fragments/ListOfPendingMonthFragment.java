package com.bridge.bridgepmt.fragments;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.viewmanager.ListOfPendingMonthManager;
import com.bridge.bridgepmt.viewmanager.ListOfProjectsManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class ListOfPendingMonthFragment extends Fragment implements PMTListOfPenMonthManagerListner
{
	 ListView listView;
	 Context  mContext;
	 String ifGetRequest ="get";
	 
	 public ListOfPendingMonthFragment() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_pendingmonthlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
//	        pd = new ProgressDialog(getActivity());
//			pd.setMessage("loading");
	        
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
		ListOfPendingMonthManager listOfPendingMonthManager = new ListOfPendingMonthManager();
		listOfPendingMonthManager.IPMTListOfPenMonthManagerListner=ListOfPendingMonthFragment.this;
		listOfPendingMonthManager.pendingMonth(mContext,ifGetRequest);
		
	}
}
