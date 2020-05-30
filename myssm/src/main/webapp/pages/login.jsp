
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>用户登录</title>
 
<script src="<%=path %>/pages/js/jquery.min.js"></script>

	<style>
		* {margin:0;padding:0;font-size:12px}
		html, body {height:100%;background:url(<%=path %>/pages/login/pagebg.gif)}
		button,input,select { vertical-align:middle;}
		img { border:none; vertical-align:middle;}
		ul,ol { list-style-type:none;}
		.warper-bg,.warper {width:708px;height:423px;position:absolute;left:50%;margin-left:-354px;top:50%;margin-top:-232px;z-index:200}
		.warper-bg {background:url(<%=path %>/pages/login/bg.png) no-repeat;_filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(src='<%=path %>/pages/login/bg.png', sizingMethod='crop');_background:none;z-index:100}
		.content {height:75px;margin-top:75px;height:280px}
		.download {width:270px;float:left;height:100%}
		.downloadlink {display:block;width:100%;height:100%;text-indent:-10000px}
		.login {width:438px;float:right;height:100%}
		.login .text {padding:20px 30px 10px 10px;text-indent:2em;font-size:14px;line-height:150%}
		
		.input-text {background:#FFF url(<%=path %>/pages/login/input_bg.gif) no-repeat;border:0;padding:3px}
		.validate { cursor:pointer}
		.button-submit {width:94px;height:69px;background:url(<%=path %>/pages/login/submit.gif) no-repeat;border:0; cursor:pointer}
		
		.links {padding:20px 0 0 30px}
		.links li {float:left;width:85px;font-size:14px}
		.links li span {font-weight:bold}
		.links li a {color:#F00}
		
		.url-new {display:block;float:right;width:400px;height:36px;text-indent:-100000px}
		
		.cRed {color:#900;font-size:14px;font-weight:bold; font-family:'黑体'}
		
		#msgdiv {height: 130px;width: 300px;border: 5px solid #a09d18;padding: 10px;text-align: center;}
	</style>
	
	
	<script language="javascript">
	function check1()
		{     
		     if(document.ThisForm.userName.value=="")
			 {
			 	alert("请输入用户名");
				document.ThisForm.userName.focus();
				return false;
			 }
			 if(document.ThisForm.userPw.value=="")
			 {
			 	alert("请输入密码");
				document.ThisForm.userPw.focus();
				return false;
			 }
			
			 	  document.ThisForm.submit();

		}
		
		
		
	    </script>
  
  </head>
  
  <body>
      <div class="warper-bg"></div>
      <div class="warper">
	      <div class="content">
              <a href="#"><div style="width:163px; height:29px; position:absolute; top: 234px; left:50px;cursor:pointer;"> </div></a>
              <a href="#"><div style="width:202px; height:21px; position:absolute; top: 273px; left:36px;cursor:pointer;"></div></a>
		      <div class="login">
				  <div class="text" style="font-size: 22px;font-weight: 700">
					健康管理系统
				  </div>
			      <div class="login-field">
			           <form action="check.php" method="post" name="ThisForm">
							<table width="100%" border="0" cellspacing="10">
							  <tr>
								<td width="80" align="right">
								   <span class="cRed">账号:</span>
							    </td>
								<td width="150">
								   <input class="input-text" type="text" name="userName" value="" style="width: 200px;height:26px"/>
								</td>
							  </tr>
							  <tr>
								<td width="80" align="right">
								   <span class="cRed">密码:</span>
							    </td>
								<td width="150">
								   <input class="input-text" type="password" name="userPw" value="" style="width: 200px;height:26px"/>
								</td>
							  </tr>
							  <%--<tr>
								<td width="80" align="right">
								   <span class="cRed">类型:</span>
							    </td>
								<td width="150">
								     <select name="userType" id="userType"  style="width: 205px;height:30px"> 
                                         <option value="0">管理员</option>
                                         <option value="1">用户</option>	
                                     </select>
								</td>
							  </tr>--%>
							  <tr>
								<td width="80" align="right">
							    </td>
								<td rowspan="2">
								   <input type="button" value="登陆"  id="log" style="width: 80px;height:30px"/>&nbsp; 
								   
								   <input type="button" value="用户注册"  onclick="location.href='<%=path %>/pages/user/userreg.jsp'" style="width: 80px;height:30px"/>&nbsp; 
								   								                        	<span id="msg">${msg}</span>   
								   <img id="indicator" src="<%=path %>/pages/login/loading.gif" style="display:none"/>
								</td>
							  </tr>
							</table>
				       </form>
			      </div>
		      </div>
	      </div>
      </div>
  </body>
</html>

<script>
$(function(){
$("#log").on('click',function(event) {
var username = $("input[name='userName']").val();
var pwd = $("input[name='userPw']").val();
var userType =  $('#userType').val();
if(username==''){
	alert("用户名不能为空！");
			//$('#msg').addClass('text-danger').text('用户名不能为空！');
			return false;
		}
		if(pwd==''){
				alert("密码不能为空!");

			//$('#msg').addClass('text-danger').text('密码不能为空！');
			return false;
		}
	$.ajax({
			url: '/check',
			type: 'post',
			data: {"username": username,"pwd": pwd,"userType":userType},
			beforeSend: function(){
				$('#msg').addClass('text-success').text('正在登录...');
				//$(".log").attr('disabled',true);
			},
			dataType: 'json',
				success: function(rs){
				var status=rs.status;
				var msg=rs.msg;
			//	alert(msg);
				if(status=="1"){ //登录成功
					alert(msg);
					$('#msg').removeClass('text-danger').addClass('text-success').text('登录成功！');

					location.href='/pages/adminindex.jsp';

				}else{
				alert(msg);
					$('#msg').addClass('text-danger').text('用户名或密码错误！');
				}
			},
			error:function(){
				alert("发生登录异常");
			}
		});

});
});
		
		
	    </script>

