package com.example.rssreader;

public class RSSItem {
	private String title;
	private String description;

	public RSSItem() {}

	public RSSItem(String title, String description)
	{
		this.title = title;
		this.description = description;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getDescription()
	{
		return description;
	}

	public String getTitle()
	{
		return title;
	}

}
