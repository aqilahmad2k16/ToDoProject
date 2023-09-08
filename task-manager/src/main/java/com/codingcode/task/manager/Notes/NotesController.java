package com.codingcode.task.manager.Notes;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tasks/{taskId}")
public class NotesController {
	private static final Logger logger = (Logger) LogManager.getLogger(NotesController.class);
	@Autowired
	private NotesService notesService;
	
	/*
	GetMapping()
	*/
	
	@GetMapping("/note")
	public ResponseEntity<List<NoteDto>> getAllNotesByTaskId(@PathVariable Long taskId) throws Throwable {
		return ResponseEntity.ok(notesService.getAllNotesByTaskId(taskId));
	}
	
	/*
	 * PostMapping()
	 */
	
	@PostMapping("/note")
	public ResponseEntity<NoteDto> addNoteToTask(@PathVariable Long taskId, @RequestBody NoteDto noteDto) throws Exception{
		logger.info("adding note to task with taskId " + taskId);
		return ResponseEntity.ok(notesService.addNoteToTask(taskId, noteDto));
	}
	
	/*
	 * DeleteMapping()
	 */
	
	@DeleteMapping("/{noteId}")
	public ResponseEntity<NoteDto> removeNoteFromTask(@PathVariable Long taskId, @PathVariable Long noteId) throws Exception {
		return ResponseEntity.ok(notesService.remoreNoteFromTask(taskId, noteId));
	}
	
}
