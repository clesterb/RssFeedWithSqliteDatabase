package com.example.rssreader;
	import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParserException;

import android.os.AsyncTask;


	public class RSSAsyncTask extends AsyncTask<Void,Void,Void>
	{

		private ArrayList<RSSItem> rssItem;

		public interface OnFinishedListener
		{
			public void onFinished();
		}

		private OnFinishedListener listener;

		public RSSAsyncTask ( OnFinishedListener listener )
		{
			this.listener = listener;
		}

		protected Void doInBackground(Void... params) 
		{
			RSSPullParser rpp = new RSSPullParser();
			try {
				RSSPullParser.parse("http://rss.cnn.com/rss/cnn_topstories.rss");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (XmlPullParserException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			return null;
		}

		protected void onPostExecute()
		{
			listener.onFinished();
		}


	}

