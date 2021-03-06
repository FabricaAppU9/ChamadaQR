package fabricaapp.com.br.chamadaqr.login.contract;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;

import fabricaapp.com.br.chamadaqr.basecontract.BaseContract;

public class LoginContract {

    public interface View extends BaseContract.View {

        void showSnackBarError();

        void hideProgressBar();

        void hideKeyboard();
    }

    public interface Presenter extends BaseContract.Presenter<View> {

        void openCamera();

        void getPermission(Activity activity);

        void verifyPermissions(int[] grantResults, Activity activity);

        void loginUser(String matricula);
    }
}
