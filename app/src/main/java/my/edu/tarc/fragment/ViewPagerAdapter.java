package my.edu.tarc.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Eric Yam on 7/31/2016.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    CharSequence Titles[];
    int NumofTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence mTitles[], int mNumofTabsumb) {
        super(fm);
        this.Titles = mTitles;
        this.NumofTabs = mNumofTabsumb;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            Tab1 tab1 = new Tab1();
            return tab1;
        }else if (position == 1){
            Tab2 tab2 = new Tab2();
            return tab2;
        }else{
            Tab3 tab3 = new Tab3();
            return tab3;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles[position];
    }

    @Override
    public int getCount() {
        return NumofTabs;
    }
}
