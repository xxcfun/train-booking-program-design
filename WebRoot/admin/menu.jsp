<%@ page language="java" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">   

	<STYLE type=text/css>
		BODY {PADDING-RIGHT: 0px; PADDING-LEFT: 5px; PADDING-BOTTOM: 0px; MARGIN: 0px; PADDING-TOP: 0px; BACKGROUND-COLOR: #87CEFA}
		BODY {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		TD {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		DIV {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		P {FONT-SIZE: 11px; COLOR: #003366; FONT-FAMILY: Verdana}
		.mainMenu {FONT-WEIGHT: bold; FONT-SIZE: 14px; CURSOR: hand; COLOR: #000000;font-size: 18px;font-weight: 700;font-family: 微软雅黑}
		A.style2:link {PADDING-LEFT: 4px; COLOR: #0055bb; TEXT-DECORATION: none;font-size: 14px;font-family: 微软雅黑}
		A.style2:visited {PADDING-LEFT: 4px; COLOR: #0055bb; TEXT-DECORATION: none;font-size: 14px;font-family: 微软雅黑}
		A.style2:hover {PADDING-LEFT: 4px; COLOR: #ff0000; TEXT-DECORATION: none;font-size: 14px;font-family: 微软雅黑}
		A.active {PADDING-LEFT: 4px; COLOR: #ff0000; TEXT-DECORATION: none;font-size: 14px;font-family: 微软雅黑}
		.span {COLOR: #ff0000;font-family:"宋体";font-size: 15px;}
	</STYLE>

    <script type="text/javascript">
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path %>/login.jsp";
		   }
		}
	</script>
  </head>
  
  
  
<body onload="displayAll()">
 
<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15><IMG src="<%=path %>/img/new_005.jpg" border=0></TD>
    <TD align=middle width=180 background=<%=path %>/img/new_006.jpg height=35><B></B> </TD>
    <TD width=15><IMG src="<%=path %>/img/new_007.jpg" border=0></TD>
  </TR>
</TABLE>

<TABLE cellSpacing=0 cellPadding=0 width=210 align=center border=0>
  <TR>
    <TD width=15 background=<%=path %>/img/new_008.jpg></TD>
    <TD vAlign=top width=180 bgColor=#ffffff>
      <TABLE cellSpacing=0 cellPadding=3 width=165 align=center border=0>
        <!--  -->
        <TR><TD class=mainMenu>修改个人密码</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/userinfo/userPw.jsp" target=dmMain>－ 修改个人密码</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
        <!--  -->
        <TR><TD class=mainMenu>公告信息管理</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/gonggaoMana.action" target=dmMain>－ 公告信息管理</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  --> 
        
        <!--  -->
        <TR><TD class=mainMenu>车次信息管理</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/checiMana.action" target=dmMain>－ 车次信息管理</A></TD></TR>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/admin/checi/checiAdd.jsp" target=dmMain>－ 车次信息添加</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
        
        <!--  -->
        <TR><TD class=mainMenu>订单信息管理</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/orderMana.action" target=dmMain>－ 订单信息管理</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
        
        <!--  -->
        <TR><TD class=mainMenu>会员信息管理</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/userMana.action" target=dmMain>－ 会员信息管理</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
        
        
        <!--  -->
        <TR><TD class=mainMenu>留言板--管理</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/liuyanMana.action" target=dmMain>－ 留言板--管理</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
       <!--  -->
        <TR><TD class=mainMenu>寻物招领中心</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 href="<%=path %>/xunwuMana.action" target=dmMain>－ 寻物招领中心</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
       
        <!--  -->
        <TR><TD class=mainMenu>安全退出系统</TD></TR>
        <TR>
          <TD>
            <TABLE cellSpacing=0 cellPadding=2 width=155 align=center border=0>
              <TR><TD class=menuSmall><A class=style2 onclick="logout()" style="font-size: 14px;font-family: 微软雅黑" target=dmMain>－ 安全退出系统</A></TD></TR>
			</TABLE>
		  </TD>
		</TR>
        <TR><TD background=<%=path %>/img/new_027.jpg height=1></TD></TR><TR>  
        <!--  -->  
        
      </TABLE>
    </TD>
    <TD width=15 background=<%=path %>/img/new_009.jpg></TD></TR>
</TABLE>
</body>
</html>
