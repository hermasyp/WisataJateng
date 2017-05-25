package io.github.hermasyp.wisatajateng.Base;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import io.github.hermasyp.wisatajateng.Utills.ModelTag;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by herma on 23-May-17.
 */

public class BaseActivity extends AppCompatActivity {
    protected Subscription subcriber = new CompositeSubscription();

    protected void bind(int layout){
        setContentView(layout);
        ButterKnife.bind(this);
    }
    protected void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    protected void shareIntent(String message){
        Intent send = new Intent();
        send.setAction(Intent.ACTION_SEND);
        send.putExtra(Intent.EXTRA_TEXT, message);
        send.setType("text/plain");
        startActivity(send);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        subcriber.unsubscribe();
    }
}
