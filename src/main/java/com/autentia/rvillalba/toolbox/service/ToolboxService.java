package com.autentia.rvillalba.toolbox.service;

import org.springframework.stereotype.Service;

import com.autentia.rvillalba.toolbox.api.SampleResponse;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ToolboxService{

    private final AddressExternalService addressExternalService;

    public SampleResponse process(String id){
        return SampleResponse.builder().message("The id is " + generateId(id))
                .address(addressExternalService.findAddress(id)).build();
    }

    private String generateId(String id){
        if(id.startsWith("Id")){
            return id.toUpperCase();
        }
        return id.toLowerCase();
    }
}
