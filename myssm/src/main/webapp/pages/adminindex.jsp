<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="security"
           uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理系统</title>
<link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" href="css/css.css" />
<script type="text/javascript" src="js/jquery1.9.0.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/sdmenu.js"></script>

</head>

<body>
<div class="header">
	 <div class="logo">个人健康信息管理系统</div>
     
				<div class="header-right">
                 <!--  <i class="icon-question-sign icon-white"></i> <a href="#" style="font-size:18px">关于系统</a>  --->
				   <i class="icon-question-sign icon-white"></i> 
				   <a href="#" style="font-size:16px">欢迎你:
				
                  ${sessionScope.loginname}
	            
	               
	                </strong>,</a>
				   <i class="icon-off icon-white"></i> <a id="modal-973558" href="#modal-container-973558" role="button" data-toggle="modal" style="font-size:18px">注销</a> 
                <div id="modal-container-973558" class="modal hide fade" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="width:300px; margin-left:-150px; top:30%">
				<div class="modal-header">
					 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
					<h3 id="myModalLabel">
						注销系统
					</h3>
				</div>
				<div class="modal-body">
					<p>
						您确定要注销退出系统吗？
					</p>
				</div>
				<div class="modal-footer">
					 <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button> <a class="btn btn-primary" style="line-height:20px;" href="<%=path %>/userLogout" target="_top" >确定退出</a>
				</div>
			</div>
				</div>
</div>
<!-- 顶部 -->     
            
<div id="middle">
     <div class="left">
     
     <script type="text/javascript">
var myMenu;
window.onload = function() {
	myMenu = new SDMenu("my_menu");
	myMenu.init();
};
</script>

<div id="my_menu" class="sdmenu">
    <!--开始-->
<security:authorize access="hasRole('ROLE_SUPER_ADMIN')">
    <div class="collapsed">
        <span>管理员管理</span>
        <a target="manFrame" href="<%=path %>/adminlist">管理员管理</a>
        <a target="manFrame" href="<%=path %>/adminadd">管理员添加</a>
    </div>
</security:authorize>
					   <%--<c:if test="${sessionScope.userType==0}">--%>
    <security:authorize access="hasAnyRole('ROLE_SUPER_ADMIN','ROLE_ADMIN')">
        <div class="collapsed">
            <span>用户管理</span>
            <a target="manFrame" href="<%=path %>/userlist">用户管理</a>
            <a target="manFrame" href="<%=path %>/useradd">用户添加</a>
        </div>

<div class="collapsed">

 <span>健康档案管理</span>
         <a target="manFrame" href="<%=path %>/danganlist">健康档案管理</a>
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>体检记录管理</span>
         <a target="manFrame" href="<%=path %>/healthlist">体检记录管理</a> 
    </div>
<!--开始-->
<%-- <div class="collapsed">
 <span>留言管理</span>
         <a target="manFrame" href="<%=path %>/liuyanlist">留言管理</a> 
    </div>--%>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>新闻公告管理</span>
         <a target="manFrame" href="<%=path %>/noticelist">新闻公告管理</a> 
      <a target="manFrame" href="<%=path %>/noticeadd">新闻公告添加</a> 
    </div>
	<!--结束-->
	
<!--开始-->

	<!--结束-->

	<!--结束-->

	<!--结束-->
   </security:authorize>
<security:authorize access="hasRole('USER')">
<%--</c:if>--%>
 <%--<c:if test="${sessionScope.userType==1}">--%>
 <!--开始-->
 <div class="collapsed">
   <span>健康预警</span>
	
            <a target="manFrame" href="<%=path %>/healthAll">健康预警</a> 

    </div>
    
     <div class="collapsed">
	  <span>健康趋势分析查看</span>
            <a target="manFrame" href="<%=path %>/danganAll">健康趋势分析</a> 

    </div>
<div class="collapsed">
	  <span>公告查看</span>
            <a target="manFrame" href="<%=path %>/noticeAll">公告查看</a> 

    </div>
<div class="collapsed">
 <span>健康档案管理</span>
         <a target="manFrame" href="<%=path %>/danganmy">健康档案管理</a> 
      <a target="manFrame" href="<%=path %>/danganadd">健康档案添加</a> 
    </div>
	<!--结束-->
<!--开始-->
 <div class="collapsed">
 <span>体检记录管理</span>
         <a target="manFrame" href="<%=path %>/healthmy">体检记录管理</a> 
      <a target="manFrame" href="<%=path %>/healthadd">体检记录添加</a> 
    </div>
</security:authorize>

<%--     <div class="collapsed">
 <span>我的留言</span>
         <a target="manFrame" href="<%=path %>/liuyanmy">我的留言管理</a> 
                  <a target="manFrame" href="<%=path %>/liuyanadd">在线留言</a> 
	<!--结束-->
	</div>--%>
		<div class="collapsed">
 <span>修改个人资料</span>
         <a target="manFrame" href="<%=path %>/userinfo?id=${sessionScope.loginid}">修改个人资料</a> 
    </div>
	<!--结束-->
<%--</c:if>--%>



	</div>
     </div>
     <div class="Switch"></div>
     <script type="text/javascript">
	$(document).ready(function(e) {
    $(".Switch").click(function(){
	$(".left").toggle();
	 
		});
});
</script>

     <div class="right"  id="mainFrame">
     
     <div class="right_cont">
  <iframe scrolling="auto" frameborder="0" src="right.jsp" name="manFrame" style="margin:0 auto;" width="100%" height="820"></iframe>

 
</div>
     
     
     </div>     
     </div>
    </div>
    
<!-- 底部 -->
    
    





 
</body>
</html>
