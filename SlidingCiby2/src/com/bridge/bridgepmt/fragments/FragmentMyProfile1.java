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
import com.bridge.bridgepmt.app.Bridgepmt;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class FragmentMyProfile1 extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView mTitletxtview;
    public FragmentMyProfile1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_myprofile, null);
    
      Bridgepmt.setCurrentlogin(2);
        
        return view;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}


	
	
}
