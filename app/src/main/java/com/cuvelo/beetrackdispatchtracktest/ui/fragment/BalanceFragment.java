package com.cuvelo.beetrackdispatchtracktest.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuvelo.beetrackdispatchtracktest.R;
import com.cuvelo.beetrackdispatchtracktest.databinding.ActivityHomeBinding;
import com.cuvelo.beetrackdispatchtracktest.databinding.FragmentBalanceBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.BalanceFragmentViewModel;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.HomeActivityViewModel;

import org.jetbrains.annotations.NotNull;


public class BalanceFragment extends Fragment {


    private FragmentBalanceBinding binding;
    private HomeActivityViewModel homeActivityViewModel;
    private BalanceFragmentViewModel balanceFragmentViewModel;

    public BalanceFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_balance,
                container,
                false);

        binding.setLifecycleOwner(getViewLifecycleOwner());




        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        homeActivityViewModel = new ViewModelProvider(this).get(HomeActivityViewModel.class);
        balanceFragmentViewModel = new ViewModelProvider(this).get(BalanceFragmentViewModel.class);

    }
}

