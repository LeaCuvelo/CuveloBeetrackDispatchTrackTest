package com.cuvelo.beetrackdispatchtracktest.ui.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.cuvelo.beetrackdispatchtracktest.databinding.ItemBitcoinTransactionBinding;
import com.cuvelo.beetrackdispatchtracktest.ui.common.BitcoinTransactionDomainDiffCallback;
import com.cuvelo.domain.BitcoinTransactionDomain;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class BitcoinTransactionAdapter extends RecyclerView.Adapter<BitcoinTransactionAdapter.TransactionViewHolder> {

    private List<BitcoinTransactionDomain> transactionsList = new ArrayList<>();
    private ItemBitcoinTransactionBinding binding;

    public void updateItems(List<BitcoinTransactionDomain> newList){
        if(newList != null){
            BitcoinTransactionDomainDiffCallback diffUtil = new BitcoinTransactionDomainDiffCallback();
            diffUtil.setOldBitcoinTransactionDomainList(transactionsList);
            diffUtil.setNewBitcoinTransactionDomainList(newList);
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(diffUtil);
            transactionsList = newList;
            result.dispatchUpdatesTo(this);
        }
    }

    @NonNull
    @NotNull
    @Override
    public BitcoinTransactionAdapter.TransactionViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        binding = ItemBitcoinTransactionBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new TransactionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull BitcoinTransactionAdapter.TransactionViewHolder holder, int position) {
        BitcoinTransactionDomain bitcoinTransactionDomain = transactionsList.get(position);
        holder.bind(bitcoinTransactionDomain);
    }

    @Override
    public int getItemCount() {
        return transactionsList.size();
    }

    //region ViewHolder

    public static class TransactionViewHolder extends RecyclerView.ViewHolder{

        private final ItemBitcoinTransactionBinding binding;

        public TransactionViewHolder(@NonNull @NotNull ItemBitcoinTransactionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(BitcoinTransactionDomain bitcoinTransactionDomain){
            binding.setBitcoinTransaction(bitcoinTransactionDomain);
        }

    }

    //endregion ViewHolder

}