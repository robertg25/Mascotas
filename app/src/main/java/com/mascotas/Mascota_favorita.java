package com.mascotas;


import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Mascota_favorita extends AppCompatActivity {

    ArrayList<Mascota> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);


        listaContactos = findViewById(R.id.rvContactos);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);



        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        Mascota_Adapter adaptador = new Mascota_Adapter(contactos, this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {
        contactos = new ArrayList<Mascota>();


        int m11 = 0;
        int m12 = 0;
        int m13 = 0;
        int m14 = 0;
        int m15 = 0;


        for (int i = 0; i < 5; i++) {
            if ((Mascota.count1 > Mascota.count2) && (Mascota.count1 > Mascota.count3) && (Mascota.count1 > Mascota.count4) &&
                    (Mascota.count1 > Mascota.count5)) {
                contactos.add(new Mascota(R.drawable.pet1, "Garfield", Mascota.count1));
                m11 = Mascota.count1;
                Mascota.count1 = 0;
            } else if ((Mascota.count2 > Mascota.count1) && (Mascota.count2 > Mascota.count3) && (Mascota.count2 > Mascota.count4) && (Mascota.count2 > Mascota.count5)) {
                contactos.add(new Mascota(R.drawable.pet2, "Bicho", Mascota.count2));
                m12 = Mascota.count2;
                Mascota.count2 = 0;
            } else if ((Mascota.count3 > Mascota.count1) && (Mascota.count3 > Mascota.count2) && (Mascota.count3 > Mascota.count4) && (Mascota.count3 > Mascota.count5)) {
                contactos.add(new Mascota(R.drawable.pet3, "Félix", Mascota.count3));
                m13 = Mascota.count3;
                Mascota.count3 = 0;
            } else if ((Mascota.count4 > Mascota.count1) && (Mascota.count4 > Mascota.count2) && (Mascota.count4 > Mascota.count3) && (Mascota.count4 > Mascota.count5)) {
                contactos.add(new Mascota(R.drawable.pet4, "Ronaldo", Mascota.count4));
                m14 = Mascota.count4;
                Mascota.count4 = 0;
            } else if ((Mascota.count5 > Mascota.count1) && (Mascota.count5 > Mascota.count2) && (Mascota.count5 > Mascota.count3) && (Mascota.count5 > Mascota.count4)) {
                contactos.add(new Mascota(R.drawable.pet5, "Pulga", Mascota.count5));
                m15 = Mascota.count5;
                Mascota.count5 = 0;
            }
        }
            if (m11 > 0) {
                Mascota.count1 = m11;
            }
            if (m12 > 0) {
                Mascota.count2 = m12;
            }
            if (m13 > 0) {
                Mascota.count3 = m13;
            }
            if (m14 > 0) {
                Mascota.count4 = m14;
            }
            if (m15 >0 )
                Mascota.count5 = m15;
            }



        @Override
        public boolean onKeyDown ( int keyCode, KeyEvent event){
            if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
            }
            return super.onKeyDown(keyCode, event);
        }
    }

