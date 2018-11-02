package fabricaapp.com.br.chamadaqr.cameraqr.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;

import fabricaapp.com.br.chamadaqr.cameraqr.contract.CameraQrContract;
import fabricaapp.com.br.chamadaqr.cameraqr.presenter.CameraQrPresenter;
import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraQrCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler,
        CameraQrContract.View {

    private ZXingScannerView scannerView;

    private CameraQrContract.Presenter presenter = new CameraQrPresenter();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
        presenter.attachView(this);
        presenter.getDate();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    private void initViews() {

        scannerView = new ZXingScannerView(this);
        setContentView(scannerView);
        scannerView.setAutoFocus(true);
        scannerView.setResultHandler(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        scannerView.startCamera();

    }

    @Override
    public void handleResult(Result result) {
        presenter.validQRCode(result.getText());

    }
    @Override
    public Context getContext() {
        return this;
    }
}
