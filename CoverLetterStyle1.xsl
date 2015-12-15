<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="xml" indent="no"/>
<xsl:template match="/">
<xsl:variable name = "linefeed" select = "'$#10;'"/>
 <html xmlns="http://www.w3.org/1999/xhtml">
 <head> 
		<title> Cover Letter </title>
		<link href ="CoverStyle1.css" rel = "stylesheet" type = "text/css" title ="Style"/>
</head>
 
 <body id ="page-wrap">
 <h1> 
		<xsl:value-of select = "coverletter/personal/firstname" /> 
		<xsl:value-of select = "coverletter/personal/lastname" /> 
</h1>
		<p class ="heading">
		
			<xsl:value-of select = "coverletter/personal/address"/>
		<br/>
			<xsl:value-of select = "coverletter/personal/city"/>
			<xsl:value-of select = "coverletter/personal/state"/>
			<xsl:value-of select = "coverletter/personal/zipCode"/>
		<br/>
			<xsl:value-of select = "coverletter/personal/phone"/>
		<br/>
			<xsl:value-of select = "coverletter/personal/email"/>
		</p> 
	 <hr class = "strikeout"/> 		
	  <br/>
		<p> 
			<xsl:value-of select = "coverletter/coverpersonal/contactname"/> 
				<br/>
			<xsl:value-of select = "coverletter/coverpersonal/contacttitle"/> 
				<br/>
			<xsl:value-of select = "coverletter/coverpersonal/organizationname"/> 
				<br/>
			<xsl:value-of select = "coverletter/coverpersonal/address"/> 							
			<xsl:value-of select = "coverletter/coverpersonal/city"/> 
			<xsl:value-of select = "coverletter/coverpersonal/state"/>
			<xsl:value-of select = "coverletter/coverpersonal/zipCode"/> 
		</p>
		
		<p class = "paragraphs">
		<xsl:value-of select = "coverletter/coverparagraphs/paragraph" />
					
		</p>
		<p class = "ending">
		  <xsl:value-of select ="coverletter/end"/>
		</p>
		
 
 </body>
</html>
</xsl:template>
</xsl:stylesheet>