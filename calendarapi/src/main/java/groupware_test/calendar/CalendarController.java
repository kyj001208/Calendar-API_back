package groupware_test.calendar;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import groupware_test.calendar.sevice.CalendarService;
import groupware_test.dto.CalendarListDto;
import groupware_test.dto.CalendarSaveDto;
import groupware_test.dto.CalendarUpdateDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RequiredArgsConstructor
@RestController
public class CalendarController {
	
	private final CalendarService service;
	
	@PostMapping("/save")
	public String saveCalendar(@RequestBody CalendarSaveDto dto) {
		System.out.println("Received selectedDate: " + dto.getSelectedDate());  // 확인
		service.saveProcess(dto);
		return "일정 저장";
	}
	
	
	//월전체, 선택한 일 둘다 사용할수 있도록 블럼 타입
	@GetMapping("/list")
	public ResponseEntity<List<CalendarListDto>> listCalendar(
	        @RequestParam(value = "date", required = false) LocalDate date,
	        @RequestParam(value = "specificDay", defaultValue = "false") boolean specificDay) {

	    // 서비스 메서드 호출 시 specificDay 파라미터 전달
	    List<CalendarListDto> events = service.listProcess(date, specificDay);

	    // 조회된 일정들을 JSON 형식으로 반환
	    return ResponseEntity.ok(events);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteCalendar(@PathVariable("id") long id) {
		
	    service.deleteProcess(id);
	}

	@PutMapping("/update/{id}")
	public void updateCalendar(@PathVariable("id") long id, @RequestBody CalendarUpdateDto dto) {
		
		service.updateProcess(id,dto);
	}




	

}
