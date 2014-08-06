package com.bridge.bridgepmt.fragments;

import java.util.ArrayList;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.ListAdapter;
import com.bridge.bridgepmt.adapters.PMTDevelopersListAdapter;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.interfaces.ListOfDeveloperManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.ListOfDeveloperScreenReturns;
import com.bridge.bridgepmt.model.PMTListOfPendingMonthScreenReturns;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.bridge.bridgepmt.utilities.SMUtility;
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
	 ProgressDialog  mprogressbar;
	 Fragment mListOfPendingMonthFragment;
	 public ListOfDeveloperFragment() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_developerlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        mprogressbar = new ProgressDialog(getActivity());
	        mprogressbar.setMessage("loading");
	        
	        view.setFocusableInTouchMode(true);
	        view.requestFocus();
	        view.setOnKeyListener(new View.OnKeyListener() {
	                @Override
	                public boolean onKey(View v, int keyCode, KeyEvent event) {
	                    Log.i("tag", "keyCode: " + keyCode);
	                    if( keyCode == KeyEvent.KEYCODE_BACK ) {
	                            Log.i("tag", "onKey Back listener is working!!!");
	                        getFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
	                        return true;
	                    } else {
	                        return false;
	                    }
	                }
	            });
	        
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
		mprogressbar.show();
		mprogressbar.setContentView(R.layout.custom_prgressdailog);
		if(SMUtility.isNetworkAvailable(getActivity())==true)
		{
		 ListOfDeveloperManager listOfDeveloperManager = new ListOfDeveloperManager();
		 listOfDeveloperManager.IListOfDeveloperManagerListner=ListOfDeveloperFragment.this;
		 listOfDeveloperManager.developers(mContext,ifGetRequest);
		}
		else
		{
			SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoInternetConnection));
			mprogressbar.dismiss();
		}
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
		  
		  listView.setOnItemClickListener(new OnItemClickListener() {

			  public void onItemClick(AdapterView<?> parent, View view, int position,
					    long id) {
					   // TODO Auto-generated method stub
					 

					   
					   Bridgepmt.setDeveloperid(developerdetails.get(position).getUser_id());
					   
					  mListOfPendingMonthFragment=new ListOfPendingMonthFragment();
					  
					  FragmentChangeActivity fragmentChangeActivity=  (FragmentChangeActivity) getActivity();
					  fragmentChangeActivity.switchContent(mListOfPendingMonthFragment);

					  
					  }
					 });
		  
		  
		  mprogressbar.dismiss();
	}
		  else
	  	  {
	  		
	  		SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoDevelopersFound));
				
	  	  }
	}




}
