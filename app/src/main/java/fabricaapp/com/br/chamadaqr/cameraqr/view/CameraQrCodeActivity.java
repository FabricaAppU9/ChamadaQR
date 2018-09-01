package fabricaapp.com.br.chamadaqr.cameraqr.view;

import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class CameraQrCodeActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
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
        Toast.makeText(this, result.getText(), Toast.LENGTH_SHORT).show();
        finish();
    }
}
