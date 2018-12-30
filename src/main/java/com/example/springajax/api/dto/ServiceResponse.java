package com.example.springajax.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ServiceResponse<T> {

	public ServiceResponse(String string, Book book) {
		// TODO Auto-generated constructor stub
	}
	private String status;
	private T data;
	
}
