<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes" />
  <xsl:template match="/Candy">
    <root>
      <xsl:for-each
        select="CandyItem[generate-id() = generate-id(key('byProduction', Production)[1])]">
        <xsl:element name="{Production}">
          <xsl:for-each select="key('byProduction', Production)">
            <xsl:copy-of select="." />
          </xsl:for-each>
        </xsl:element>
      </xsl:for-each>
    </root>
  </xsl:template>
  <xsl:key name="byProduction" match="CandyItem" use="Production" />
</xsl:stylesheet>