package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cognizant.ormlearn.model.Country;
import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
    
    // Custom query method to find countries matching a partial name (Hands-on 5)
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String partialName);
}