package br.com.fabricaapp.chamadaqr.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.Window;
import android.widget.*;
import android.view.View;

import br.com.fabricaapp.chamadaqr.R;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    EditText txt_Login, txt_Senha;
    Button botao_Login, botao_Registrar;
    AlertDialog alertaLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txt_Login = (EditText) findViewById(R.id.txtUsuario);
        txt_Senha = (EditText) findViewById(R.id.txtSenha);

        botao_Login = (Button) findViewById(R.id.btnLogin);
        botao_Login.setOnClickListener(this);

        botao_Registrar = (Button) findViewById(R.id.btnRegistrar);
        botao_Registrar.setOnClickListener(this);
    }

        public void onClick (View view){
            switch (view.getId()) {
                case R.id.btnLogin:
                    String usuario = txt_Login.getText().toString();
                    String senha = txt_Senha.getText().toString();
                    if (usuario.equals("admin") && senha.equals("1234")) {
                    Intent TelaPrincipal = new Intent(MainActivity.this, TelaPrincipalActivity.class);
                    startActivity(TelaPrincipal);
                    } else {
                    AlertDialog.Builder msgErro = new AlertDialog.Builder(this);
                    msgErro.setTitle("Erro");
                    msgErro.setMessage("Usuário ou Senha incorretos\nTente Novamente");
                    alertaLogin = msgErro.create();
                    alertaLogin.show();
                    }
                break;
                case R.id.btnRegistrar:
                    Intent TelaCadastro = new Intent(MainActivity.this, TelaCadastroActivity.class);
                    startActivity(TelaCadastro);
                    break;
            }
        }

    }
