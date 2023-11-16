package com.autentia.rvillalba.toolbox.api;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class SampleResponse{
    private String message;
    private String address;
}
