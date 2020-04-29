package com.example.app_login.ui.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_login.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//import java.util.Map;

public class SegundoActivity extends AppCompatActivity {
private EditText et1;
private EditText et2;
private EditText et3;
private Button btn1;

private String name="";
private String email="";
private String password="";
//---------------
//-----bd
    FirebaseAuth nAuth;
    DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
//----------------------bd-------obtener instancias
        nAuth= FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
//-------------------------------------------------------------
        et1=(EditText) findViewById(R.id.et_nombre);
        et2=(EditText) findViewById(R.id.et_correo);
        et3=(EditText) findViewById(R.id.et_pw);
        btn1=(Button) findViewById(R.id.btn_register);//en ingles se le conocw como boton
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                name = et1.getText().toString();
                email = et2.getText().toString();
                password = et3.getText().toString();



                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){
                    if ( password.length() >= 6 ){

                        registerUser();
                    }
                    else {
          Toast.makeText(  SegundoActivity.this, "debe contener mas de 6 caracteres", Toast.LENGTH_LONG).show();
                    }//if doble

                }//termina el if
            }
        });
   }

   public  void registerUser(){
        nAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Map<String, Object> map = new HashMap<>();
                    map.put("name", name);
                    map.put("email",email);
                    map.put("password",password);

                    String id=nAuth.getCurrentUser().getUid();
                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if( task2.isComplete() ) {
                                startActivity(new Intent(SegundoActivity.this, TreeActivity.class));
                                finish();

                            }else {

                             Toast.makeText( SegundoActivity.this, "no se crearon los datos correctamente", Toast.LENGTH_SHORT ).show();
                            }

                        }
                    });

                }else{
                    Toast.makeText( SegundoActivity.this,"no se puedo registrar el user", Toast.LENGTH_SHORT ).show();
                }//funcion dobre
            }
        });

   }



//--------
}
