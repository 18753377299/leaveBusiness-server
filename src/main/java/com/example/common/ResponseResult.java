package com.example.common;

import lombok.Data;

@Data
public class ResponseResult {
	
	// 返回结果信息
	private Object result;
	// 状态标志位
	private String  status;
	// 返回的信息
	private String message;
	
}
