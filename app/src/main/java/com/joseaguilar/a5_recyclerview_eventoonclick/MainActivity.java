package com.joseaguilar.a5_recyclerview_eventoonclick;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.joseaguilar.a5_recyclerview_eventoonclick.Adapters.AdapterPersonajes;
import com.joseaguilar.a5_recyclerview_eventoonclick.Clases.Personajes;
import com.joseaguilar.a5_recyclerview_eventoonclick.Controles.Utilidades;

import java.util.ArrayList;

//EL ORDEN PARA DESARROLLAR ESTE PROYECTO ES: CLASE -> ADAPTER -> MAINACTIVITY
public class MainActivity extends AppCompatActivity {
    //Paso 1: creamos arraylist
    ArrayList<Personajes> listaPersonajes;
    //Paso 2: referenciamos a nuestro recyclerview
    RecyclerView recyclerPersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        construirRecycler();
    }
    //Paso 3: Declararemos una condicional switch para que se pueda saber que boton esta preiconando
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnlista:
                Utilidades.visualizacion = Utilidades.LIST;
                break;
            case R.id.btngrid:
                Utilidades.visualizacion = Utilidades.GRID;
        }
        construirRecycler();
    }


    //Paso 4: Creamos metodo "construirRecycler" que se encargara de mostrar la logica de visualizacion
    private void construirRecycler() {
        //Paso 5: instanciamos a la lista personajes
        listaPersonajes = new ArrayList<>();
        //Paso 6: vinculamos referencia de nuestro recyclerview
        recyclerPersonajes = (RecyclerView) findViewById(R.id.RecyclerId);


        //Paso 7: creamos una condicional para saber que layout deberemos de asignar dependiendo de la seleccion del usuario
        if(Utilidades.visualizacion==Utilidades.LIST){
            recyclerPersonajes.setLayoutManager(new LinearLayoutManager(this));
        }else{
            recyclerPersonajes.setLayoutManager(new GridLayoutManager(this,2));
        }


        //Paso 8: creamos metodo de llenarimagenes para que se encargue de alimentar las fotos de la lista
        llenarPersonajes();

        //Paso 9: enviamos lista de imagenes al adaptador
        AdapterPersonajes adapter = new AdapterPersonajes(listaPersonajes);

        //Paso 10: ahora agregamos el metodo onClickListener
        adapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //aca ya va toda la logica que se quiera implementar, como ejemplo solo mandaremos un toast
                Toast.makeText(getApplicationContext(),
                        "Seleccion: "+listaPersonajes.get(recyclerPersonajes.getChildAdapterPosition(v)).getNombre(),
                        Toast.LENGTH_SHORT ).show();
            }
        });

        //Paso 11: enviamos el adapter creado a nuestro recyclerview
        recyclerPersonajes.setAdapter(adapter);
    }



    private void llenarPersonajes() {
        listaPersonajes.add(new Personajes("Bart", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.bart));
        listaPersonajes.add(new Personajes("Mr. Burns", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.burns));
        listaPersonajes.add(new Personajes("Flanders", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.flanders));
        listaPersonajes.add(new Personajes("Homero", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.homero));
        listaPersonajes.add(new Personajes("Krusty", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.krusti));
        listaPersonajes.add(new Personajes("Lisa", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.lisa));
        listaPersonajes.add(new Personajes("Magie", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.magie));
        listaPersonajes.add(new Personajes("Marge", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.marge));
        listaPersonajes.add(new Personajes("Milhouse", "Lorem Ipsum es simplemente el texto de relleno de las imprentas y archivos de texto. Lorem Ipsum ha sido el texto de relleno estándar de las industrias desde el año 1500, cuando un impresor (N. del T. persona que se dedica a la imprenta) desconocido usó una galería de textos y los mezcló de tal manera que logró hacer un libro de textos especimen", R.drawable.milhouse));
    }

}
