package com.autentia.rvillalba.toolbox.utils;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class ToolboxPodamFactory{

    private static PodamFactory customPodamFactory;

    public static PodamFactory getCustomFactory(){
        if (customPodamFactory == null){
            customPodamFactory = new PodamFactoryImpl();
            customPodamFactory.getStrategy().setDefaultNumberOfCollectionElements(3);
            customPodamFactory.getStrategy().setMemoization(true);
        }
        return customPodamFactory;
    }
}
