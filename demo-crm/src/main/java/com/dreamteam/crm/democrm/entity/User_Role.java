package com.dreamteam.crm.democrm.entity;


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
public class User_Role {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private Integer role_id;

    @Column
    private Integer user_id;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role_Data role_data;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User_Data user_data;
}
