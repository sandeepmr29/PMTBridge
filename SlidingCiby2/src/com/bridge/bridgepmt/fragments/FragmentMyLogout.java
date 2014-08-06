package com.bridge.bridgepmt.fragments;

import android.content.Intent;
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
import com.bridge.bridgepmt.views.LoginScreen;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class FragmentMyLogout extends Fragment {
   
    TextView mTitletxtview;
    public FragmentMyLogout() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logout, null);
        
        
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
			     mhead.setText("Logout");
			     TextView maptxtview=(TextView)v.findViewById(R.id.txt_map);

			     getActivity().finish();
			     Intent ione=new Intent(getActivity(), LoginScreen.class);
			        startActivity(ione);

	}


	
	
}
