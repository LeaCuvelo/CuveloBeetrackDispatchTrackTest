package com.cuvelo.beetrackdispatchtracktest.ui.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.splashscreen.SplashScreen;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.cuvelo.beetrackdispatchtracktest.R;
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

    //region LifeCycle Methods

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        splashScreen.setKeepOnScreenCondition(() -> false);

        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(GenerateBitcoinAddressViewModel.class);
        String btcAddress = viewModel.isBtcAddressStored();
        if(!btcAddress.isEmpty()){
            navigateToHome();
        }

        binding = ActivityGenerateBitcoinAddressBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.setLifecycleOwner(this);
        binding.setViewModel(viewModel);
        setupObservers();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.saveAlertDialogVisibility.setValue(false);
    }

    //endregion LifeCycle Methods

    //region Private Methods

    private void generateQRBtcAddress(AddressDomain address){
        try {
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.encodeBitmap(address.address, BarcodeFormat.QR_CODE, 400, 400);
            binding.ivBtcAddressQr.setImageBitmap(bitmap);
        } catch(Exception e) {
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
        }
    }

    private void showSaveBtcAddressAlertDialog(Boolean visibility){
        if(visibility && viewModel.addressMutableLiveData.getValue() != null){

            AlertDialog.Builder confirmBtcAddressAlertDialogBuilder = new AlertDialog.Builder(this)
                    .setMessage(getBaseContext().getString(R.string.btc_address_save_message, viewModel.addressMutableLiveData.getValue().address))
                    .setPositiveButton(R.string.btc_address_save_confirm, (dialog, which) -> {
                        dialog.cancel();
                        viewModel.storeCurrentBtcAddressInSP();
                        navigateToHome();
                    })
                    .setNegativeButton(R.string.btc_address_save_cancel, (dialog, which) -> dialog.cancel());

            AlertDialog confirmBtcAddressAlertDialog = confirmBtcAddressAlertDialogBuilder.create();
            confirmBtcAddressAlertDialog.setTitle(R.string.btc_address_save_title);
            confirmBtcAddressAlertDialog.show();
        }
    }

    private void setupObservers() {
        viewModel.addressMutableLiveData.observe(this,this::generateQRBtcAddress);
        viewModel.saveAlertDialogVisibility.observe(this,this::showSaveBtcAddressAlertDialog);
    }

    private void navigateToHome(){
        Intent navigateToHomeIntent = new Intent(GenerateBitcoinAddressActivity.this, HomeActivity.class);
        startActivity(navigateToHomeIntent);
        finish();
    }

    //endregion Private Methods

}