package com.apporiotaxi.techbangla.getipaddressretrofit;

import com.apporiotaxi.techbangla.getipaddressretrofit.Remote.IpService;
import com.apporiotaxi.techbangla.getipaddressretrofit.Remote.RetrofitClient;

/**
 * Created by emon on 11/29/2017.
 */

public class Common {
    private static final String BASE_URL="http://ip.jsontest.com/";

    public static IpService getIpService(){
        return RetrofitClient.getClient(BASE_URL).create(IpService.class);
    }
}
