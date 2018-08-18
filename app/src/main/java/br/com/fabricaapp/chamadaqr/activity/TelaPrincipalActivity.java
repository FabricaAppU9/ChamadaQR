package br.com.fabricaapp.chamadaqr.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.fabricaapp.chamadaqr.ClickRecyclerView;
import br.com.fabricaapp.chamadaqr.R;
import br.com.fabricaapp.chamadaqr.domain.Evento;
import br.com.fabricaapp.chamadaqr.adapter.EventoAdapter;

import static java.security.AccessController.getContext;


public class TelaPrincipalActivity extends AppCompatActivity implements ClickRecyclerView {

    private RecyclerView nRecyclerView;
    private RecyclerView.LayoutManager nLayoutManager;
    EventoAdapter adapter;
    private List<Evento> listaEvento = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tela_principal);

        setRecyclerView();
    }

        public void setRecyclerView(){
        nRecyclerView = (RecyclerView) findViewById(R.id.recyclerEventos);
        nLayoutManager = new LinearLayoutManager(this);
        nRecyclerView.setLayoutManager(nLayoutManager);

        adapter = new EventoAdapter(listaEvento, this, this);
        nRecyclerView.setAdapter(adapter);

            for(int i = 0; i < 5; i++){
                Evento evento = new Evento();
                evento.nome = "Projeto: " + i;
                listaEvento.add(evento);
            }
    }

    @Override
    public void onCustomClick(Object object) {

    }
}
