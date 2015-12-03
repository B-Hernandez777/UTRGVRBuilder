package vaqpack.model;

import vaqpack.model.resume.Resume;

public class Vaqpack
{
	private CoverLetter coverLetter;
	private Resume resume;
	public CoverLetter getCoverLetter()
	{
		return coverLetter;
	}
	public void setCoverLetter(CoverLetter coverLetter)
	{
		this.coverLetter = coverLetter;
	}
}
