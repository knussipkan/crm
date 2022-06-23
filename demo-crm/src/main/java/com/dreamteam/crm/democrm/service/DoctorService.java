package com.dreamteam.crm.democrm.service;


import com.dreamteam.crm.democrm.entity.Doctor;
import com.dreamteam.crm.democrm.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import javax.transaction.Transactional;
import java.util.List;


// всегда нужно создавать отдельный класс Service для доступа к данным, даже если кажется,
// что мало методов или это все можно реализовать сразу в контроллере
// Такой подход полезен для будущих доработок и правильной архитектуры (особенно, если работаете с транзакциями)

@Service
@Transactional
public class DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired // добавляем возле конструктора - тогда во все внутренние параметры будут подставлены конкретные объекты
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor add(Doctor doctor){
        return doctorRepository.save(doctor); // метод save обновляет или создает новый объект, если его не было
    }

    public Doctor update(Doctor doctor){
        return doctorRepository.save(doctor); // метод save обновляет или создает новый объект, если его не было
    }


    // удаляем один объект по id
    public void delete(Long id){
        doctorRepository.deleteById(id);
    }


    public List<Doctor> findAll(){
        return doctorRepository.findAll();
    }

    // поиск доктора по фио
    public List<Doctor> find(String firstname, String lastname) {
        return doctorRepository.findDoctorByFirstnameAndLastname(firstname, lastname);
    }

    // находим один объект по id
    public Doctor findById(Long id){
        return doctorRepository.findById(id).get();
    }
}
