package vaqpack.model;

public class CoverLetter
{
	private String coverLetter;
	public CoverLetter(String coverLetter)
	{
		this.coverLetter = coverLetter;
	}
	public String getCoverLetter()
	{
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter)
	{
		this.coverLetter = coverLetter;
	}
	
	@Override
	public String toString()
	{
		return coverLetter;
	}
}
