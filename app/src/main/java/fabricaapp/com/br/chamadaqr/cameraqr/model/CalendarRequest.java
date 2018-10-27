package fabricaapp.com.br.chamadaqr.cameraqr.model;

import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CalendarRequest  {

    private Call<Date> call;

    private Date date;

    private String dateString;

    public CalendarRequest(Date date, String dateString) {
        this.date = date;
        this.dateString = dateString;
    }

    public void onStartSync() {
        ServiceApi serviceApi = RetrofitConfig.getService();

        call = serviceApi.getDate(dateString);

        call.enqueue(new Callback<Date>() {
            @Override
            public void onResponse(Call<Date> call, Response<Date> response) {
                if (response.body() != null) {
                    date = response.body();
                }
            }

            @Override
            public void onFailure(Call<Date> call, Throwable t) {

            }
        });

    }


}
