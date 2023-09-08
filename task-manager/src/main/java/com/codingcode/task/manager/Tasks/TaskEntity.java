package com.codingcode.task.manager.Tasks;

import java.util.Date;
import java.util.List;

import com.codingcode.task.manager.Notes.NoteEntity;
import com.codingcode.task.manager.common.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tasks")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class TaskEntity extends BaseEntity {

	@Column(name = "name", nullable = false)
	String name;
	
	@Column(name = "due_data", nullable = false)
	Date dueDate;
	
	@Column(name = "done",nullable = false, columnDefinition = "boolean default false")
	boolean done;
	
	@OneToMany(mappedBy = "task", cascade = CascadeType.ALL)
	@ToString.Exclude
	List<NoteEntity> notes;
	
	//1. the mappedBy = "parent" specifies that the parent field in the Child entity is responsible for managing the relationship.
	//2. When you define a cascade type on a One-to-Many relationship, it determines how operations such as persisting, merging, refreshing, and removing entities should be propagated from the parent entity (the "one" side) to the associated child entities (the "many" side).
	//3. CascadeType.ALL: This cascade type includes all of the above cascade types: PERSIST, MERGE, REFRESH, and REMOVE. It specifies that all operations performed on the parent entity should be cascaded to the associated child entities.
	//4. When you apply @ToString.Exclude to a field in a class, Lombok excludes that field from being included in the generated toString() method.
	
	public void setNotes(List<NoteEntity> notes) {
		this.notes = notes;
	}
}
