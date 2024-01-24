package com.example.tpmbe.utils;

import com.example.tpmbe.ApiResponse.ApiResponse;
import com.example.tpmbe.ApiResponse.DataResponse;
import com.example.tpmbe.ApiResponse.PaginationResponse;
import com.example.tpmbe.constants.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ApiConfig {

    public <T> ApiResponse<T> formatApi(PaginationResponse<T> paginationResponse) {

        DataResponse<T> data = new DataResponse<T>(paginationResponse);

        return new ApiResponse<T>(HttpStatus.OK.value(), Constants.GET_SUCCESS_MESSAGE, data);
    }
}
