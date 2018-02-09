package com.example.alu.p_78_content_2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MiAdaptador miAdaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayList<Item> datos = leerDatos();
        RecyclerView recView = findViewById(R.id.recyclerView);
        recView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutmanager=new LinearLayoutManager(this,
        LinearLayoutManager.VERTICAL, false);
        recView.setLayoutManager(layoutmanager);
        miAdaptador = new MiAdaptador(datos, new MiAdaptador.MiOnItemClickListener() {
            @Override
            public void miOnItemClick(int posicionItem) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(getResources().getStringArray(R.array.web)[posicionItem]));

            }
        });

        recView.setAdapter(miAdaptador);
    }

    private ArrayList<Item> leerDatos() {
        ArrayList<Item> datos = new ArrayList<>();
            datos.add(new Item("Todos"));
            datos.add(new Item("Primeros"));
            datos.add(new Item("Segundos"));
            datos.add(new Item("Postres"));
        return datos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar layout_item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
