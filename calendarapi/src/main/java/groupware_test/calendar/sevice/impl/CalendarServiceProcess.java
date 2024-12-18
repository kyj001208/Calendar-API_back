package groupware_test.calendar.sevice.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import org.springframework.ui.Model;
import groupware_test.calendar.sevice.CalendarRepository;
import groupware_test.calendar.sevice.CalendarService;
import groupware_test.dto.CalendarListDto;
import groupware_test.dto.CalendarSaveDto;
import groupware_test.dto.CalendarUpdateDto;
import groupware_test.entity.CalendarEntity;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CalendarServiceProcess implements CalendarService {

	private final CalendarRepository repository;
	
	@Override
	public void saveProcess(CalendarSaveDto dto) {
		
		repository.save(dto.toEntity());
	}

	@Override
	public List<CalendarListDto> listProcess(LocalDate date, boolean specificDay) {
	    List<CalendarEntity> events;

	    if (date != null) {
	        if (specificDay) {
	            // 특정 날짜에 해당하는 일정만 조회
	            events = repository.findBySelectedDate(date);
	        } else {
	            // 해당 월의 첫 날과 마지막 날 계산
	            LocalDate startOfMonth = date.withDayOfMonth(1);
	            LocalDate endOfMonth = date.withDayOfMonth(date.lengthOfMonth());

	            // 주어진 월의 전체 일정 조회
	            events = repository.findBySelectedDateBetween(startOfMonth, endOfMonth);
	        }
	    } else {
	        events = new ArrayList<>(); // 날짜가 null이면 빈 리스트 반환
	    }

	    // DTO로 변환하여 반환
	    return events.stream()
	            .map(CalendarEntity::toListDto)
	            .collect(Collectors.toList());
	}


	@Override
	public void deleteProcess(long id) {
		
		repository.deleteById(id);
		
	}

	@Override
	public void updateProcess(long id, CalendarUpdateDto dto) {
	    
	    CalendarEntity entity = repository.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("해당 일정이 존재하지 않습니다. ID: " + id));

	    
	    CalendarEntity updatedEntity = entity.toBuilder()  // toBuilder()를 사용하여 기존 객체 기반으로 빌더 생성
	        .title(dto.getTitle())  // 새로 받은 값으로 설정
	        .description(dto.getDescription())
	        .selectedDate(dto.getSelectedDate())
	        .build();  // 새로운 객체로 빌드

	    // 수정된 엔티티 저장
	    repository.save(updatedEntity);
	}


}
