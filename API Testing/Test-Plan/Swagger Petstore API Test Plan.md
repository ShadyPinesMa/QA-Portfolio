

Swagger Petstore API

**TEST PLAN**

Version \- Draft (06/03/2026)

**VERSION HISTORY**

| Version \# | Completed By | Revision Date | Approved By | Approval Date | Reason |
| :---- | :---- | :---- | :---- | :---- | :---- |
| Draft | *Carla* |  | TBD | N/A | Test plan |
|  |  |  |  |  |  |
|  |  |  |  |  |  |

**[1\. Introduction	4](#1.-introduction)**

[1.1 Objective	4](#1.1-objective)

[1.2 API Description:	4](#1.2-api-description:)

[**2\. Scope of testing	4**](#2.-scope-of-testing)

[2.1 In-scope	4](#2.1-in-scope)

[2.2 Out of scope	5](#2.2-out-of-scope)

[**3\. Assumptions/Risks	5**](#3.-assumptions/risks)

[3.1 Assumptions	5](#3.1-assumptions)

[3.2 Risks	5](#3.2-risks)

[**4\. Test Approach	6**](#4.-test-approach)

[4.1 Test Schedule	6](#4.1-test-schedule)

[4.2 Test Data	6](#4.2-test-data)

[3.3 Test Strategy	6](#3.3-test-strategy)

[**5\. Deliverables	7**](#5.-deliverables)

[**6\. Tools Used	7**](#6.-tools-used)

[7\. Stakeholders \- roles and responsibilities	7](#7.-stakeholders---roles-and-responsibilities)

[8.1 Project Team	8](#8.1-project-team)

## **1\. Introduction** {#1.-introduction}

### 1.1 Objective {#1.1-objective}

This test plan aims to ensure the quality, functionality, and reliability of the Swagger Petstore API hosted at https://petstore.swagger.io/. The API is designed to handle pets, orders, and users for a pet store. This project will focus only on API endpoints dealing with pets.

### 1.2 API Description: {#1.2-api-description:}

- Create (POST) Operation:  
  * Test the API’s ability to create new pets using valid input data.  
  * Verify that appropriate error responses are returned for invalid or missing data.  
  * Verify that newly created data is stored correctly in the system.  
- Read (GET) Operation:  
  * Test the API’s ability to retrieve data by various criteria (e.g., pet ID, status).  
  * Verify that the API rejects invalid requests with appropriate error responses.  
  * Verify that data is correctly modified in the system after updates.  
- Update (Put) Operation:  
  * Test the API’s ability to update existing data with valid new data  
  * Verify that the API rejects invalid requests with appropriate error responses.  
  * Verify that data is correctly modified in the system after updates.  
- Delete (DELETE) Operation:  
  * Test the API’s ability to delete data by providing valid criteria (pet ID)  
  * Verify that the API returns appropriate responses after successful deletion.  
  * Verify that the deleted data is removed from the system.

## **2\. Scope of testing** {#2.-scope-of-testing}

	The Swagger Petstore API is designed to handle pets, orders, and users for a petstore. For this project, we will be focusing on the API endpoints relating to pets only.

### 2.1 In-scope {#2.1-in-scope}

- Functional Testing:  
  * Verify the correctness and functionality of pet API endpoints as per the API documentation.  
  * Test various scenarios for creation, modification, and deletion.  
- Data Validation Testing:   
  * Ensure the API correctly validates input data and rejects invalid requests.  
  * Test boundary values for input fields to check for unexpected behaviors.  
  * Validate the accuracy of data returned in responses.  
- Positive Testing:  
  * Ensure API creates, reads, updates, or deletes data using valid inputs.  
  * Test data used will be inside the accepted parameters for each endpoint.  
  * Verify returned codes indicate successful creation, reading, updating, or deletion when using valid inputs.  
- Negative Testing:  
  * Ensure API rejects any requests to create, read, update, or delete data using invalid inputs.  
  * Test data used will be outside of the accepted parameters for each endpoint.  
  * Verify returned codes indicate unsuccessful creation, reading, updating, or deletion when using invalid inputs.

### 2.2 Out of scope {#2.2-out-of-scope}

	All forms of non-functional testing are out of scope for this testing project. Some examples of non-functional testing are listed below:

* Load/stress testing  
* User Experience testing  
* Security testing  
* Performance testing

## **3\. Assumptions/Risks** {#3.-assumptions/risks}

### 3.1 Assumptions {#3.1-assumptions}

Testing will be done on the live website and the defects will be tracked in Google Sheets. Developers will have access to the bug tracking Google Sheet and will be monitoring the defects on a daily basis. Defect fixes will be delivered to the scrum team at least 1 day before the sprint end day so that the testing team can retest and close the defect in the same sprint. Any defects of high priority and high severity will be fixed within 1 day and turned over to the testing team for retesting.

### 3.2 Risks {#3.2-risks}

| Risks | Mitigation |
| ----- | ----- |
| Insufficient resources (manpower, lack of access to appropriate tools) to execute all of the test cases before the end of sprint. | Defects will be tested based on priority. Any open defects remaining at the end of the sprint will be moved to the next sprint, based on priority. |
| Defects are found late in the sprint and there is insufficient time to fix defect before the end of sprint | Defects added late in the sprint (later than 1 day before the sprint end day) will be moved to the next sprint, based on priority. |

## **4\. Test Approach** {#4.-test-approach}

	Testing will be executed using the Scrum-Agile methodology. The scrum team will participate in the following scrum events:

* Sprint Planning  
* Daily Scrum  
* Sprint Review  
* Sprint Retrospective

### 4.1 Test Schedule {#4.1-test-schedule}

	

| Activity | Dates |
| ----- | ----- |
| Test Planning | June 3, 2026  |
| Test Case Design | June 3, 2026 \- June 4, 2026 |
| Test Environment Setup | June 4, 2026 |
| Test Execution | June 4, 2026 \- June 9, 2026 |
| Defect Resolution | June 9, 2026 |
| Test Closure | June 9, 2026 |

### 4.2 Test Data {#4.2-test-data}

* Test data, both valid and invalid, can be manually created by the testing team to cover specific scenarios and edge cases.  
* Test data can be manually or automatically created based on the API specs.

### 3.3 Test Strategy {#3.3-test-strategy}

	**Step 1:**

- The first step is to create test scenarios and test cases for the features in scope. While developing test cases, we will use a number of test techniques:  
  * Equivalence Partitioning  
  * Manual testing  
- Test scenarios and test cases will be designed to cover the following:  
  * Checking status codes  
  * Verifying that responses contain allowed values  
  * Verifying that responses have correct JSON information  
- The team will use its expertise in creating test cases by applying the following:  
  * Error Guessing  
  * Exploratory Testing  
    

  **Step 2:**  
- Smoke testing will be conducted to determine if the various and important functionalities are working.  
- The build will be rejected if smoke testing fails. We will wait for a stable build before performing in-depth testing of the functionalities.  
- Once a stable build is received that passes smoke testing, we will perform in-depth testing using the test cases created.  
- Multiple test resources will be testing Insurance API to ensure its performance across different environments.  
- As part of testing, we will perform the following types of testing:  
  * Smoke testing  
  * Functionality testing  
  * Positive testing  
  * Negative testing

## **5\. Deliverables** {#5.-deliverables}

The following deliverables will be assembled by the testing team during this project:

* Test Plan  
* Test Cases  
* Test Summary Report

## **6\. Tools Used** {#6.-tools-used}

* Postman: used to test Swagger Petstore API endpoints.  
* Google Sheets: used to create and log test scenarios and test cases. Also used for defect tracking  
* Google Documents: used to create the test plan and test summary report

## **7\. Stakeholders \- roles and responsibilities** {#7.-stakeholders---roles-and-responsibilities}

	Product owner: responsible for defining requirements and acceptance criteria, prioritizing project backlog, providing sign off on deliverables  
	Scrum master: responsible for facilitating the scrum team and removing impediments to progress  
	Developers: responsible for developing the application, fixing defects and assigning defects to testing team  
	Testers: responsible for testing the application, logging and tracking defects, and providing testing reports to stakeholders 

### 8.1 Project Team  {#8.1-project-team}

| Name | Role | Responsibilities |
| ----- | ----- | ----- |
| TBD | Product Owner | Define requirements and acceptance criteria, prioritize backlog, provide sign off on deliverables |
| TBD | Scrum Master | Facilitate the scrum team, remove impediments to progress |
| TBD | Developer | Fix defects found by the test team and assign defects to the test team. |
| Carla Cipolloni | Tester | Test the application, log and track defects, provide testing reports to stakeholders |

### 

#### 

