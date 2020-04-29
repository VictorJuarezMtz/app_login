package com.example.app_login.ui.login;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app_login.R;

public class principal extends AppCompatActivity {
    public static final String user="names";
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        txtUser =(TextView)findViewById(R.id.txt_user);
        String user = getIntent().getStringExtra("names");
        txtUser.setText("¡Bienvenido "+ user +"!");


    }
}
