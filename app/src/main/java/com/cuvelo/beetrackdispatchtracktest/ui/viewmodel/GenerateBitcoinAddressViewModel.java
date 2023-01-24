package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cuvelo.domain.AddressDomain;
import com.cuvelo.usecases.interactor.DefaultSubscriber;
import com.cuvelo.usecases.interactor.GenerateAddressUseCase;

import java.lang.ref.WeakReference;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class GenerateBitcoinAddressViewModel extends ViewModel {

    private static final String TAG = "GenerateBTCAddressVM";

    public MutableLiveData<AddressDomain> addressMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> progressBarVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> saveAlertDialogVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> errorStateVisibility = new MutableLiveData<>(false);

    @Inject
    public GenerateAddressUseCase mGenerateAddressUseCase;

    @Inject
    public SharedPreferences btcAddressSharedPreference;
    private static final String BTC_ADDRESS_KEY = "BTC_ADDRESS_KEY";

    @Inject
    public GenerateBitcoinAddressViewModel(){
    }

    //region LifeCycle Methods

    @Override
    protected void onCleared() {
        super.onCleared();
        mGenerateAddressUseCase.unsubscribe();
    }

    //endregion LifeCycle Methods

    //region Public Methods

    public void generateBitcoinAddress(){
        progressBarVisibility.setValue(true);
        mGenerateAddressUseCase.execute(new GenerateAddressUseCaseSubscriber(this));
    }

    public void processNewBtcAddress(AddressDomain address){
        addressMutableLiveData.setValue(address);
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(false);
    }

    public void saveBtcAddress(){
        saveAlertDialogVisibility.setValue(true);
    }

    public void storeCurrentBtcAddressInDB(){
        storeBtcAddressInSharedPreferences();
    }

    public void storeBtcAddressInSharedPreferences(){
        if(addressMutableLiveData.getValue() != null){
            SharedPreferences.Editor myEdit = btcAddressSharedPreference.edit();
            myEdit.putString(BTC_ADDRESS_KEY, addressMutableLiveData.getValue().address);
            myEdit.apply();
        }
    }

    private String readBtcAddressFromSharedPreferences(){
        String btcAddress = btcAddressSharedPreference.getString(BTC_ADDRESS_KEY, "");
        Log.d(TAG, "BTC ADDRESS: " + btcAddress);
        return btcAddress;
    }

    public String isBtcAddressStored() {
        return readBtcAddressFromSharedPreferences();
    }

    public void showErrorState(){
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(true);
    }

    //endregion Public Methods

    //region Subscriber classes

    static class GenerateAddressUseCaseSubscriber extends DefaultSubscriber<AddressDomain>{

        final WeakReference<GenerateBitcoinAddressViewModel> viewModelWeakReference;

        public GenerateAddressUseCaseSubscriber(GenerateBitcoinAddressViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
            final GenerateBitcoinAddressViewModel viewModel = viewModelWeakReference.get();
            viewModel.showErrorState();
        }

        @Override
        protected void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onNext(AddressDomain address) {
            super.onNext(address);
            final GenerateBitcoinAddressViewModel viewModel = viewModelWeakReference.get();
            viewModel.processNewBtcAddress(address);
        }
    }

    //endregion Subscriber classes
}