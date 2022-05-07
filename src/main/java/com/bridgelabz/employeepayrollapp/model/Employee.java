package com.bridgelabz.employeepayrollapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 * @data-combination of getter and setters in lombok
 * @table-Create a table in my Sql
 *  @Entity-To create table with this entity column in sql(database)
 *
 */
@Entity
@Data
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private Long salary;

}
