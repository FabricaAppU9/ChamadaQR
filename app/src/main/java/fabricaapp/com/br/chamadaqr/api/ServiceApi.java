package fabricaapp.com.br.chamadaqr.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ServiceApi {
    @GET("aluno")
    Call<ResponseBody> getUsers();

    @GET("frequencia")
    Call<ResponseBody> frequency();
}