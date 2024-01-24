package com.example.tpmbe.repositories;

import com.example.tpmbe.models.TPMDashboardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TPMDashboardRepository extends JpaRepository<TPMDashboardModel, Integer> {

    @Query(value = "{CALL usp_TMP_Dashboard(?,?,?,?)}", nativeQuery = true)
    public List<TPMDashboardModel> getTPMDashboard(   @Param("pLocation") String location
                                                    , @Param("pPosition") String position
                                                    , @Param("pPageIndex") Integer pageIndex
                                                    , @Param("pPageSize") Integer pageSize
                                                    );
}
