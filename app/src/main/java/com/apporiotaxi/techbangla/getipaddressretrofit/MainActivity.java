package com.apporiotaxi.techbangla.getipaddressretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.apporiotaxi.techbangla.getipaddressretrofit.Remote.IpService;
import com.apporiotaxi.techbangla.getipaddressretrofit.model.IP;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    IpService mService;
    Button btnGetIp;
    TextView txtIp;
    SpotsDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mService=Common.getIpService();
        btnGetIp=(Button)findViewById(R.id.btnGetIP);
        txtIp=(TextView)findViewById(R.id.txtIP);
        dialog=new SpotsDialog(MainActivity.this);

        btnGetIp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                getIpAddress();
            }
        });
    }

    private void getIpAddress() {
        mService.getIP().enqueue(new Callback<IP>() {
            @Override
            public void onResponse(Call<IP> call, Response<IP> response) {
                dialog.dismiss();
                txtIp.setText(response.body().getIp());

            }

            @Override
            public void onFailure(Call<IP> call, Throwable t) {
                Log.e("ERROR",t.getMessage());
                dialog.dismiss();
            }
        });
    }
}
