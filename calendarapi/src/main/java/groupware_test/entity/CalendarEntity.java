package groupware_test.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import groupware_test.dto.CalendarListDto;
import groupware_test.dto.CalendarUpdateDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@DynamicUpdate
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="calendar")
public class CalendarEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String title;
	
	private String description;
	
	@Column(columnDefinition = "timestamp")
	@CreationTimestamp
	private LocalDateTime createdAt;

	
	@Column(columnDefinition = "timestamp")
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	
	private LocalDate selectedDate;


	public CalendarListDto toListDto() {
		
		return CalendarListDto.builder()
				.id(id)
				.title(title)
				.description(description)
				.updatedAt(updatedAt)
				.selectedDate(selectedDate)
				.build();
	}


	public CalendarEntityBuilder toBuilder() {
        return CalendarEntity.builder()
            .id(id)  // 기존 ID는 그대로 사용
            .title(title)
            .selectedDate(selectedDate)
            .description(description);
    }
}
