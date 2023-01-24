package com.cuvelo.beetrackdispatchtracktest.ui.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.cuvelo.beetrackdispatchtracktest.ui.fragment.BalanceFragment;
import com.cuvelo.beetrackdispatchtracktest.ui.fragment.HistoryFragment;

import org.jetbrains.annotations.NotNull;

public class MainViewPagerAdapter extends FragmentStateAdapter {

    public String btcAddress;

    public MainViewPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NotNull
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new BalanceFragment(btcAddress);
        }
        return new HistoryFragment(btcAddress);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public String getBtcAddress() {
        return btcAddress;
    }

    public void setBtcAddress(String btcAddress) {
        this.btcAddress = btcAddress;
    }
}
