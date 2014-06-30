package com.example.slidingciby;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



public class SlidingmenuAdapter extends BaseAdapter {
	private Context context;
    private ArrayList<SlidingmenuItem> menuItems;
    
    
    public SlidingmenuAdapter(Context context, ArrayList<SlidingmenuItem> navDrawerItems){
        this.context = context;
        this.menuItems = navDrawerItems;
    }
    
    
    
    
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return menuItems.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		 return menuItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		   if (convertView == null) {
	            LayoutInflater mInflater = (LayoutInflater)
	                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
	            convertView = mInflater.inflate(R.layout.menu_list_item, null);
	        }
	          
	        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.img_icon);
	        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
	       
	          
	        imgIcon.setImageResource(menuItems.get(position).getIcon());       
	        txtTitle.setText(menuItems.get(position).getTitle());
	         
	        // displaying count
	        // check whether it set visible or not
	        if(menuItems.get(position).getCounterVisibility()){
	        
	        }else{
	            // hide the counter view
	
	        }
	         
	        return convertView;
	    }
	

}
