package rw.ac.rca.termOneExam.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import rw.ac.rca.termOneExam.dto.CreateCityDTO;

import java.util.Objects;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@RequestMapping("/api/cities")
@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CityControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getAll_success(){
        ResponseEntity<String> response = restTemplate.getForEntity("/all", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void findById_testSuccess() {
        ResponseEntity<String> response = restTemplate.getForEntity("/id/101", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void findById_testNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/106", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void findByCityName_test() {
        ResponseEntity<String> response = restTemplate.getForEntity("/byCityName/Kigali", String.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void findByCityName_testNotFound() {
        ResponseEntity<String> response = restTemplate.getForEntity("/byCityName/Abuja", String.class);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }


    @Test
    public void create_testSuccess() {
        CreateCityDTO city = new CreateCityDTO();
        ResponseEntity<CreateCityDTO> response = restTemplate.postForEntity("/add", city, CreateCityDTO.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals("Dodoma", Objects.requireNonNull(response.getBody()));
    }

    @Test
    public void create_testDuplicateCityName() {
        CreateCityDTO city = new CreateCityDTO();
        ResponseEntity<String> response = restTemplate.postForEntity("/add", city, String.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("City already exists", response.getBody());
    }




    @Test
    public void delete_test() {
        ResponseEntity<String> response = restTemplate.exchange("/api/city/2", HttpMethod.DELETE, null, String.class);

        assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        assertEquals("Removed", response.getBody());
    }


}
