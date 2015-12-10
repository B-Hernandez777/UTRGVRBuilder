<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" >
<xsl:output method="xml" indent="no"/>
<xsl:template match="/">
 <html xmlns="http://www.w3.org/1999/xhtml">
	<head> 
		<title> Resume </title>
		<link href ="Style1.css" rel = "stylesheet" type = "text/css" title ="Style"/>
	</head>
<body>
	<div id = "page-wrap">
		<div>
			<h1> 
				<xsl:value-of select = "resume/personal/firstname" /> 
				<xsl:value-of select = "resume/personal/lastname" />
				</h1>
			<h4>
				<i> Email: </i> <xsl:value-of select = "resume/personal/email" />
					
				<i> Cell: </i> <xsl:value-of select = "resume/personal/phone" />
					<br> </br>
				<xsl:value-of select = "resume/personal/address" />
					<br> </br>
				<xsl:value-of select = "resume/personal/city" />,
					
				<xsl:value-of select = "resume/personal/state" />
					
				<xsl:value-of select = "resume/personal/zip" />
			</h4>
			
 		</div>
		<div id = "objective" >
			<p>
				<xsl:choose>
					<xsl:when test = "resume/objective/object"> 
						<xsl:value-of select = "resume/objective/object"/> 
					</xsl:when>
					<xsl:otherwise> </xsl:otherwise>
				</xsl:choose>
			</p>
		</div>
		
		<div class = "clear"> </div>
		
		<dl>
			<dd class = "clear"> </dd>
				<xsl:choose>
					<xsl:when test = "resume/experience/e">
						<dt> 
							Experience
				
						</dt>  
					</xsl:when>
						<xsl:otherwise> </xsl:otherwise>
					</xsl:choose>
			<dd>
				<xsl:choose>
					<xsl:when test = "resume/experience/e">
						
							
							<xsl:for-each select="resume/experience/e">	
							
								<p>

								<b><xsl:value-of select = "job" /></b>
									<p style="padding-left: 1cm; text-indent:50px;">
								<i> <xsl:value-of select = "description" /> </i> 
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
			</dd>
			
			<dd class="clear"></dd>
				
				<xsl:choose>
					<xsl:when test = "resume/education/ed">
						<dt> 
				
							Education 
						</dt>
					</xsl:when>
					<xsl:otherwise> </xsl:otherwise>
				</xsl:choose>
			
			
			<dd>
				
				<xsl:choose>
					<xsl:when test = "resume/education/ed">
						
							
							<xsl:for-each select="resume/education/ed">	
							<p>
								<b><xsl:value-of select = "school" /> </b>
								
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
				
			</dd>	
			
			<dd class="clear"></dd>

				<xsl:choose>
					<xsl:when test = "resume/achievement/a">
					<dt> 
						Achievements
					</dt>
					</xsl:when>
						<xsl:otherwise> </xsl:otherwise>
				</xsl:choose>
			
			
			<dd>
				<xsl:choose>
					<xsl:when test = "resume/achievement/a">
						
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
			</dd>
			<dd class="clear"></dd>
			
			
				<xsl:choose>
					<xsl:when test = "resume/skill/s">
						<dt> 
							Skills 
						</dt>
					</xsl:when>
						<xsl:otherwise> </xsl:otherwise>
				</xsl:choose>
			
			
			<dd>
				<xsl:choose>
					<xsl:when test = "resume/skill/s">
						
							<xsl:for-each select="resume/skill/s">	
							<p>
								 <xsl:value-of select = "skilltype" />
															
							</p>
							</xsl:for-each>
						
					</xsl:when>
					<xsl:otherwise> </xsl:otherwise>
				</xsl:choose>
			</dd>		
				
		</dl>
	</div>	
</body>
</html>
</xsl:template>
</xsl:stylesheet>		