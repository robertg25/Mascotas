package com.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        miActionBar.setLogo(R.drawable.pata);

        listaContactos = findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itmRaking:
                //Toast.makeText(this, "Item 1 selected", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Mascota_favorita.class);
                this.startActivity(intent);
                return true;
            case R.id.itmCerrar:
                //Toast.makeText(this, "Item 2 selected", Toast.LENGTH_SHORT).show();
                finish();
                System.exit(0);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    public void inicializarAdaptador() {
        Mascota_Adapter adaptador = new Mascota_Adapter(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        contactos = new ArrayList<Mascota>();

        contactos.add(new Mascota(R.drawable.pet1, "Garfield", Mascota.count1));
        contactos.add(new Mascota(R.drawable.pet2, "Bicho", Mascota.count2));
        contactos.add(new Mascota(R.drawable.pet3, "Félix", Mascota.count3));
        contactos.add(new Mascota(R.drawable.pet4, "Ronaldo", Mascota.count4));
        contactos.add(new Mascota(R.drawable.pet5, "Pulga", Mascota.count5));

    }
}