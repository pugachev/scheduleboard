<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<HTML>
 <BODY>
  <html:form action="/ReservedList" target="main">
   ビル名
  <!-- 1)buildingに設定された値で初期化 -->
  <html:select property="building" >
   <html:options collection="buildings" property="id" labelProperty="name" />
  </html:select><BR>
  <html:text property="year" size="4" />年
  <html:text property="month" size="2"/>月
  <html:text property="day" size="2"/>日<BR>
   <html:submit value="更新" />
  </html:form>
 </BODY>
</HTML>