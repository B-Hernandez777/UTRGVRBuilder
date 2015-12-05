package vaqpack.model.resume;

import java.io.Serializable;

public class ResumeStyle implements Serializable
{

	private static final long serialVersionUID = 1L;
	private String style;

	public ResumeStyle(String style)
	{
		this.style = style;
	}

	public String getStyle()
	{
		return style;
	}

	public void setStyle(String style)
	{
		this.style = style;
	}

	public String toString()
	{
		return style;
	}
}
