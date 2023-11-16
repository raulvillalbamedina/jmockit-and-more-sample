package com.autentia.rvillalba.toolbox.controller;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.autentia.rvillalba.toolbox.utils.ToolboxPodamFactory;
import com.autentia.rvillalba.toolbox.api.SampleResponse;
import com.autentia.rvillalba.toolbox.service.ToolboxService;

import net.datafaker.Faker;
import uk.co.jemos.podam.api.PodamFactory;

@ExtendWith(MockitoExtension.class)
class ToolboxControllerTest{
    @Mock
    private ToolboxService toolboxService;
    @InjectMocks
    private ToolboxController toolboxController;
    private PodamFactory podamFactory = ToolboxPodamFactory.getCustomFactory();
    private Faker faker = new Faker();

    @Test
    void whenCallToSampleThenOkWithPodam(){
        var id = podamFactory.manufacturePojo(String.class);
        var expectedResult = podamFactory.manufacturePojoWithFullData(SampleResponse.class);
        Mockito.when(toolboxService.process(id)).thenReturn(expectedResult);

        var result = toolboxController.sample(id);

        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void whenCallToSampleThenOkWithDataFaker(){
        var id = faker.idNumber().valid();
        var expectedResult = SampleResponse.builder().message(faker.gameOfThrones().city()).build();
        Mockito.when(toolboxService.process(id)).thenReturn(expectedResult);

        var result = toolboxController.sample(id);

        Assertions.assertEquals(expectedResult, result);
    }
}
