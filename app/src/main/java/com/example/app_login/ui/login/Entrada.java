package com.example.app_login.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_login.R;

public class Entrada extends AppCompatActivity implements View.OnClickListener{
    private Button btn_register, btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrada);
//asociacion de las variables con las idas de la interfaz
        btn_register = (Button) findViewById(R.id.btn_foto_registro);
        btn_login = (Button) findViewById(R.id.btn_foto_login);
//asociasicon del oyente listener
        btn_register.setOnClickListener(this);
        btn_login.setOnClickListener(this);

    }
    private  void vista_registro(){
        startActivity(new Intent(Entrada.this, SegundoActivity.class));
    }
    private void vista_sesion(){
        startActivity(new Intent(Entrada.this, LoginActivity.class));
    }

    //implementacionde view on listener o escucha
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_foto_registro:
                vista_registro();
                break;
            case R.id.btn_foto_login:
                vista_sesion();
                break;

        }



    }
}
