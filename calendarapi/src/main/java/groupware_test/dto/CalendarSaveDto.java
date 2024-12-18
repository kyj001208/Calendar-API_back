package groupware_test.dto;

import java.time.LocalDate; // ZonedDateTime 대신 LocalDate를 사용

import com.fasterxml.jackson.annotation.JsonFormat;

import groupware_test.entity.CalendarEntity;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class CalendarSaveDto {

    private long id;
    private String title;
    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd") // 날짜 형식만 처리
    private LocalDate selectedDate; // LocalDate로 변경

    public CalendarEntity toEntity() {
        return CalendarEntity.builder()
                .id(id)
                .title(title)
                .description(description)
                .selectedDate(selectedDate) // selectedDate를 null이 아닌 올바른 값으로 설정
                .build();
    }
}
