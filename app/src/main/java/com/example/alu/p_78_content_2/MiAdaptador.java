package com.example.alu.p_78_content_2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alu on 09/02/2018.
 */

public class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MiViewHolder> {
    private final ArrayList<Item> datos;
    private final Context applicationContext;
    private MiOnItemClickListener listener;

    public interface MiOnItemClickListener {
        void miOnItemClick(int posicionItem);
    }

    public MiAdaptador(ArrayList<Item> datos, Context applicationContext,MiOnItemClickListener listener) {
        this.datos = datos;
        this.applicationContext = applicationContext;
        this.listener = listener;
    }
        public class MiViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public MiViewHolder(View itemView) {
                super(itemView);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(applicationContext, SegundaActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putInt("enviado", getLayoutPosition());
                        listener.miOnItemClick(getLayoutPosition());
                        intent.putExtras(bundle);
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        applicationContext.startActivity(intent);
                    }
                });
                textView =itemView.findViewById(R.id.textView);
            }
        }
    

    @Override
    public MiAdaptador.MiViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item,
                parent, false);
        return new MiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MiAdaptador.MiViewHolder holder, int position) {
        String texto = datos.get(position).getTexto();
        holder.textView.setText(texto);
    }

    @Override
    public int getItemCount() {
     return datos.size();
    }

}
