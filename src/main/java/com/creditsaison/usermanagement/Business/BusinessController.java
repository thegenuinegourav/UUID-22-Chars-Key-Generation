package com.creditsaison.usermanagement.Business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusinessController {

    @Autowired
    private BusinessRepository businessRepository;

    @GetMapping("/businesses")
    public Page<Business> getAllBusinesses(Pageable pageable) {
        return businessRepository.findAll(pageable);
    }

    @PostMapping("/business")
    public Business createBusiness(@RequestBody Business business) {
        System.out.println(business.getId());
        return businessRepository.save(business);
    }
}
