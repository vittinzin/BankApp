package com.vitor.bankapp.view;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.vitor.bankapp.R;
import com.vitor.bankapp.authentication.Login;
import com.vitor.bankapp.controller.RegisterController;
import com.vitor.bankapp.controller.RegisterDBController;

public class MainActivity extends AppCompatActivity {

    TextView signUp;
    RegisterDBController registerDBController;
    EditText etEmail, etPassword;
    Login login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button loginBtn = findViewById(R.id.loginBtn);

        etEmail = findViewById(R.id.email);
        etPassword = findViewById(R.id.password);

        loginBtn.setOnClickListener(v ->{
            registerDBController = new RegisterDBController(this);

            login = new Login(
                    etEmail.getText().toString(),
                    etPassword.getText().toString()
            );

            if (login.confirmLogin(login) == -1) {
                if (registerDBController.loginRegister(login)) {
                    Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "Usuario inexistente", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "Dados invalidos", Toast.LENGTH_SHORT).show();
            }

        });

        signUp = findViewById(R.id.cadastro);

        signUp.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });
    }
}