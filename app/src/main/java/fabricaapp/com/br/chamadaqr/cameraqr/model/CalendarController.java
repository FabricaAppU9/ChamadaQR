package fabricaapp.com.br.chamadaqr.cameraqr.model;

import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarController {

    private Call<Date> call;

    private String dateString;

    ResponseCameraListener listener;

    public CalendarController(ResponseCameraListener listener, String dateString) {
        this.dateString = dateString;
        this.listener = listener;
    }

    public void onStartSync() {
        ServiceApi serviceApi = RetrofitConfig.getService();

        call = serviceApi.getDate(dateString);

        call.enqueue(new Callback<Date>() {
            @Override
            public void onResponse(Call<Date> call, Response<Date> response) {

                Date date = response.body();
                listener.getDate(date);
            }

            @Override
            public void onFailure(Call<Date> call, Throwable t) {

            }
        });

    }


}
