package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Health;
import com.service.HealthService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class HealthController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	HealthService healthService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("healthmy")
	public String listHealthmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("danwei")) && request.getParameter("danwei") !=null)
w=w+ " and danwei like '%"+request.getParameter("danwei")+"%'";

if (!"".equals(request.getParameter("xiangmu")) && request.getParameter("xiangmu") !=null)
w=w+ " and xiangmu like '%"+request.getParameter("xiangmu")+"%'";

if (!"".equals(request.getParameter("jieguo")) && request.getParameter("jieguo") !=null)
w=w+ " and jieguo like '%"+request.getParameter("jieguo")+"%'";

if (!"".equals(request.getParameter("cuoshi")) && request.getParameter("cuoshi") !=null)
w=w+ " and cuoshi like '%"+request.getParameter("cuoshi")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Health> cs= healthService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Health health=(Health)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Health> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/health/healthmy";
	}
//体检记录列表管理页面
	@RequestMapping("healthlist")
	public String listHealth(Model model){
String w="";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("danwei")) && request.getParameter("danwei") !=null)
w=w+ " and danwei like '%"+request.getParameter("danwei")+"%'";

if (!"".equals(request.getParameter("xiangmu")) && request.getParameter("xiangmu") !=null)
w=w+ " and xiangmu like '%"+request.getParameter("xiangmu")+"%'";

if (!"".equals(request.getParameter("jieguo")) && request.getParameter("jieguo") !=null)
w=w+ " and jieguo like '%"+request.getParameter("jieguo")+"%'";

if (!"".equals(request.getParameter("cuoshi")) && request.getParameter("cuoshi") !=null)
w=w+ " and cuoshi like '%"+request.getParameter("cuoshi")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Health> cs= healthService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Health health=(Health)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Health> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		
		return "pages/health/healthlist";
	}

	@RequestMapping("healthadd")
	public String addhealth(Model model){

	return "pages/health/healthadd";
	}
	//添加体检记录数据
	@RequestMapping("healthinsert")
	public String insertHealth(Health health,Model model){
	String forword=request.getParameter("forword");
		healthService.insert(health);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除体检记录数据
	@RequestMapping("healthdel")
	public String deleteHealth(Health health,Model model){
		String forword=request.getParameter("forword");
		healthService.delete(health);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的体检记录数据
	@RequestMapping("healthedit")
	public String editHealth(Model model,Health health){
		Health c= healthService.get(health.getId());

		model.addAttribute("c", c);
		return "pages/health/healthedit";
	}

	//修改的体检记录数据
	@RequestMapping("healthupdate")
	public String updateHealth(Health health,Model model){
		String forword=request.getParameter("forword");
		healthService.update(health);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//体检记录所有列表页
	@RequestMapping("healthAll")
	public String listHealthAll(Model model){
String w="";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("danwei")) && request.getParameter("danwei") !=null)
w=w+ " and danwei like '%"+request.getParameter("danwei")+"%'";

if (!"".equals(request.getParameter("xiangmu")) && request.getParameter("xiangmu") !=null)
w=w+ " and xiangmu like '%"+request.getParameter("xiangmu")+"%'";

if (!"".equals(request.getParameter("jieguo")) && request.getParameter("jieguo") !=null)
w=w+ " and jieguo like '%"+request.getParameter("jieguo")+"%'";

if (!"".equals(request.getParameter("cuoshi")) && request.getParameter("cuoshi") !=null)
w=w+ " and cuoshi like '%"+request.getParameter("cuoshi")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Health> cs= healthService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Health health=(Health)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Health> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
		// 放入转发参数
		return "pages/health/healthAll";
	}
}