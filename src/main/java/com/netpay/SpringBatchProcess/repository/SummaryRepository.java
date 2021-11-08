package com.netpay.SpringBatchProcess.repository;

import com.netpay.SpringBatchProcess.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummaryRepository extends JpaRepository<Summary,Integer> {
}
