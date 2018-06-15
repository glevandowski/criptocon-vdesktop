package service;

import java.util.List;
import model.Coin;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIRetrofitService {
   public static String BASE_URL = "https://api.coinmarketcap.com/v1/ticker/";

    @GET("?convert=BRL")
    public Call<List<Coin>> getCoin(@Query("limit") int limit);   
}
