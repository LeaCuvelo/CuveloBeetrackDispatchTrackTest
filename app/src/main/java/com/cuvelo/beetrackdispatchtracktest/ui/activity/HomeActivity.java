package com.cuvelo.beetrackdispatchtracktest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import com.cuvelo.beetrackdispatchtracktest.R;
import com.cuvelo.beetrackdispatchtracktest.databinding.ActivityHomeBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.adapter.MainViewPagerAdapter;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.HomeActivityViewModel;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private HomeActivityViewModel homeActivityViewModel;


    //region Lifecycle Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        homeActivityViewModel = new ViewModelProvider(this).get(HomeActivityViewModel.class);


        View view = binding.getRoot();
        setContentView(view);

        binding.setLifecycleOwner(this);
        setupViewPager();

        homeActivityViewModel.setAddress();
    }

    //endregion Lifecycle Methods

    //region Private Methods

    private void setupViewPager(){
        MainViewPagerAdapter viewPagerAdapter =  new MainViewPagerAdapter(this);
        binding.vpMain.setAdapter(viewPagerAdapter);

        List<String> tabNames = new ArrayList<>();
        tabNames.add(getString(R.string.balance_tab_title));
        tabNames.add(getString(R.string.history_tab_title));

        TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(binding.tlMain, binding.vpMain,
                (tab, position) -> tab.setText(tabNames.get(position)));

        tabLayoutMediator.attach();
    }

    //endregion Private Methods

}