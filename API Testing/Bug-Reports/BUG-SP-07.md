# Bug ID: BUG-SP-07

**Endpoint:** GET /pet/findByStatus
**Severity:** Medium

## Title: Invalid status enum value accepted without validation. Returns 200 OK with empty array instead of 400 Bad Request

## Steps to Reproduce:

1. Send GET request to
   https://petstore.swagger.io/v2/pet/findByStatus
2. Set Header: Accept = application/json
3. Add query param: status = invalidStatus
4. Send the request

## Expected Result:

400 Bad Request with structured error indicating
the supplied value is not a valid enum:

```json
{
  "code": 400,
  "type": "error",
  "message": "Invalid status value"
}
```

## Actual Result:

200 OK returned with empty array response body: []
The API accepted the invalid enum value, performed
a search, found no matching pets, and returned
an empty result set with no indication that
the input itself was invalid.

## Impact:

1. Missing enum validation. The API accepts
   any string as a valid status value,
   completely ignoring the enum constraint
   defined in the Swagger spec

2. Misleading success response. A 200 OK
   with an empty array looks identical to
   a valid request that simply returned no
   results. A client developer receiving
   this response has no way of knowing
   whether their status value was invalid
   or simply matched no records

3. Silent failure. Clients supplying a
   typo or incorrect status value will
   receive no error feedback, making
   integration issues extremely difficult
   to diagnose

## Severity Justification:

Rated Medium. No server crash or data
modification occurred. However the combination
of missing enum validation and a misleading
200 success response represents a meaningful
contract violation that could cause significant
confusion for client developers integrating
with this endpoint.
