package carfleet;

import carfleet.domain.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCar {

   private Car car ;
   public void setUp(){
       car =new Car();
   }
   @Test
   public void testCreatCarBYOneCar(){
       Car car1 =new Car(null,"Toyota","Camry",2021,"Black",2300,
               "VA333",true,true,3400);

       assertEquals(2300, car1.getMiles(),0.0000001);

   }
    @Test
    public void testCreatCarBYAddingTwoCars(){
        Car car1 =new Car(null,"Toyota","Camry",2021,"Black",2300,
                "VA333",true,true,3400);
        Car car2 =new Car(null,"Toyota","Camry",2022,"Black",2300,
                "VA1232",true,true,3500);
        int expected = car2.getMiles()+car2.getMiles();

        assertEquals(expected, 4600,0.0000001);

    }

}
