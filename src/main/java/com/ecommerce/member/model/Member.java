package com.ecommerce.member.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "members")
public class Member {

    @Column(unique = true)
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @Column
    private String password;

    @Column
    private String name;
}
