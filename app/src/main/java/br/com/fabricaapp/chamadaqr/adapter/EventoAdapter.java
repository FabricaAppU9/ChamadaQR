package br.com.fabricaapp.chamadaqr.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.fabricaapp.chamadaqr.ClickRecyclerView;
import br.com.fabricaapp.chamadaqr.R;
import br.com.fabricaapp.chamadaqr.activity.TelaCadastroActivity;
import br.com.fabricaapp.chamadaqr.activity.TelaDetalhesEvento;
import br.com.fabricaapp.chamadaqr.domain.Evento;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {
    public static ClickRecyclerView clickRecyclerView;
    //public static EventoClickListener eventoClickListener;
    private List<Evento> eventos;
    private Context context;

    public EventoAdapter(List<Evento> eventos, Context context, ClickRecyclerView clickRecyclerView){
        this.eventos = eventos;
        this.context = context;
        this.clickRecyclerView = clickRecyclerView;

    }

    @Override
    public EventoViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        //EventoViewHolder holder = new EventoViewHolder(view);
        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final EventoViewHolder viewHolder, final int position){
        //EventoViewHolder holder = (EventoViewHolder) viewHolder;
        Evento evento = eventos.get(position);
        viewHolder.nome.setText(evento.getNome());
    }

    @Override
    public int getItemCount(){
        return eventos.size();
    }


    public interface EventoClickListener {
        public void onClickEvento(View view, int position);
    }


    protected class EventoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView nome;
        /*final TextView local;
        final TextView data;
        final TextView detalhes;*/
        ImageView imgEvento;

        public EventoViewHolder(View view){
            super(view);
            context = view.getContext();
            nome = (TextView) view.findViewById(R.id.textview_nome);
            imgEvento = (ImageView) view.findViewById(R.id.imgEvento);
            imgEvento.setImageResource(R.mipmap.ic_launcher);
            view.setClickable(true);
            view.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            final Intent intent;
            intent = new Intent(context, TelaDetalhesEvento.class);
            context.startActivity(intent);
        }
    }
}
