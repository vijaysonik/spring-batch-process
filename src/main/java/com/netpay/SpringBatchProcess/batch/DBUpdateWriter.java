package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Category;
import com.netpay.SpringBatchProcess.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class DBUpdateWriter implements ItemWriter<Category> {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUpdateWriter.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void write(List<? extends Category> categories) throws Exception {
        System.out.println("Data Update in Category" + categories);
        for (Category category : categories) {
            if (category.getStatus()==1) {
                categoryRepository.updateProcessedCatagory(category.getId());
            }
        }

    }
}
