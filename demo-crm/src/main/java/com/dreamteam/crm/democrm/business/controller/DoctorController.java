package com.dreamteam.crm.democrm.business.controller;


import com.dreamteam.crm.democrm.business.enitity.Doctor;
import com.dreamteam.crm.democrm.business.service.DoctorService;
import com.dreamteam.crm.democrm.business.util.MyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

Чтобы дать меньше шансов для взлома (например, CSRF атак): POST/PUT запросы могут изменять/фильтровать закрытые данные, а GET запросы - для получения незащищенных данных
Т.е. GET-запросы не должны использоваться для изменения/получения секретных данных

Если возникнет exception - вернется код  500 Internal Server Error, поэтому не нужно все действия оборачивать в try-catch

Используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON,
иначе пришлось бы добавлять лишние объекты в код, использовать @ResponseBody для ответа, указывать тип отправки JSON

Названия методов могут быть любыми, главное не дублировать их имена и URL mapping

*/

@RestController
@RequestMapping
public class DoctorController {

    private DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    // для получения данных используем тип запроса POST, позволяет отправлять и получать значения в body - более безопасно, по сравнению с GET
    @PutMapping("/all")
    public ResponseEntity<List<Doctor>> findAll(){
        return ResponseEntity.ok(doctorService.findAll());
    }


    @PutMapping("/add")
    public ResponseEntity<Doctor> add(@RequestBody Doctor doctor){
        MyLogger.debugMethodName("DoctorController: add(doctor) --------------------------------------------------------- ");

        if(doctor.getId() != null && doctor.getId() != 0){
            return new ResponseEntity("redundat param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getFirstname() == null || doctor.getFirstname().trim().length() == 0){
            return new ResponseEntity("missed param: firstName", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getLastname() == null || doctor.getLastname().trim().length() == 0){
            return new ResponseEntity("missed param: lastName", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getEmail() == null || doctor.getEmail().trim().length() == 0){
            return new ResponseEntity("missed param: email", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getAddress() == null || doctor.getEmail().trim().length() == 0){
            return new ResponseEntity("missed param: address", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getDate_of_birth() == null){
            return new ResponseEntity("missed param: date_of_birth", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getPhone() == null || doctor.getPhone().trim().length() == 0){
            return new ResponseEntity("missed param: phone number", HttpStatus.NOT_ACCEPTABLE);
        }

        return ResponseEntity.ok(doctorService.add(doctor));
    }


    @PatchMapping("/update")
    public ResponseEntity<Doctor> update(@RequestBody Doctor doctor){
        MyLogger.debugMethodName("DoctorController: update(doctor) --------------------------------------------------------- ");

        if (doctor.getId() == null || doctor.getId() == 0) {
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getId() != null && doctor.getId() != 0){
            return new ResponseEntity("redundat param: id MUST be null", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getFirstname() == null || doctor.getFirstname().trim().length() == 0){
            return new ResponseEntity("missed param: firstName", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getLastname() == null || doctor.getLastname().trim().length() == 0){
            return new ResponseEntity("missed param: lastName", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getEmail() == null || doctor.getEmail().trim().length() == 0){
            return new ResponseEntity("missed param: email", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getAddress() == null || doctor.getEmail().trim().length() == 0){
            return new ResponseEntity("missed param: address", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getDate_of_birth() == null){
            return new ResponseEntity("missed param: date_of_birth", HttpStatus.NOT_ACCEPTABLE);
        }

        if(doctor.getPhone() == null || doctor.getPhone().trim().length() == 0){
            return new ResponseEntity("missed param: phone number", HttpStatus.NOT_ACCEPTABLE);
        }

        doctorService.update(doctor);
        return new ResponseEntity(HttpStatus.OK);
    }

    // для удаления используем тип запроса DELETE , позволяет передавать значение в body, а не в адресной строке (как в GET)
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestBody Long id){
        MyLogger.debugMethodName("DoctorControler: delete(id) ---------------------------------------------------- ");

        if(id == null || id == 0){
            return new ResponseEntity("missed param: id", HttpStatus.NOT_ACCEPTABLE);
        }

        // можно обойтись и без try-catch, тогда будет возвращаться полная ошибка (stacktrace)
        // здесь показан пример, как можно обрабатывать исключение и отправлять свой текст/статус
        try{
            doctorService.delete(id);
        } catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            return new ResponseEntity("id=" + id + " not found", HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity(HttpStatus.OK);
    }


}

