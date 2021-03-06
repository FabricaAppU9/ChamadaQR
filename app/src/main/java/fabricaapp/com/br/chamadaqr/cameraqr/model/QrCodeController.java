package fabricaapp.com.br.chamadaqr.cameraqr.model;

import java.util.List;

import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrCodeController {

    private Call<List<QRCode>> call;

    private List<QRCode> qrCodeList;
    private ResponseCameraListener listener;

    public QrCodeController(ResponseCameraListener listener) {
        this.listener = listener;
    }

    public void onStartSync() {
        ServiceApi serviceApi = RetrofitConfig.getService();

        call = serviceApi.getQRCode();
        call.enqueue(new Callback<List<QRCode>>() {
            @Override
            public void onResponse(Call<List<QRCode>> call, Response<List<QRCode>> response) {
                if (response.body() != null) {
                    qrCodeList = response.body();
                    listener.getQRCode(qrCodeList.get(0));
                }
            }

            @Override
            public void onFailure(Call<List<QRCode>> call, Throwable t) {
            }
        });
    }
}
