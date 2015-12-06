package vaqpack.model;

import java.io.Serializable;

import vaqpack.model.resume.Resume;

public class Vaqpack implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Resume resume;
	private CoverLetter coverLetter;
	private BusinessCard businesscard;
	
	public Vaqpack()
	{
		resume = new Resume(null);
	}
	
	
	public Vaqpack(Resume resume, CoverLetter coverLetter,
			BusinessCard businesscard, Website website)
	{
		this.resume = resume;
		this.coverLetter = coverLetter;
		this.businesscard = businesscard;
		this.website = website;
	}
	private Website website;
	
	public Resume getResume()
	{
		return resume;
	}
	public void setResume(Resume resume)
	{
		this.resume = resume;
	}
	public BusinessCard getBusinesscard()
	{
		return businesscard;
	}
	public void setBusinesscard(BusinessCard businesscard)
	{
		this.businesscard = businesscard;
	}
	
	public CoverLetter getCoverLetter()
	{
		return coverLetter;
	}
	public void setCoverLetter(CoverLetter coverLetter)
	{
		this.coverLetter = coverLetter;
	}
	public Website getWebsite()
	{
		return website;
	}
	public void setWebsite(Website website)
	{
		this.website = website;
	}
}
