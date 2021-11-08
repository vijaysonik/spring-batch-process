package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Category;
import com.netpay.SpringBatchProcess.model.CompositeDTO;
import com.netpay.SpringBatchProcess.model.Summary;
import org.springframework.batch.item.adapter.PropertyExtractingDelegatingItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.List;

@Component
public class CompositeWriter {

    @Autowired
    private DBUpdateWriter dbUpdateWriter;

    @Autowired
    private DBInsertWriter dbInsertWriter;

    @Bean()
    public PropertyExtractingDelegatingItemWriter<CompositeDTO> itemWriterAccessLogEntry() {
        PropertyExtractingDelegatingItemWriter<CompositeDTO> propertyExtractingDelegatingItemWriter = new PropertyExtractingDelegatingItemWriter<CompositeDTO>();
        propertyExtractingDelegatingItemWriter.setFieldsUsedAsTargetMethodArguments(new String[]{"summary", "category"});
        propertyExtractingDelegatingItemWriter.setTargetObject(this);
        propertyExtractingDelegatingItemWriter.setTargetMethod("saveTransaction");
        return propertyExtractingDelegatingItemWriter;
    }

    public void saveTransaction(List<Summary> summaryList, List<Category> categoryList) throws Exception {
        dbInsertWriter.write(summaryList);
        if (null != categoryList && !categoryList.isEmpty()) {
            dbUpdateWriter.write(categoryList);
        }

    }
}
