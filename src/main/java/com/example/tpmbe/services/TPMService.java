package com.example.tpmbe.services;

import com.example.tpmbe.ApiResponse.ApiResponse;
import com.example.tpmbe.ApiResponse.PaginationResponse;
import com.example.tpmbe.models.TPMDashboardModel;
import com.example.tpmbe.repositories.TPMDashboardRepository;
import com.example.tpmbe.utils.ApiConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TPMService {
    private final TPMDashboardRepository tpmDashboardRepository;

    private final ApiConfig apiConfig;

    public ApiResponse<TPMDashboardModel> getTpmDashboard(String location, String position, Integer pageIndex, Integer pageSize) {
        List<TPMDashboardModel> result = tpmDashboardRepository.getTPMDashboard(location, position, pageIndex, pageSize);
        int totalElements = 0;
        if (!result.isEmpty()) {
            totalElements = result.get(0).getTotalElements();
        }
        PaginationResponse<TPMDashboardModel> page = new PaginationResponse<>(pageIndex, pageSize, totalElements, result);
        return apiConfig.formatApi(page);
    }
}
