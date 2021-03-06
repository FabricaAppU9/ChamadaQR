package fabricaapp.com.br.chamadaqr.login.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import fabricaapp.com.br.chamadaqr.R;
import fabricaapp.com.br.chamadaqr.login.contract.LoginContract;
import fabricaapp.com.br.chamadaqr.login.presenter.LoginPresenter;

import static fabricaapp.com.br.chamadaqr.login.presenter.LoginPresenter.MY_CAMERA_REQUEST_CODE;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginContract.View {

    private EditText userName;
    private Button btnLogin;
    private ProgressBar progressBar;

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

        presenter.getPermission(LoginActivity.this);

        userName = findViewById(R.id.user_name);
        btnLogin = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progressBar);

        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                presenter.loginUser(userName.getText().toString());
                progressBar.setVisibility(View.VISIBLE);
                break;
        }
    }

    @Override
    public Context getContext() {
        return this;
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == MY_CAMERA_REQUEST_CODE && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            presenter.verifyPermissions(grantResults, LoginActivity.this);
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    @Override
    public void showSnackBarError() {
        Snackbar.make(btnLogin, getContext().getString(R.string.unauthorized_user), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideKeyboard(){
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        if (inputManager != null && getCurrentFocus() != null) {

            inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
