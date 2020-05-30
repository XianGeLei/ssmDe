package com.controller;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.entity.Dangan;
import com.service.DanganService;

import com.util.Page;
import com.util.Pagesize;
import com.util.Pagination;
//告诉spring mvc这是一个控制器类
@Controller
//RequestMapping注解会将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上。 
@RequestMapping("")
public class DanganController {
	//它可以对类成员变量,方法及构造函数进行标注,完成自动装配的工作,通过 @Autowired的使用来消除 set,get方法
	@Autowired
	DanganService danganService;
@Autowired
HttpServletRequest request;
//个人列表页
	@RequestMapping("/danganmy")
	public String listDanganmy(Model model){
		HttpSession session=request.getSession();
		String uname= (String) session.getAttribute("loginname");
		String w=" and uname='"+uname+"'";
		
if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("xuetang")) && request.getParameter("xuetang") !=null)
w=w+ " and xuetang like '%"+request.getParameter("xuetang")+"%'";

if (!"".equals(request.getParameter("xuezhi")) && request.getParameter("xuezhi") !=null)
w=w+ " and xuezhi like '%"+request.getParameter("xuezhi")+"%'";

if (!"".equals(request.getParameter("ganyou")) && request.getParameter("ganyou") !=null)
w=w+ " and ganyou like '%"+request.getParameter("ganyou")+"%'";

if (!"".equals(request.getParameter("xueya1")) && request.getParameter("xueya1") !=null)
w=w+ " and xueya1 like '%"+request.getParameter("xueya1")+"%'";

if (!"".equals(request.getParameter("xueya")) && request.getParameter("xueya") !=null)
w=w+ " and xueya like '%"+request.getParameter("xueya")+"%'";

if (!"".equals(request.getParameter("xinlv")) && request.getParameter("xinlv") !=null)
w=w+ " and xinlv like '%"+request.getParameter("xinlv")+"%'";

if (!"".equals(request.getParameter("tiwen")) && request.getParameter("tiwen") !=null)
w=w+ " and tiwen like '%"+request.getParameter("tiwen")+"%'";

if (!"".equals(request.getParameter("huxi")) && request.getParameter("huxi") !=null)
w=w+ " and huxi like '%"+request.getParameter("huxi")+"%'";

if (!"".equals(request.getParameter("shiyu")) && request.getParameter("shiyu") !=null)
w=w+ " and shiyu like '%"+request.getParameter("shiyu")+"%'";

if (!"".equals(request.getParameter("shui")) && request.getParameter("shui") !=null)
w=w+ " and shui like '%"+request.getParameter("shui")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dangan> cs= danganService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dangan dangan=(Dangan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dangan> cs1 = cs.subList(fromIndex, toIndex);
				Pagination p = new Pagination();//创建 分页对象
		        p.setIndex(index);//设置页数
		        p.setPageSize(Pagesize.size);
		        p.setTotle(cs.size());//设置总共的条数
		        p.setData(cs1);//设置数据
			
		// 放入转发参数
		model.addAttribute("cs", p);
		model.addAttribute("page", p);
		model.addAttribute("dlist", cs);		
	return "pages/dangan/danganmy";
	}
//健康档案列表管理页面
	@RequestMapping("/danganlist")
	public String listDangan(Model model){
		System.out.println("DangAnList-------------");
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("xuetang")) && request.getParameter("xuetang") !=null)
w=w+ " and xuetang like '%"+request.getParameter("xuetang")+"%'";

if (!"".equals(request.getParameter("xuezhi")) && request.getParameter("xuezhi") !=null)
w=w+ " and xuezhi like '%"+request.getParameter("xuezhi")+"%'";

if (!"".equals(request.getParameter("ganyou")) && request.getParameter("ganyou") !=null)
w=w+ " and ganyou like '%"+request.getParameter("ganyou")+"%'";

if (!"".equals(request.getParameter("xueya1")) && request.getParameter("xueya1") !=null)
w=w+ " and xueya1 like '%"+request.getParameter("xueya1")+"%'";

if (!"".equals(request.getParameter("xueya")) && request.getParameter("xueya") !=null)
w=w+ " and xueya like '%"+request.getParameter("xueya")+"%'";

if (!"".equals(request.getParameter("xinlv")) && request.getParameter("xinlv") !=null)
w=w+ " and xinlv like '%"+request.getParameter("xinlv")+"%'";

if (!"".equals(request.getParameter("tiwen")) && request.getParameter("tiwen") !=null)
w=w+ " and tiwen like '%"+request.getParameter("tiwen")+"%'";

if (!"".equals(request.getParameter("huxi")) && request.getParameter("huxi") !=null)
w=w+ " and huxi like '%"+request.getParameter("huxi")+"%'";

if (!"".equals(request.getParameter("shiyu")) && request.getParameter("shiyu") !=null)
w=w+ " and shiyu like '%"+request.getParameter("shiyu")+"%'";

if (!"".equals(request.getParameter("shui")) && request.getParameter("shui") !=null)
w=w+ " and shui like '%"+request.getParameter("shui")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dangan> cs= danganService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dangan dangan=(Dangan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dangan> cs1 = cs.subList(fromIndex, toIndex);
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
		
		return "pages/dangan/danganlist";
	}

	@RequestMapping("/danganadd")
	public String adddangan(Model model){

	return "pages/dangan/danganadd";
	}
	//添加健康档案数据
	@RequestMapping("/danganinsert")
	public String insertDangan(Dangan dangan,Model model){
	String forword=request.getParameter("forword");
		danganService.insert(dangan);
		model.addAttribute("msg","成功");
		model.addAttribute("path",forword);
		return "success";
	
	}	
	//删除健康档案数据
	@RequestMapping("dangandel")
	public String deleteDangan(Dangan dangan,Model model){
		String forword=request.getParameter("forword");
		danganService.delete(dangan);
		model.addAttribute("msg","删除成功");
 model.addAttribute("path",forword);
		return "success";
	}//提取要修改的健康档案数据
	@RequestMapping("danganedit")
	public String editDangan(Model model,Dangan dangan){
		Dangan c= danganService.get(dangan.getId());

		model.addAttribute("c", c);
		return "pages/dangan/danganedit";
	}

	//修改的健康档案数据
	@RequestMapping("danganupdate")
	public String updateDangan(Dangan dangan,Model model){
		String forword=request.getParameter("forword");
		danganService.update(dangan);
		model.addAttribute("msg","操作成功");
 model.addAttribute("path",forword);
		return "success";
	}
//健康档案所有列表页
	@RequestMapping("/danganAll")
	public String listDanganAll(Model model){
String w="";

if (!"".equals(request.getParameter("name")) && request.getParameter("name") !=null)
w=w+ " and name like '%"+request.getParameter("name")+"%'";

if (!"".equals(request.getParameter("sdate")) && request.getParameter("sdate") !=null)
w=w+ " and sdate like '%"+request.getParameter("sdate")+"%'";

if (!"".equals(request.getParameter("xuetang")) && request.getParameter("xuetang") !=null)
w=w+ " and xuetang like '%"+request.getParameter("xuetang")+"%'";

if (!"".equals(request.getParameter("xuezhi")) && request.getParameter("xuezhi") !=null)
w=w+ " and xuezhi like '%"+request.getParameter("xuezhi")+"%'";

if (!"".equals(request.getParameter("ganyou")) && request.getParameter("ganyou") !=null)
w=w+ " and ganyou like '%"+request.getParameter("ganyou")+"%'";

if (!"".equals(request.getParameter("xueya1")) && request.getParameter("xueya1") !=null)
w=w+ " and xueya1 like '%"+request.getParameter("xueya1")+"%'";

if (!"".equals(request.getParameter("xueya")) && request.getParameter("xueya") !=null)
w=w+ " and xueya like '%"+request.getParameter("xueya")+"%'";

if (!"".equals(request.getParameter("xinlv")) && request.getParameter("xinlv") !=null)
w=w+ " and xinlv like '%"+request.getParameter("xinlv")+"%'";

if (!"".equals(request.getParameter("tiwen")) && request.getParameter("tiwen") !=null)
w=w+ " and tiwen like '%"+request.getParameter("tiwen")+"%'";

if (!"".equals(request.getParameter("huxi")) && request.getParameter("huxi") !=null)
w=w+ " and huxi like '%"+request.getParameter("huxi")+"%'";

if (!"".equals(request.getParameter("shiyu")) && request.getParameter("shiyu") !=null)
w=w+ " and shiyu like '%"+request.getParameter("shiyu")+"%'";

if (!"".equals(request.getParameter("shui")) && request.getParameter("shui") !=null)
w=w+ " and shui like '%"+request.getParameter("shui")+"%'";

if (!"".equals(request.getParameter("zt")) && request.getParameter("zt") !=null)
w=w+ " and zt like '%"+request.getParameter("zt")+"%'";

		List<Dangan> cs= danganService.list(w);
		for(int i=0;i<cs.size();i++)
		{
			Dangan dangan=(Dangan)cs.get(i);
}
int index=0;
				if(request.getParameter("index")==null)
				{index=1;}
				else
				{index=Integer.parseInt(request.getParameter("index"));}
				int fromIndex = (index - 1) * Pagesize.size;
				int toIndex = Math.min(fromIndex + Pagesize.size, cs.size());
		         List<Dangan> cs1 = cs.subList(fromIndex, toIndex);
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
		return "pages/dangan/danganAll";
	}
}