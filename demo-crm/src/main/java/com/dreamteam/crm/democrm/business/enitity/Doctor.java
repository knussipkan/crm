package com.dreamteam.crm.democrm.business.enitity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Doctor {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private Date date_of_birth;

    @Column
    private char gender;

    @Column
    private String phone;

    @Column
    private Integer specialist_id;

    @ManyToOne
    @JoinColumn(name = "specialist_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Specialist specialist;

    @OneToOne
    private User_Data user_data;
}
