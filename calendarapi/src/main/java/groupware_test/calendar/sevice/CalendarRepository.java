package groupware_test.calendar.sevice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import groupware_test.entity.CalendarEntity;

@Repository
public interface CalendarRepository extends JpaRepository<CalendarEntity, Long>{

	 List<CalendarEntity> findBySelectedDate(LocalDate date);

	List<CalendarEntity> findBySelectedDateBetween(LocalDate startOfMonth, LocalDate endOfMonth);

}
