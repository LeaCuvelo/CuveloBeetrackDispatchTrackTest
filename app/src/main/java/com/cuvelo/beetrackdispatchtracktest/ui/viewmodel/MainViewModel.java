package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.cuvelo.domain.AddressDomain;
import com.cuvelo.usecases.interactor.DefaultSubscriber;
import com.cuvelo.usecases.interactor.GenerateAddressUseCase;
import java.lang.ref.WeakReference;
import javax.inject.Inject;
import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {

    @Inject
    public GenerateAddressUseCase mGenerateAddressUseCase;

    @Inject
    public MainViewModel(GenerateAddressUseCase generateAddressUseCase){
        this.mGenerateAddressUseCase = generateAddressUseCase;
    }

    public void generateBitcoinAddress(){
        mGenerateAddressUseCase.execute(new GenerateAddressUseCaseSubscriber(this));
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mGenerateAddressUseCase.unsubscribe();
    }

    //region Subscriber classes
    static class GenerateAddressUseCaseSubscriber extends DefaultSubscriber<AddressDomain>{

        final WeakReference<MainViewModel> viewModelWeakReference;

        public GenerateAddressUseCaseSubscriber(MainViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e("DEBUG", "ERROR");
        }

        @Override
        protected void onCompleted() {
            super.onCompleted();
            Log.e("DEBUG", "onCompleted");

        }

        @Override
        public void onNext(AddressDomain address) {
            super.onNext(address);
            Log.e("DEBUG", "onNext");
            Log.e("DEBUG", address.address);
        }
    }

    //endregion Subscriber classes

}
