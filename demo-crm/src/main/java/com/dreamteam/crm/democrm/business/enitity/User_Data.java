package com.dreamteam.crm.democrm.business.enitity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class User_Data {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String email;

    @Column
    private String passwordd;

    @Column
    private String username;

    @Column
    private Integer doctor_id;

    @Column
    private Integer patient_id;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Doctor doctor;

    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Patient patient;

    // не создаем обратную ссылку на User_Role с типом Collection, чтобы каждый раз не тянуть с объектом целую коллекцию - будет перегруз ненужных данных или зацикливание

}
