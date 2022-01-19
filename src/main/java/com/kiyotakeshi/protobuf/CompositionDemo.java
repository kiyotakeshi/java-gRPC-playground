package com.kiyotakeshi.protobuf;

import com.google.protobuf.Int32Value;
import com.kiyotakeshi.models.Address;
import com.kiyotakeshi.models.Car;
import com.kiyotakeshi.models.Person;

import java.util.ArrayList;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("route 123")
                .setCity("tokyo")
                .build();

        Car crown = Car.newBuilder()
                .setMake("toyota")
                .setModel("crown")
                .setYear(2018)
                .build();

        Car prius = Car.newBuilder()
                .setMake("toyota")
                .setModel("prius")
                .setYear(2018)
                .build();

        ArrayList<Car> cars = new ArrayList<>();
        cars.add(crown);
        cars.add(prius);

        Person mike = Person.newBuilder()
                .setName("mike")
                .setAge(Int32Value.newBuilder().setValue(29).build())
                .addAllCar(cars)
                .setAddress(address)
                .build();

        System.out.println(mike);
        System.out.println(mike.hasAge());
    }
}
