package com.cuvelo.beetrackdispatchtracktest.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuvelo.beetrackdispatchtracktest.R;
import com.cuvelo.beetrackdispatchtracktest.databinding.FragmentBalanceBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.BalanceFragmentViewModel;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.HomeActivityViewModel;
import com.cuvelo.domain.AddressDomain;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.jetbrains.annotations.NotNull;

import dagger.hilt.android.AndroidEntryPoint;


@AndroidEntryPoint
public class BalanceFragment extends Fragment {

    private static final String TAG = "BalanceFragment";


    private FragmentBalanceBinding binding;
    private HomeActivityViewModel homeActivityViewModel;
    private BalanceFragmentViewModel balanceFragmentViewModel;
    private final String btcAddress;

    public BalanceFragment(String btcAddress) {
        this.btcAddress = btcAddress;
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

        binding.setBalanceViewModel(balanceFragmentViewModel);
        binding.setHomeActivityViewModel(homeActivityViewModel);

        setupObservers();
    }

    @Override
    public void onResume() {
        super.onResume();
       balanceFragmentViewModel.getBitcoinWalletBalance(btcAddress);
    }

    private void setupObservers() {
        balanceFragmentViewModel.addressMutableLiveData.observe(getViewLifecycleOwner(),this::generateQRBtcAddress);
    }

    private void generateQRBtcAddress(String address){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(address, BarcodeFormat.QR_CODE, 400, 400);
            binding.ivBtcAddressQr.setImageBitmap(bitmap);
        } catch(Exception e) {
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }
}