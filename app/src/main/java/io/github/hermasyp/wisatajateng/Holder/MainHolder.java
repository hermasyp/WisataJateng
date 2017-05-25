package io.github.hermasyp.wisatajateng.Holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.hermasyp.wisatajateng.R;

/**
 * Created by herma on 25-May-17.
 */

public class MainHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtAlamat) TextView txtAlamat;
    @BindView(R.id.txtNamaTempat) TextView txtNamaTempat;
    @BindView(R.id.imgHeader) ImageView imgHeader;
    @BindView(R.id.cvItem) CardView cvItem;

    public MainHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void setTextAlamat(String alamat){
        txtAlamat.setText(alamat);
    }
    public void setTextNama(String nama){
        txtNamaTempat.setText(nama);
    }
    public ImageView getImgHeader(){
        return imgHeader;
    }
    public CardView getLayoutItem(){
        return cvItem;
    }
}
