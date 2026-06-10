# Bug ID: BUG-SP-02 - API returns 500 Internal Server Error when request body contains invalid data types

**Endpoint:** POST /pet
**Severity:** High

## Steps to Reproduce:

1. Send post request to https://petstore.swagger.io/v2/pet
2. Set Content-Type: application/json
3. Send body with incorrect data types:

```json
{
  "id": "abc",
  "category": "Dogs",
  "name": 12345,
  "photoUrls": "https://example.com/scout.jpg",
  "tags": "friendly",
  "status": true
}
```

## Expected Result:

    400 Bad Request. Invalid data types should be rejected at the validation layer with a descriptive error message.

## Actual Result:

    500 Internal Server Error returned with message "something bad happened". Server failed to handle invalid input gracefully.

## Impact:

    The API has no input validation layer protecting the server from malformed requests. Invalid data types bypass validation entirely and cause an internal server crash. This represents a stability and reliability risk. A malicious or careless client could repeatedly trigger 500 errors, potentially destabilizing the server.

## Severity Justification:

    Rated High rather than Medium because the outcome is a server crash rather than silent acceptance of bad data. A 400 would indicate validation exists but is misapplied. A 500 indicates no protective validation layer exists at all.
