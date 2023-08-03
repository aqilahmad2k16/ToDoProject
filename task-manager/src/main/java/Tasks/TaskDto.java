package Tasks;

import java.util.Date;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
