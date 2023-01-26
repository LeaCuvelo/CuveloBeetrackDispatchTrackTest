package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.cuvelo.domain.BitcoinTransactionDomain;
import com.cuvelo.domain.FullBalanceDomain;
import com.cuvelo.usecases.interactor.DefaultSubscriber;
import com.cuvelo.usecases.interactor.FindFullBalanceByAddressUseCase;

import java.lang.ref.WeakReference;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class HistoryFragmentViewModel extends ViewModel {

    private static final String TAG = "HistoryFragmentVM";

    public MutableLiveData<List<BitcoinTransactionDomain>> bitcoinTransactions = new MutableLiveData<>();
    public MutableLiveData<Boolean> progressBarVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> errorStateVisibility = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> emptyStateVisibility = new MutableLiveData<>(false);


    @Inject
    FindFullBalanceByAddressUseCase findFullBalanceByAddressUseCase;

    @Inject
    public HistoryFragmentViewModel() {

    }

    //region Public Methods

    public void getBitcoinWalletFullBalance(String address){
        progressBarVisibility.setValue(true);
        findFullBalanceByAddressUseCase.setBtcWalletAddress(address);
        findFullBalanceByAddressUseCase.execute(new HistoryFragmentViewModel.FindFullBalanceByAddressUseCaseSubscriber(this));
    }

    //endregion Public Methods

    //region Private Methods

    private void showErrorState(){
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(true);
    }

    private void showEmptyState(){
        emptyStateVisibility.setValue(true);
    }

    private void hideEmptyState(){
        emptyStateVisibility.setValue(false);
    }

    private void processFullBalance(List<BitcoinTransactionDomain> transactions){
        progressBarVisibility.setValue(false);
        errorStateVisibility.setValue(false);
        if(transactions.isEmpty()){
            showEmptyState();
        }
        else {
            hideEmptyState();
        }
        bitcoinTransactions.setValue(transactions);
    }

    //endregion Private Methods

    //region Subscriber classes

    static class FindFullBalanceByAddressUseCaseSubscriber extends DefaultSubscriber<FullBalanceDomain> {

        final WeakReference<HistoryFragmentViewModel> viewModelWeakReference;

        public FindFullBalanceByAddressUseCaseSubscriber(HistoryFragmentViewModel viewModelWeakReference) {
            this.viewModelWeakReference = new WeakReference<>(viewModelWeakReference);
        }

        @Override
        public void onError(Throwable e) {
            super.onError(e);
            Log.e(TAG, e.getClass().getSimpleName() + ": " + e.getMessage());
            final HistoryFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.showErrorState();
        }

        @Override
        protected void onCompleted() {
            super.onCompleted();
        }

        @Override
        public void onNext(FullBalanceDomain fullBalance) {
            super.onNext(fullBalance);
            final HistoryFragmentViewModel viewModel = viewModelWeakReference.get();
            viewModel.processFullBalance(fullBalance.getTransactions());
        }
    }

    //endregion Subscriber classes

}