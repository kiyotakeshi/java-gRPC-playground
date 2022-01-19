package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.models.Car;
import com.kiyotakeshi.models.Dealer;

public class MapDemo {
    public static void main(String[] args) {

        Car crown = Car.newBuilder()
                .setMake("toyota")
                .setModel("crown")
                .setYear(2018)
                .build();

        Car prius = Car.newBuilder()
                .setMake("toyota")
                .setModel("prius")
                .setYear(2020)
                .build();

        Dealer dealer = Dealer.newBuilder()
                .putModel(2018, crown)
                .putModel(2020, prius)
                .build();

        // System.out.println(dealer.getModelOrThrow(2017));
        // System.out.println(dealer.getModelOrDefault(2019, crown));
        System.out.println(dealer.getModelMap());
    }
}
