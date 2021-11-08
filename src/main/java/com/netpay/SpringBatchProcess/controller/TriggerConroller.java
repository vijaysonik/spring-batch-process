package com.netpay.SpringBatchProcess.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST Controller for Batch to trigger the Job from Rest Call.
 */
@RestController
@RequestMapping("/trigger")
public class TriggerConroller {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    /**
     * Trigger the Batch Job and return status as Completed/Failed.
     *
     * @return BatchStatus
     * @throws JobParametersInvalidException
     * @throws JobExecutionAlreadyRunningException
     * @throws JobRestartException
     * @throws JobInstanceAlreadyCompleteException
     */
    @GetMapping
    public BatchStatus triggerJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job,parameters);

        System.out.println("Batch is Running....");
        while(jobExecution.isRunning()){
            System.out.println("...");
        }
        System.out.println("JobExecution "+jobExecution.getStatus());
        return jobExecution.getStatus();
    }

}
