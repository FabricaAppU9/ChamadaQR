package br.com.fabricaapp.chamadaqr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.com.fabricaapp.chamadaqr.R;

public class TelaCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tela__cadastro);
    }
}
