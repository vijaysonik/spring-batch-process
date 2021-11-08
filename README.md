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
