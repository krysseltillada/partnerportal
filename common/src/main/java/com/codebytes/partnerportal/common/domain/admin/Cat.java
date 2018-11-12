package com.codebytes.partnerportal.common.domain.admin;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Cat
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long catId;

    private String name;
    private int hungryLevel;
}
