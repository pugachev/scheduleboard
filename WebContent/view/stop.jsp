<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<HTML>

 <BODY>
  <H3>
  システムがトラブルをおこしたようです。ご迷惑をおかけして申し訳ありません<BR>
  <html:errors /></H3><BR>
  <bean:message key="system.mail" />までご連絡いただければ幸いです。
 </BODY>
</HTML>