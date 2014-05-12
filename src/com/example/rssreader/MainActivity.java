package com.example.rssreader;
	import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

	import org.xmlpull.v1.XmlPullParserException;

	import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

	public class MainActivity extends Activity 
	{
		DBAdapter myDb;
		protected void onCreate(Bundle savedInstanceState) 
		{
			
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			final ListView lv = (ListView) findViewById(R.id.rss_list);
			final Activity memRefThis = this;
			(new Thread(new Runnable(){

				ArrayList<RSSItem> RSSItems;

				@Override
				public void run() {
					try {
						this.RSSItems = RSSPullParser.parse("http://rss.cnn.com/rss/cnn_topstories.rss");
						
						
						
					} catch (MalformedURLException e) 
					{
						e.printStackTrace();
					} 
					catch (XmlPullParserException e) 
					{
						e.printStackTrace();
					} 
					catch (IOException e) 
					{	
						e.printStackTrace();
					}
					MainActivity.this.runOnUiThread(new Runnable(){
						@Override
						public void run() 
						{
							lv.setAdapter( new RSSItemAdapter(memRefThis, RSSItems));
							
						}
						public void run1()
						{
							
						        TextView textView = (TextView) findViewById(R.id.textView1);
						        CharSequence message = null;
								textView.setText(message);
							
							myDb = new DBAdapter(this);
							myDb.open();
							long newId = myDb.insertRow("Jenny", "Green");
							Cursor cursor = myDb.getRow(newId);
							if (cursor.moveToFirst()) {
								do {
									
									int id = cursor.getInt(DBAdapter.COL_ROWID);
									String title = cursor.getString(DBAdapter.COL_TITLE);
									String discription = cursor.getString(DBAdapter.COL_DISCRIPTION);
									
											message = "id=" + id
											   +", name=" + title
											   +", #=" + discription
											   +"\n";
								} while(cursor.moveToNext());
						}
						
						}
					});
				}
	        })).start();
		
		}
		
			
		
	/*	protected void onDestroy() {
			super.onDestroy();	
			closeDB();
		}


		private void openDB() {
			myDb = new DBAdapter(this);
			myDb.open();
		}
		private void closeDB() {
			myDb.close();
		}
		
			public void display(){
			long newId = myDb.insertRow("Jenny", "Green");
			
			// Query for the record we just added.
			// Use the ID:
			Cursor cursor = myDb.getRow(newId);
			displayRecordSet(cursor);
			}
		
		private void displayRecordSet(Cursor cursor) {
			String message = "";
			// populate the message from the cursor
			
			// Reset cursor to start, checking to see if there's data:
			if (cursor.moveToFirst()) {
				do {
					// Process the data:
					int id = cursor.getInt(DBAdapter.COL_ROWID);
					String title = cursor.getString(DBAdapter.COL_TITLE);
					String discription = cursor.getString(DBAdapter.COL_DISCRIPTION);
					
					
					// Append data to the message:
					message += "id=" + id
							   +", name=" + title
							   +", #=" + discription
							   +"\n";
				} while(cursor.moveToNext());
			}
			
			// Close the cursor to avoid a resource leak.
			cursor.close();
			
			displayText(message);
		}
		private void displayText(String message) {
	        TextView textView = (TextView) findViewById(R.id.textView1);
	        textView.setText(message);
	}*/
	}


	


