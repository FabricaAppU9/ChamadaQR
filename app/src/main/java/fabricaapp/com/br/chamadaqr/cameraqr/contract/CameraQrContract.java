package fabricaapp.com.br.chamadaqr.cameraqr.contract;

import fabricaapp.com.br.chamadaqr.basecontract.BaseContract;

public class CameraQrContract {

    public interface View extends BaseContract.View {

    }

    public interface Presenter extends BaseContract.Presenter<View> {

        void getDate();

        void getQRCode();
    }
}
