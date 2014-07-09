package com.bridge.bridgepmt.adapters;

import java.util.ArrayList;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.EvaluationQuestiondetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class PMTEvaluateQuestionAdapter extends BaseAdapter{

	/** The listner. */

	/** The activity. */
	public Activity activity;
	
/** The array list tip. */
	
	ArrayList<EvaluationQuestiondetails> evaluatequestiondetillist;
	
	/** The inflater. */
	public LayoutInflater inflater = null;


	EvaluationQuestiondetails evaluateQuestionDetails;

	/** The selected position. */

	/**
	 * Instantiates a new tips list view adaptor.
	 * 
	 * @param listingActivity
	 *            the listing activity
	 * @param listrowTip
	 *            the listrow tip
	 * @param arrayListTip
	 *            the array list tip
	 * @param con
	 *            the con
	 */
	public PMTEvaluateQuestionAdapter(Activity listingActivity, int listrowTip,
			ArrayList<EvaluationQuestiondetails> arrayListTip, Context con) {
		activity = listingActivity;

		this.evaluatequestiondetillist = arrayListTip;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return evaluatequestiondetillist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return evaluatequestiondetillist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View listContentView = convertView;
		
		if (convertView == null) {
			listContentView = inflater.inflate(R.layout.evaluatequestionrw, null);
		}
		evaluateQuestionDetails =evaluatequestiondetillist .get(position);
		if (evaluateQuestionDetails != null) {

		
			TextView tvquestion = (TextView) listContentView
					.findViewById(R.id.txt_questions);
			
			TextView tvEnterRating = (TextView) listContentView
					.findViewById(R.id.txt_EnterYourRating);
			
			EditText  evRating = (EditText) listContentView
					.findViewById(R.id.etrating);
			
			
			
			tvquestion.setText(evaluateQuestionDetails.getQuestion());
			
			
			

		}
		return listContentView;
	}

}
