package br.com.fabricaapp.chamadaqr.domain;


public class Evento {
    private int idEvento;
    public String nome;


    /*public Evento(String nome, String local, String data, String detalhes) {
        this.nome = nome;
        this.local = local;
        this.data = data;
        this.detalhes = detalhes;
    }*/

    public String getNome() {
        return nome;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }
}
