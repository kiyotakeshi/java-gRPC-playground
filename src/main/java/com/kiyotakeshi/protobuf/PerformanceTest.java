package com.kiyotakeshi.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.kiyotakeshi.json.JPerson;
import com.kiyotakeshi.models.Person;


public class PerformanceTest {

    public static void main(String[] args) {

        // json
        JPerson jPerson = new JPerson();
        jPerson.setName("mike");
        jPerson.setAge(30);
        ObjectMapper mapper = new ObjectMapper();

        Runnable json = () -> {
            try {
                byte[] bytes = mapper.writeValueAsBytes(jPerson);
                // System.out.println(bytes.length);
                JPerson person1 = mapper.readValue(bytes, JPerson.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        // protobuf
        Person mike = Person.newBuilder()
                .setName("mike")
                .setAge(Int32Value.newBuilder().setValue(30).build())
                .build();

        Runnable proto = () -> {
            try {
                byte[] bytes = mike.toByteArray();
                // System.out.println(bytes.length);
                Person mike1 = Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }
        };

        // for (int i = 0; i < 1; i++) {
        for (int i = 0; i < 5; i++) {
            runPerformanceTest(json, "JSON");
            runPerformanceTest(proto, "PROTO");
        }
    }

    private static void runPerformanceTest(Runnable runnable, String method) {
        long start = System.currentTimeMillis();
        // for (int i = 0; i < 1; i++) {
        for (int i = 0; i < 5_000_000; i++) {
            runnable.run();
        }
        long end = System.currentTimeMillis();

        System.out.println(method + " : " + (end - start) + " ms");
    }
}
