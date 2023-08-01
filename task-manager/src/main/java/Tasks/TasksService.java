package Tasks;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TasksService {
	
	@Autowired
	private TasksRepository tasksRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	public List<TaskDto> getAllTasks() {
		return tasksRepository.findAll().stream().map(task -> mapper.map(task, TaskDto.class)).collect(Collectors.toList());
	}

	public TaskDto getTaskById(Long taskId) {
//		TaskEntity task = tasksRepository.findById(taskId).orElseThrow(()-> new IllegalArgumentException("user not found  with id " + taskId));
		return mapper.map(tasksRepository.findById(taskId), TaskDto.class);
	}

	public TaskDto createNewTask(TaskDto taskDto) {
		//convert dto to entity
		TaskEntity taskEntity = mapper.map(taskDto, TaskEntity.class);
		//save entity to DB
		tasksRepository.save(taskEntity);
		//convert entity to dto
		TaskDto tasDto = mapper.map(taskEntity, TaskDto.class);
		return tasDto;
	}

	public TaskDto updateTaskById(TaskDto taskDto, Long taskId) {
		TaskEntity entity = tasksRepository.findById(taskId).get();
		entity.setName(taskDto.getName());
		entity.setDone(taskDto.getDone());
		entity.setDueDate(taskDto.getDueDate());
		return mapper.map(tasksRepository.save(entity), TaskDto.class);
	}
	
	
	

}
