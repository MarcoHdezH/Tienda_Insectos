package com.example.natureway;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText nombre,contraseña,correo;
    private Button Agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registro de Nuevo Usuario");

        //Defino mis edittext y botones
        nombre = (EditText) findViewById(R.id.editTextTextPersonName);
        contraseña = (EditText) findViewById(R.id.editTextTextPassword);
        correo = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Agregar = (Button) findViewById(R.id.Agregar);

    }

    //Metodo que permite agregar un nuevo usuario a la base de datos
    public void Registrar(View view){
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this,"administracion",null,1);
        SQLiteDatabase BaseDeDatos = admin.getWritableDatabase();

        String Nombre = nombre.getText().toString();
        String Contraseña = contraseña.getText().toString();
        String Correo = correo.getText().toString();

        if(!Nombre.isEmpty() && !Contraseña.isEmpty() && !Correo.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre",Nombre);
            registro.put("contraseña",Contraseña);
            registro.put("correo",Correo);

            BaseDeDatos.insert("usuarios",null,registro);

            nombre.setText("");
            contraseña.setText("");
            correo.setText("");

            Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Login.this,MainActivity.class);
            startActivity(intent);

        }else{
            Toast.makeText(this, "Debes Llenar todos los espacios", Toast.LENGTH_SHORT).show();
        }
    }


}