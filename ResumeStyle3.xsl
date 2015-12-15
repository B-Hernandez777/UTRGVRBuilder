<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="xml" indent="no"/>
<xsl:template match="/">
 <html xmlns="http://www.w3.org/1999/xhtml">
	<head> 
		<title> Resume </title>
		<link href ="Style3.css" rel = "stylesheet" type = "text/css" title ="Style"/>
	</head>
<body>
	<div id="w" >
		<header class="clearfix">
			<div id="info">			
				<h1><span><xsl:value-of select = "resume/personal/firstname" /> 
					<xsl:value-of select = "resume/personal/lastname" /></span></h1>
				
				
				  <span><xsl:value-of select = "resume/personal/address" />
					</span>, 
				  <span><xsl:value-of select = "resume/personal/city" />
					</span>, 
				  <span><xsl:value-of select = "resume/personal/state" />
					<xsl:value-of select = "resume/personal/zipCode" /></span>
				
				<small><span itemprop="email"><xsl:value-of select = "resume/personal/email" />
					</span></small>
				
			</div>
		</header>
		
		<section id = "profile">
			
				 <xsl:choose>
					<xsl:when test = "resume/objective/object">
						<xsl:if test = "resume/objective/object != 'null'" >					
						<h2> Objective </h2>
						<p> <xsl:value-of select = "resume/objective/object"/> </p>
						</xsl:if>
					</xsl:when>
					<xsl:otherwise> </xsl:otherwise>
				
				</xsl:choose>
				
				
		</section>
		<section id="experience">
			<xsl:choose>
					<xsl:when test = "resume/experience/e">
					
						<h2> Experience </h2>
						<xsl:for-each select="resume/experience/e">	
							
								<p>
								
								<b><xsl:value-of select = "job" /></b>
								
								<p style="padding-left: 1cm;">
							    <xsl:value-of select = "description" />
								<br></br>  <xsl:value-of select = "companyname" /> 
								<br></br>  <xsl:value-of select = "companycity" /> 
							      <xsl:value-of select = "companystate" /> 
								<br></br>  <xsl:value-of select = "companystart" /> 
								 <xsl:value-of select = "companyend" /> 
									</p>
								</p>
						</xsl:for-each>
					
					</xsl:when>
					<xsl:otherwise> </xsl:otherwise>
				
			</xsl:choose>
		</section>
		<section id = "education">
			<xsl:choose>
				<xsl:when test = "resume/education/ed">
				<h2> Education </h2> 
				<xsl:for-each select="resume/education/ed">	
				<p> 
				<b> <xsl:value-of select = "school" /> </b>
								
					<p style="padding-left: 1cm;">
					<xsl:value-of select = "schoolcity" /> 
					<xsl:value-of select = "schoolstate" />
					<br></br>
					<xsl:value-of select = "degree" /> 
					<br></br>
				    <xsl:value-of select = "GPA" />
					<br></br>
					<xsl:value-of select = "schoolstart" /> 
					<xsl:value-of select = "schoolend" /> 
					</p>
				</p>
				</xsl:for-each>
					
				</xsl:when>
				<xsl:otherwise> </xsl:otherwise>
			</xsl:choose>		
		</section>
		<section id = "achievements">
			<xsl:choose>
				<xsl:when test = "resume/achievement/a">
				<h2> Achievements </h2>
				<xsl:for-each select="resume/achievement/a">
				<p>
					<b> <xsl:value-of select = "achieve" /> </b>
					<br></br>
					<p style="padding-left: 1cm;">
					<xsl:value-of select = "achievedescription" /> 		
					</p>
				</p>
				</xsl:for-each>
				</xsl:when>
				<xsl:otherwise> </xsl:otherwise>
			</xsl:choose>
		</section>
		<section id = "skills">
			<xsl:choose>
				<xsl:when test = "resume/skill/s">
				<h2> Skills </h2>
				<xsl:for-each select="resume/skill/s">
				<p>
					
					<b> <xsl:value-of select = "skilltype" /> </b>
															
				</p>
				</xsl:for-each>
				</xsl:when>
				<xsl:otherwise> </xsl:otherwise>
			</xsl:choose>
		</section>
		
		
	</div>


</body>
</html>
</xsl:template>
</xsl:stylesheet>	