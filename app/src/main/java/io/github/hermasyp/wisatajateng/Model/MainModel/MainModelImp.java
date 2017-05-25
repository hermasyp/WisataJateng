package io.github.hermasyp.wisatajateng.Model.MainModel;

import java.util.ArrayList;

import io.github.hermasyp.wisatajateng.Model.DataPariwisata;
import io.github.hermasyp.wisatajateng.Utills.URLs;
import okhttp3.Request;

/**
 * Created by herma on 23-May-17.
 */

public class MainModelImp implements MainModel {
    public ArrayList<DataPariwisata> DataPariwisata;

    public ArrayList<DataPariwisata> getDataPariwisatas() {
        return DataPariwisata;
    }


    @Override
    public Request build() {
        return new Request.Builder()
                .get()
                .url(URLs.getDataPariwisata())
                .build();
    }
}
