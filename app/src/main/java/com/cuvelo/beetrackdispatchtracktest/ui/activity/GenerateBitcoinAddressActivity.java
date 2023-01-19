package com.cuvelo.beetrackdispatchtracktest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cuvelo.beetrackdispatchtracktest.databinding.ActivityGenerateBitcoinAddressBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.GenerateBitcoinAddressViewModel;
import com.cuvelo.domain.AddressDomain;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class GenerateBitcoinAddressActivity extends AppCompatActivity {

    private static final String TAG = "GenerateBtcAddrssActvty";

    private ActivityGenerateBitcoinAddressBinding binding;
    private GenerateBitcoinAddressViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //TODO fix size of splash icon
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        splashScreen.setKeepOnScreenCondition(() -> false);

        super.onCreate(savedInstanceState);
        binding = ActivityGenerateBitcoinAddressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        viewModel = new ViewModelProvider(this).get(GenerateBitcoinAddressViewModel.class);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        setupObservers();
    }

    private void generateQRBtcAddress(AddressDomain address){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(address.address, BarcodeFormat.QR_CODE, 400, 400);
            binding.ivBtcAddressQr.setImageBitmap(bitmap);
        } catch(Exception e) {
            Log.d(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private void setupObservers() {
        viewModel.addressMutableLiveData.observe(this,this::generateQRBtcAddress);
    }


}