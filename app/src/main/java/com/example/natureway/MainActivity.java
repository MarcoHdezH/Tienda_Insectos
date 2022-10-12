package com.example.natureway;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button login;
    private Button create;
    private EditText user;
    private EditText password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        user = (EditText)findViewById(R.id.user);
        password = (EditText)findViewById(R.id.Password);
        login = (Button)findViewById(R.id.login);
        create = (Button)findViewById(R.id.create);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String usuario=user.getText().toString();
                String contraseña=password.getText().toString();

                if(!usuario.isEmpty() && !contraseña.isEmpty()){
                    Buscar(view);
                }else{
                    Toast.makeText(MainActivity.this, "Debes Llenar todos los espacios", Toast.LENGTH_SHORT).show();
                }
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Login.class);
                startActivity(intent);
            }
        });
    }

    //Método que permite buscar a un usuario dentro de la base de datos
    public void Buscar(View view) {
        AdminSQLiteHelper admin = new AdminSQLiteHelper(this, "administracion", null, 1);
        SQLiteDatabase BaseDeDatos = admin.getReadableDatabase(); //abrimos la base de datos en modo lectura y escritura

        String codigo = user.getText().toString(); // almacenamos el usuario que inserte el usuario
        if (codigo.isEmpty()) {
            Toast.makeText(this, "No puedes dejar el campo en blanco!", Toast.LENGTH_SHORT).show();
        } else {
            Cursor fila = BaseDeDatos.rawQuery("SELECT contraseña,correo FROM usuarios WHERE nombre = '"+ codigo+"'", null);
            if (fila.moveToFirst()) {
                String aux= password.getText().toString();//Recupero la contraseña del usuario
                String correo=fila.getString(1);
                if(aux.equals(fila.getString(0))){//Si la contraseña del usuario es igual a la que coloco en el edittext
                    Intent intent = new Intent(MainActivity.this,Principal.class);
                    intent.putExtra("Usuario",codigo);
                    intent.putExtra("Correo",correo);
                    startActivity(intent);
                }else{
                    Toast.makeText(this, "Contraseña Incorrecta", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(this, "No se han encontrado usuarios con ese nombre", Toast.LENGTH_SHORT).show();
            }
            fila.close();
        }
        BaseDeDatos.close();
    }
}