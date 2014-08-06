package com.bridge.bridgepmt.fragments;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONObject;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.adapters.PMTDevelopersListAdapter;
import com.bridge.bridgepmt.adapters.PMTEvaluateQuestionAdapter;
import com.bridge.bridgepmt.app.Bridgepmt;
import com.bridge.bridgepmt.interfaces.ListOfEvaluateQuestionManagerListner;
import com.bridge.bridgepmt.interfaces.PMTListOfPenMonthManagerListner;
import com.bridge.bridgepmt.interfaces.PMTQuestionAnswerPOstListner;
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
import android.support.v4.app.FragmentManager;
import android.text.Editable;
import android.text.format.Time;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class FragmentEvaluateQuestions extends Fragment implements ListOfEvaluateQuestionManagerListner ,PMTQuestionAnswerPOstListner
{

	 Context  mContext;
	 String ifGetRequest ="get";
	 private PMTEvaluateQuestionAdapter mListAdapter;
	 ArrayList<EvaluationQuestiondetails> evaluatequestiondetails;
	 ProgressDialog  mprogressbar;
	 Button          mbtnSubmit;
	 String method = "post";
	 Fragment  mFragmentMyDeveloperEvaluation;
	 LayoutInflater inflater1;
	 View parentView;
	 View childView;
	 LinearLayout l;
     View view;
     EditText medittext;
     EditText ed;
	 List<EditText> allEds = new ArrayList<EditText>();
	 
	 
	 public FragmentEvaluateQuestions() 
	 {
		 
	 }
	 
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
		 view  = inflater.inflate(R.layout.fragment_evaluatequestions, container, false);
	        this.inflater1=inflater;

	        mbtnSubmit=(Button) view.findViewById(R.id.btnSubmit);

	        mprogressbar = new ProgressDialog(getActivity());
	        mprogressbar.setMessage("loading");
	        
	        loadQuestions();
	      
	        return view;
	    }
	 
	 @Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			

		    buttonOnclick();
			
	 }


	private void buttonOnclick() 
	{
		mbtnSubmit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				 
				String[] strings=new String[allEds.size()];
				
				 ArrayList<String> mannschaftsnamen = new ArrayList<String>();
				 for(int i=0; i < allEds.size(); i++)
				    {

					 Bridgepmt.setSurvey_id(evaluatequestiondetails.get(i).getSurvey_id());					
					 int questionid=evaluatequestiondetails.get(i).getId();

					 strings[i] = allEds.get(i).getText().toString();
					 Log.e("values",strings[i].toString());
					    mannschaftsnamen.add(String.valueOf(questionid+":"+strings[i]));
				 
					}  
				
				 Log.v("ypgs", String.valueOf(mannschaftsnamen));
				
				 String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
				 
				 Time today = new Time(Time.getCurrentTimezone());
					today.setToNow();
				 
				 
				 String evaluationanswerdetails =("token"+":"+Bridgepmt.getAccessToken()+","+"survey_id"+":"+Bridgepmt.getSurvey_id()+","+"client_id"+":"+Bridgepmt.getClientid()+","
						+"devid"+":"+Bridgepmt.getDeveloperid()+","+"month"+":"+Bridgepmt.getMonth()+","+"year"+":"+today.year+","+"date"+":"+date);
				
				
				ListOfEvaluateQuestionManager listOfEvaluateQuestionManager = new ListOfEvaluateQuestionManager();
				listOfEvaluateQuestionManager.IPMTQuestionAnswerPOstListner=FragmentEvaluateQuestions.this;
				listOfEvaluateQuestionManager.postAnswers(mContext,method,date,today.year,mannschaftsnamen);
			}
		});
	}





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

		
		for(int i=0;i<evaluatequestiondetails.size();i++)
		{
	     l=(LinearLayout)view.findViewById(R.id.rel_parent);
		LinearLayout.LayoutParams currentLayout = new LinearLayout.LayoutParams(
			1080,140);	
		currentLayout.bottomMargin=10;
		View childview=this.inflater1.inflate(R.layout.childllayout, null);
ed=(EditText)childview.findViewById(R.id.etext_test);
		ed.setId(i);
		allEds.add(ed);
	TextView question_txtview=(TextView)childview.findViewById(R.id.txt_question);
		EvaluationQuestiondetails ev=new EvaluationQuestiondetails();
		ev=evaluatequestiondetails.get(i);
	question_txtview.setText(ev.getQuestion());
			l.addView(childview,currentLayout);

		}
		
		
		
	}


	@Override
	public void postSuccess(
			PMTEvaluationQuestionsScreenReturns pMTEvaluationQuestionsScreenReturns) 
	{
		if(pMTEvaluationQuestionsScreenReturns.getStatus().equals("success"))
		{
			SMUtility.buildAlertMessage(getActivity(), getResources().getString(R.string.Success));
			
			
			mFragmentMyDeveloperEvaluation=new FragmentMyDeveloperEvaluation();
			  
			  
			  FragmentChangeActivity fragmentChangeActivity=  (FragmentChangeActivity) getActivity();
			  fragmentChangeActivity.switchContent(mFragmentMyDeveloperEvaluation);
	  			
		}
		
	}
}
