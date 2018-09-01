package fabricaapp.com.br.chamadaqr.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("url")
    Call<ResponseBody> getUsers();
}
