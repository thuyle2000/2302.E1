<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : d04_style1.xsl
    Created on : August 15, 2023, 6:53 PM
    Author     : THUYLM
    Description:
        Purpose of transformation follows.
        Hien thi danh sach sinh vien co diem thi tren 50
-->

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/school">
        <html>
            <head>
                <title>students</title>
                <link rel="stylesheet" 
                        href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" />
                <link href="d04_students.css" rel="stylesheet" />
            </head>
            <body>
                <div class="container">
                    <h2> Shool Name: <xsl:value-of select="sc_name" /> </h2>
                    <h4> Adress: <xsl:value-of select="sc_address" /> </h4>
                    <h4> Telephone: <xsl:value-of select="sc_tel" /> </h4>
                    <hr/>

                    <div>
                        <xsl:apply-templates select="batch" /> 
                    </div>
                </div>
                
            </body>
        </html>
    </xsl:template>
    
    
    <xsl:template match="batch">
        <p>Batch No: <xsl:value-of select="@no" /> </p>
        
        <table class="table table-hover table-striped">
            <thead>
                <tr>
                    <th>no.</th>
                    <th>id</th>
                    <th>name</th>
                    <th>gender</th>
                    <th>year of birth</th>
                    <th>email</th>
                    <th>mark</th>
                </tr>
            </thead>
            <tbody>
                <xsl:for-each select="student">
                    <xsl:if test=" mark &gt;= 50 ">
                    <tr>
                        <td>
                            <xsl:number value="position()" />
                        </td>
                        <td>
                            <xsl:value-of select="@id" />
                        </td>
                        <td>
                            <xsl:value-of select="name" />
                        </td>
                        <td>
                            <xsl:value-of select="@gender" />
                        </td>
                        <td>
                            <xsl:value-of select="yob" />
                        </td>
                        <td>
                            <xsl:value-of select="email" />
                        </td>
                        <td>
                            <xsl:value-of select="mark" />
                        </td>
                    </tr>
                    </xsl:if>
                </xsl:for-each>
            </tbody>
        </table>

    </xsl:template>
    
</xsl:stylesheet>
