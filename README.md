

Sprint  Tasks
During Sprint 7, teams will continue working on the Cucumber
framework to create and implement 15 scenarios for API layer of the
application.
1-Write and implement your API scenarios in BDD using the Cucumber
feature files.
2-For the available API endpoints to test, refer to the provided API
documentation.
3-Create scenarios that involves the following validations:
oVerify correct HTTP status code.  
oVerify response payload.
oVerify response headers.
oVerify basic performance sanity.
4-Your API tests should include:
obasic positive tests
onegative tests with valid input that attempt illegal operations
onegative tests with invalid input
odestructive tests that intentionally attempt to fail the API to
check its robustness.
5-Also include:
oscenarios that test the API endpoints in isolation.
oscenarios that include multiple endpoints for verifying end-to-end
flow.
oscenarios that include UI or DB layers along with API. For
example, performing a transaction on the API layer and verifying
the result through UI or vice versa. And performing a transaction
on the DB and verifying it through API or vice versa.
6-Also use more advanced features of Rest Assured such as
serialization/deserialization using Java data structures and POJOs,
extracting and verifying values using Groovy Gpath and Ham crest
Matchers
7-Use Jira to track your process and branch-based flow to collaborate in
GitHub