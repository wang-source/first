package com.yzit.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yzit.demo.entity.Student;

@RestController
public class StudentController {

	@PostMapping("/stu")
	public String add( @RequestBody  @Valid Student stu ,BindingResult result){
		
		StringBuffer  errorMsg = new StringBuffer();
		if(result.hasErrors()){//判断校验是否成功
			 List<ObjectError> errorList = result.getAllErrors();//获取校验失败信息
	            for(ObjectError error : errorList){
	                System.out.println(error.getDefaultMessage());
	                errorMsg.append(error.getDefaultMessage() +" ;<br/>");
	            }

		}
		if(errorMsg.length() > 0 ){
			return errorMsg.toString();
		}
		
		return "成功成功";
	}
}
