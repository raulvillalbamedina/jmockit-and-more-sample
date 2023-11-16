package com.autentia.rvillalba.toolbox.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.autentia.rvillalba.toolbox.api.SampleResponse;
import com.autentia.rvillalba.toolbox.service.ToolboxService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ToolboxController{
    private final ToolboxService toolboxService;

    @GetMapping("/sample/{id}")
    public SampleResponse sample(@PathVariable String id){
           return toolboxService.process(id);
    }
}
