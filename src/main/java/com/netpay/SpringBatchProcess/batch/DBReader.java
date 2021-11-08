package com.netpay.SpringBatchProcess.batch;

import com.netpay.SpringBatchProcess.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class DBReader extends JdbcCursorItemReader<Category> implements ItemReader<Category> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBReader.class);

    public DBReader(@Autowired DataSource primaryDataSource) {
        setDataSource(primaryDataSource);
        setSql("SELECT id, categories, value, status FROM CATEGORY WHERE status = 1");
        setFetchSize(100);
        setRowMapper(new CategoryRowMapper());
    }

    public class CategoryRowMapper implements RowMapper<Category> {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
            Category category = new Category();
            category.setId(rs.getInt("id"));
            category.setCategories(rs.getString("categories"));
            category.setValue(rs.getString("value"));
            category.setStatus(rs.getInt("status"));
            return category;
        }
    }

}
