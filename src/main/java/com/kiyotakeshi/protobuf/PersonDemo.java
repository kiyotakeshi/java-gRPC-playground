package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.models.Person;

public class PersonDemo {

    public static void main(String[] args) {
        Person mike = Person.newBuilder()
                .setName("mike")
                .setAge(29)
                .build();

        System.out.println(mike.toString());
    }
}
