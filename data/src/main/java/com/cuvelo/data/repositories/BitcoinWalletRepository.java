package com.cuvelo.data.repositories;

import com.cuvelo.data.datasources.LocalBitcoinWalletBalanceDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletAddressDataSource;
import com.cuvelo.data.datasources.RemoteBitcoinWalletBalanceDataSource;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.domain.BalanceDomain;
import com.cuvelo.domain.FullBalanceDomain;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;


public class BitcoinWalletRepository {

    private final RemoteBitcoinWalletAddressDataSource mRemoteBitcoinWalletAddressDataSource;
    private final LocalBitcoinWalletBalanceDataSource mLocalBitcoinWalletBalanceDataSource;
    private final RemoteBitcoinWalletBalanceDataSource mRemoteBitcoinWalletBalanceDataSource;


    public BitcoinWalletRepository(RemoteBitcoinWalletAddressDataSource remoteBitcoinWalletAddressDataSource,
                                   LocalBitcoinWalletBalanceDataSource localBitcoinWalletBalanceDataSource,
                                   RemoteBitcoinWalletBalanceDataSource remoteBitcoinWalletBalanceDataSource){
        this.mRemoteBitcoinWalletAddressDataSource = remoteBitcoinWalletAddressDataSource;
        this.mLocalBitcoinWalletBalanceDataSource = localBitcoinWalletBalanceDataSource;
        this.mRemoteBitcoinWalletBalanceDataSource = remoteBitcoinWalletBalanceDataSource;
    }


    public Observable<BalanceDomain> getBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> findFullBalanceByAddressFromDataBase(String address){
        return mLocalBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

    public Observable<AddressDomain> generateBitcoinWalletAddressFromApi(){
        return mRemoteBitcoinWalletAddressDataSource.generateBitcoinWalletAddress();
    }

    public void saveBalance(BalanceDomain balanceDomain){
        mLocalBitcoinWalletBalanceDataSource.saveBalance(balanceDomain);
    }
    
    public Observable<BalanceDomain> getBalance(String address){
        //TODO offline mode, WIP on the following way of catch data from DB or API
        Observable<BalanceDomain> databaseObservable = getBalanceByAddressFromDataBase(address);
        Observable<BalanceDomain> networkObservable = getBalanceByAddressFromApi(address);
        //return Observable.concat(databaseObservable, networkObservable);


        return getBalanceByAddressFromApi(address);
    }

    public Observable<BalanceDomain> getBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getBalance(address);
    }

    public Observable<FullBalanceDomain> getFullBalanceByAddressFromApi(String address){
        return mRemoteBitcoinWalletBalanceDataSource.getFullBalance(address);
    }

    /*
    private boolean isNetworkInProgress() {
        return dataProviderDisposable != null && !dataProviderDisposable.isDisposed();
    }*/

    /*
    *
    *
    *
    *    @Override
    public Observable<WeatherData> getForecastData() {
        String currentLocationName = sessionService.getLocation();
        Observable<WeatherData> memoryObservable = memoryInteractor.getWeatherData().toObservable();
        Observable<WeatherData> databaseObservable = databaseInteractor.getWeatherData(currentLocationName).toObservable();
        Observable<WeatherData> networkObservable = networkInteractor.getWeatherData(currentLocationName).toObservable();
        if (!isNetworkInProgress()) {
            dataProviderDisposable = Observable.concat(memoryObservable, databaseObservable, networkObservable)
                    .filter(data -> data.name.equals(sessionService.getLocation()))
                    .filter(WeatherData::isDataInDate)
                    .firstElement()
                    .subscribe((boosterData) -> {}, this::handleNonHttpException);
        }

        return memoryInteractor.getWeatherDataObservable();
    }
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *
    *     @Override
    public Single<WeatherData> getWeatherData(String city) {
        return apiService.getWeather(city)
                 .map(WeatherData::copyFromResponse)
                .doOnSuccess(data -> sessionService.saveLocation(data.name))
                .doOnSuccess(databaseInteractor::saveData)
                .doOnSuccess(memoryInteractor::saveData);
    }
    *
    *
    * */

}