package me.codetalk.designsupporttest.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import me.codetalk.designsupporttest.R;
import me.codetalk.designsupporttest.fragment.PostFragment;
import me.codetalk.designsupporttest.fragment.TutorialFragment;
import me.codetalk.designsupporttest.fragment.UserInfoFragment;

/**
 * Created by Administrator on 2017/12/18.
 */

public class SimpleFragmentPagerAdapter extends FragmentPagerAdapter {

    private Context mContext;

    public SimpleFragmentPagerAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {
            return new UserInfoFragment();
        } else if(position == 1) {
            return new PostFragment();
        } else if(position == 2) {
            return new TutorialFragment();
        }

        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.tab_title_userinfo);
            case 1:
                return mContext.getString(R.string.tab_title_post);
            case 2:
                return mContext.getString(R.string.tab_title_tutorial);
            default:
                return null;
        }
    }
}
