package com.example.tpmbe.controllers;

import com.example.tpmbe.ApiResponse.ApiResponse;
import com.example.tpmbe.constants.Constants;
import com.example.tpmbe.models.TPMDashboardModel;
import com.example.tpmbe.services.TPMService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping(path = Constants.BASE_URL)
public class TPMController {
    private final TPMService service;

    @GetMapping
    public ApiResponse<TPMDashboardModel> getTpmDashboard(@RequestParam(value = "location", required = false, defaultValue = "")  String location
                                                        , @RequestParam(value = "position", required = false, defaultValue = "") String position
                                                        , @RequestParam(value = "p",required = false, defaultValue = "0") Integer p
                                                        , @RequestParam(value = "s",required = false, defaultValue = "101") Integer s
                                                          ) {
        return service.getTpmDashboard(location, position, p, s);
    }

}
