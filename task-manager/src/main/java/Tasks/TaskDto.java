package Tasks;

import java.util.Date;

import org.springframework.lang.Nullable;

import lombok.Data;

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
