package com.codebytes.partnerportal.common.domain.admin;

import com.codebytes.partnerportal.common.domain.admin.enums.AccountType;
import com.codebytes.partnerportal.common.domain.common.Account;
import com.codebytes.partnerportal.common.domain.common.Address;
import com.codebytes.partnerportal.common.domain.common.ContactDetails;
import com.codebytes.partnerportal.common.domain.common.Name;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Set;

@Getter
@Entity
public class PartnerBrand extends Account
{
    private final String companyName;
    private final String brand;

    @Enumerated(EnumType.STRING)
    private final AccountType accountType;

    @Builder
    public PartnerBrand(long accountId, String username, String password,
                        Name name,
                        Address address,
                        ContactDetails contactDetails,
                        String accountImageLink, Set<String> role, String pCompanyName, String pBrand,
                        AccountType pAccountType)
    {
        super(accountId, username, password, name, address, contactDetails, accountImageLink, role);
        companyName = pCompanyName;
        brand = pBrand;
        accountType = pAccountType;
    }
}
