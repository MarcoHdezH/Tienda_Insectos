package com.example.natureway;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Insectos extends AppCompatActivity {

    private TextView Titulo1,Titulo2,Titulo3,Titulo4,Descripcion1,Descripcion2,Descripcion3,Descripcion4;
    private TextView Tamaño1,Tamaño2,Tamaño3,Tamaño4,Precio1,Precio2,Precio3,Precio4;
    private ImageView Img1,Img2,Img3,Img4;
    private ImageButton ImgBtn1,ImgBtn2,ImgBtn3,ImgBtn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insectos);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        String Usuario=getIntent().getStringExtra("Usuario");
        String Correo=getIntent().getStringExtra("Correo");

        //Segun la seccion en la que entra el usuario, muestro la informacion recibida (Insectos, Escorpiones, etc)
        Titulo1 = (TextView)findViewById(R.id.Titulo1);
        String Nombre = getIntent().getStringExtra("Titulo1");
        Titulo1.setText(Nombre);

        Img1 = (ImageView) findViewById(R.id.Imagen1);

        Descripcion1 = (TextView) findViewById(R.id.Descripcion1);
        String Texto = getIntent().getStringExtra("Descripcion1");
        Descripcion1.setText(Texto);

        Tamaño1 = (TextView) findViewById(R.id.Tamaño1);
        String Medida = getIntent().getStringExtra("Tamaño1");
        Tamaño1.setText(Medida);

        Precio1 = (TextView) findViewById(R.id.Precio1);
        String Total = getIntent().getStringExtra("Precio1");
        Precio1.setText(Total);
        ImgBtn1 = (ImageButton) findViewById(R.id.Comprar1);
        /////////////////////////////////////////////////////////////////////////////////
        Titulo2 = (TextView)findViewById(R.id.Titulo2);
        String Nombre2 = getIntent().getStringExtra("Titulo2");
        Titulo2.setText(Nombre2);

        Img2 = (ImageView) findViewById(R.id.Imagen2);

        Descripcion2 = (TextView) findViewById(R.id.Descripcion2);
        String Texto2 = getIntent().getStringExtra("Descripcion2");
        Descripcion2.setText(Texto2);

        Tamaño2 = (TextView) findViewById(R.id.Tamaño2);
        String Medida2 = getIntent().getStringExtra("Tamaño2");
        Tamaño2.setText(Medida2);

        Precio2 = (TextView) findViewById(R.id.Precio2);
        String Total2 = getIntent().getStringExtra("Precio2");
        Precio2.setText(Total2);

        ImgBtn2 = (ImageButton) findViewById(R.id.Comprar2);
        //////////////////////////////////////////////////////////////////////////77

        Titulo3 = (TextView)findViewById(R.id.Titulo3);
        String Nombre3 = getIntent().getStringExtra("Titulo3");
        Titulo3.setText(Nombre3);

        Img3 = (ImageView) findViewById(R.id.Imagen3);

        Descripcion3 = (TextView) findViewById(R.id.Descripcion3);
        String Texto3 = getIntent().getStringExtra("Descripcion3");
        Descripcion3.setText(Texto3);

        Tamaño3 = (TextView) findViewById(R.id.Tamaño3);
        String Medida3 = getIntent().getStringExtra("Tamaño3");
        Tamaño3.setText(Medida3);

        Precio3 = (TextView) findViewById(R.id.Precio3);
        String Total3 = getIntent().getStringExtra("Precio3");
        Precio3.setText(Total3);

        ImgBtn3 = (ImageButton) findViewById(R.id.Comprar3);
        /////////////////////////////////////////////////////
        Titulo4 = (TextView)findViewById(R.id.Titulo4);
        String Nombre4 = getIntent().getStringExtra("Titulo4");
        Titulo4.setText(Nombre4);

        Img4 = (ImageView) findViewById(R.id.Imagen4);

        Descripcion4 = (TextView) findViewById(R.id.Descripcion4);
        String Texto4 = getIntent().getStringExtra("Descripcion4");
        Descripcion4.setText(Texto4);

        Tamaño4 = (TextView) findViewById(R.id.Tamaño4);
        String Medida4 = getIntent().getStringExtra("Tamaño4");
        Tamaño4.setText(Medida4);

        Precio4 = (TextView) findViewById(R.id.Precio4);
        String Total4 = getIntent().getStringExtra("Precio4");
        Precio4.setText(Total4);

        ImgBtn4 = (ImageButton) findViewById(R.id.Comprar4);

        String ID = getIntent().getStringExtra("ID");

        //Segun la seccion en la que entra el usuario, cambio las imagenes
        if(ID.equals("1")) {
            Img1.setImageResource(R.drawable.tarantula_azul);
            Img2.setImageResource(R.drawable.tarantula_mexicana);
            Img3.setImageResource(R.drawable.tarantula_himalaya);
            Img4.setImageResource(R.drawable.tarantula_rubia);
            actionBar.setTitle("Lista de Arañas en Stock");
        }
        if(ID.equals("2")){
            Img1.setImageResource(R.drawable.escorpion_androctonus);
            Img2.setImageResource(R.drawable.escorpion_rojo);
            Img3.setImageResource(R.drawable.escorpion_azul);
            Img4.setImageResource(R.drawable.escorpion_grueso);
            actionBar.setTitle("Lista de Escorpiones en Stock");
        }

        if(ID.equals("3")){
            Img1.setImageResource(R.drawable.mantis);
            Img2.setImageResource(R.drawable.hormigas);
            Img3.setImageResource(R.drawable.amblipigido);
            Img4.setImageResource(R.drawable.insecto_palo);
            actionBar.setTitle("Lista de Insectos en Stock");
        }

        if(ID.equals("4")){
            Img1.setImageResource(R.drawable.argentina);
            Img2.setImageResource(R.drawable.madagascar);
            Img3.setImageResource(R.drawable.grillo);
            Img4.setImageResource(R.drawable.gusano);
            actionBar.setTitle("Alimento Vivo Disponible");
        }
        if(ID.equals("5")){
            Img1.setImageResource(R.drawable.terrario3);
            Img2.setImageResource(R.drawable.terrario2);
            Img3.setImageResource(R.drawable.terrario);
            Img4.setImageResource(R.drawable.terrario_hormigas);
            actionBar.setTitle("Terrarios y Accesorios");
        }

        //Segun el prodcuto escogido, envio la informacion a la clase "Comprar"
        ImgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insectos.this,Comprar.class);
                intent.putExtra("Nombre",Nombre);
                intent.putExtra("Precio",Total);

                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
            }
        });

        ImgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insectos.this,Comprar.class);
                intent.putExtra("Nombre",Nombre2);
                intent.putExtra("Precio",Total2);

                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
            }
        });

        ImgBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insectos.this,Comprar.class);
                intent.putExtra("Nombre",Nombre3);
                intent.putExtra("Precio",Total3);

                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
            }
        });

        ImgBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Insectos.this,Comprar.class);
                intent.putExtra("Nombre",Nombre4);
                intent.putExtra("Precio",Total4);

                intent.putExtra("Usuario",Usuario);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
            }
        });
    }
}