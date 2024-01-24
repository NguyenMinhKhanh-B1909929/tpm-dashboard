package com.example.tpmbe.controllers;

import com.example.tpmbe.ApiResponse.ApiResponse;
import com.example.tpmbe.constants.Constants;
import com.example.tpmbe.models.FactoryModel;
import com.example.tpmbe.services.FactoryFilterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = Constants.BASE_URL)
@CrossOrigin
@RequiredArgsConstructor
public class FactoryController {

    private final FactoryFilterService factoryFilterService;

    @GetMapping(Constants.URL_GET_FACTORY)
    public ApiResponse<Map<String, List<String>>> getFactory() {
        return factoryFilterService.getFactoryFilter();
    }
}
