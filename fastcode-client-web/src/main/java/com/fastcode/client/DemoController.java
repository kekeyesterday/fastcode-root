package com.fastcode.client;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fastcode.inf.IMyDemo;
import com.fastcode.inf.vo.UserVo;

@RestController
@RequestMapping(value = "/demo")
//@RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。 
public class DemoController {
	@Autowired
	private IMyDemo myDemoService = null;

	//restful路径匹配 consumes:请求的数据格式  produce:返回的格式
	@RequestMapping(value = "/greeting/{name}", method = RequestMethod.GET,consumes="application/json")
	
	//@ResponseBody
	public UserVo greeting(HttpServletRequest req, @PathVariable("name") String name) {
		String msg = myDemoService.getMsg(name);
		UserVo uv = new UserVo();
		uv.setDesc(msg);
		return uv;
	}
	
	@RequestMapping(value = "/userInfo/{userId}", method = RequestMethod.GET,produces="text/plain;charset=UTF-8")
	//@ResponseBody
	public String getUserInfo(HttpServletRequest req, @PathVariable("userId") Long userId){
		System.out.println("=============测试下===============");
		//myDemoService = SpringContextUtil.getBean("myDemoService",IMyDemo.class);
		String msg = myDemoService.getUserInfo(userId);
		return msg;
	}
	
	//restful路径匹配
	@RequestMapping(value = "/put/{name}", method = RequestMethod.PUT)
	@ResponseBody
	public UserVo putTest(HttpServletRequest req, @PathVariable("name") String name) {
		String msg = myDemoService.getMsg(name);
		UserVo uv = new UserVo();
		uv.setDesc(msg);
		return uv;
	}
	
	//restful路径匹配
	@RequestMapping(value = "/del/{name}", method = RequestMethod.DELETE)
	@ResponseBody
	public UserVo delTest(HttpServletRequest req, @PathVariable("name") String name) {
		String msg = myDemoService.getMsg(name);
		UserVo uv = new UserVo();
		uv.setDesc(msg);
		return uv;
	}

	/**
	 * 文件上传
	 * @param req
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/resourceUpload", produces = {
			"application/json;charset=UTF-8" }, method = RequestMethod.POST)
	@ResponseBody
	public String resourceUpload(HttpServletRequest req,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		System.out.println("fileName:" + file.getOriginalFilename());
		return "success";
	}
	
	//正则表达式
	@RequestMapping(value = "/bars/{numericId:[\\d*]}")
	@ResponseBody
	public String getBarsBySimplePathWithPathVariable(@PathVariable final int numericId) {
	    return "Get a specific Bar with id=" + numericId;
	}
	
	//多路径匹配
	@RequestMapping(value = { "/advanced/bars", "/advanced/foos" })
	@ResponseBody
	public String getFoosOrBarsByPath() {
	    return "Advanced - Get some Foos or Bars";
	}
	
	



}
