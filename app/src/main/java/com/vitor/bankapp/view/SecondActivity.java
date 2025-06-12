package com.vitor.bankapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitor.bankapp.R;
import com.vitor.bankapp.authentication.Register;
import com.vitor.bankapp.controller.RegisterController;
import com.vitor.bankapp.controller.RegisterDBController;

public class SecondActivity extends AppCompatActivity {

    Register register;
    RegisterController registerController;
    RegisterDBController rdb;

    EditText etName, etPhone, etEmail, etPassword, etConfirm;
    Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.confirmPassword);

        registerBtn = findViewById(R.id.registerBtn);

        registerBtn.setOnClickListener(v->{

            registerController = new RegisterController();
            rdb = new RegisterDBController(this);

            if (etPassword.getText().toString().equals(etConfirm.getText().toString())){
                register = new Register(
                        etName.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etPassword.getText().toString()
                );

                if (registerController.confirmRegister(register) == -1) {
                    rdb.insert(
                            register.getName(),
                            register.getPhone(),
                            register.getEmail(),
                            register.getPassword()
                    );
                    Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Invalid!", Toast.LENGTH_SHORT).show();
                }
                } else {
                Toast.makeText(this, "Passwords dont match!", Toast.LENGTH_SHORT).show();
                }
        });
    }
}