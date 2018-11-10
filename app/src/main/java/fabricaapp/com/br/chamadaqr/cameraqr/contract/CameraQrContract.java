package fabricaapp.com.br.chamadaqr.cameraqr.contract;

import fabricaapp.com.br.chamadaqr.basecontract.BaseContract;

public class CameraQrContract {

    public interface View extends BaseContract.View {
        void closeActivity();

        void closeApp();
    }

    public interface Presenter extends BaseContract.Presenter<View> {

        void getDate();

        void getQRCodeRequest();

        void validQRCode(String result);
    }
}
