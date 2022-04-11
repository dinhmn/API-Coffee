package com.dev.Coffee.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "tbl_contact")

public class ContactEntities extends BaseEntity{

//    private Long id;

    private String name;
    private String email;
    private String message;

}
