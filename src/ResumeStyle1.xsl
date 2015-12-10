<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="/">
<html>
	<style>
		* { 
				margin: 0; 
				padding: 0; 
		}
        body { 
				font: 16px Helvetica, Sans-Serif; 
				line-height: 24px; 
		}
        .clear { 
				clear: both; 
		}
        #page-wrap { 
				width: 800px; 
				margin: 40px auto 60px; 
		}
        #pic { 
				float: right; 
				margin: -30px 0 0 0; 
		}
        h1 { 
				margin: 0 0 16px 0; 
				padding: 0 0 16px 0; 
				font-size: 42px; 
				font-weight: bold; 
				letter-spacing: -2px; 
				border-bottom: 1px solid #999; 
		}
        h2 { 
				font-size: 20px; 
				margin: 0 0 6px 0; 
				position: relative; 
		}
        h2 span { 
				position: absolute; 
				bottom: 0; right: 0; 
				font-style: italic; 
				font-family: Georgia, Serif; 
				font-size: 16px; color: #999; 
				font-weight: normal; 
		}
        p { 
				margin: 0 0 16px 0; 
		}
        a { 
				color: #999; 
				text-decoration: none; 
				border-bottom: 1px dotted #999; 
		}
        a:hover { 
				border-bottom-style: solid; 
				color: black; 
		}
        ul { 
				margin: 0 0 32px 17px; 
		}
        #objective { 
				width: 800px; 
				float: left; 
		}
        #objective p { 
				font-family: Georgia, Serif;
				font-style: italic; color: #666; 
		}
        dt 	{ 
				font-style: italic; 
				font-weight: bold; 
				font-size: 18px; 
				text-align: right; 
				padding: 0 26px 0 0;
				width: 150px; 
				float: left; 
				height: 100px; 
				border-right: 1px solid #999;  
		}
        dd 	{  
				width: 600px; 
				float: right; 
		}
        dd.clear { 
				float: none; 
				margin: 0; 
				height: 15px;				
		}
		td 	{
				vertical-align: top;
				padding: 10px;
		}
		th 	{
				text-align: left;
				vertical-align:top; 
				padding: 10px;
		}
		</style>
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