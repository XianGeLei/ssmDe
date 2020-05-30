<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>健康档案 </title>
    <!-- Bootstrap -->
	    	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script  src="<%=path %>/js/laydate/laydate.js"></script>
	<script type="text/javascript">
		</script>
	      

</head>

<table   class="table table-hover">
 <tr> <th>
<form name="formsea" class="form-inline" role="form" method="post" action="<%=path %>/danganmy">
  
  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="name" id="name" class="form-control" placeholder="名称"/>
	</div>
  </div>

  <div class="form-group">
    <div class="col-sm-2">
	<input type="text" name="sdate" id="sdate"  class="form-control" onClick="laydate({istime: false, format: 'YYYY-MM-DD'})" placeholder="日期"/>
	</div>
  </div>
  

 <button type="submit"  class="btn  btn-primary">查询</button>

          </form>   </th>
        </tr>    
</table>

<table class="table table-hover table-striped table-bordered">
 <tr><th>&nbsp; &nbsp; 
 血糖（空腹：3.9-6.1mmol/L）
血压（收缩压：90-139mmHg，舒张压：60-89mmHg）可以分成两项写
血脂（甘油三酯：0.56-1.7mmol/L，胆固醇酯：2.8-5.17mmol/L）
心率：60-100/分钟
体温（腋窝）：36-37摄氏度
呼吸次数：12-20次/分钟
睡眠时间（成年人：6-8小时）

</th></tr></table>
<table class="table table-hover table-striped table-bordered">
 <thead>
 <tr>
<th>序号</th>
<th>名称</th>
<th>日期</th>
<th>血糖</th>
<th>总胆固醇</th>
<th>甘油三酯</th>
<th>低压</th>
<th>高压</th>
<th>心率</th>
<th>体温</th>
<th>呼吸次数</th>
<th>食欲</th>
<th>睡眠</th>
<th>健康状态</th>
<th>健康分析</th>
<th>操作</th></tr></thead>
<c:forEach items="${requestScope.page.data}" var="c"  varStatus="ss">

 <tbody><tr>
<td>${ss.index+1}</td>

<td>${c.name}</td>

<td>${c.sdate}</td>

<td>${c.xuetang}
<c:if test="${c.xuetang>='3.9' && c.xuetang<='6.1'}">
 -
</c:if>
 <c:if test="${c.xuetang>'6.1'}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.xuetang<'3.9'}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.xuezhi}
<c:if test="${c.xuezhi>=2.8 && c.xuezhi<=5.17}">
 -
</c:if>
 <c:if test="${c.xuezhi>5.17}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.xuezhi<2.8}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.ganyou}
<c:if test="${c.ganyou>=0.56 && c.ganyou<=1.7}">
 -
</c:if>
 <c:if test="${c.ganyou>1.7}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.ganyou<0.56}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.xueya1}
<c:if test="${c.xueya1>=60 && c.xueya1<90}">
 -
</c:if>
 <c:if test="${c.xueya1>=90}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.xueya1<=60}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.xueya}
<c:if test="${c.xueya>=110 && c.xueya<=130}">
 -
</c:if>
 <c:if test="${c.xueya>130}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.xueya<100}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.xinlv}
<c:if test="${c.xinlv>=60 && c.xinlv<=110}">
 -
</c:if>
 <c:if test="${c.xinlv>110}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.xinlv<60}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.tiwen}
<c:if test="${c.tiwen>=36 && c.tiwen<37}">
 -
</c:if>
 <c:if test="${c.tiwen>=37}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.tiwen<36}">
<font color=green size=5>↓</font>
</c:if></td>

<td>${c.huxi}
<c:if test="${c.huxi>=12 && c.huxi<=20}">
 -
</c:if>
 <c:if test="${c.huxi>20}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.huxi<12}">
<font color=green size=5>↓</font>
</c:if>


</td>

<td>${c.shiyu}</td>

<td>${c.shui}
<c:if test="${c.shui>=6 && c.shui<=8}">
 -
</c:if>
 <c:if test="${c.shui>8}">
<font color=red size=5 >↑</font>
</c:if>
 <c:if test="${c.shui<6}">
<font color=green size=5>↓</font>
</c:if>

</td>

<td>${c.zt}</td>

<td>${c.yijian}</td>

<td>
 <a href="<%=path %>/danganedit?id=${c.id}&forword=danganmy" class="btn btn-default">修改</a> |
 <a href="dangandel?id=${c.id}&forword=danganmy" onClick="return confirm('您确定要删除吗?')" class="btn btn-default">删除</a>

 </td>
</tr></tbody>
</c:forEach> </table><script type="text/javascript">
	       function go(index)
           {
               window.location.href="<%=path %>/danganmy?index="+index;
           }
</script>
<table class="table table-hover table-striped table-bordered">
						        <tr>
							        <td>
							                  共<span style="color:#FF0000">${requestScope.page.totle}</span>条记录&nbsp;&nbsp;&nbsp;&nbsp;
							                  每页<span style="color:#FF0000">${requestScope.page.pageSize}</span>条&nbsp;&nbsp;&nbsp;&nbsp;
							                  第<span style="color:#FF0000">${requestScope.page.index}</span>页/共${requestScope.page.totlePage}页&nbsp;&nbsp;&nbsp;&nbsp;
							                <c:if test="${requestScope.page.index==1}">
							                       首&nbsp;&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;上一页&nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index!=1}">
							                       <a style="color: red" href="#" onclick="go(1)">首&nbsp;&nbsp;页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.index-1})">上一页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index >= requestScope.page.totlePage}">
							                          下一页&nbsp;&nbsp;&nbsp;&nbsp;末&nbsp;&nbsp;页&nbsp;&nbsp;&nbsp;&nbsp;
							                </c:if>
							                <c:if test="${requestScope.page.index < requestScope.page.totlePage}">
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.index+1})">下一页</a>
							                       &nbsp;&nbsp;&nbsp;&nbsp;
							                       <a style="color: red" href="#" onclick="go(${requestScope.page.totlePage})">末&nbsp;&nbsp;页</a>
							                </c:if>
							        </td>
						       </tr>
  </table>