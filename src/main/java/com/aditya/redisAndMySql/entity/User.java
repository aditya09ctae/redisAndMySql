package com.aditya.redisAndMySql.entity;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @SerializedName("id")
    private Integer Id;

    @Column(name = "user_name")
    @SerializedName("name")
    private String name;

    @Column(name = "user_branch")
    @SerializedName("branch")
    private String branch;

    @Column(name = "salary")
    @SerializedName("salary")
    private Double salary;
}
