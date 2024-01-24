package com.example.tpmbe.services;

import com.example.tpmbe.ApiResponse.ApiResponse;
import com.example.tpmbe.ApiResponse.PaginationResponse;
import com.example.tpmbe.models.FactoryModel;
import com.example.tpmbe.repositories.FactoryRepository;
import com.example.tpmbe.utils.ApiConfig;
import com.example.tpmbe.utils.Util;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class FactoryFilterService {

    private final FactoryRepository factoryRepository;
    private final ApiConfig apiConfig;
    private final Util util;

    public ApiResponse<Map<String, List<String>>> getFactoryFilter() {
        List<FactoryModel> listFac = factoryRepository.getFactoryFilter();
        Map<String, List<String>> groupedData = util.groupByPosition(listFac, FactoryModel::getPosition, FactoryModel::getLocation);
        PaginationResponse<Map<String, List<String>>> paginationResponse = new PaginationResponse<>(0, 10, 10, List.of(groupedData));

        return apiConfig.formatApi(paginationResponse);
    }
}
