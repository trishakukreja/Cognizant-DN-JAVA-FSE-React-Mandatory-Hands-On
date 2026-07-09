package com.cognizant.ormlearn.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

    @Mock
    private CountryRepository countryRepository;

    @InjectMocks
    private CountryService countryService;

    @Test
    public void testFindCountryByCode_Success() throws Exception {
        Country mockCountry = new Country("IN", "India");
        when(countryRepository.findById("IN")).thenReturn(Optional.of(mockCountry));

        Country result = countryService.findCountryByCode("IN");
        
        assertNotNull(result);
        assertEquals("India", result.getName());
        verify(countryRepository, times(1)).findById("IN");
    }

    @Test
    public void testFindCountryByCode_NotFound() {
        when(countryRepository.findById("XX")).thenReturn(Optional.empty());

        assertThrows(CountryNotFoundException.class, () -> {
            countryService.findCountryByCode("XX");
        });
    }
}
