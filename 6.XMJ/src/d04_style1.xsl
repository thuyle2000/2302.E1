<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : d04_style1.xsl
    Created on : August 15, 2023, 6:53 PM
    Author     : THUYLM
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/school">
        <html>
            <head>
                <title>students</title>
                <link href="d04_students.css" rel="stylesheet" />
            </head>
            <body>
                <h2> Shool Name: <xsl:value-of select="sc_name" /> </h2>
                <h4> Adress: <xsl:value-of select="sc_address" /> </h4>
                <h4> Telephone: <xsl:value-of select="sc_tel" /> </h4>
                <hr/>

                <div>
                    <xsl:apply-templates select="batch" /> 
                </div>
                
            </body>
        </html>
    </xsl:template>
    
    <xsl:template match="student">
        <xsl:value-of select="@id" /> ,
        <xsl:value-of select="name" /> ,
        <xsl:value-of select="@gender" /> ,
        <xsl:value-of select="email" /> ,
        <xsl:value-of select="yob" /> ,
        <xsl:value-of select="mark" /> 
        <br/>
    </xsl:template>
    
    <xsl:template match="batch">
        <p>Batch No: <xsl:value-of select="@no" /> </p>
        <div>
            <xsl:apply-templates select="student" /> 
        </div>
    </xsl:template>
    
</xsl:stylesheet>
