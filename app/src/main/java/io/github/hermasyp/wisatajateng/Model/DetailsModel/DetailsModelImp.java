package io.github.hermasyp.wisatajateng.Model.DetailsModel;

import java.util.ArrayList;

import io.github.hermasyp.wisatajateng.Model.DataFotoPariwisata;
import io.github.hermasyp.wisatajateng.Utills.URLs;
import okhttp3.Request;

/**
 * Created by herma on 23-May-17.
 */

public class DetailsModelImp implements DetailModel  {
    public ArrayList<DataFotoPariwisata> DaftarFoto;

    public ArrayList<DataFotoPariwisata> getDaftarFoto() {
        return DaftarFoto;
    }

    @Override
    public Request build(String id) {
        return new Request.Builder()
                .get()
                .url(URLs.getDataFoto(id))
                .build();
    }
}
