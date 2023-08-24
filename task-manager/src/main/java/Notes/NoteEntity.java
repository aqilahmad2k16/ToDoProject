package Notes;

import common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notes")
@Data 
@EqualsAndHashCode(callSuper = false)
public class NoteEntity extends BaseEntity {
	
}
