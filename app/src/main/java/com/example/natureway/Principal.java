package com.example.natureway;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Principal extends AppCompatActivity {

    private Button Arañas,Escorpiones,Otros,Alimento,Extras;
    private ImageButton Perfil,Nosotros;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        String Titulo=getIntent().getStringExtra("Usuario");
        String Correo=getIntent().getStringExtra("Correo");

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Bienvenido "+Titulo);
        actionBar.setDisplayHomeAsUpEnabled(true);

        Arañas = (Button) findViewById(R.id.imageButtonAraña);
        Escorpiones = (Button) findViewById(R.id.imageButtonEscorpion);
        Otros = (Button) findViewById(R.id.imageButtonOtros);
        Alimento = (Button) findViewById(R.id.imageButtonComida);
        Extras = (Button) findViewById(R.id.imageButtonExtras);
        Perfil = (ImageButton)findViewById(R.id.imageButtonCuenta);
        Nosotros = (ImageButton) findViewById(R.id.imageButtonNosotros);

        final String[] Descripcion1 = new String[1];
        final String[] Descripcion2 = new String[1];
        final String[] Descripcion3 = new String[1];
        final String[] Descripcion4 = new String[1];

        //De acuerdo a la seccion escogida, se envia informacion distinta al activity "Insectos"
        //Envio de: Nombre, Descripcion, Tamaño, Precio.
        Arañas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Insectos.class);
                intent.putExtra("Titulo1","Tarantula Azul");
                Descripcion1[0] = "La tarántula azul, recientemente descubierta, presenta una patas azul eléctrico y un cuerpo marrón claro. Esta especie es nativa de Sarawak, Malasia. No es tarantula para principiantes";
                intent.putExtra("Descripcion1", Descripcion1[0]);
                intent.putExtra("Tamaño1","Tamaño Aproximado: 10-12 cm");
                intent.putExtra("Precio1","Precio(Unidad):3000 MXN");

                intent.putExtra("Titulo2","Tarantula Mexicana de Patas Rojas");
                Descripcion2[0] = "La tarántula mexicana de rodillas rojas es considerada la especie más emblemática de todas las tarántulas debido a su belleza y docilidad. Es por esto que esta especie presenta una gran demanda como mascota. Muerde muy rara vez, pero al sentirse amenazada sacude unos vellos urticantes.";
                intent.putExtra("Descripcion2", Descripcion2[0]);
                intent.putExtra("Tamaño2","Tamaño Aproximado: 08-10 cm");
                intent.putExtra("Precio2","Precio(Unidad):1200 MXN");

                intent.putExtra("Titulo3","Tarantula del Himalaya");
                Descripcion3[0] = "Estas tarántulas habitan en entornos tropicales, requiriendo asi una humedad elevada. Construyen madrigueras de varios metros de profundidad, de las cuales salen para buscar alimento.";
                intent.putExtra("Descripcion3", Descripcion3[0]);
                intent.putExtra("Tamaño3","Tamaño Aproximado: 12-15 cm");
                intent.putExtra("Precio3","Precio(Unidad):4200 MXN");

                intent.putExtra("Titulo4","Tarantula Rubia del Desierto");
                Descripcion4[0] = "Aparte del veneno que utilizan para paralizar a sus presas algunas de las cerdas de su abdomen están diseñadas para la defensa, produciendo un daño urticante. Si una tarántula es amenazada, frotará su abdomen contra su atacante. Las cerdas son muy difícil de retirar debido a las barbas de su diseño. Se recomienda especial manejo en su cuidado.";
                intent.putExtra("Descripcion4", Descripcion4[0]);
                intent.putExtra("Tamaño4","Tamaño Aproximado: 5.6-8.2 cm");
                intent.putExtra("Precio4","Precio(Unidad):920 MXN");
                intent.putExtra("ID","1");

                intent.putExtra("Usuario",Titulo);
                intent.putExtra("Correo",Correo);
                startActivity(intent);
            }
        });



        Escorpiones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Insectos.class);
                intent.putExtra("Titulo1","Escorpión Androctonus Crassicauda");
                Descripcion1[0] = "Nacidos en cautividad procedentes de Israel, Irán e Iraq. Para la compra de este animal es necesario tener la Licencia de Animales Potencialmente Peligrosos, dicha licencia se puede adquirir en tu propio ayuntamiento.";
                intent.putExtra("Descripcion1", Descripcion1[0]);
                intent.putExtra("Tamaño1","Tamaño Aproximado: 8-12 cm");
                intent.putExtra("Precio1","Precio(Unidad):7200 MXN");

                intent.putExtra("Titulo2","Escorpión Gigante Rojo");
                Descripcion2[0] = "Procedente de africa, de paises como Kenia y Camerún, habita zonas áridas de la sabana africana, especificamente debajo de las rocas o cortezas de árboles en busca de humedad. No es de importancia médica.";
                intent.putExtra("Descripcion2", Descripcion2[0]);
                intent.putExtra("Tamaño2","Tamaño Aproximado: 06-08 cm");
                intent.putExtra("Precio2","Precio(Unidad):1250 MXN");

                intent.putExtra("Titulo3","Escorpión Emperador Azul");
                Descripcion3[0] = "Es uno de los escorpiones más grandes del mundo y vive entre 6 y 8 años. El escorpión emperador es una especie muy popular en el comercio de mascotas.\nEn la mayoría de los casos las personas no se ven afectadas por la picadura del escorpión emperador, pero puede afectar a personas alérgicas o con enfermedades presentes.";
                intent.putExtra("Descripcion3", Descripcion3[0]);
                intent.putExtra("Tamaño3","Tamaño Aproximado: 15-21 cm");
                intent.putExtra("Precio3","Precio(Unidad):850 MXN");

                intent.putExtra("Titulo4","Escorpión de Cola Gruesa");
                Descripcion4[0] = "Pueden vivir en una variedad de entornos, que van desde las zonas urbanas hasta las montañas áridas y la selva amazónica. Los escorpiones de Tityus son más conocidos por su veneno y su potente picadura.\nSe recomienda especial manejo en su cuidado.";
                intent.putExtra("Descripcion4", Descripcion4[0]);
                intent.putExtra("Tamaño4","Tamaño Aproximado: 5.6-7.2 cm");
                intent.putExtra("Precio4","Precio(Unidad):420 MXN");
                intent.putExtra("ID","2");

                intent.putExtra("Usuario",Titulo);
                intent.putExtra("Correo",Correo);

                startActivity(intent);
            }
        });

        Otros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Insectos.class);
                intent.putExtra("Titulo1","Mantis Religiosa");
                Descripcion1[0] = "La mantis religiosa es un insecto que se caracteriza y recibe su nombre por la forma de sus patas delanteras, dobladas y en posición de rezo.\nSe trata de un insecto inofensivo para los seres humanos, debido a su pequeño tamaño y a que no cuentan con ninguna sustancia tóxica como defensa.";
                intent.putExtra("Descripcion1", Descripcion1[0]);
                intent.putExtra("Tamaño1","Tamaño Aproximado: 04-07 cm");
                intent.putExtra("Precio1","Precio(Unidad):340 MXN");

                intent.putExtra("Titulo2","Colonia de Hormigas(100)");
                Descripcion2[0] = "Sí, aunque parezca increíble, hay personas que adoran tener a las hormigas como mascotas. Las hormigas son animales tranquilos, no provocan ruidos y son un gran ejemplo de trabajo en equipo.\nNo es de extrañar que muchos deseen tenerlas en casa como mascotas, aunque a otras muchas personas les disguste su presencia, especialmente cuando aparecen en la cocina.";
                intent.putExtra("Descripcion2", Descripcion2[0]);
                intent.putExtra("Tamaño2","Tamaño Aproximado: 0.30-1.0 cm");
                intent.putExtra("Precio2","Precio(Unidad):250 MXN");

                intent.putExtra("Titulo3","Amblipigio Damon Diadema");
                Descripcion3[0] = "Los amblipigios son parientes lejanos de las arañas y suelen ser llamados arañas látigo o escorpiones sin cola, pero no son ni uno ni otro. Apreciado por su aspecto aterrador y alienígena, no cabe duda de que el amblipigio sorprenderá a cualquiera.\nEstos invertebrados pueden ser buenas mascotas, ya que no suponen ningún peligro para los humanos.";
                intent.putExtra("Descripcion3", Descripcion3[0]);
                intent.putExtra("Tamaño3","Tamaño Aproximado: 10-25 cm");
                intent.putExtra("Precio3","Precio(Unidad):1299 MXN");

                intent.putExtra("Titulo4","Insecto Palo Extatosoma tiaratum");
                Descripcion4[0] = "Esta es una especie muy popular, debido a su gran tamaño e impresionante camuflaje. Al igual que casi todos los insectos palo, esta especie es dócil por naturaleza. Es nocturna y generalmente sólo se mueve de noche.\n" +
                        "Tiene una impresionante estrategia de defensa: Imitar a un escorpión cuando se siente amenazado.";
                intent.putExtra("Descripcion4", Descripcion4[0]);
                intent.putExtra("Tamaño4","Tamaño Aproximado: 12-15 cm");
                intent.putExtra("Precio4","Precio(Unidad):1420 MXN");
                intent.putExtra("ID","3");

                intent.putExtra("Usuario",Titulo);
                intent.putExtra("Correo",Correo);

                startActivity(intent);

            }
        });

        Alimento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Insectos.class);
                intent.putExtra("Titulo1","Cucaracha Argentina (Lote 50 Crías)");
                Descripcion1[0] = "Es muy popular como alimento de reptiles y anfibios debido a su calidad nutritiva y su facilidad de cría comparada con los grillos. La cucaracha argentina tiene una mejor relación de proteína digerible comparada con la de los grillos.\nSe alimentan en condiciones más secas y apenas producen olor, son tranquilas y fáciles de manipular para alimentarlas.";
                intent.putExtra("Descripcion1", Descripcion1[0]);
                intent.putExtra("Tamaño1","Tamaño Aproximado: 04-4.5 cm");
                intent.putExtra("Precio1","Precio(Paquete):350 MXN");

                intent.putExtra("Titulo2","Cucaracha Madagascar (Lote de 30 crías)");
                Descripcion2[0] = "La cucaracha de Madagascar es una cucaracha realmente rica en proteínas. Se ha convertido en una popular mascota debido a su sonido siseante, su gran tamaño y su aspecto. y también puede ofrecérselos ocasionalmente como comida desecada para perros gatos o ratones.\nAsí mismo a diferente tipo de reptiles como alimento vivo.";
                intent.putExtra("Descripcion2", Descripcion2[0]);
                intent.putExtra("Tamaño2","Tamaño Aproximado: 05-8.2 cm");
                intent.putExtra("Precio2","Precio(Paquete):550 MXN");

                intent.putExtra("Titulo3","Grillo Común (Lote de 60 Crías)");
                Descripcion3[0] = "El grillo, como alimento vivo, es de vital importancia en la alimentación de reptiles y arácnidos, pues aportan un 60% de proteína en peso seco. Esto supone un aporte nutricional importante para el correcto desarrollo de lagartijas, camaleones, arañas etc.";
                intent.putExtra("Descripcion3", Descripcion3[0]);
                intent.putExtra("Tamaño3","Tamaño Aproximado: 02-3.8 cm");
                intent.putExtra("Precio3","Precio(Paquete):280 MXN");

                intent.putExtra("Titulo4","Gusanos de Seda (Frasco 500g)");
                Descripcion4[0] = "El gusano de seda es un insecto que se alimenta de morera, usado como alimento vivo o deshidratado en forma de larva. Se ha convertido en una parte indispensable del alimento moderno de animales exóticos.\nTienen una increíble composición alimentaria con una cantidad alta de proteínas y de grasa";
                intent.putExtra("Descripcion4", Descripcion4[0]);
                intent.putExtra("Tamaño4","Tamaño Aproximado: 1-2 cm");
                intent.putExtra("Precio4","Precio(Frasco):320 MXN");
                intent.putExtra("ID","4");

                intent.putExtra("Usuario",Titulo);
                intent.putExtra("Correo",Correo);

                startActivity(intent);

            }
        });

        Extras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Insectos.class);
                intent.putExtra("Titulo1","Terrario Vidrio (Incluye Accesorios)");
                Descripcion1[0] = "Adornar un terrario no es como colgar bolas en un árbol de Navidad, ¡a lo loco! No, debemos colocar el número justo para que la mascota no se sienta agobiada y pueda andar libremente.\nLe ofreceremos un lugar para que pueda resguardarse, para los momentos de soledad y si vas a poner cactus acuérdate de quitarles las espinas.";
                intent.putExtra("Descripcion1", Descripcion1[0]);
                intent.putExtra("Tamaño1","Tamaño Aproximado: 16 x 16 x 20 cm");
                intent.putExtra("Precio1","Precio(Unidad):650 MXN");

                intent.putExtra("Titulo2","Terrario Acrílico (Accesorios Incluidos)");
                Descripcion2[0] = "La belleza del terrario complacerá más a los cuidadores que a las arañas. Aun así, siéntete libre de decorar el hogar de tu mascota como consideres. Eso sí, recuerda que este debe ser funcional para la araña que vivirá allí.";
                intent.putExtra("Descripcion2", Descripcion2[0]);
                intent.putExtra("Tamaño2","Tamaño Aproximado: 25 x 23 x 21 cm");
                intent.putExtra("Precio2","Precio(Paquete):600 MXN");

                intent.putExtra("Titulo3","Terrario Mantis Religiosa");
                Descripcion3[0] = "La mantis tiene una esperanza de vida de entre 6 meses a 1 año, para que tu mantis viva el mayor tiempo posible debes proporcionarle un hábitat adecuado.\n¡Con este terrario lo conseguiras!";
                intent.putExtra("Descripcion3", Descripcion3[0]);
                intent.putExtra("Tamaño3","Tamaño Aproximado: 18 x 12 x 25 cm");
                intent.putExtra("Precio3","Precio(Paquete):780 MXN");

                intent.putExtra("Titulo4","Granja para Hormigas (Todo Incluido)");
                Descripcion4[0] = "Hormiguero 3D con Depósito de Agua. Incluye sala de forrajeo integrada con tapadera y sistema de humedad. Perfecto para jóvenes colonias. Con galerías más naturales que aprovechan mejor el espacio disponible.";
                intent.putExtra("Descripcion4", Descripcion4[0]);
                intent.putExtra("Tamaño4","Tamaño Aproximado: 43 x 25 x 7.2 cm");
                intent.putExtra("Precio4","Precio(Unidad):520 MXN");
                intent.putExtra("ID","5");

                intent.putExtra("Usuario",Titulo);
                intent.putExtra("Correo",Correo);

                startActivity(intent);

            }
        });

        Perfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Usuario.class);
                intent.putExtra("Usuario",Titulo);
                startActivity(intent);
            }
        });

        Nosotros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Principal.this,Nosotros.class);
                startActivity(intent);
            }
        });
    }
}