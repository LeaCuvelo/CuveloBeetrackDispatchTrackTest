package com.cuvelo.beetrackdispatchtracktest.ui.viewmodel;

import static com.cuvelo.beetrackdispatchtracktest.ui.viewmodel.TestHelper.configureUseCaseSuccess;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

import com.cuvelo.data.repositories.BitcoinWalletRepository;
import com.cuvelo.domain.AddressDomain;
import com.cuvelo.usecases.executor.PostExecutionThread;
import com.cuvelo.usecases.executor.ThreadExecutor;
import com.cuvelo.usecases.interactor.GenerateAddressUseCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.LooperMode;


@RunWith(RobolectricTestRunner.class)
@LooperMode(LooperMode.Mode.PAUSED)
public class GenerateBitcoinAddressViewModelTest {

    private GenerateBitcoinAddressViewModel viewModel;
    private GenerateAddressUseCase generateAddressUseCase;

    @Mock
    PostExecutionThread postExecutionThread;

    @Mock
    ThreadExecutor threadExecutor;

    @Mock
    BitcoinWalletRepository bitcoinWalletRepository;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        viewModel = new GenerateBitcoinAddressViewModel();
        generateAddressUseCase = new GenerateAddressUseCase(threadExecutor, postExecutionThread, bitcoinWalletRepository);
    }

    @Test
    public void whenGenerateAddressApiSuccessShowData(){
        viewModel.generateBitcoinAddress();

        //TODO NPE , useCase in VM null
        verify(generateAddressUseCase).execute(any());

    }

    @Test
    public void whenGenerateAddressApiErrorShowErrorMessage(){

    }

    private void configureAddressDomainResponseSuccess(){
        AddressDomain addressDomainResponse = new AddressDomain();
        addressDomainResponse.address = "address";
        addressDomainResponse.publicKeyPair = "publicKeyPair";
        addressDomainResponse.privateKeyPair = "privateKeyPair";
        addressDomainResponse.wif = "wif";
        configureUseCaseSuccess(generateAddressUseCase,addressDomainResponse);

        PowerMockito.mockStatic(AddressDomain.class);
    }

}
