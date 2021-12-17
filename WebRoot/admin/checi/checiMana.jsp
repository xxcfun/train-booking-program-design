<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function checiDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   var url="<%=path %>/checiDel.action?id="+id;
                   window.location.href=url;
               }
           }
           
           function checiAdd()
           {
                 var url="<%=path %>/admin/checi/checiAdd.jsp";
				 window.location.href=url;
           }
           
           function checiEditTo(id)
           {
        	   var url="<%=path %>/checiEditTo.action?id="+id;
				 window.location.href=url;
           }
           
           
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan=18" background="<%=path %>/img/tbg.gif">&nbsp;&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="4%">序号</td>
					
					<td width="9%">车次日期</td>
					<td width="9%">车次编号</td>
					<td width="9%">始发地点</td>
					<td width="9%">到达地点</td>
					
					<td width="9%">发车时间</td>
					<td width="9%">剩余票数</td>
					<td width="9%">成人票价</td>
					
					<td width="9%">学生（儿童）票价</td>
					<td width="9%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.checiList}" var="checi" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						 ${ss.index+1}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.riqi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.bianhao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.shifadi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.daodadi}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.facheshi}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.shengpiao}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.chengrenpiaojia}
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 ${checi.ertongpiaojia}
					</td>
					<td bgcolor="#FFFFFF" align="center">
					<input type="button" value="修改" onclick="checiEditTo(${checi.id})"/>
						<input type="button" value="删除" onclick="checiDel(${checi.id})"/>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 8px;">
			  <tr>
			    <td>
			      <input type="button" value="添加车次信息" style="width: 80px;" onclick="checiAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
