package com.autentia.rvillalba.toolbox.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.autentia.rvillalba.toolbox.utils.ToolboxPodamFactory;
import com.autentia.rvillalba.toolbox.api.SampleResponse;

import net.datafaker.Faker;
import uk.co.jemos.podam.api.PodamFactory;

@ExtendWith(MockitoExtension.class)
class ToolboxServiceTest{
    private static final String MESSAGE_PREFIX = "The id is ";
    private static final String ID_PREFIX = "Id";
    @InjectMocks
    private ToolboxService toolboxService;
    @Mock
    private AddressExternalService addressExternalService;
    private PodamFactory podamFactory = ToolboxPodamFactory.getCustomFactory();
    private Faker faker = new Faker();

    @Test
    void whenCallTProcessWithIdPrefixThenUpperCaseResultOkWithPodam(){
        var id = ID_PREFIX + podamFactory.manufacturePojo(String.class);
        var expectedResult = podamFactory.manufacturePojoWithFullData(SampleResponse.class);
        expectedResult.setMessage(MESSAGE_PREFIX + id.toUpperCase());
        Mockito.when(addressExternalService.findAddress(id)).thenReturn(expectedResult.getAddress());

        var result = toolboxService.process(id);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void whenCallTProcessWithIdPrefixThenLowerCaseResultOkWithPodam(){
        var id = podamFactory.manufacturePojo(String.class);
        var expectedResult = podamFactory.manufacturePojoWithFullData(SampleResponse.class);
        expectedResult.setMessage(MESSAGE_PREFIX + id.toLowerCase());
        Mockito.when(addressExternalService.findAddress(id)).thenReturn(expectedResult.getAddress());

        var result = toolboxService.process(id);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void whenCallTProcessWithIdPrefixThenUpperCaseResultOkWithDataFaker(){
        var id = ID_PREFIX + faker.idNumber().valid();
        var address = faker.address().fullAddress();
        var expectedResult = SampleResponse.builder().message(MESSAGE_PREFIX + id.toUpperCase()).address(address)
                .build();
        Mockito.when(addressExternalService.findAddress(id)).thenReturn(address);

        var result = toolboxService.process(id);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void whenCallTProcessWithIdPrefixThenLowerCaseResultOkWithDataFaker(){
        var id = faker.idNumber().valid();
        var address = faker.address().fullAddress();
        var expectedResult = SampleResponse.builder().message(MESSAGE_PREFIX + id.toLowerCase()).address(address)
                .build();
        Mockito.when(addressExternalService.findAddress(id)).thenReturn(address);

        var result = toolboxService.process(id);

        Assertions.assertEquals(expectedResult, result);
    }
}
