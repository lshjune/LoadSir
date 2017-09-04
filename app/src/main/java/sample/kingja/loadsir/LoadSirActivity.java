package sample.kingja.loadsir;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kingja.loadsir.LoadSir;
import com.kingja.loadsir.callback.DefaultCallback;
import com.kingja.loadsir.callback.LoadCallback;


/**
 * Created by Administrator on 2017/9/3.
 */

public class LoadSirActivity extends AppCompatActivity {

    private LoadSir loadSir;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loadser);
        loadSir = LoadSir.callLoadSir(this, new LoadCallback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                showEmpty();
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loadSir.showLoadCallback(CustomCallback.CUSTOM_CALLBACK);
            }
        }, 2000);
    }

    private void showSuccess() {
        loadSir.showLoadCallback(DefaultCallback.CONTENT_CALLBACK);
    }

    private void showError() {
        loadSir.showLoadCallback(DefaultCallback.ERROR_CALLBACK);
    }

    private void showEmpty() {
        loadSir.showLoadCallback(DefaultCallback.EMPTY_CALLBACK);
    }
}
