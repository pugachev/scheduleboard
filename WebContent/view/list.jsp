<%@page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<HTML>
 <HEAD>
  <TITLE>予約状況</TITLE>
 </HEAD>
 <BODY>


  <TABLE border="1" width="1000" >
  <TBODY>
   <TR>
    <TH></TH>
   
    <!-- 1)RangeInfoを利用して時間を表示する -->
    <logic:iterate id="rg" name="range" scope="application" type="model.Range" >
     <logic:notEqual name="rg" property="colSpan" value="0" >
      <TH colspan="<%= ((model.Range)pageContext.getAttribute("rg")).getColSpan() %>" >
       <bean:write name="rg" property="timeName" />
      </TH>
     </logic:notEqual>
    </logic:iterate>
   </TR>

   <!-- 2) 部屋を表示し、その日の予約状況を表示する -->
   <logic:iterate id="roomInfo" name="roomReserveList" type="action.viewhelper.RoomReservedInfo" >
    <TR>
      <TH>
       <html:link action="/Entry" name="roomInfo" property="params" >
        <bean:write name="roomInfo" property="roomNo" />
       </html:link>
      </TH>

      <!-- 3) ReservedInfoを利用して予約を表示する -->
      <logic:iterate id="reserveInfo" name="roomInfo" property="reservedInfos" type="action.viewhelper.ReservedInfo" >
        <logic:equal name="reserveInfo" property="reserved" value="true" >
         <TD>
          <!-- 4) 予約がある場合 -->
          <html:link action="/Entry" name="reserveInfo" property="params" >
          <html:img page="/img/red.gif" 
                    alt="<%= ((action.viewhelper.ReservedInfo)pageContext.getAttribute(\"reserveInfo\")).getReserveInfo() %>" />
          </html:link>
         </TD>
        </logic:equal>
        <logic:equal name="reserveInfo" property="reserved" value="false" >
         <TD><html:img page="/img/white.gif" /></TD>
        </logic:equal>
      </logic:iterate>
    </TR>
   </logic:iterate>
   
  </TBODY>
  </TABLE>
  
 </BODY>
</HTML>