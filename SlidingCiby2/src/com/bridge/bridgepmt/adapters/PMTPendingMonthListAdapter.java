package com.bridge.bridgepmt.adapters;

import java.util.ArrayList;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.model.Developerdetails;
import com.bridge.bridgepmt.model.PendingMonthdetails;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PMTPendingMonthListAdapter extends BaseAdapter{

	/** The activity. */
	public Activity activity;
	
/** The array list tip. */
	
	ArrayList<PendingMonthdetails> pendingmonthdetillist;
	
	/** The inflater. */
	public LayoutInflater inflater = null;
	
	
	PendingMonthdetails PendingMonthDetails;
	
	
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
	public PMTPendingMonthListAdapter(Activity listingActivity, int listrowTip,
			ArrayList<PendingMonthdetails> arrayListTip, Context con) {
		activity = listingActivity;

		this.pendingmonthdetillist = arrayListTip;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return pendingmonthdetillist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return pendingmonthdetillist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) 
	{
		View listContentView = convertView;
		
		if (convertView == null) {
			listContentView = inflater.inflate(R.layout.pendingmonthlistrw, null);
		}
		
		PendingMonthDetails=pendingmonthdetillist.get(position);
		
		if (PendingMonthDetails != null) {

			
//			TextView pendingmonthtxtview = (TextView) listContentView
//					.findViewById(R.id.txt_month);
			TextView pendingmonthName = (TextView) listContentView
					.findViewById(R.id.txt_monthname);
			
//			pendingmonthtxtview.setText(Integer.toString(PendingMonthDetails.getMonth()));
			pendingmonthName.setText(PendingMonthDetails.getMonth_name());

		

		}
		return listContentView;
	}

}
