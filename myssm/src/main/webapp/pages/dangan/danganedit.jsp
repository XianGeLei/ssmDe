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
    <title>健康档案 </title>
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

 if (document.formAdd.name.value=="")
  {
    alert("名称不能为空！");
    document.formAdd.name.focus();
    return false;
  }

 if (document.formAdd.sdate.value=="")
  {
    alert("日期不能为空！");
    document.formAdd.sdate.focus();
    return false;
  }

 if (document.formAdd.xuetang.value=="")
  {
    alert("血糖不能为空！");
    document.formAdd.xuetang.focus();
    return false;
  }

 if (document.formAdd.xuezhi.value=="")
  {
    alert("总胆固醇不能为空！");
    document.formAdd.xuezhi.focus();
    return false;
  }

 if (document.formAdd.ganyou.value=="")
  {
    alert("甘油三酯不能为空！");
    document.formAdd.ganyou.focus();
    return false;
  }

 if (document.formAdd.xueya1.value=="")
  {
    alert("低压不能为空！");
    document.formAdd.xueya1.focus();
    return false;
  }

 if (document.formAdd.xueya.value=="")
  {
    alert("高压不能为空！");
    document.formAdd.xueya.focus();
    return false;
  }

 if (document.formAdd.xinlv.value=="")
  {
    alert("心率不能为空！");
    document.formAdd.xinlv.focus();
    return false;
  }

 if (document.formAdd.tiwen.value=="")
  {
    alert("体温不能为空！");
    document.formAdd.tiwen.focus();
    return false;
  }

 if (document.formAdd.huxi.value=="")
  {
    alert("呼吸次数不能为空！");
    document.formAdd.huxi.focus();
    return false;
  }

 if (document.formAdd.shiyu.value=="")
  {
    alert("食欲不能为空！");
    document.formAdd.shiyu.focus();
    return false;
  }

 if (document.formAdd.shui.value=="")
  {
    alert("睡眠不能为空！");
    document.formAdd.shui.focus();
    return false;
  }

document.formAdd.submit();
}
</script><form name="formAdd" method="post" action="danganupdate" class="form-horizontal" role="form">
<fieldset> <legend>修改健康档案</legend>

<input type="hidden" name="id" value="${c.id}"/>


<div class="form-group">
    <label class="col-sm-2 control-label" for="name">名称</label>
      <div class="col-sm-4">
<input name="name" type="text" id="name"  value="${c.name}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
   <label class="col-sm-2 control-label" for="sdate">日期</label>
    <div class="col-sm-4">
	<input name="sdate" type="text" id="sdate" class="form-control" value="${c.sdate}" onClick="laydate({istime: false, format: 'YYYY-MM-DD'})"/>
</div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xuetang">血糖</label>
      <div class="col-sm-4">
<input name="xuetang" type="text" id="xuetang"  value="${c.xuetang}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xuezhi">总胆固醇</label>
      <div class="col-sm-4">
<input name="xuezhi" type="text" id="xuezhi"  value="${c.xuezhi}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="ganyou">甘油三酯</label>
      <div class="col-sm-4">
<input name="ganyou" type="text" id="ganyou"  value="${c.ganyou}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xueya1">低压</label>
      <div class="col-sm-4">
<input name="xueya1" type="text" id="xueya1"  value="${c.xueya1}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xueya">高压</label>
      <div class="col-sm-4">
<input name="xueya" type="text" id="xueya"  value="${c.xueya}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="xinlv">心率</label>
      <div class="col-sm-4">
<input name="xinlv" type="text" id="xinlv"  value="${c.xinlv}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="tiwen">体温</label>
      <div class="col-sm-4">
<input name="tiwen" type="text" id="tiwen"  value="${c.tiwen}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="huxi">呼吸次数</label>
      <div class="col-sm-4">
<input name="huxi" type="text" id="huxi"  value="${c.huxi}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="shiyu">食欲</label>
      <div class="col-sm-4">
<input name="shiyu" type="text" id="shiyu"  value="${c.shiyu}"  class="form-control" >
 </div>
	</div>


<div class="form-group">
    <label class="col-sm-2 control-label" for="shui">睡眠</label>
      <div class="col-sm-4">
<input name="shui" type="text" id="shui"  value="${c.shui}"  class="form-control" >
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
  