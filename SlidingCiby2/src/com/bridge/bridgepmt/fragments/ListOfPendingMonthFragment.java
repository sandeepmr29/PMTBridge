package com.bridge.bridgepmt.fragments;

import java.util.ArrayList;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.PMTDevelopersListAdapter;
import com.bridge.bridgepmt.adapters.PMTPendingMonthListAdapter;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.PMTListOfPendingMonthScreenReturns;
import com.bridge.bridgepmt.model.PendingMonthdetails;
import com.bridge.bridgepmt.utilities.SMUtility;
import com.bridge.bridgepmt.viewmanager.ListOfPendingMonthManager;
import com.bridge.bridgepmt.viewmanager.ListOfProjectsManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class ListOfPendingMonthFragment extends Fragment implements PMTListOfPenMonthManagerListner
{
	 ListView listView;
	 Context  mContext;
	 String ifGetRequest ="get";
	 private PMTPendingMonthListAdapter mListAdapter;
	 ArrayList<PendingMonthdetails> pendingmonthdetails;
		Fragment mFragmentEvaluateQuestions;
		 ProgressDialog  mprogressbar;
	 
	 public ListOfPendingMonthFragment() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_pendingmonthlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        mprogressbar = new ProgressDialog(getActivity());
	        mprogressbar.setMessage("loading");

	        
	        return view;
	    }
	 
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			
			loadpendingmonthList();
			
			

			
	 }

	private void loadpendingmonthList() 
	{
		mprogressbar.show();
		mprogressbar.setContentView(R.layout.custom_prgressdailog);
		if(SMUtility.isNetworkAvailable(getActivity())==true)
		{
		ListOfPendingMonthManager listOfPendingMonthManager = new ListOfPendingMonthManager();
		listOfPendingMonthManager.IPMTListOfPenMonthManagerListner=ListOfPendingMonthFragment.this;
		listOfPendingMonthManager.pendingMonth(mContext,ifGetRequest);
		mprogressbar.dismiss();
		}
		else
		{
			SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoInternetConnection));
			mprogressbar.dismiss();
		}
		
	}

	@Override
	public void pendingmonthListFinished(
			PMTListOfPendingMonthScreenReturns pMTListOfPendingMonthScreenReturns) 
	{
		pendingmonthdetails=pMTListOfPendingMonthScreenReturns.getMonths();
		if(pendingmonthdetails!=null)
		  {
			
			
			 mListAdapter = new PMTPendingMonthListAdapter(getActivity(),
				        R.layout.pendingmonthlistrw, pendingmonthdetails, getActivity());
				  
				  listView.setAdapter(mListAdapter);
				
				  listView.setOnItemClickListener(new OnItemClickListener() {

					  public void onItemClick(AdapterView<?> parent, View view, int position,
							    long id) {
						  
						  Bridgepmt.setMonth(pendingmonthdetails.get(position).getMonth());
							   // TODO Auto-generated method stub
							   TextView midtxtview=(TextView)view.findViewById(R.id.txt_id1);
//							   Bundle b=new Bundle();
//							   b.putString("id", midtxtview.getText().toString());
							   
//							   Bridgepmt.setProjectid(projectdetails.get(position).getId());
							   
							   mFragmentEvaluateQuestions=new FragmentEvaluateQuestions();
							  
							  
							  FragmentChangeActivity fragmentChangeActivity=  (FragmentChangeActivity) getActivity();
							  fragmentChangeActivity.switchContent(mFragmentEvaluateQuestions);
							  
							  
							  
							  
							  }
							 });  
				  
				  
				  mprogressbar.dismiss();
		  }
		  else
	  	  {
	  		
	  		SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoPendingMonths));
				
	  	  }
		
	}
}
