package com.dreamteam.crm.democrm.entity;


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
public class Patient {

    @GeneratedValue( strategy = GenerationType.IDENTITY)
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
    private String comment;

    @Column
    private String allergy;

    @Column
    private String illness;

    @Column
    private Date date_added;

    @Column
    private Date date_modified;

    @Column
    private Integer source_id;

    @ManyToOne
    @JoinColumn(name = "source_id", referencedColumnName = "id")
    private Sources sources;

    @OneToOne
    private User_Data user_data;
}
