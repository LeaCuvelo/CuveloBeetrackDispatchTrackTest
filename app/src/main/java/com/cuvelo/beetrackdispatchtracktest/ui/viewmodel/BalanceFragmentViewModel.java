package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.usecases.interactor.DefaultCompletableSubscriber;
import com.cuvelo.usecases.interactor.DefaultSubscriber;
import com.cuvelo.usecases.interactor.FindBalanceByAddressUseCase;
import com.cuvelo.usecases.interactor.SaveBalanceUseCase;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BalanceFragmentViewModel  extends ViewModel {

    private static final String TAG = "BalanceFragmentVM";

    public MutableLiveData<BalanceDomain> btcBalanceMutableLiveData = new MutableLiveData<>();
    public MutableLiveData<Boolean> progressBarVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> errorStateVisibility = new MutableLiveData<>(false);


    @Inject
    public FindBalanceByAddressUseCase findBalanceByAddressUseCase;

    @Inject
    public SaveBalanceUseCase saveBalanceUseCase;

    @Inject
    public BalanceFragmentViewModel(){
        Log.d(TAG,"BalanceFragmentViewModel");
    }

    //region LifeCycle Methods

    @Override
    protected void onCleared() {
        super.onCleared();
        findBalanceByAddressUseCase.unsubscribe();
    }

    //endregion LifeCycle Methods

    //region Public Methods

    public void getBitcoinWalletBalance(String address){
        progressBarVisibility.setValue(true);
        findBalanceByAddressUseCase.setBtcWalletAddress(address);
        findBalanceByAddressUseCase.execute(new BalanceFragmentViewModel.FindBalanceByAddressUseCaseSubscriber(this));
    }

    public void showErrorState(){
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(true);
    }

    //endregion Public Methods

    //region Private Methods

    private void processBalance(BalanceDomain balanceDomain){
        btcBalanceMutableLiveData.setValue(balanceDomain);
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(false);
        saveBalanceInDb(balanceDomain);
    }



    private void saveBalanceInDb(BalanceDomain balanceDomain){
        saveBalanceUseCase.setBalanceDomain(balanceDomain);
        saveBalanceUseCase.execute(new BalanceFragmentViewModel.SaveBalanceByAddressUseCaseSubscriber(this));
    }

    private void errorSavingDb(){
        Log.d(TAG, "ERROR SAVING DB");
    }

    private void balanceStoredInDb(){
        Log.d(TAG, "SUCCESS SAVING DB");
    }

    //endregion Private Methods

    //region Subscriber classes

    static class FindBalanceByAddressUseCaseSubscriber extends DefaultSubscriber<BalanceDomain> {

        final WeakReference<BalanceFragmentViewModel> viewModelWeakReference;

        public FindBalanceByAddressUseCaseSubscriber(BalanceFragmentViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
            final BalanceFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.showErrorState();
        }

        @Override
        protected void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onNext(BalanceDomain balance) {
            super.onNext(balance);
            final BalanceFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.processBalance(balance);
        }
    }

    static class SaveBalanceByAddressUseCaseSubscriber extends DefaultCompletableSubscriber {

        final WeakReference<BalanceFragmentViewModel> viewModelWeakReference;

        public SaveBalanceByAddressUseCaseSubscriber(BalanceFragmentViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
            final BalanceFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.errorSavingDb();
        }

        @Override
        protected void onCompleted() {
            super.onCompleted();
            final BalanceFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.balanceStoredInDb();
        }

    }

    //endregion Subscriber classes

}