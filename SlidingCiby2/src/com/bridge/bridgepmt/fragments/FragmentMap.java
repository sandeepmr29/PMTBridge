package com.bridge.bridgepmt.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bridge.bridgepmt.activities.R;
import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;



public class FragmentMap extends Fragment {

    TextView mTitletxtview;
    public FragmentMap() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, null);
    

        
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
			     mhead.setText("Map");
	
			     
			     TextView txtlist=(TextView)v.findViewById(R.id.txt_map);
			    txtlist.setText("LIST");
			    txtlist.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Fragment fragment=new FragmentListView();
						FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
						fca.switchContent(fragment);
					}
				});
			     
			     
			     
			     
			     
	}


	
	
}
