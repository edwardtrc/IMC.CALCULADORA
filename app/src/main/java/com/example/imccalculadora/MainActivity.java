package com.example.imccalculadora;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText etNombre,etPeso,etAltura;
    Button btnCalcular,btnLimpiar;
    RadioButton rbVaron,rbMujer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) findViewById(R.id.button1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), MainActivity2.class);
                startActivityForResult(intent, 0);
            }
        });

        etNombre=(EditText)findViewById(R.id.etNombre);
        etPeso=(EditText)findViewById(R.id.etPeso);
        etAltura=(EditText)findViewById(R.id.etAltura);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnLimpiar=(Button)findViewById(R.id.btnLimpiar);
        rbVaron=(RadioButton)findViewById(R.id.rbVaron);
        rbMujer=(RadioButton)findViewById(R.id.rbMujer);

        btnLimpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Limpiar();
            }
        } );
        btnCalcular.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                calcular();
            }
        } );

    }



    public void Limpiar() {
        etNombre.setText("");
        etAltura.setText("");
        etPeso.setText("");
    }
    private String MensajeIMC(double IMC){

        String mensaje ="";
        if (IMC<16)
            mensaje=" PESO BAJO MUY GRAVE";
        else if(IMC>=16 & IMC <17)
            mensaje=" PESO BAJO GRAVE";
        else if(IMC<=17.00 || IMC<=18.49)
            mensaje=" PESO ACEPTABLE";
        else if(IMC<=18.50 ||IMC<=24.99)
            mensaje=" Peso Normal";
        else if(IMC<=25.00 || IMC<=29.99)
            mensaje =" Sobrepeso";
        else if(IMC<=30.00 || IMC<=34.99)
            mensaje =" Obeso: GRADO I";
        else if(IMC<=35.00 || IMC<=39.99)
            mensaje=" Obeso: GRADO II";
        else if(IMC<=40.00 || IMC<=50.00)
           mensaje=" Obeso: GRADO III";
        else
            mensaje="  IMC INCORRECTO";

        return mensaje;
    }

    private String Mensaje2(double IMC){

        String mensaje ="";
        if (IMC<16)
            mensaje="#Tu peso esta por debajo del promedio " +
                    "#Comer con m??s frecuencia.\n" +
                    "#Escoger comidas ricas en nutrientes.\n" +
                    "#Tomar batidos y licuados de frutas.\n" +
                    "#Elegir productos l??cteos enteros.\n" +
                    "#Cocinar salsas y sopas con leche en lugar de agua. ";

        else if(IMC>=16 & IMC <17)
            mensaje="#Tienes el peso bajo\n"+
                    "#Cocinar salsas y sopas con leche en lugar de agua.\n"+
                    "#Anotar cu??ndo y cu??nto se bebe.\n"+
                    "#Permitirse caprichos.\n"+
                    "#Hacer ejercicio. ";

        else if(IMC<=17.00 || IMC<=18.49)
            mensaje="#Te encuentras un poco bajo de peso\n"+
                    "#Elegir productos l??cteos enteros.\n" +
                    "#Cocinar salsas y sopas con leche en lugar de agua. ";

        else if(IMC<=18.50 ||IMC<=24.99)
            mensaje="Tienes el IMC correcto pero no te descuides come saludable :D";

        else if(IMC<=25.00 || IMC<=29.99)
            mensaje ="#Estas levemente subido de peso\n"+
                    "#Limitar el consumo de alimentos que sean ricos en az??cares y grasas\n" +
                     "#Comer varias veces al d??a fruta y verdura, as?? como legumbres, cereales integrales y frutos secos.\n" +
                     "#Realizar actividad f??sica frecuente: unos 60 minutos por d??a para los j??venes y 150 minutos semanales para los adultos.";

        else if(IMC<=30.00 || IMC<=34.99)
            mensaje ="Estas Obeso\n" +
                    "#Limitar el consumo de alimentos que sean ricos en az??cares y grasas\n" +
                    "#Comer varias veces al d??a fruta y verdura, as?? como legumbres, cereales integrales y frutos secos.\n" +
                    "#Realizar actividad f??sica frecuente: unos 60 minutos por d??a para los j??venes y 150 minutos semanales para los adultos.\n " +
                    "comenzar por caminar 30 minutos al d??a a paso ligero. \n" +
                    "#Deja de fumar. Fumar est?? asociado con muchas enfermedades, pero tambi??n con el aumento de peso.\n" +
                    "#Es importante no obsesionarse, pero puede ayudar a controlar el peso pesarse regularmente: una vez por semana es suficiente.\n";


        else if(IMC<=35.00 || IMC<=39.99)
            mensaje="#Ten Cuidado\n"+
                    "#Realizar actividad f??sica frecuente: unos 60 minutos por d??a para los j??venes y 150 minutos semanales para los adultos.\n" +
                    "#Retire toda la grasa visible de las carnes o la piel del pollo antes de cocinarla.\n" +
                    "#Utilice formas de cocinar sencillas, que no requieran mucho aceite: plancha, grill, horno, microondas.\n" +
                    "#La cocci??n al vapor con la olla a presi??n permite cocinar con poca agua y se preservan todas las propiedades de los alimentos\n" +
                    "#Para cocinar carnes y pescados envu??lvalas en papel de aluminio (papillote), as?? se cocinan en su propio jugo.";


        else if(IMC<=40.00 || IMC<=50.00)
            mensaje="#Cuidate\n"+
                    "#Tome de 2 a 3 piezas de fruta al d??a.  Evite aquellas con abundante contenido en az??car: pl??tano, uvas, higos, cerezas, n??speros, chirimollas\n" +
                    "#Beba abundante agua, entre 1.5 y 2 litros al d??a.\n" +
                    "#Evite o limite el consumo de alimentos fritos o cocinados con excesiva grasa.\n" +
                    "#Esconda los alimentos ricos en calor??as.\n" +
                    "#Tenga a mano tentempi??s m??s saludables: verduras, l??cteos desnatados, fruta";

        else
            mensaje="  IMC INCORRECTO";


        return mensaje;
    }






    public void calcular()
    {
        String nombre= etNombre.getText().toString();
        Double altura = Double.valueOf(etAltura.getText().toString());
        Double peso = Double.valueOf(etPeso.getText().toString());
        double IMC = peso /Math.pow(altura,2);




        Toast toasta =

                Toast.makeText(this, "RECOMENDACIONES\n"+Mensaje2(IMC), Toast.LENGTH_LONG);
               toasta.setGravity(Gravity.CENTER | Gravity.CENTER,0,700);
               toasta.show();


        Toast toast1 =
               Toast.makeText(this, "Hola " +String.format( nombre), Toast.LENGTH_SHORT);
               toast1.setGravity(Gravity.BOTTOM | Gravity.CENTER,0,1000);
        toast1.show();

               Toast toast =
                Toast.makeText(this, "TU IMC ES "+String.format("%.2f",IMC)+MensajeIMC(IMC), Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER | Gravity.CENTER,0,50);
        toast.show();


        if (rbMujer.isChecked()==true)

            Toast.makeText(this, "Eres Mujer", Toast.LENGTH_SHORT).show();
        else if (rbVaron.isChecked()==true)
            Toast.makeText(this, "Eres Varon", Toast.LENGTH_SHORT).show();
        else
        Toast.makeText(this, "No eligio Sexo", Toast.LENGTH_SHORT).show();

    }


}