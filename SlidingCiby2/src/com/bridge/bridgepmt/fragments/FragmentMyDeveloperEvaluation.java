package com.bridge.bridgepmt.fragments;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bridge.bridgepmt.activities.R;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class FragmentMyDeveloperEvaluation extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView mTitletxtview;
    Button   mbtnEvaluateDev;
    
    @SuppressWarnings("unused")
	private Fragment mContent;
  
    public FragmentMyDeveloperEvaluation() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_developerevaluation, null);
    
        mbtnEvaluateDev=(Button)view.findViewById(R.id.btnEvaluateDev);
        
        return view;
        
    }



	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		final FragmentActivity i=		getActivity();
		SlidingFragmentActivity k=(SlidingFragmentActivity)i;
		View v=k.getSupportActionBar().getCustomView();
			 //    View v=getS
			     TextView mhead=(TextView)v.findViewById(R.id.mytext);
			    
			     
					Typeface signupfont=Typeface.createFromAsset(getActivity().getAssets(),"fonts/MuseoSans-300.otf"); 
					mhead.setTypeface(signupfont);
			     mhead.setText("Developer Evaluation");

			     
			     mbtnEvaluateDev.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) 
					{

						Fragment listOfProjectsFragments = new ListOfProjectsFragments();
						FragmentChangeActivity fragmentChangeActivity=		(FragmentChangeActivity) getActivity();
						fragmentChangeActivity.switchContent(listOfProjectsFragments);
							
					}
				});	     
			     
			     
			     
			     
	}
	
	
}
