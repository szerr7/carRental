package carfleetrestclient;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;

@Component
public class FleetManager {
RestTemplate restTemplate =new RestTemplate();
    private String serverUrl = "http://localhost:8082";

    public void createCar(String id,String  make,String brand,int year,String color,
                          int miles,String LicensePlate,boolean rented,boolean reserved,double price ){
        restTemplate.postForLocation(serverUrl+"/cars?id={id}&make={make}&brand={brand}&" +
                "year={year}&color={color}&miles={miles}&LicensePlate={LicensePlate}&rented={rented}" +
                        "reserved={reserved}&price={price}",CarDto.class,id,make,brand,year,color,miles,
                LicensePlate,rented,reserved,price);
    }
    public  void removeCar(String id){
        restTemplate.delete(serverUrl+"/cars/{id}",id);
    }
    public void updateCar(CarDto carDto,String id){
       // restTemplate.put(serverUrl+"/{firstName}" , contact, "John");
 restTemplate.put(serverUrl+"/cars/{id}",carDto,id);


    }
    public Collection<CarDto> getByCarMaker(String maker){
        Collection<CarDto> collection = restTemplate.getForObject(serverUrl+"/cars/{maker}", CarDtos.class,maker).getCollection();

    return collection;
    }

    public void getByCarMakerAndBrand(String maker,String brand){
     restTemplate.getForObject(serverUrl+"/cars?{maker=maker}&brand={brand}", Car.class,maker,brand);
       // return number ;
    }


}
