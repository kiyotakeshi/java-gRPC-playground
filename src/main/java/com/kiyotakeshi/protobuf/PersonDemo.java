package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args) throws IOException {
        Person mike1 = Person.newBuilder()
                .setName("mike")
                .setAge(29)
                .build();

        Person mike2 = Person.newBuilder()
                .setName("mike")
                .setAge(29)
                .build();

        System.out.println(mike1);

        // equals method is override
        System.out.println(mike1.equals(mike2));

        Path path = Paths.get("mike.serialize");
//        Files.write(path, mike1.toByteArray());
        byte[] bytes = Files.readAllBytes(path);
        Person deserializedMike = Person.parseFrom(bytes);
        System.out.println(deserializedMike);
    }
}
