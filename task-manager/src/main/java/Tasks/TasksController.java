package Tasks;
import java.util.List;

//import Tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
}
