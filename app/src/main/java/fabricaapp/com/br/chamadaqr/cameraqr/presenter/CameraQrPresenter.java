package fabricaapp.com.br.chamadaqr.cameraqr.presenter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import java.text.SimpleDateFormat;

import fabricaapp.com.br.chamadaqr.R;
import fabricaapp.com.br.chamadaqr.Utils;
import fabricaapp.com.br.chamadaqr.cameraqr.contract.CameraQrContract;
import fabricaapp.com.br.chamadaqr.cameraqr.model.CalendarController;
import fabricaapp.com.br.chamadaqr.cameraqr.model.Date;
import fabricaapp.com.br.chamadaqr.cameraqr.model.Frequency;
import fabricaapp.com.br.chamadaqr.cameraqr.model.FrequencyController;
import fabricaapp.com.br.chamadaqr.cameraqr.model.QRCode;
import fabricaapp.com.br.chamadaqr.cameraqr.model.QrCodeController;
import fabricaapp.com.br.chamadaqr.cameraqr.model.ResponseCameraListener;

public class CameraQrPresenter implements CameraQrContract.Presenter, ResponseCameraListener {

    private CameraQrContract.View view;

    private CalendarController calendarController;

    private QrCodeController qrCodeController;

    private FrequencyController frequencyController;

    private String dateString;

    private Date date;

    private QRCode qrCode;

    private String result;

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
        java.util.Date today = new java.util.Date();
        dateString = new SimpleDateFormat("dd-MM-yyyy").format(today);

        calendarController = new CalendarController(this, dateString);
        calendarController.onStartSync();
    }

    @Override
    public void getQRCodeRequest(){
        qrCodeController = new QrCodeController(this);
        qrCodeController.onStartSync();
    }

    @Override
    public void getQRCode(QRCode qrCode) {
        this.qrCode = qrCode;
        if (result.equals(qrCode.getValidacao())) {
            sendFrequency();
        } else {
            view.closeActivity();
            Toast.makeText(view.getContext(), view.getContext().getString(R.string.invalid_qrcode), Toast.LENGTH_SHORT ).show();
        }
    }

    @Override
    public void getDate(Date date) {
        this.date = date;
    }

    @Override
    public void isFrequencySuccess(Boolean isSuccess) {

        Context context = view.getContext();
        if (isSuccess) {
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.
                    setTitle(context.getString(R.string.alert))
                    .setMessage(context.getString(R.string.message_ok))
                    .setCancelable(false)
                    .setPositiveButton(context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            view.closeApp();
                        }
                    });
            builder.show();
        } else {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_LONG).show();
            view.closeActivity();
        }
    }

    @Override
    public void validQRCode(String result) {
        this.result = result;
        getQRCodeRequest();
    }


    private void sendFrequency() {

        Frequency frequency = new Frequency();
        if (date != null)
            frequency.setDateId(String.valueOf(date.getDataId()));
        frequency.setStudentId(Utils.STUDENT_ID);
        frequency.setFrequency("S");

        frequencyController = new FrequencyController(frequency,this);
        frequencyController.onStartSync();
    }
}
