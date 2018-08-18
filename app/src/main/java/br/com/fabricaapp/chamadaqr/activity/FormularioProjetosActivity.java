package br.com.fabricaapp.chamadaqr.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.Window;

import br.com.fabricaapp.chamadaqr.R;


/**
 * Created by Victor Monfardini on 04/04/2018.
 */

public class FormularioProjetosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_projetos);
    };



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario_projetos, menu);
        return super.onCreateOptionsMenu(menu);
    }


}
