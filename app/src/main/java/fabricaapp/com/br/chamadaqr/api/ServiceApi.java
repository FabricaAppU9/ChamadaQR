package fabricaapp.com.br.chamadaqr.api;

import java.util.List;

import fabricaapp.com.br.chamadaqr.cameraqr.model.Date;
import fabricaapp.com.br.chamadaqr.cameraqr.model.QRCode;
import fabricaapp.com.br.chamadaqr.login.model.User;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServiceApi {
    @GET("aluno/{matricula}")
    Call<User> loginUser(@Path("matricula") String matricula);

    @GET("frequencia")
    Call<ResponseBody> frequency();

    @GET("calendario/{date")
    Call<Date> getDate(@Path("date") String date);

    @GET("qrcode")
    Call<List<QRCode>> getQRCode();
}