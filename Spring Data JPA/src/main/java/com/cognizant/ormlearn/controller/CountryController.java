package com.cognizant.ormlearn.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@RestController
@RequestMapping("/countries")
public class CountryController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryService countryService;

    // GET: http://localhost:8080/countries
    @GetMapping
    public List<Country> getAllCountries() {
        LOGGER.info("Start: getAllCountries endpoint");
        return countryService.getAllCountries();
    }

    // GET: http://localhost:8080/countries/IN
    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) throws CountryNotFoundException {
        LOGGER.info("Start: getCountryByCode endpoint for code: {}", code);
        return countryService.findCountryByCode(code.toUpperCase());
    }

    // POST: http://localhost:8080/countries
    @PostMapping
    public void addCountry(@RequestBody Country country) {
        LOGGER.info("Start: addCountry endpoint for country: {}", country);
        countryService.addCountry(country);
    }

    // PUT: http://localhost:8080/countries/IN
    @PutMapping("/{code}")
    public void updateCountry(@PathVariable String code, @RequestBody Country country) throws CountryNotFoundException {
        LOGGER.info("Start: updateCountry endpoint for code: {}", code);
        countryService.updateCountry(code.toUpperCase(), country.getName());
    }

    // DELETE: http://localhost:8080/countries/IN
    @DeleteMapping("/{code}")
    public void deleteCountry(@PathVariable String code) {
        LOGGER.info("Start: deleteCountry endpoint for code: {}", code);
        countryService.deleteCountry(code.toUpperCase());
    }
}