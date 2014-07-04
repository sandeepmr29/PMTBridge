package com.bridge.bridgepmt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bridge.bridgepmt.activities.R;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class FragmentSettings extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView mTitletxtview;
    public FragmentSettings() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, null);
    

        
        return view;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		
		
		
		FragmentActivity i=		getActivity();
		SlidingFragmentActivity k=(SlidingFragmentActivity)i;
		View v=k.getSupportActionBar().getCustomView();
			 //    View v=getS
			     TextView mhead=(TextView)v.findViewById(R.id.mytext);
			     mhead.setText("Contact us");
			     TextView maptxtview=(TextView)v.findViewById(R.id.txt_map);

if(maptxtview.getVisibility()==View.VISIBLE)
{
	maptxtview.setVisibility(View.INVISIBLE);

}
	}


	
	
}
