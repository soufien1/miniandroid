package tp.uvt.myapplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;

public interface CitoyenAPIInterface {

    @GET("citoyens/1")
    Call<Citoyen> getCitoyenbyId();

    @PUT("citoyens/1")
    Call<Citoyen> update(@Body Citoyen citoyen);
}
