package com.bridge.bridgepmt.adapters;

import java.util.ArrayList;

import com.bridge.bridgepmt.activities.R;
import com.bridge.bridgepmt.model.ProjectDetails;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;




/** Class extends from the base adapter 
 * loads the contentview and the listrw and gives the size of the list and 
 * initializes the textview in the listrw **/


public class ListAdapter extends BaseAdapter {


	
	/** The listner. */

	/** The activity. */
	public Activity activity;

	/** The array list tip. */
	
	ArrayList<ProjectDetails> projectdetillist;

	/** The inflater. */
	public LayoutInflater inflater = null;

	

	ProjectDetails projectDetails;

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
	public ListAdapter(Activity listingActivity, int listrowTip,
			ArrayList<ProjectDetails> arrayListTip, Context con) {
		activity = listingActivity;

		this.projectdetillist = arrayListTip;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		return projectdetillist.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	public ProjectDetails getItem(int position) {
		return projectdetillist.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int position) {
		return position;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View listContentView = convertView;

		if (convertView == null) {
			listContentView = inflater.inflate(R.layout.projectlistrw, null);
		}

		projectDetails = projectdetillist.get(position);
		if (projectDetails != null) {

		
			TextView projectnametxtview = (TextView) listContentView
					.findViewById(R.id.txt_name);
	projectnametxtview.setText(projectDetails.getName());

		}
		return listContentView;
	}
}
