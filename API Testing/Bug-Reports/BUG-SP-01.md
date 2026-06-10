# Bug ID: BUG-SP-01 - API accepts pet creation request with missing required field photoUrls

**Endpoint:** POST/pet
**Severity:** Medium

## Steps to Reproduce:

1. Send POST request to https://petstore.swagger.io/v2/pet
2. Set Content-Type: application/json
3. Send body:

```json
{
  "id": 10001,
  "name": "Scout",
  "status": "sold"
}
```

## Expected Result:

    400 Bad Request. photoUrls is a required field per the Swagger spec and should be rejected when missing

## Actual Result:

    200 OK returned. Server auto-populated photoUrls and tags as empty arrays and created the pet record successfully.

## Impact:

    The API does not enforce its own schema contract for required fields. Clients that omit required fields receive no validation error, which could lead to incomplete data being persisted silently.

## BUG-SP-01 Update:

Missing required field validation is absent on
both POST /pet and PUT /pet:

- POST /pet (TC-SP-P-01): photoUrls omitted.
  Accepted with 200 OK, defaulted to empty array
- PUT /pet (TC-SP-N-14b): name and photoUrls
  omitted. Accepted with 200 OK, photoUrls
  defaulted to empty array, name field removed
  from record entirely

Finding is confirmed systemic across both
write operations.
