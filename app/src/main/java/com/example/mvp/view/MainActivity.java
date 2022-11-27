package com.example.mvp.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mvp.LoginInterface;
import com.example.mvp.R;
import com.example.mvp.model.User;
import com.example.mvp.presenter.LoginPresenter;

public class MainActivity extends AppCompatActivity implements LoginInterface {
    private EditText email, password;
    private Button btnLogin;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.edt_email);
        password = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        loginPresenter = new LoginPresenter(this);
        btnLogin.setOnClickListener(v -> clickLogin());
    }

    private void clickLogin() {
        String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();
        User user = new User(Email, Password);
        loginPresenter.login(user);
    }

    @Override
    public void loginSuccess() {
        Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Toast.makeText(this, "Login error", Toast.LENGTH_SHORT).show();
    }
}