package com.example.slidingciby;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;



public class FragmentNews extends Fragment {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView mTitletxtview;
    public FragmentNews() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_checkbox, null);
    
        checkBox1 = (CheckBox) view.findViewById(R.id.fragment_checkbox_checkbox1);
        checkBox2 = (CheckBox) view.findViewById(R.id.fragment_checkbox_checkbox2);
        View v=getActivity().getActionBar().getCustomView();
        
        return view;
    }

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	     View v=getActivity().getActionBar().getCustomView();
	     TextView mhead=(TextView)v.findViewById(R.id.mytext);
	     mhead.setText("News");
	     TextView maptxtview=(TextView)v.findViewById(R.id.txt_map);

if(maptxtview.getVisibility()==View.VISIBLE)
{
maptxtview.setVisibility(View.INVISIBLE);

}
	}


	
	
}
