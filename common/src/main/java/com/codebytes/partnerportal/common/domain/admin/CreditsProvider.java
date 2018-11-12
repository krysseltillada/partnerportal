package com.codebytes.partnerportal.common.domain.admin;

import com.codebytes.partnerportal.common.domain.common.Account;
import com.codebytes.partnerportal.common.domain.common.Address;
import com.codebytes.partnerportal.common.domain.common.ContactDetails;
import com.codebytes.partnerportal.common.domain.common.Name;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import java.util.Set;

@Getter
@Entity
public class CreditsProvider extends Account
{
    private final String companyName;

    @Builder
    public CreditsProvider(long accountId, String username, String password,
                           Name name, Address address,
                           ContactDetails contactDetails, String accountImageLink, Set<String> role,
                           String pCompanyName)
    {
        super(accountId, username, password, name, address, contactDetails, accountImageLink, role);
        companyName = pCompanyName;
    }
}
