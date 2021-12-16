package rw.ac.rca.termOneExam.service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.dto.CreateCityDTO;
import rw.ac.rca.termOneExam.repository.ICityRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class CityServiceTest {
    @Mock
    private ICityRepository cityRepo;

    @InjectMocks
    private CityService cityService;

    @Test
    public void getAll() {
        when(cityRepo.findAll()).thenReturn(Arrays.asList( new City(101, "Kigali", 24,75.2),
                new City(102,"Musanze",14,64.4)));

        assertEquals("Kigali", cityService.getAll().get(1).getName());
    }
    @Test
    public void findById(){
        when(cityRepo.findById(anyInt())).thenReturn(Optional.of(new City("kigali",24)));
        assertEquals("Kigali",cityService.getById(101).get().getName());

    }
    @Test
    public void createTest(){
        when(cityRepo.save(any(City.class))).thenReturn( new City("Kigali",24));
    }

}