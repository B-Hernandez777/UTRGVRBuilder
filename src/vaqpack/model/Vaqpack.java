package vaqpack.model;

import vaqpack.model.resume.Resume;

public class Vaqpack
{
	private Resume resume;
	private CoverLetter coverLetter;
	private BusinessCard businesscard;
	private Website	website;
	
	public CoverLetter getCoverLetter()
	{
		return coverLetter;
	}
	public void setCoverLetter(CoverLetter coverLetter)
	{
		this.coverLetter = coverLetter;
	}
}
