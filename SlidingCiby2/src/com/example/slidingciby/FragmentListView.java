package com.example.slidingciby;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.jeremyfeinstein.slidingmenu.lib.app.SlidingFragmentActivity;





public class FragmentListView extends Fragment {
    ListView listView;
    
    public FragmentListView() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
    	
  
        View view = inflater.inflate(R.layout.fragment_listview, null);
    
        String[] listViewItems = new String[] { "Symbian", "iOS", "Windows Phone", "Blackberry", "Meego", "Symbian", "Blackberry", "Meego", "Symbian", "Blackberry", "Meego", "Symbian"};
        listView = (ListView) view.findViewById(R.id.fragment_listview_listview);
        listView.setAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, listViewItems));
        
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
			     mhead.setText("NEAR BY");

			     
			     TextView maptxtview=(TextView)v.findViewById(R.id.txt_map);
			     maptxtview.setText("MAP"); 
			     maptxtview.setVisibility(View.VISIBLE);
			     
			     
			     maptxtview.setOnClickListener(new View.OnClickListener() {
						
						@Override
						public void onClick(View v) {
							// TODO Auto-generated method stub
							Fragment fragment=new FragmentMap();
							FragmentChangeActivity fca = (FragmentChangeActivity) getActivity();
							fca.switchContent(fragment);
						}
					});
			     
			     
			     
			     
			     
			     
			     
	}
    
}
