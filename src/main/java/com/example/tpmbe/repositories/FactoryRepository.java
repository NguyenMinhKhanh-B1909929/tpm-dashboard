package com.example.tpmbe.repositories;

import com.example.tpmbe.models.FactoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactoryRepository extends JpaRepository<FactoryModel, String> {

    @Query(value = "{CALL usp_TMP_Dashboard_GetFilter}", nativeQuery = true)
    public List<FactoryModel> getFactoryFilter();
}
