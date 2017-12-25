package me.codetalk.fragtransitiontest1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment1 extends Fragment
{
    @BindView(R.id.fragment1_logo)
    ImageView mLogo;

    public Fragment1()
    {
        // Required empty public constructor
    }

    public static Fragment1 newInstance()
    {
        return new Fragment1();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment1, container, false);
        if (v != null)
        {
            ButterKnife.bind(this, v);
        }
        return v;
    }
}
