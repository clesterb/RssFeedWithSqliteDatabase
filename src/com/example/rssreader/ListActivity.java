package com.example.rssreader;
	import android.os.Bundle;
	import android.util.Log;
	import android.webkit.WebView;
	import android.widget.TextView;
	import android.app.Activity;

	public class ListActivity extends Activity
	{
		protected void onCreate(Bundle savedInstanceState) 
		{


			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_list);

			Bundle bundle = getIntent().getExtras();

			String description = bundle.getString("description");
			String title = bundle.getString("title");

			TextView titleTV = (TextView) findViewById(R.id.item_title_desc);
			WebView descriptionWV = (WebView) findViewById(R.id.item_desc);

			descriptionWV.loadData(description, "text/html;  charset=UTF-8", null);
			titleTV.setText(title);

			Log.i("Title:" , title);
			Log.i("Description:" , (String) descriptionWV.getUrl());

		}


	}


	

