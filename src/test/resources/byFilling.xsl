<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:output method="xml" indent="yes" />
  <xsl:template match="/Candy">
    <root>
      <xsl:for-each select="CandyItem[generate-id() = generate-id(key('byFilling', @filling)[1])]">
        <xsl:element name="{@filling}">
          <xsl:for-each select="key('byFilling', @filling)">
            <xsl:copy-of select="." />
          </xsl:for-each>
        </xsl:element>
      </xsl:for-each>
    </root>
  </xsl:template>
  <xsl:key name="byFilling" match="CandyItem" use="@filling" />
</xsl:stylesheet>