package fabricaapp.com.br.chamadaqr.cameraqr.model;


import org.json.JSONException;
import org.json.JSONObject;

import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FrequencyController  {

    private Call<ResponseBody> call;

    private Frequency frequency;

    ResponseCameraListener listener;


    public FrequencyController(Frequency frequency, ResponseCameraListener listener) {
        this.frequency = frequency;
        this.listener = listener;
    }

    public void onStartSync() {
        ServiceApi serviceApi = RetrofitConfig.getService();

        String json = getJson();

        RequestBody request = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);

        call = serviceApi.frequency(request);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                listener.isFrequencySuccess(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                listener.isFrequencySuccess(false);
            }
        });
    }

    private String getJson() {

        JSONObject frequencyJson = new JSONObject();

        try {
            frequencyJson.put("alunoID", frequency.getStudentId());
            frequencyJson.put("dataID", frequency.getDateId());
            frequencyJson.put("presenca", frequency.getFrequency());
            frequencyJson.put("justificativa", JSONObject.NULL);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return frequencyJson.toString();
    }

}
