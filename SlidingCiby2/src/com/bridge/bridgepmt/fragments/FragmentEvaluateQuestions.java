package com.bridge.bridgepmt.fragments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.JSONObject;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.PMTDevelopersListAdapter;
import com.bridge.bridgepmt.adapters.PMTEvaluateQuestionAdapter;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.interfaces.ListOfEvaluateQuestionManagerListner;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.EvaluationQuestiondetails;
import com.bridge.bridgepmt.model.PMTEvaluationQuestionsScreenReturns;
import com.bridge.bridgepmt.utilities.SMUtility;
import com.bridge.bridgepmt.viewmanager.ListOfEvaluateQuestionManager;
import com.bridge.bridgepmt.viewmanager.ListOfPendingMonthManager;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.format.Time;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentEvaluateQuestions extends Fragment implements ListOfEvaluateQuestionManagerListner
{
	 ListView listView;
	 Context  mContext;
	 String ifGetRequest ="get";
	 private PMTEvaluateQuestionAdapter mListAdapter;
	 ArrayList<EvaluationQuestiondetails> evaluatequestiondetails;
	 ProgressDialog  mprogressbar;
	 Button          mbtnSubmit;
	 String method = "post";
	 
	 public FragmentEvaluateQuestions() {
	    }
	 
	 
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	        View view = inflater.inflate(R.layout.fragment_evaluatequestions, container, false);
	       
	        listView= (ListView) view.findViewById(R.id.list);
	        mbtnSubmit=(Button) view.findViewById(R.id.btnSubmit);

	        mprogressbar = new ProgressDialog(getActivity());
	        mprogressbar.setMessage("loading");
	        return view;
	    }
	 
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			
		
			loadQuestions();
		    buttonOnclick();
			

			
	 }


	private void buttonOnclick() 
	{
		mbtnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				 
			
				 ArrayList<String> mannschaftsnamen = new ArrayList<String>();
				 for(int i =0;i<listView.getCount();i++)
				    {
					 
					 Bridgepmt.setSurvey_id(evaluatequestiondetails.get(i).getSurvey_id());
					    RelativeLayout layout =(RelativeLayout) listView.getChildAt(0);

//					    TextView text = (TextView)layout.getChildAt(0);
//					    text.getText();
					    EditText editText = (EditText)layout.getChildAt(2);
					    editText.getText();
					    mannschaftsnamen.add(String.valueOf(editText.getText()));
					    
					  
//					    	EditText et = (EditText) layout.getChildAt(i).findViewById(R.id.etrating);
//					        if (et!=null) {
//					           mannschaftsnamen.add(String.valueOf(et.getText()));
//
//					           /** you can try to log your values EditText */
////					           Log.v("ypgs", String.valueOf(et.getText()));
//					       
//					    }
//					 
					}  
				
				 Log.v("ypgs", String.valueOf(mannschaftsnamen));
				
				 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 
				 Time today = new Time(Time.getCurrentTimezone());
					today.setToNow();
				 
				 
				 String evaluationanswerdetails =("token"+":"+Bridgepmt.getAccessToken()+","+"survey_id"+":"+Bridgepmt.getSurvey_id()+","+"client_id"+":"+Bridgepmt.getClientid()+","
						+"devid"+":"+Bridgepmt.getDeveloperid()+","+"month"+":"+Bridgepmt.getMonth()+","+"year"+":"+today.year+","+"date"+":"+date);
				
				
				ListOfEvaluateQuestionManager listOfEvaluateQuestionManager = new ListOfEvaluateQuestionManager();
				listOfEvaluateQuestionManager.IListOfEvaluateQuestionManagerListner=FragmentEvaluateQuestions.this;
				listOfEvaluateQuestionManager.postAnswers(mContext,method,date,today.year);
			}
		});
	}


//	protected void loadSubmitDetails() 
//	{
//		Time today = new Time(Time.getCurrentTimezone());
//		today.setToNow();
//		
//		Log.e("date", today.setToNow);
//		 try {
//			  JSONObject submitdetails=new JSONObject();
//			  submitdetails.accumulate("token",);
//			  submitdetails.accumulate("survey_id", Bridgepmt.getSurvey_id());
//			  submitdetails.accumulate("client_id", Bridgepmt.getClientid());
//			  submitdetails.accumulate("devid", Bridgepmt.getDeveloperid());
//			  submitdetails.accumulate("month", Bridgepmt.getMonth());
//			  
//			  Log.e("json string",submitdetails.toString());
//			  }
//			  catch(Exception e)
//			  {
//			   
//			  }
//		
//		
//	}


	private void loadQuestions() 
	{
		mprogressbar.show();
		mprogressbar.setContentView(R.layout.custom_prgressdailog);
		if(SMUtility.isNetworkAvailable(getActivity())==true)
		{
		ListOfEvaluateQuestionManager listOfEvaluateQuestionManager = new ListOfEvaluateQuestionManager();
		listOfEvaluateQuestionManager.IListOfEvaluateQuestionManagerListner=FragmentEvaluateQuestions.this;
		listOfEvaluateQuestionManager.questions(mContext,ifGetRequest);
		mprogressbar.dismiss();
		}
		else
		{
			SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoInternetConnection));
			mprogressbar.dismiss();
		}
	}


	@Override
	public void evaluateQuestionFinished(
			PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns) 
	{
		evaluatequestiondetails=pMTEvaluationQuestionsScreenReturns.getQuestions();
		
		 if(evaluatequestiondetails!=null)
		  {
//			 Bridgepmt.setSurvey_id(evaluatequestiondetails.get(getId()).getSurvey_id());
			 
			 
			 mListAdapter = new PMTEvaluateQuestionAdapter(getActivity(),
				        R.layout.evaluatequestionrw, evaluatequestiondetails, getActivity());
				  
				  listView.setAdapter(mListAdapter);
				
				

				  listView.setOnItemClickListener(new OnItemClickListener() {

					  public void onItemClick(AdapterView<?> parent, View view, int position,
							    long id) {
						  
						 
						  
							  }
							 });  
				  
		  }
		 else
	  	  {
	  		
//	  		SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.NoDevelopersFound));
				
	  	  }
	}
}
