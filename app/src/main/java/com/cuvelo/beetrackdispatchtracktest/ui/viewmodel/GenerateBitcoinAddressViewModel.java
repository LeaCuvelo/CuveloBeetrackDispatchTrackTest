package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;


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

    private static final String TAG = "GenerateBitcoinAddressViewModel";

    public MutableLiveData<AddressDomain> addressMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> progressBarVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> saveAlertDialogVisibility = new MutableLiveData<>(false);

    @Inject
    public GenerateAddressUseCase mGenerateAddressUseCase;

    @Inject
    public GenerateBitcoinAddressViewModel(GenerateAddressUseCase generateAddressUseCase){
        this.mGenerateAddressUseCase = generateAddressUseCase;
    }

    public void generateBitcoinAddress(){
        progressBarVisibility.setValue(true);
        mGenerateAddressUseCase.execute(new GenerateAddressUseCaseSubscriber(this));
    }

    public void processNewBtcAddress(AddressDomain address){
        addressMutableLiveData.setValue(address);
        progressBarVisibility.setValue(false);
    }

    public void saveBtcAddress(){
        saveAlertDialogVisibility.setValue(true);
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mGenerateAddressUseCase.unsubscribe();
    }

    //region Subscriber classes
    static class GenerateAddressUseCaseSubscriber extends DefaultSubscriber<AddressDomain>{

        final WeakReference<GenerateBitcoinAddressViewModel> viewModelWeakReference;

        public GenerateAddressUseCaseSubscriber(GenerateBitcoinAddressViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
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
