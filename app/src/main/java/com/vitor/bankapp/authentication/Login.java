package com.vitor.bankapp.authentication;

public class Login {

    private String email;
    private String password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int confirmLogin(Login login){
        String[] loginData = new String[]{
                login.getEmail(),
                login.getPassword()
        };

        for (int i = 0; i < i; i++) {
            if (loginData[i] == null || loginData[i].trim().isEmpty()) {
                return i;
            }
        }
        return -1;
    }
}
