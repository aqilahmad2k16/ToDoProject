package com.codingcode.task.manager.Notes;


import com.codingcode.task.manager.Tasks.TaskEntity;
import com.codingcode.task.manager.common.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class NoteEntity extends BaseEntity {
	@Column(name = "title", length = 200)
	String title;
	
	@Column(name = "body", length = 200)
	String body;
	
	@ManyToOne
	@JoinColumn(name = "task_id")
	TaskEntity task;	
}
