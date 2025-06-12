package com.vitor.bankapp.controller;

import com.vitor.bankapp.authentication.Register;

public class RegisterController {

    public RegisterController() {
    }

    public int confirmRegister (Register register) {
        String[] registerInfos = new String[] {
                register.getName(), register.getPhone(), register.getEmail(), register.getPassword()
        };

        for (int i = 0; i < registerInfos.length; i++) {
            if (registerInfos[i] == null || registerInfos[i].trim().isEmpty()){
                return i;
            }
        }
        return -1;
    }
}
