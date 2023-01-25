package com.cuvelo.beetrackdispatchtracktest.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cuvelo.beetrackdispatchtracktest.R;
import com.cuvelo.beetrackdispatchtracktest.databinding.FragmentHistoryBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.adapter.BitcoinTransactionAdapter;
import com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.HistoryFragmentViewModel;
import com.cuvelo.domain.BitcoinTransactionDomain;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HistoryFragment extends Fragment {

    private static final String TAG = "HistoryFragment";

    private FragmentHistoryBinding binding;
    private HistoryFragmentViewModel historyFragmentViewModel;
    private final String btcAddress;
    private BitcoinTransactionAdapter transactionAdapter;

    public HistoryFragment(String btcAddress) {
        this.btcAddress = btcAddress;
    }

    //region Lifecycle Methods

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_history,
                container,
                false);

        binding.setLifecycleOwner(getViewLifecycleOwner());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        historyFragmentViewModel = new ViewModelProvider(this).get(HistoryFragmentViewModel.class);

        binding.setHistoryViewModel(historyFragmentViewModel);

        setupRecyclerView();
        setupObservers();
    }

    @Override
    public void onResume() {
        super.onResume();
        historyFragmentViewModel.getBitcoinWalletFullBalance(btcAddress);
    }

    //endregion Lifecycle Methods

    //region Private Methods

    private void setupRecyclerView(){
        transactionAdapter = new BitcoinTransactionAdapter();
        binding.rvHistoryTransactions.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.rvHistoryTransactions.setAdapter(transactionAdapter);
        setupSwipeRefreshLayout();
    }

    private void setupSwipeRefreshLayout(){
        binding.srlBalanceListRefreshContainer.setOnRefreshListener(() -> {
            historyFragmentViewModel.getBitcoinWalletFullBalance(btcAddress);
        });
    }

    private void setupObservers() {
        historyFragmentViewModel.bitcoinTransactions.observe(getViewLifecycleOwner(),this::processTransactions);
    }

    private void processTransactions(List<BitcoinTransactionDomain> transactions){
        transactionAdapter.updateItems(transactions);
        binding.srlBalanceListRefreshContainer.setRefreshing(false);
    }

    //endregion Private Methods

}