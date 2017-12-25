package me.codetalk.fragtransitiontest1;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.transition.TransitionSet;
import android.view.View;

import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private static final long MOVE_DEFAULT_TIME = 1000;
    private static final long FADE_DEFAULT_TIME = 300;

    private FragmentManager mFragmentManager;

    private Handler mDelayedTxnHandler = new Handler();
    private Runnable mRunnable = () -> {
        performTransition();
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mFragmentManager = getSupportFragmentManager();

        loadInitialFragment();
        mDelayedTxnHandler.postDelayed(mRunnable, 1000);
    }

    private void loadInitialFragment() {
        Fragment initialFragment = Fragment1.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, initialFragment);
        fragmentTransaction.commit();
    }

    private void performTransition() {
        if(isDestroyed()) return;

        Fragment prevFragment = mFragmentManager.findFragmentById(R.id.fragment_container);
        Fragment nextFragment = Fragment2.newInstance();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();

        // 1. exit previous
        Fade exitFade = new Fade();
        exitFade.setDuration(FADE_DEFAULT_TIME);
        prevFragment.setExitTransition(exitFade);

        // 2. Shared elements transition
        TransitionSet enterTransitionSet = new TransitionSet();
        enterTransitionSet.addTransition(TransitionInflater.from(this).inflateTransition(android.R.transition.move));
        enterTransitionSet.setDuration(MOVE_DEFAULT_TIME);
        enterTransitionSet.setStartDelay(FADE_DEFAULT_TIME);
        nextFragment.setSharedElementEnterTransition(enterTransitionSet);

        // 3. Enter transition for new fragment
        Fade enterFade = new Fade();
        enterFade.setStartDelay(MOVE_DEFAULT_TIME + FADE_DEFAULT_TIME);
        enterFade.setDuration(FADE_DEFAULT_TIME);
        nextFragment.setEnterTransition(enterFade);

        View logo = findViewById(R.id.fragment1_logo);
        fragmentTransaction.addSharedElement(logo, logo.getTransitionName());
        fragmentTransaction.replace(R.id.fragment_container, nextFragment);
        fragmentTransaction.commitAllowingStateLoss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelayedTxnHandler.removeCallbacks(mRunnable);
    }
}
