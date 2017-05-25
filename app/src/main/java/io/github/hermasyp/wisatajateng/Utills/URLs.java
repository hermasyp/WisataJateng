package io.github.hermasyp.wisatajateng.Utills;

import io.github.hermasyp.wisatajateng.BuildConfig;

/**
 * Created by herma on 24-May-17.
 */

public class URLs {
    private static final String BASE_URL = BuildConfig.URI;
    private static final String DataPariwisata = "/api/DaftarPariwisata";
    private static final String DataFoto = "/api/DaftarFoto/";

    public static String getDataPariwisata() {
        return BASE_URL+DataPariwisata;
    }
    public static String getDataFoto(String id){
        return BASE_URL+DataFoto+id;
    }

}
