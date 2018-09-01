package fabricaapp.com.br.chamadaqr.login.presenter;

import android.content.Context;
import android.content.Intent;

import fabricaapp.com.br.chamadaqr.cameraqr.view.CameraQrCodeActivity;
import fabricaapp.com.br.chamadaqr.login.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter {

    LoginContract.View view;

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void openCamera(Context context) {
        Intent intent = new Intent(context, CameraQrCodeActivity.class);
        context.startActivity(intent);
    }
}
