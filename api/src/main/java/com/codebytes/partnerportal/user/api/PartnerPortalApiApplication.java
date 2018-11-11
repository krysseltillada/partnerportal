package com.codebytes.partnerportal.user.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EntityScan(basePackages="com.codebytes.partnerportal.common")
@RestController
public class PartnerPortalApiApplication
{

    @GetMapping("/api")
    public String dashboard () {
        return "successfully called api.";
    }

    public static void main(String[] args) {
        SpringApplication.run(PartnerPortalApiApplication.class, args);
    }
}
