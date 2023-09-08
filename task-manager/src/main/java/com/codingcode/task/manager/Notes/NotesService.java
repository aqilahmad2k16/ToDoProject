package com.codingcode.task.manager.Notes;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
//import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.codingcode.task.manager.Tasks.TaskEntity;
import com.codingcode.task.manager.Tasks.TasksRepository;

@Service
public class NotesService {
	private static final Logger logger = (Logger) LogManager.getLogger(NotesService.class);
	@Autowired
	private NotesRepository notesRepository;

	@Autowired
	private TasksRepository tasksRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	
	public List<NoteDto> getAllNotesByTaskId(Long taskId) throws Throwable {
		// add exception handle for whether this task is exist or not
		if (tasksRepository.existsById(taskId)) {
			logger.info("task with taskId " + taskId + " is available");
			TaskEntity taskEntity = tasksRepository.findById(taskId).orElse(null);
			List<NoteEntity> noteEntities = taskEntity.getNotes();
			if (noteEntities.size() == 0) {
				throw new Exception("this task doesn't have any Notes");
			}

			List<NoteDto> noteDtos = new ArrayList<>();
			noteEntities.forEach(entity -> noteDtos.add(mapper.map(entity, NoteDto.class)));
			return noteDtos;
		} else {
			throw new Exception("task with taskId " + taskId + " is not found, please enter a valid id");
		}

	}

	public NoteDto addNoteToTask(Long taskId, NoteDto noteDto) throws Exception {
		// add exception handle for whether this task is exist or not
		if (tasksRepository.existsById(taskId)) {
			logger.info("task with taskId " + taskId + " is available");
			TaskEntity taskEntity = tasksRepository.findById(taskId).orElse(null);
			List<NoteEntity> noteEntities = taskEntity.getNotes();
			noteEntities.add(mapper.map(noteDto, NoteEntity.class));
			taskEntity.setNotes(noteEntities);
			notesRepository.save(mapper.map(noteDto, NoteEntity.class));
			return noteDto;
		} else {
			throw new Exception("task with taskId " + taskId + " is not found, please enter a valid id");
		}

	}

	public NoteDto remoreNoteFromTask(Long taskId, Long noteId) throws Exception {
		if (tasksRepository.existsById(taskId)) {
			logger.info("task with taskId " + taskId + " is available");
			TaskEntity taskEntity = tasksRepository.findById(taskId).orElse(null);
			List<NoteEntity> noteEntities = taskEntity.getNotes();
			//check is there, this note contains or note
			NoteEntity currentNoteEntity;
			if(notesRepository.existsById(noteId)) {
				logger.info("Note is availabe with noteId " + noteId);
				currentNoteEntity = notesRepository.findById(noteId).orElse(null);
				for(NoteEntity entity : noteEntities) {
					if(entity.getId() == noteId) {
						noteEntities.remove(currentNoteEntity);
					}
				}
				
				taskEntity.setNotes(noteEntities);
				logger.info("Note with noteId " + noteId + " is updated in tasksDb");
				tasksRepository.save(taskEntity);
				
				notesRepository.deleteById(noteId);
				logger.info("Note with noteId " + noteId + " is deleted from noteDb");
			} else {
				throw new Exception("this note with noteId " + noteId  + " does not exist on this task");
			}
			
			
			return mapper.map(currentNoteEntity, NoteDto.class);
		} else {
			throw new Exception("task with taskId " + taskId + " is not found, please enter a valid id");
		}
	}

}
