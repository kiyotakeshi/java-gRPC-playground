package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.models.Address;
import com.kiyotakeshi.models.Car;
import com.kiyotakeshi.models.Person;

public class CompositionDemo {

    public static void main(String[] args) {
        Address address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("route 123")
                .setCity("tokyo")
                .build();

        Car car = Car.newBuilder()
                .setMake("toyota")
                .setModel("crown")
                .setYear(2018)
                .build();

        Person mike = Person.newBuilder()
                .setName("mike")
                .setAge(29)
                .setCar(car)
                .setAddress(address)
                .build();

        System.out.println(mike);
    }
}
