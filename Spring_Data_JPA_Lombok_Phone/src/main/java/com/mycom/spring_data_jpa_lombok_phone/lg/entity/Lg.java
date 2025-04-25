package com.mycom.spring_data_jpa_lombok_phone.lg.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="lg")
public class Lg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String model;
    private String size;
    private String memory;
    private String price;
}
