package com.codebytes.partnerportal.common.domain.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.java.Log;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@Log
@MappedSuperclass
public abstract class Account
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long accountId;

    protected final String username;
    protected final String password;

    @Embedded
    protected final Name name;

    @Embedded
    protected final Address address;

    @Embedded
    protected final ContactDetails contactDetails;

    protected final String accountImageLink;

    @ElementCollection
    protected final Set<String> role;
}
