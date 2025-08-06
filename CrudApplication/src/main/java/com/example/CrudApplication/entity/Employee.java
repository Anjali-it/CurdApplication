package com.example.CrudApplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Data
@Entity
@Table(name="EmployeeEntity")
public class Employee {
    @Id
    private int id;
    private String name;
    private double salary;

    
}
