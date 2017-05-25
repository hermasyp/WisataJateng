package io.github.hermasyp.wisatajateng.View.DetailsActivity;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;

import butterknife.BindView;
import io.github.hermasyp.wisatajateng.Adapter.ListAdapter;
import io.github.hermasyp.wisatajateng.Base.BaseActivity;
import io.github.hermasyp.wisatajateng.Holder.DetailHolder;
import io.github.hermasyp.wisatajateng.Model.DataFotoPariwisata;
import io.github.hermasyp.wisatajateng.Model.DetailsModel.DetailsModelImp;
import io.github.hermasyp.wisatajateng.Presenter.DetailsPresenter.DetailsPresenter;
import io.github.hermasyp.wisatajateng.Presenter.DetailsPresenter.DetailsPresenterImp;
import io.github.hermasyp.wisatajateng.Presenter.MainPresenter.MainPresenterImp;
import io.github.hermasyp.wisatajateng.R;
import io.github.hermasyp.wisatajateng.Utills.ModelTag;
import io.github.hermasyp.wisatajateng.View.MainActivity.MainActivity;
import io.github.hermasyp.wisatajateng.View.MainActivity.MainActivityView;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class DetailsActivity extends BaseActivity implements DetailsActivityView {


    @BindView(R.id.fabshare) FloatingActionButton fabshare;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.txtTempat) TextView txtTempat;
    @BindView(R.id.txtLoc) TextView txtLoc;
    @BindView(R.id.txtDesc) TextView txtDesc;
    @BindView(R.id.rvDetail)
    RecyclerView rvDetail;
    ListAdapter adapter;
    private final String TAG = "DETAILS ACTIVITY";
    private DetailsPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_details);
        setSupportActionBar(toolbar);
        presenter = new DetailsPresenterImp(this);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        txtTempat.setText(getIntent().getStringExtra(ModelTag.TAG_NAMA));
        txtLoc.setText(getIntent().getStringExtra(ModelTag.TAG_ALAMAT));
        txtDesc.setText(getIntent().getStringExtra(ModelTag.TAG_DESKRIPSI));
        fabshare.setOnClickListener(v -> {
            shareIntent("Tempat Wisata : "+getIntent().getStringExtra(ModelTag.TAG_NAMA)+"\n" +
                    "Lokasi : "+getIntent().getStringExtra(ModelTag.TAG_ALAMAT)+"\n" +
                    "Deskripsi : " +getIntent().getStringExtra(ModelTag.TAG_DESKRIPSI));
        });
        subcriber = presenter.getResult(getIntent().getStringExtra(ModelTag.TAG_ID_PARIWISATA))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess,this::onError);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onSuccess(DetailsModelImp result) {
        Log.d(TAG, "onSuccess: "+result.getDaftarFoto().size());
        rvDetail.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapter = new ListAdapter<DataFotoPariwisata, DetailHolder>(R.layout.item_detail, DetailHolder.class, DataFotoPariwisata.class, result.getDaftarFoto()) {
            @Override
            protected void bindView(DetailHolder holder, DataFotoPariwisata model, int position) {
                holder.setketTempat(model.getImg_keterangan());
                holder.setNamaTempat(model.getImg_title());
                Glide.with(DetailsActivity.this)
                        .load(model.getImg_path())
                        .into(holder.getImgDetail());
            }
        };
        rvDetail.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable err) {

    }
}
