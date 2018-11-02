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
            builder.setMessage(context.getString(R.string.alert))
                    .setCancelable(false)
                    .setPositiveButton(context.getString(android.R.string.ok), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
        } else {
            Toast.makeText(context, context.getString(R.string.error), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void validQRCode(String result) {
        this.result = result;
        getQRCodeRequest();
    }


    private void sendFrequency() {

        Frequency frequency = new Frequency();
        frequency.setDateId(String.valueOf(date.getDataId()));
        frequency.setStudentId(Utils.STUDENT_ID);
        frequency.setJustification("");

        frequencyController = new FrequencyController(frequency,this);
        frequencyController.onStartSync();
    }
}
