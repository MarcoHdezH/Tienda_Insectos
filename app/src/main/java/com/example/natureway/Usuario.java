package com.example.natureway;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Usuario extends AppCompatActivity {

    private TextView userr,password,email;
    private Button Modificar,Eliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        String Usuario = getIntent().getStringExtra("Usuario");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Perifl de: "+Usuario);
        actionBar.setDisplayHomeAsUpEnabled(true);

        userr = (TextView) findViewById(R.id.editTextuser);
        userr.setText(Usuario);
        password = (TextView) findViewById(R.id.editTextpassword);
        email = (TextView) findViewById(R.id.editTextemail);

         //Realizo una consulta a la base de datos para recuperar la informacion del usuario
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase(); //abrimos la base de datos en modo lectura y escritura

        String codigo = userr.getText().toString(); // almacenamos el codigo que inserte el usuario
        if (codigo.isEmpty()) {
            Toast.makeText(this, "No puedes dejar el campo en blanco!", Toast.LENGTH_SHORT).show();
        } else {
            Cursor fila = BaseDeDatos.rawQuery("SELECT contraseña,correo FROM usuarios WHERE nombre = '"+ codigo+"'", null);
            if (fila.moveToFirst()) {
                    password.setText(fila.getString(0));
                    email.setText(fila.getString(1));
            } else {
                Toast.makeText(this, "No se han encontrado usuarios con ese nombre", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        }
        BaseDeDatos.close();
    }
}