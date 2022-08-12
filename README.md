

Sprint 6 Tasks
During Sprint 6, teams will test the Database layer of the Duobank
application

1. Teams need to create 25 automated test cases related to database testing.
2. Teams need to create test cases that involve various aspects of the database
such as data flow from UI to DB and vice versa, data mapping, business rule
conformity, etc.
The example of the scenarios:
- Verify that data inserted from UI is reflecting properly in the
appropriate table and vice versa.
- Check for data integrity. Data should be stored in single or multiple
tables based on design. 
- Verify Table Schema, Column names as per Design Document 
- Verify Column Length and DataType 
- Verify Unicode Support (e.g store Chinese/Japanese Characters)
- Check if input data is not truncated while saving. Field length shown to the user 
on a page and in database schema should be the same 
- Check numeric fields with minimum, maximum, and float values 
- Check numeric fields with negative values 
- Check if database fields are designed with the correct data type and data length 
- Check if all table constraints like a Primary key, Foreign key, etc. are implemented
correctly 
- Test stored procedures and triggers with sample input data 
- Test if input field leading and trailing spaces are truncated before committing data 
to the database 
- Check values for columns which are not accepting null values 
- Null values should not be allowed for the Primary key column 
- Checking for duplicates.

3. The following is the information about the tables of the loan schema: (you
can also check it yourself since you have an access to the database)
4. This Sprint teams also need to setup the Jenkins server on AWS and create
the following jobs:
- a freestyle job for a smoke test suite that runs daily once every 6 hours. 
- a freestyle job for a regression test suite that runs every Saturday at 2 am. 
- a freestyle job for Sprint 6 scenarios that runs every time there is a
new commit to the repository. 
- a pipeline style job for Sprint 6 scenarios that runs once a day at 6 am
and every time there is a new commit to the repo. It should have an
option to generate cucumber report and send an email on failure.

5. During the demo teams need to display their Jenkins jobs and the result of
the latest build