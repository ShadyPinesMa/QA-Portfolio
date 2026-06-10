# Finding ID: FIND-SP-02

**Endpoint:** GET /pet/{petId}
**Severity:** Low
**Title:** Negative petId accepted as valid input. Returns 404 instead of 400 Bad Request

## Steps to Reproduce:

1. Send GET request to
   https://petstore.swagger.io/v2/pet/-1
2. Set Header: Accept = application/json
3. Send the request

## Expected Result:

400 Bad Request. Negative integers are not
semantically valid pet IDs and should be
rejected at the validation layer

## Actual Result:

404 Not Found returned with structured response:

```json
{
  "code": 1,
  "type": "error",
  "message": "Pet not found"
}
```

Server accepted -1 as a valid integer, performed
a database lookup, and returned 404 when no
matching record was found.

## Notes:

This result contrasts with BUG-SP-05 where a
non-numeric value (abc) caused a raw Java
exception. The server correctly parsed -1 as
an integer and handled the request gracefully.
The finding is limited to the absence of
positive integer validation on the petId
parameter.

Impact:
Low. Server handled the request gracefully
with no crash or exposed internals. Finding
is limited to missing boundary validation
on the petId parameter. No data was created
or modified.
