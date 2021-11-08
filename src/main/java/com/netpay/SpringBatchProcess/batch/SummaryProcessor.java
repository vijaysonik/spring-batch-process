package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Category;
import com.netpay.SpringBatchProcess.model.Summary;
import com.netpay.SpringBatchProcess.util.StatusEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

/**
 * Processor class to transform Category into Summary
 */
@Component
public class SummaryProcessor implements ItemProcessor<Category, Summary> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummaryProcessor.class);

    @Override
    public Summary process(Category category) throws Exception {
        Summary summary = new Summary();
        summary.setSummaryOfCategories(category.getCategories());

        LOGGER.info("Grouping Category ( {} ) into ( {} )", category, summary);
        return summary;
   }
}
