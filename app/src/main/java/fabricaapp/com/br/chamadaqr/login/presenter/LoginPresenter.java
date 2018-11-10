package fabricaapp.com.br.chamadaqr.login.presenter;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.content.ContextCompat;

import fabricaapp.com.br.chamadaqr.api.SyncInterface;
import fabricaapp.com.br.chamadaqr.cameraqr.view.CameraQrCodeActivity;
import fabricaapp.com.br.chamadaqr.login.contract.LoginContract;
import fabricaapp.com.br.chamadaqr.login.model.UserRequest;

public class LoginPresenter implements LoginContract.Presenter, SyncInterface {

    public LoginContract.View view;
    public static final int MY_CAMERA_REQUEST_CODE = 10;

    private UserRequest request;

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
                != PackageManager.PERMISSION_GRANTED
                && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

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

    @Override
    public void loginUser(String matricula) {

        view.hideKeyboard();
        request = new UserRequest(this, matricula);
        request.onStartSync();

    }

    @Override
    public void onSuccessSync() {
        view.hideProgressBar();
        openCamera();
    }

    @Override
    public void onFailureSync() {
        view.hideProgressBar();
        view.showSnackBarError();
    }
}
