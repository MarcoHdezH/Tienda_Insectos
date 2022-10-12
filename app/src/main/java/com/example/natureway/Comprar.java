package com.example.natureway;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Comprar extends AppCompatActivity {

    private TextView nombre,correo,descripcion;
    private Button Enviar;
    Session session;

    String CorreoEnvia,Contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comprar);
        ActionBar actionBar = getSupportActionBar();


        //Defino mis textview
        nombre = (TextView) findViewById(R.id.nombre);
        correo = (TextView) findViewById(R.id.correo);
        descripcion = (TextView) findViewById(R.id.descripcion);
        Enviar = (Button) findViewById(R.id.enviar);

        String Usuario=getIntent().getStringExtra("Usuario");
        String Correo=getIntent().getStringExtra("Correo");

        String aux1=getIntent().getStringExtra("Nombre");
        String aux2=getIntent().getStringExtra("Precio");
        String Mensaje ="Pedido confirmado de: "+aux1+". "+aux2+".\n¡Gracias por su compra!";

        nombre.setText(Usuario);
        correo.setText(Correo);
        descripcion.setText(Mensaje);

        //Cuenta Gmail que envia los correos
        CorreoEnvia="correopruebaappsmoviles@gmail.com";
        Contraseña="Tumama210*";

        Enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                Properties properties = new Properties();
                //Conexion con googlemail.com
                properties.put("mail.smtp.host","smtp.googlemail.com");
                properties.put("mail.smtp.socketFactory.port","465");
                properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.port","465");

                try {
                    session = Session.getDefaultInstance(properties, new Authenticator() {
                        @Override
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(CorreoEnvia,Contraseña);
                        }
                    });
                    //Si logro conectarme a googlemail.com
                    if(session!=null){
                        Message message = new MimeMessage(session);
                        message.setFrom(new InternetAddress(CorreoEnvia));
                        message.setSubject("Compra (Confirmación) de Articulo");//Asunto del Mensaje
                        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(Correo));//"Correo es la cuenta destinatario"
                        message.setContent(Mensaje,"text/html; charset=utf-8");//Formato de mensaje a enviar
                        Transport.send(message);//Envio mensaje
                        Toast.makeText(Comprar.this, "Confirmación de pedido Exitosa", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Comprar.this,Principal.class);
                        intent.putExtra("Usuario",Usuario);
                        intent.putExtra("Correo",Correo);
                        startActivity(intent);
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });




    }
}