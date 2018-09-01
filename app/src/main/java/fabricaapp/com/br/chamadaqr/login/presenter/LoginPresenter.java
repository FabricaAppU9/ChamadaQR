package fabricaapp.com.br.chamadaqr.login.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.widget.Toast;

import fabricaapp.com.br.chamadaqr.cameraqr.view.CameraQrCodeActivity;
import fabricaapp.com.br.chamadaqr.login.contract.LoginContract;

public class LoginPresenter implements LoginContract.Presenter {

    public LoginContract.View view;
    public static final int MY_CAMERA_REQUEST_CODE = 10;

    @Override
    public void attachView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void openCamera() {
        Intent intent = new Intent(view.getContext(), CameraQrCodeActivity.class);
        view.getContext().startActivity(intent);
    }

    @Override
    public void getPermission(Activity activity) {
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            activity.requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);

        }
    }

    @Override
    public void verifyPermissions(int[] grantResults, Activity activity) {

        if (grantResults.length > 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {
            getPermission(activity);
        }
    }
}
