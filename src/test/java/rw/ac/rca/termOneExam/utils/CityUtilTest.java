package rw.ac.rca.termOneExam.utils;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import rw.ac.rca.termOneExam.domain.City;
import rw.ac.rca.termOneExam.repository.ICityRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@DataJpaTest

@RunWith(SpringRunner.class)
public class CityUtilTest {

    @Autowired
    private ICityRepository cityRepo;

    @Test
    public void mocking(){
     ArrayList<City> arrayListMock=mock(ArrayList.class);
     City newCity=new City("Kigali",24);
     arrayListMock.add(newCity);
     Mockito.verify(arrayListMock).add(newCity);
     assertEquals(0,arrayListMock.size());

 }

    @Test
    public void spying() {

        ArrayList<City> SpyarrayListMock=mock(ArrayList.class);
        City newCity=new City("Kigali",24);
        SpyarrayListMock.add(newCity);
        Mockito.verify(SpyarrayListMock).add(newCity);
        assertEquals(1,SpyarrayListMock.size());

    }
    @Test
    public void verifyDown(){
        boolean resp=false;
        ArrayList<City> cities= (ArrayList<City>) cityRepo.findAll();
        for(City city: cities)
            if(city.getWeather()<10)
                resp=true;

        assertEquals(false,resp);
    }
    @Test
    public void verifyUp(){
    boolean resp=false;
    ArrayList<City> cities= (ArrayList<City>) cityRepo.findAll();
    for(City city: cities)
        if(city.getWeather()>40)
            resp=true;

    assertEquals(false,resp);
    }

    @Test
    public void testOccurance(){
        boolean exists=false;
        ArrayList<City> arrayListCity=Mockito.mock(ArrayList.class);
        City city=new City("Kigali",24);
        arrayListCity.add(city);
        Mockito.verify(arrayListCity).add(city);
        assertEquals(0,arrayListCity);

    }
}
