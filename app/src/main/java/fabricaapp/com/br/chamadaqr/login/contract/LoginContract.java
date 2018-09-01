package fabricaapp.com.br.chamadaqr.login.contract;

import android.content.Context;

import fabricaapp.com.br.chamadaqr.basecontract.BaseContract;

public class LoginContract {

    public interface View extends BaseContract.View {

    }

    public interface Presenter extends BaseContract.Presenter<View> {

        void openCamera(Context context);
    }
}
