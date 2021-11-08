package com.netpay.SpringBatchProcess.config;


import com.netpay.SpringBatchProcess.batch.*;
import com.netpay.SpringBatchProcess.model.Category;
import com.netpay.SpringBatchProcess.model.Summary;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Configuration class for SpringBatch.
 *
 * @author : Vijay soni
 * @since : November 21
 */
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {


    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DBReader itemReader;

    @Autowired
    private SummaryProcessor processor;

    @Autowired
    private DBInsertWriter insertWriter;

    @Autowired
    private DBUpdateWriter updateWriter;

    @Autowired
    private CompositeWriter compositeItemWriter;


    /**
     * Job builder for Reading, Processing and writing the Task.
     *
     * @param jobBuilderFactory
     * @param stepBuilderFactory
     * @param itemReader
     * @param itemWriter
     * @return
     */
    @Bean
    public Job categorySummaryJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("categorySummaryJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(step1).next(step2())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Category, Summary>chunk(1000)
                .reader(itemReader)
                .processor(processor)
                .writer(insertWriter)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step1")
                .<Category, Category>chunk(1000)
                .reader(itemReader)
                .writer(updateWriter)
                .build();
    }



}
