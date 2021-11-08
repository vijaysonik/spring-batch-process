package com.netpay.SpringBatchProcess.repository;

import com.netpay.SpringBatchProcess.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

/*
    @Transactional
    @Modifying
    @Query("UPDATE CATEGORY SET STATUS = 0 WHERE  id in :ids")
    public int updateProcessedCatagories(@Param(value = "ids") List<Integer> ids);
*/


    @Transactional
    @Modifying
    @Query("UPDATE Category SET status = 0 WHERE  id  = :id")
    public int updateProcessedCatagory(@Param(value = "id") Integer id);

}
