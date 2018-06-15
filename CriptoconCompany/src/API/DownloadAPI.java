
package API;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import deserializer.CoinDeserializer;
import java.awt.Component;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import model.Coin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.APIRetrofitService;
import util.Progress;

import views.listeners.ApiListener;

public class DownloadAPI{
    public static ApiListener apiListener;
    private static Component context;
    private static Progress progressModel;
    private static JProgressBar progress;
    private static JLabel jlabel;
    private static JButton refresh;
    private static JTextField search;
    
    public DownloadAPI(ApiListener apiListener,Component context,Progress progressModel,JProgressBar progress,JLabel jlabel,JButton buttonRefresh,JTextField search) {
        DownloadAPI.apiListener = apiListener;
        DownloadAPI.context = context;
        DownloadAPI.progress= progress;
        DownloadAPI.jlabel = jlabel;
        DownloadAPI.progressModel = progressModel;
        DownloadAPI.refresh = buttonRefresh;
        DownloadAPI.search = search;
    }

    public static void progressAux(JProgressBar progress,JLabel jlabel, int i){
        if(progressModel != null){
          progressModel.isProgress(progress,jlabel,i);  
        }
    }
    public static boolean actionButtonsAux(boolean FLAG){
        if(search != null&& refresh != null){
            if(FLAG==false){
            search.setEnabled(false);
            refresh.setEnabled(false);
            return FLAG;
            }else{
           search.setEnabled(true);
            refresh.setEnabled(true);
            return FLAG;
        }}
        return FLAG;
    }
    
    public static void addCoinDownload() {
        actionButtonsAux(false);
        progressAux(progress, jlabel, 10);
        Gson g = new GsonBuilder().registerTypeAdapter(Coin.class, new CoinDeserializer()).create();

        Retrofit retro = new Retrofit.Builder().baseUrl(APIRetrofitService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(g)).build();

        APIRetrofitService service = retro.create(APIRetrofitService.class);

        Call<List<Coin>> callCoin = service.getCoin(0);
        callCoin.enqueue(new Callback<List<Coin>>() {
            @Override
            public void onResponse(Call<List<Coin>> call, Response<List<Coin>> rspns) { 
              if(!rspns.isSuccessful()){
                progressAux(progress, jlabel, 0);
                JOptionPane.showMessageDialog( context.getParent(), "Falha de conexão ao servidor!");
              }else{
                  actionButtonsAux(true);
                  List<Coin> coinAux = rspns.body();
                  apiListener.addCoin(coinAux);
                 
              }
            }

            @Override
            public void onFailure(Call<List<Coin>> call, Throwable thrwbl) {
                call.cancel();
                  progressAux(progress, jlabel, 0);
              JOptionPane.showMessageDialog(context.getParent(), "Ops..Erro de comunicação, verifique sua conexão à internet");
            }      
      });
    }
   
}