package fabricaapp.com.br.chamadaqr.login.contract;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.RequiresApi;

import fabricaapp.com.br.chamadaqr.basecontract.BaseContract;

public class LoginContract {

    public interface View extends BaseContract.View {

        void showSnackBarError();

    }

    public interface Presenter extends BaseContract.Presenter<View> {

        void openCamera();

        void getPermission(Activity activity);

        @RequiresApi(Build.VERSION_CODES.M)
        void verifyPermissions(int[] grantResults, Activity activity);

        void loginUser();
    }
}
