import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @BeforeEach
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest(){
        int listSize = list.getCount();
        list.addCity(new City("Halifax", "NS"));
        assertEquals(listSize + 1, list.getCount());
    }

    @Test
    public void hasCityTest(){
        //Check it fails if city is not in list
        City newCity = new City("Edmonton", "AB");
        assertEquals(false, list.hasCity(newCity));
        //Check it passes if city is in list
        list.addCity(newCity);
        assertEquals(true, list.hasCity(newCity));
    }

    @Test
    public void deleteCityTest(){
        City newCity = new City("Edmonton", "AB");
        list.addCity(newCity);
        assertEquals(1, list.getCount());
        list.deleteCity(newCity);
        assertEquals(0, list.getCount());
    }

    @Test
    public void testCountCities(){
        assertEquals(java.util.Optional.of(0), list.countCities());
        City newCity = new City("Edmonton", "AB");
        list.addCity(newCity);
        assertEquals(java.util.Optional.of(1), list.countCities());
    }
}
