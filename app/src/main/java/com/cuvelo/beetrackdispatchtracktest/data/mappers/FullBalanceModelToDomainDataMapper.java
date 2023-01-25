package com.cuvelo.beetrackdispatchtracktest.data.mappers;

import com.cuvelo.beetrackdispatchtracktest.data.model.BitcoinTransactionModel;
import com.cuvelo.beetrackdispatchtracktest.data.model.FullBalanceModel;
import com.cuvelo.domain.BitcoinTransactionDomain;
import com.cuvelo.domain.FullBalanceDomain;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FullBalanceModelToDomainDataMapper implements Transformer<FullBalanceDomain, FullBalanceModel>{

    private final int SATOSHIS_FACTOR_CONVERTION = 100000000;

    @Override
    public FullBalanceDomain transform(FullBalanceModel fullBalanceModel) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        decimalFormat.setMaximumFractionDigits(20);
        FullBalanceDomain fullBalanceDomain = new FullBalanceDomain();
        fullBalanceDomain.address = fullBalanceModel.address;
        fullBalanceDomain.balance = decimalFormat.format((double) fullBalanceModel.balance / SATOSHIS_FACTOR_CONVERTION);
        fullBalanceDomain.unconfirmedBalance = decimalFormat.format((double) fullBalanceModel.unconfirmedBalance / SATOSHIS_FACTOR_CONVERTION);
        fullBalanceDomain.finalBalance = decimalFormat.format((double) fullBalanceModel.finalBalance / SATOSHIS_FACTOR_CONVERTION );

        List<BitcoinTransactionDomain> bitcoinTransactionDomain = new ArrayList<>();
        for(BitcoinTransactionModel bitcoinTransaction : fullBalanceModel.transactions) {
            BitcoinTransactionDomain transaction = new BitcoinTransactionDomain();
            String timestamp = "";
            transaction.setTotal(decimalFormat.format((double) bitcoinTransaction.total / SATOSHIS_FACTOR_CONVERTION));
            timestamp = formatTimeStamp(bitcoinTransaction.timeStampConfirmed);
            transaction.setUnconfirmed(timestamp.isEmpty());
            transaction.setTimestampConfirmed(timestamp);
            bitcoinTransactionDomain.add(transaction);
        }
        fullBalanceDomain.transactions = bitcoinTransactionDomain;
        return fullBalanceDomain;
    }

    private String formatTimeStamp(String timeStampToFormat){
        String timeStampFormatted = "";
        SimpleDateFormat timeStampFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        Date date = null;
        try {
            if(timeStampToFormat != null) date = timeStampFormatter.parse(timeStampToFormat);
        } catch (ParseException e) {
            e.printStackTrace();
            return timeStampFormatted;
        }
        if(date != null)  timeStampFormatted = date.toString();
        return timeStampFormatted;
    }
}