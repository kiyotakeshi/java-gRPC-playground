package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.models.Television;
//import com.kiyotakeshi.models.Type;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        // v1
        /*
        Television television = Television.newBuilder()
                .setBrand("LG")
                .setYear(2019)
                .build();

        Path pathV1 = Paths.get("tv-v1");
        Files.write(pathV1, television.toByteArray());
         */

        // v2
        /*
        Television television = Television.newBuilder()
                .setBrand("LG")
                .setModel(2018)
                .setType(Type.OLED)
                .build();

        Path pathV2 = Paths.get("tv-v2");
        Files.write(pathV2, television.toByteArray());
         */

        // byte[] bytes = Files.readAllBytes(pathV1);

        // deserialize as v1 model...
        // brand: "LG"
        // year: 2018
        // 3: 3
        Path pathV2 = Paths.get("tv-v2");
        byte[] bytes = Files.readAllBytes(pathV2);
        System.out.println(
                Television.parseFrom(bytes)
        );

    }
}
