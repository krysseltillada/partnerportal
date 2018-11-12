package com.codebytes.partnerportal.common.domain.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.persistence.Embeddable;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Log
@Embeddable
public class Name
{

    private final String firstname;
    private final String lastname;
    private final String middlename;

}
