package com.bridge.bridgepmt.fragments;


import java.util.ArrayList;

import android.app.ProgressDialog;
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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.ListAdapter;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.interfaces.ListOfProjectsManagerListner;
import com.bridge.bridgepmt.model.ListOfProjectScreenReturns;
import com.bridge.bridgepmt.model.LoginScreenReturn;
import com.bridge.bridgepmt.model.ProjectDetails;
import com.bridge.bridgepmt.utilities.SMUtility;
import com.bridge.bridgepmt.viewmanager.ListOfProjectsManager;
import com.bridge.bridgepmt.views.LoginScreen;


public class ListOfProjectsFragments extends Fragment implements ListOfProjectsManagerListner
{
	 ListView listView;
	 /**declaring the object of list Adapter class  */
		private ListAdapter mListAdapter;
	 Context  mContext;
	 ArrayList<ProjectDetails> projectdetails;
	 String ifGetRequest ="get";
	 ProgressDialog  mprogressdialog;
	Fragment mListofdeveloperFragment;
	
	 public ListOfProjectsFragments() {
	    }
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_projectlist, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        mprogressdialog = new ProgressDialog(getActivity());
	        mprogressdialog.setMessage("loading");
	        
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
		mprogressdialog.show();
		mprogressdialog.setContentView(R.layout.custom_prgressdailog);
		if(SMUtility.isNetworkAvailable(getActivity())==true)
		{
			 ListOfProjectsManager listOfProjectsManager = new ListOfProjectsManager();
			 listOfProjectsManager.IListOfProjectsManagerListner=ListOfProjectsFragments.this;
			 listOfProjectsManager.projectList(mContext,ifGetRequest);
		 
		}
		else
		{
			SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoInternetConnection));
			mprogressdialog.dismiss();
		}
		
		
		
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
	  
	  listView.setOnItemClickListener(new OnItemClickListener() {

	  public void onItemClick(AdapterView<?> parent, View view, int position,
			    long id) {
			   // TODO Auto-generated method stub
			   TextView midtxtview=(TextView)view.findViewById(R.id.txt_id1);
//			   Bundle b=new Bundle();
//			   b.putString("id", midtxtview.getText().toString());
			   
			   Bridgepmt.setProjectid(projectdetails.get(position).getId());
			   
			  mListofdeveloperFragment=new ListOfDeveloperFragment();
			  
			  
			  FragmentChangeActivity fragmentChangeActivity=  (FragmentChangeActivity) getActivity();
			  fragmentChangeActivity.switchContent(mListofdeveloperFragment);
	  
			  
			  }
			 });
	  
	  
	  mprogressdialog.dismiss();
	  }
	  else
  	  {
  		
  		SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoProjectAdded));
			
  	  }
//	  pd.dismiss();
	  
	  
	 
	  
	 }
	
	
	

}
