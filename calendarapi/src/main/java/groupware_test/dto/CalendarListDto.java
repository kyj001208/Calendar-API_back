package groupware_test.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CalendarListDto {
	
	private long id;

	private String title;

	private String description;

	private LocalDateTime updatedAt;

	@JsonFormat(pattern = "yyyy-MM-dd") // 날짜 형식 설정
	private LocalDate selectedDate; // selectedDate 추가

}
