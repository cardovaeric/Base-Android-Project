package net.mavenmobile.baseandroidproject.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.hwangjr.rxbus.RxBus;

import net.mavenmobile.baseandroidproject.activity.BaseActivity;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Cardova on 9/18/16.
 */
public class BaseFragment extends Fragment {

    CompositeSubscription subscriptions;
    RxBus bus;


    public RxBus getBus() {
        return bus;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bus = ((BaseActivity) getActivity()).getBus();
    }
    @Override
    public void onStart() {
        super.onStart();
        subscriptions = new CompositeSubscription();

    }
    @Override
    public void onStop() {
        super.onStop();
        subscriptions.clear();
    }
}
