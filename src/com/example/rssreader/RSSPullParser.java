package com.example.rssreader;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import android.util.Log;

public class RSSPullParser {
	private static ArrayList<RSSItem> items = new ArrayList<RSSItem>();
	private static RSSItem currentItem = null;

	public static ArrayList<RSSItem> parse(String url) throws XmlPullParserException, IOException, MalformedURLException 
	{

		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
		factory.setNamespaceAware(true);
		XmlPullParser xpp = factory.newPullParser();

		xpp.setInput(new URL(url).openStream(), null);

		int eventType = xpp.getEventType();

		while (eventType != XmlPullParser.END_DOCUMENT) 
		{
			if (eventType == XmlPullParser.START_DOCUMENT) 
			{
				Log.i("RSSPullParser", "Start Parsing...");
			} 

			else if (eventType == XmlPullParser.START_TAG) 
			{
				if (xpp.getName().equals("item")) 
				{
					
					currentItem = new RSSItem();
				} 
				else if (xpp.getName().equals("title") && currentItem != null) 
				{
					// set title for the current item
					currentItem.setTitle(xpp.nextText());
				} 

				else if (xpp.getName().equals("description") && currentItem != null) 

				{
					// set description for the current item
					currentItem.setDescription(xpp.nextText());
				}
			} 

			else if (eventType == XmlPullParser.END_TAG) 
			{
				if (xpp.getName().equals("item")) 
				{
					// add the current item to items so that we can instantiate
					// the next item in current item
					items.add(currentItem);
				}
			}
			eventType = xpp.next();
		}
		Log.i("MyPullParser", "End document");
		Log.i("MyPullParser", "We received: " + items.size());

		return items;
	}


}

