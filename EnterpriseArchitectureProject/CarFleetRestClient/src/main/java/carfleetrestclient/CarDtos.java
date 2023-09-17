package carfleetrestclient;

import java.util.ArrayList;
import java.util.Collection;

public class CarDtos {
Collection<CarDto> collection =new ArrayList<>();

    public Collection<CarDto> getCollection() {
        return collection;
    }

    public void setCollection(Collection<CarDto> collection) {
        this.collection = collection;
    }
}
