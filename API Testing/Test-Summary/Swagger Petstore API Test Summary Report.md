

Swagger Petstore API

**Test Summary Report**

## **Test Objective:**

	To ensure the quality, functionality, and reliability of the Swagger Petstore API hosted at https://petstore.swagger.io/. This project focused on API endpoints dealing with pets.

## **Testers Involved & Timeline:**

**Testers:** Carla Cipolloni  
**Testing Period:** 6/4/2026 \- 6/9/2026

## **Test Scope:**

**In-Scope:** Functional testing, data validation testing, positive testing, and negative testing for /pet endpoints  
**Out of Scope:** Automated functional testing and all forms of non-functional testing

## **Test Environment:**

**Browser:** LibreWolf 139  
**Test Data:** 

* Payloads: 1 valid full pet payload, 3 invalid payloads (missing required fields, invalid data types, empty body)  
* Path parameters: 1 non-existent ID (987987987), 1 non-numeric ID (abc), 1 negative ID (-1)  
* Query parameters: 3 valid status values (available, pending, sold), 1 invalid status value (invalidStatus)  
* File uploads: 1 valid image file, 1 invalid file type(.txt)

## **Test Summary:**

**Total Tests Executed:** 24 (10 positive, 14 negative)  
**Passed:** 10 (41.6%)  
**Failed:** 14 (58.3%)  
**Bugs Found:** 9 (4 High, 4 Medium, 1 Low, plus 2 Low severity observations)

## **Defect Summary:**

* No Input Validation (Systemic)  
  * Missing required fields are silently accepted across both POST /pet and PUT /pet. No schema validation exists at the API level for either create or update operations.  
* No Path Parameter Validation (Systemic)  
  * All four endpoints using {petId} return an identical 404 with a raw Java NumberFormatException when a non-numeric value is given. The fix requires a shared validation layer at the path parameter level.  
* Silent Data Loss on PUT  
  * PUT /pet silently removes fields omitted from the payload without warning. A client performing a partial update would unknowingly destroy existing data.  
* Security Concerns  
  * Two security relevant findings were identified:  
    * Raw Java exceptions expose internal stack information for all {petId} endpoints  
    * The upload endpoint accepts and stores any file type including potential executables.  
* Inconsistent Error Handling  
  * The API returns inconsistent status codes for similar error conditions across endpoints. 200, 404, and 405 are all returned for various forms of invalid input that should return 400\.

## **Conclusion:**

	The Swagger Petstore API demonstrates a systemic absence of validation across its endpoints. The majority of bugs are not isolated endpoint specific issues but symptoms of missing validation infrastructure at the API framework level. A comprehensive validation layer addressing required fields, data types, enum constraints, and path parameters would resolve the majority of findings identified in this test suite.

	