package com.codingcode.task.manager.Tasks;
import java.util.List;

//import Tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/tasks")
public class TasksController {
	
	@Autowired
	public TasksService tasksService;
	/*
	 * GetMapping("")
	 */
	@GetMapping("")
	public ResponseEntity<List<TaskDto>> getAllTasks(){
		List<TaskDto> tasks = tasksService.getAllTasks();
		return ResponseEntity.ok(tasks);
	}
	
	/*
	 * GetMapping("/{id}")
	 */
	
	@GetMapping("/{taskId}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable Long taskId){
		TaskDto task = tasksService.getTaskById(taskId);
		return ResponseEntity.ok(task);
	}
	
	/*
	 * PostMapping("")
	 */
	
	@PostMapping("")
	public ResponseEntity<TaskDto> createNewTask(@RequestBody TaskDto taskDto){
		return ResponseEntity.ok(tasksService.createNewTask(taskDto));
	}
	
	/*
	 * PatchMapping("/{id}")
	 */
	
	@PatchMapping("/{taskID}")
	public ResponseEntity<TaskDto> updateTaskById(@RequestBody TaskDto taskDto, @PathVariable Long taskId){
		//patch api is use to update entity partially but wont remove old object infact it update their fields
		return ResponseEntity.ok(tasksService.updateTaskById(taskDto,taskId));
	}
	
	/*
	 * updateMapping("/{id}")
	 */
	@PutMapping("/{taskId}")
	public ResponseEntity<TaskDto> updateTaskCompletely(@RequestBody TaskDto taskDto, @PathVariable Long taskId){
		return ResponseEntity.ok(tasksService.updateTaskCompletely(taskDto, taskId));
	}
	
	/*
	 * DeleteMapper ("/{id}")
	 */
	
	@DeleteMapping("/{taskId}")
	public String removeTaskById(@PathVariable Long taskId) {
		return tasksService.removeTaskById(taskId);
	}
	 
}
