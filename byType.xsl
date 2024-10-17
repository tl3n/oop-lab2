<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:output method="xml" indent="no" />

  <xsl:key name="byType" match="CandyItem" use="@type" />

  <xsl:template match="Candy">
    <root>
      <xsl:for-each select="CandyItem[generate-id() = generate-id(key('byType', @type)[1])]">
        <xsl:element name="{@type}">
          <xsl:for-each select="key('byType', @type)">
            <xsl:copy-of select="." />
          </xsl:for-each>
        </xsl:element>
      </xsl:for-each>
    </root>
  </xsl:template>
</xsl:stylesheet>