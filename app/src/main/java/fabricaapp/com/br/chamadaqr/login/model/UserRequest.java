package fabricaapp.com.br.chamadaqr.login.model;


import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import fabricaapp.com.br.chamadaqr.api.SyncInterface;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRequest implements SyncInterface {

    private Call<ResponseBody> call;

    private SyncInterface syncInterface;

    private User user;

    public UserRequest(SyncInterface syncInterface, User user) {
        this.syncInterface = syncInterface;
        this.user = user;
    }

    @Override
    public void onSuccessSync() {

        syncInterface.onSuccessSync();
    }

    @Override
    public void onFailureSync() {
        syncInterface.onFailureSync();
    }

    @Override
    public void onStartSync() {
        ServiceApi serviceApi = RetrofitConfig.getService();

        call = serviceApi.getUsers();
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                onSuccessSync();
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                onFailureSync();
            }
        });

    }


}
