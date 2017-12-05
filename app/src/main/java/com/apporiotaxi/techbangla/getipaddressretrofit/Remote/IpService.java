package com.apporiotaxi.techbangla.getipaddressretrofit.Remote;

import com.apporiotaxi.techbangla.getipaddressretrofit.model.IP;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by emon on 11/28/2017.
 */

public interface IpService {
    @GET("/")
    Call<IP> getIP();
}
