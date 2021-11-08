# spring-batch-process

# Preparation
- Create a database table (Category) that contain Categories, Value and Status fields.
- Status field must only have 0 or 1 values. Randomly fill up this table with minimum 1000 records and 70% of the
records should have Status 1.
- Create another database table (Summary) that contain Summary of Categories fields.

# Task

- Write a Spring Batch Job with Java to read all data from Category table that have Status value 1.
- While reading data from Category table, create summary by category and insert into Summary table.
- When you finish reading every record on Category table, update Status field


# Implementation

- #Database : In Memory H2 Database
- Testing Spring batch process
   - Triggering to Spring batch is via REST Call for testing
   - Run SpringBatch Test case

- Initial Data will be populated in CATEGORY table with 3 columns 
   - Categories ( Various Color name - String)
   - Calue ( Color Hex Code - String)
   - Status ( 0 or 1 - Integer)

- New Table will get created with name as SUMMARY
  - only 1 column -   SummaryOfCategories which will contain unique Colur name from CATEGORY table 
