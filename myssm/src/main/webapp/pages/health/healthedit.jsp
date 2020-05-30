<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <title>体检记录 </title>
    <!-- Bootstrap -->
	    	<script src="<%=path %>/js/jquery.min.js"></script>
    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/my.css" rel="stylesheet">
	<script src="<%=path %>/js/bootstrap.min.js"></script>
<script src="<%=path %>/js/laydate/laydate.js"></script>
 <script src="<%=path %>/ueditor/ueditor.config.js"></script>
       <script src="<%=path %>/ueditor/ueditor.all.js"></script>
  <script src="<%=path %>/layer/layer.js"></script>


</head>
<body>  
<div class="container">


<script>
function check()
{

 if (document.formAdd.sdate.value=="")
  {
    alert("检查日期不能为空！");
    document.formAdd.sdate.focus();
    return false;
  }

 if (document.formAdd.name.value=="")
  {
    alert("名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.danwei.value=="")
  {
    alert("检查医院不能为空！");
    document.formAdd.danwei.focus();
    return false;
  }

 if (document.formAdd.xiangmu.value=="")
  {
    alert("检查项目不能为空！");
    document.formAdd.xiangmu.focus();
    return false;
  }

 if (document.formAdd.jieguo.value=="")
  {
    alert("检查结果不能为空！");
    document.formAdd.jieguo.focus();
    return false;
  }

 if (document.formAdd.cuoshi.value=="")
  {
    alert("采取措施不能为空！");
    document.formAdd.cuoshi.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="healthupdate" class="form-horizontal" role="form">
<fieldset> <legend>修改体检记录</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
   <label class="col-sm-2 control-label" for="sdate">检查日期</label>
    <div class="col-sm-4">
	<input name="sdate" type="text" id="sdate" class="form-control" <%=new SimpleDateFormat("yyyy-MM-dd").format(new Date())%> value="${c.sdate}" onClick="laydate({istime: false, format: 'YYYY-MM-DD'})"/>
</div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">名称</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="danwei">检查医院</label>
      <div class="col-sm-4">
<input name="danwei" type="text" id="danwei"  value="${c.danwei}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xiangmu">检查项目</label>
      <div class="col-sm-4">
<input name="xiangmu" type="text" id="xiangmu"  value="${c.xiangmu}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="jieguo">检查结果</label>
      <div class="col-sm-4">
<input name="jieguo" type="text" id="jieguo"  value="${c.jieguo}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="cuoshi">采取措施</label>
      <div class="col-sm-4">
<input name="cuoshi" type="text" id="cuoshi"  value="${c.cuoshi}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="beizhu">备注</label>
      <div class="col-sm-4">
<input name="beizhu" type="text" id="beizhu"  value="${c.beizhu}"  class="form-control" >
 </div>
	</div>

<input name="zt" type="hidden" value="未审核">

	</fieldset>  
   <fieldset>
     <legend></legend>
		<div class="form-group">
            <div class="col-sm-10 col-sm-offset-2">
			 <input name="forword" type="hidden" value="${param.forword}"/>
           <button type="button" class="btn  btn-primary" onclick="check()">保存数据</button>
	 <button type="button" class="btn btn-default" onClick="history.back(-1)">返回</button>

    </div>
</div>
	 </fieldset>
</form>
</div>
    </body>
 </html>  
  