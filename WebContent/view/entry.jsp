<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<HTML>
 <HEAD>
  <TITLE>予約</TITLE>
 </HEAD>
 <BODY>
  <html:errors />
  <html:form action="/EntryReserve" >
  
    <!-- 1)登録・更新に必要な情報をHiddenで引き継ぐ -->
    <html:hidden property="roomId" />
    <html:hidden property="building" />
    <html:hidden property="status" />
  
    <logic:equal name="EntryReserveForm" property="status" value="1" >
      <html:hidden property="reserveId" />
    </logic:equal>
    
    <html:text property="year" size="4" />年
    <html:text property="month" size="2" />月
    <html:text property="day" size="2" />日<BR>
    予約者名<html:text property="person" size="10" /><BR>
    内容<html:text property="content" size="20" /><BR>  

    開始時間
    <html:select property="startRange" >
      <html:options collection="range" property="rangeno" labelProperty="timeName" />
    </html:select><BR>
    終了時間
    <html:select property="endRange" >
      <html:options collection="range" property="rangeno" labelProperty="timeName" />
    </html:select><BR>
  
    <!-- 2)登録、更新、削除ボタンの表示を制御　-->
    <logic:equal name="EntryReserveForm" property="status" value="0" >  
      <html:submit property="action" >
        <bean:message key="action.entry" />
      </html:submit>
    </logic:equal>
  
    <logic:equal name="EntryReserveForm" property="status" value="1" >   
      <html:submit property="action" >
        <bean:message key="action.update" />
      </html:submit>
      <html:submit property="action" >
        <bean:message key="action.delete" />    
      </html:submit>
    </logic:equal>

  </html:form>
  
 </BODY>
</HTML>