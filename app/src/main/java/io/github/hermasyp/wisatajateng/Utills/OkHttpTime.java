package io.github.hermasyp.wisatajateng.Utills;

/**
 * Created by herma on 23-May-17.
 */
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by herma on 14-May-17.
 */

public class OkHttpTime {
    public static OkHttpClient client = new OkHttpClient.Builder()
            .connectTimeout(10000L, TimeUnit.MILLISECONDS)
            .readTimeout(10000L, TimeUnit.MILLISECONDS)
            .build();
}
