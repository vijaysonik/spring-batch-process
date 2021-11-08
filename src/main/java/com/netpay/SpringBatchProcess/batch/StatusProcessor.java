package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Category;
import com.netpay.SpringBatchProcess.util.StatusEnum;
import org.springframework.batch.item.ItemProcessor;

public class StatusProcessor implements ItemProcessor<Category, Category> {


    @Override
    public Category process(Category category) throws Exception {
        category.setStatus(category.getStatus()== StatusEnum.ZERO.status ?StatusEnum.ONE.status:StatusEnum.ZERO.status);
        return category;
    }
}
