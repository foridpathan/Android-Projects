package firebaze.plenarysof.com.sqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import java.sql.SQLException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DonatDBController donatDBController;
    private InterstitialAd mInterstitialAd;

    private Button btnClickme;

    AdView adView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        insertDonarInfo();
//        getDonarInfo();

        MobileAds.initialize(this, getString(R.string.add_id));

        adView = findViewById(R.id.adView);
        btnClickme = findViewById(R.id.btn_clickme);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice("33BE2250B43518CCDA7DE426D04EE231").build();
        adView.loadAd(adRequest);


        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("adTesting", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("adTesting", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.d("adTesting", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("adTesting", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the user is about to return
                // to the app after tapping on an ad.
                Log.d("adTesting", "onAdClosed");
            }
        });

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstital));

        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        btnClickme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                }
            }
        });

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.d("adIntertitalTesting", "onAdLoaded");
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.d("adIntertitalTesting", "onAdFailedToLoad");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                Log.d("adIntertitalTesting", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.d("adIntertitalTesting", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.d("adIntertitalTesting", "onAdClosed");
            }
        });

    }

    private void insertDonarInfo(){
        DonatDBController donatDBController = new DonatDBController(this);
        try {
            donatDBController.open();
            Donar donar = createDonar();
            donatDBController.insertDonar(donar.getName(), donar.getEmail(), donar.getNumber(), donar.getBlood_group(), donar.getDate());
            donatDBController.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void getDonarInfo(){
        DonatDBController donatDBController = new DonatDBController(this);
        try {
            donatDBController.open();
            ArrayList<Donar> donarArrayList = donatDBController.getAll();
            for(int i=0; i<donarArrayList.size(); i++){
                Log.d("DataTesting", donarArrayList.get(i).getName());
            }
            donatDBController.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private Donar createDonar(){
        Donar donar = new Donar(0, "Name", "email", "09876r","O+", "ddd");
        return donar;
    }
}
