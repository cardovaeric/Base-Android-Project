package net.mavenmobile.baseandroidproject.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;

import com.hwangjr.rxbus.RxBus;

/**
 * Created by Cardova on 9/18/16.
 */
public class BaseActivity extends AppCompatActivity
{
    RxBus bus = new RxBus();

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public RxBus getBus() {
        if (bus == null) {
            bus = new RxBus();
        }

        return bus;
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
