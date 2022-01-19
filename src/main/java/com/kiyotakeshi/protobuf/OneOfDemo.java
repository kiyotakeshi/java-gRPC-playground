package com.kiyotakeshi.protobuf;

import com.kiyotakeshi.modeles.Credentials;
import com.kiyotakeshi.modeles.EmailCredentials;
import com.kiyotakeshi.modeles.PhoneOTP;

public class OneOfDemo {

    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials.newBuilder()
                .setEmail("test@example.com")
                .setPassword("1qazxsw2")
                .build();

        PhoneOTP phoneOTP = PhoneOTP.newBuilder()
                .setNumber(1234567)
                .setCode(123)
                .build();

        Credentials credentials = Credentials.newBuilder()
                // only set email or phone
                // .setEmailMode(emailCredentials)
                .setPhoneMode(phoneOTP)
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {

        // protocol buffer provide enum
        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }
    }
}
