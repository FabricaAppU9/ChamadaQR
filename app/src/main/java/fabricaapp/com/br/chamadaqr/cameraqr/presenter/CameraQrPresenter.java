package fabricaapp.com.br.chamadaqr.cameraqr.presenter;

import fabricaapp.com.br.chamadaqr.api.SyncInterface;
import fabricaapp.com.br.chamadaqr.cameraqr.contract.CameraQrContract;
import fabricaapp.com.br.chamadaqr.cameraqr.model.CalendarRequest;
import fabricaapp.com.br.chamadaqr.cameraqr.model.Date;
import fabricaapp.com.br.chamadaqr.cameraqr.model.QRCode;
import fabricaapp.com.br.chamadaqr.cameraqr.model.QrCodeRequest;

public class CameraQrPresenter implements CameraQrContract.Presenter, SyncInterface {

    private CameraQrContract.View view;

    private CalendarRequest calendarRequest;

    private QrCodeRequest qrCodeRequest;

    private String dateString;

    private Date date;

    private QRCode qrCode;

    @Override
    public void attachView(CameraQrContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void getDate() {
        calendarRequest = new CalendarRequest(date, dateString);
        calendarRequest.onStartSync();
    }

    @Override
    public void getQRCode(){
        qrCodeRequest = new QrCodeRequest(qrCode);
    }

    @Override
    public void onSuccessSync() {

    }

    @Override
    public void onFailureSync() {

    }
}
