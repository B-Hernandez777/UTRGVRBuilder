package vaqpack.model;

import vaqpack.model.resume.Resume;

public class Website
{
	private Resume resume;
	private WebsiteStyle style;
	public Resume getResume()
	{
		return resume;
	}
	public void setResume(Resume resume)
	{
		this.resume = resume;
	}
	public WebsiteStyle getStyle()
	{
		return style;
	}
	public void setStyle(WebsiteStyle style)
	{
		this.style = style;
	}
	
	public Website(Resume resume, WebsiteStyle style)
	{
		super();
		this.resume = resume;
		this.style = style;
	}
}
