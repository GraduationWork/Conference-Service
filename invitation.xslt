<xsl:stylesheet id="soccerGameDictionary" version="2.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
	xmlns:exsl="http://exslt.org/common"
	extension-element-prefixes="exsl" xmlns:saxon="http://saxon.sf.net/" exclude-result-prefixes="saxon">

	<xsl:strip-space elements="*" />

	<xsl:param name="name" />
	
	<xsl:template match="/">
		 <xsl:text disable-output-escaping='yes'>&lt;!DOCTYPE html&gt;</xsl:text>
		<html>
		<body>Hello, <xsl:value-of select="$name"/></body>
		</html>
	</xsl:template>
	
</xsl:stylesheet>