package fabricaapp.com.br.chamadaqr.login.model;



import fabricaapp.com.br.chamadaqr.api.BaseSync;
import fabricaapp.com.br.chamadaqr.api.RetrofitConfig;
import fabricaapp.com.br.chamadaqr.api.ServiceApi;
import fabricaapp.com.br.chamadaqr.api.SyncInterface;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRequest extends BaseSync {

    private Call<User> call;

    private SyncInterface syncInterface;

    private String matricula;

    private User user;

    public UserRequest(SyncInterface syncInterface, String matricula, User user) {
        this.syncInterface = syncInterface;
        this.matricula = matricula;
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

        call = serviceApi.loginUser(matricula);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.body() != null) {
                    user = response.body();
                    onSuccessSync();
                } else {
                    onFailureSync();
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                onFailureSync();
            }
        });

    }


}
