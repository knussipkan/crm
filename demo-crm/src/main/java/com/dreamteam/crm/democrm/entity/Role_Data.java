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
public class Role_Data {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column
    private String name;

    // не создаем обратную ссылку на User_Role с типом Collection, чтобы каждый раз не тянуть с объектом целую коллекцию - будет перегруз ненужных данных или зацикливание

}
