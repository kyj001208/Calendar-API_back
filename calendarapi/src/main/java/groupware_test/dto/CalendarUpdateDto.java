package groupware_test.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor 
public class CalendarUpdateDto {
	
	private long id;
	private String title;
    private String description;
    
    @JsonFormat(pattern = "yyyy-MM-dd") // 날짜 형식만 처리
    private LocalDate selectedDate; // LocalDate로 변경

}
