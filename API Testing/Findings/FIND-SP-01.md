# Finding ID: FIND-SP-01

**Endpoint:** DELETE /pet/{petId}
**Severity:** Low
**Title:** DELETE non-existent pet returns 404 with unstructured response body

## Steps to Reproduce:

1. Send DELETE request to
   https://petstore.swagger.io/v2/pet/987987987
2. Set Header: Accept = application/json
3. Send the request

## Expected Results:

404 Not Found with structured JSON error body:

```json
{
  "code": 404,
  "type": "error",
  "message": "Pet not found"
}
```

## Actual Results:

404 Not Found returned correctly but response body contains only "1" with no structure or descriptive message.

## Impact:

Low, as the status code is correct. Unstructured response body is inconsistent with other endpoints and provides no useful information to the client about why the request failed.
