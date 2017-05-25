package io.github.hermasyp.wisatajateng.Holder;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.hermasyp.wisatajateng.R;

/**
 * Created by herma on 25-May-17.
 */

public class DetailHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.txtNamaTempat) TextView txtNamaTempat;
    @BindView(R.id.txtKetTempat) TextView txtKetTempat;
    @BindView(R.id.imgDetail) ImageView imgDetail;
    @BindView(R.id.cvItemDetail) CardView cvItemDetail;

    public DetailHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
    public void setNamaTempat(String nama){
        txtNamaTempat.setText(nama);
    }

    public void setketTempat(String ket){
        txtKetTempat.setText(ket);
    }

    public ImageView getImgDetail() {
        return imgDetail;
    }

    public CardView getCvItemDetail() {
        return cvItemDetail;
    }
}
