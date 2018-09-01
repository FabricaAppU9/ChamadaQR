package fabricaapp.com.br.chamadaqr.login.view;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import fabricaapp.com.br.chamadaqr.R;
import fabricaapp.com.br.chamadaqr.login.contract.LoginContract;
import fabricaapp.com.br.chamadaqr.login.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    private EditText userName;
    private EditText userPassword;
    private Button btnLogin;

    private LoginContract.Presenter presenter = new LoginPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();

    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.attachView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void initViews() {
        userName = findViewById(R.id.user_name);
        userPassword = findViewById(R.id.user_passsowrd);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.openCamera(this);
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }
}
