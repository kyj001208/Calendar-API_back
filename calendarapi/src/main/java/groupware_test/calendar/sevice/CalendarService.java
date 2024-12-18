package groupware_test.calendar.sevice;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.ui.Model;

import groupware_test.dto.CalendarListDto;
import groupware_test.dto.CalendarSaveDto;
import groupware_test.dto.CalendarUpdateDto;

public interface CalendarService {

	void saveProcess(CalendarSaveDto dto);

	List<CalendarListDto> listProcess(LocalDate date,boolean specificDay);

	void deleteProcess(long id);

	void updateProcess(long id, CalendarUpdateDto dto);

	

	

}
