package io.github.hermasyp.wisatajateng.View.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import butterknife.BindView;
import io.github.hermasyp.wisatajateng.Adapter.ListAdapter;
import io.github.hermasyp.wisatajateng.Base.BaseActivity;
import io.github.hermasyp.wisatajateng.Holder.MainHolder;
import io.github.hermasyp.wisatajateng.Model.DataPariwisata;
import io.github.hermasyp.wisatajateng.Model.MainModel.MainModelImp;
import io.github.hermasyp.wisatajateng.Presenter.MainPresenter.MainPresenter;
import io.github.hermasyp.wisatajateng.Presenter.MainPresenter.MainPresenterImp;
import io.github.hermasyp.wisatajateng.R;
import io.github.hermasyp.wisatajateng.Utills.ModelTag;
import io.github.hermasyp.wisatajateng.View.DetailsActivity.DetailsActivity;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainActivityView {
    @BindView(R.id.rvItem) RecyclerView rvItem;
    ListAdapter adapter;

    private final String TAG = "MAIN ACTIVITY";
    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bind(R.layout.activity_main);
        mainPresenter = new MainPresenterImp(this);
        subcriber = mainPresenter.getResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onSuccess,this::onError);

    }

    @Override
    public void onSuccess(MainModelImp result) {
        Log.d(TAG, "onSuccess: "+result.getDataPariwisatas().size());
        rvItem.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ListAdapter<DataPariwisata,MainHolder>(R.layout.item_pariwisata,MainHolder.class,DataPariwisata.class,result.getDataPariwisatas()) {
            @Override
            protected void bindView(MainHolder holder, DataPariwisata model, int position) {
                holder.setTextAlamat(model.getAlamat());
                holder.setTextNama(model.getNama_tempat());
                Glide.with(MainActivity.this)
                        .load(model.getImg_header())
                        .into(holder.getImgHeader());
                holder.getLayoutItem().setOnClickListener(v -> {
                    Intent i = new Intent(MainActivity.this, DetailsActivity.class);
                    i.putExtra(ModelTag.TAG_ID_PARIWISATA,model.getId_pariwisata());
                    i.putExtra(ModelTag.TAG_NAMA,model.getNama_tempat());
                    i.putExtra(ModelTag.TAG_ALAMAT,model.getAlamat());
                    i.putExtra(ModelTag.TAG_DESKRIPSI,model.getDeskripsi());
                    i.putExtra(ModelTag.TAG_LOGNITUDE,model.getLongitude());
                    i.putExtra(ModelTag.TAG_LATITUDE,model.getLatitude());
                    startActivity(i);

                });
            }
        };
        rvItem.setAdapter(adapter);
    }

    @Override
    public void onError(Throwable err) {
        showToast(String.valueOf(err));
        Log.d(TAG, "onError: " + err);
    }
}
