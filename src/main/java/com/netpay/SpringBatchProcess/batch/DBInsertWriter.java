package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Summary;
import com.netpay.SpringBatchProcess.repository.SummaryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Writer component to write in DB.
 */
@Component
public class DBInsertWriter implements ItemWriter<Summary> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBInsertWriter.class);

    @Autowired
    private SummaryRepository summaryRepository;

    @Override
    public void write(List<? extends Summary> summaries) throws Exception {
        System.out.println("Data Saved for Summary " + summaries);
        Set<Summary>  summaryset= summaries.stream().collect(Collectors.toSet());
        LOGGER.info("Summary Set : "+summaryset);
        summaryRepository.saveAll(summaryset);
    }
}
