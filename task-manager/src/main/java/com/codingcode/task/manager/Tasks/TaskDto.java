package com.codingcode.task.manager.Tasks;

import java.util.Date;

import org.springframework.lang.Nullable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;



@Data
public class TaskDto {

	@Nullable
	Long id;
	
	@Nullable
	String name;
	
	@Nullable
	Date dueDate;
	
	@Nullable 
	Boolean done;
}
