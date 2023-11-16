package com.autentia.rvillalba.toolbox.service;

import org.springframework.stereotype.Component;

@Component
public class AddressExternalService{
    public String findAddress(String id){
        return "Street Dummy" + id;
    }
}
