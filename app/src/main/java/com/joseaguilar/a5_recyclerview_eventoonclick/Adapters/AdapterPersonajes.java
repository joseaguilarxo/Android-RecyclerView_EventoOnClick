package com.joseaguilar.a5_recyclerview_eventoonclick.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.joseaguilar.a5_recyclerview_eventoonclick.Clases.Personajes;
import com.joseaguilar.a5_recyclerview_eventoonclick.Controles.Utilidades;
import com.joseaguilar.a5_recyclerview_eventoonclick.R;

import java.util.ArrayList;

//Paso 1: Agregamos el extends para la estructura del adapter  "extends RecyclerView.Adapter<AdapterPersonajes.ViewHolderPersonajes>"
//Paso 2: Agregarmos el implement "implements View.OnClickListener"
public class AdapterPersonajes
        extends RecyclerView.Adapter<AdapterPersonajes.ViewHolderPersonajes>
        implements View.OnClickListener {

    //Paso 3: Arraylist de la clase Personajes
    ArrayList<Personajes> listaPersonajes;
    //Paso 4: creamos  variable para el evento onclickListener
    private View.OnClickListener listener; //este sera nuestro escuchador

    //Paso 5: Creamos constructor del Arraylist
    public AdapterPersonajes(ArrayList<Personajes> listaPersonajes) {
        this.listaPersonajes = listaPersonajes;
    }

    //Paso 6: Creamos un IF para la seleccion de moldes  y establecemos el escuchador
    @Override
    public ViewHolderPersonajes onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout = 0;
        if (Utilidades.visualizacion == Utilidades.LIST) {
            layout = R.layout.molde_lista_personajes;
        } else {
            layout = R.layout.molde_grid_personajes;
        }
        View view = LayoutInflater.from(parent.getContext()).inflate(layout, null, false);
        view.setOnClickListener(this);
        return new ViewHolderPersonajes(view);
    }

    //Paso 7: realizamos el conteo de items de la lista
    @Override
    public int getItemCount() {
        return listaPersonajes.size();
    }


    //Paso 8: Hacemos la misma condicional para que sepamos cual elemento debera mostrar
    public class ViewHolderPersonajes extends RecyclerView.ViewHolder {
        TextView txtnombre, txtdescripcion;
        ImageView foto;

        public ViewHolderPersonajes(View itemView) {
            super(itemView);
            if (Utilidades.visualizacion == Utilidades.LIST) {
                txtnombre = (TextView) itemView.findViewById(R.id.idNombre);
                txtdescripcion = (TextView) itemView.findViewById(R.id.idInfo);
                foto = (ImageView) itemView.findViewById(R.id.idImagen);
            } else {
                txtnombre = (TextView) itemView.findViewById(R.id.idNombre2);
                foto = (ImageView) itemView.findViewById(R.id.idImagen2);
            }
        }
    }


    //Paso 9: Creamos condicional para saber que datos enviaremos dependiendo el molde
    @Override
    public void onBindViewHolder(AdapterPersonajes.ViewHolderPersonajes holder, int position) {
        if (Utilidades.visualizacion == Utilidades.LIST) {
            holder.txtnombre.setText(listaPersonajes.get(position).getNombre());
            holder.txtdescripcion.setText(listaPersonajes.get(position).getInfo());
            holder.foto.setImageResource(listaPersonajes.get(position).getFoto()); //se coloca SetImageResource cuando las imagenes se traen desde drawable
        } else {
            holder.txtnombre.setText(listaPersonajes.get(position).getNombre());
            holder.foto.setImageResource(listaPersonajes.get(position).getFoto());
        }
    }

    //Paso 10: Creamos metodo setOnClickListener
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    //Paso 11: creamos una condicion para saber si el listener es diferente a null, lo pueda reconocer el evento y enviarlo
    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onClick(v);
        }
    }


}
