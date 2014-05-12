package com.example.rssreader;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

public class RSSItemAdapter implements ListAdapter {
	private ArrayList<RSSItem> items;
	private Activity ctx;

	public RSSItemAdapter(Activity ctx, ArrayList<RSSItem> items){
		this.items = items;
		this.ctx = ctx;
	}
	public int getCount() {
		return items.size();
	}

	public RSSItem getItem(int position) {
		return items.get(position);
	}

	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if(convertView != null){
			
			view = convertView;
		}else{
			
			view = ctx.getLayoutInflater().inflate(R.layout.listitem, null);

		}

		final RSSItem item = getItem(position);
		
		TextView tv = (TextView) view.findViewById(R.id.item_title);
		tv.setText(item.getTitle());

		
		Button btn = (Button) view.findViewById(R.id.item_btn);
		btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				
				Intent intent = new Intent(ctx,ListActivity.class);
				intent.putExtra("title", item.getTitle());
				intent.putExtra("description", item.getDescription());
				ctx.startActivity(intent);
			}
		});
		return view;
	}
	@Override
	public int getItemViewType(int arg0) {
		
		return 0;
	}
	@Override
	public int getViewTypeCount() {
		// TODO Auto-generated method stub
		return 1;
	}
	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void registerDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unregisterDataSetObserver(DataSetObserver arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean areAllItemsEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean isEnabled(int arg0) {
		// TODO Auto-generated method stub
		return false;
	}


}

