package com.dreamteam.crm.democrm.business.repo;


// реализует все необходимые запросы в БД

import com.dreamteam.crm.democrm.business.enitity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*

При запуске проекта Spring  находит все переменные, которые имеют тип этого интерфейса.

После этого внедряет в эти переменные нужные объекты, где уже реализованы все методы.

 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
   List<Doctor> findDoctorByFirstnameAndLastname(@Param("firstName") String firstname, @Param("lastName") String lastname);


}
