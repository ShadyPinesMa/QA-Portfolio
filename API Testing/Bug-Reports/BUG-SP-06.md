# Bug ID: BUG-SP-06

**Endpoint:** PUT /pet
**Severity:** Medium

## Title: PUT /pet creates a new pet record when supplied a non-existent ID instead of returning 404 Not Found

## Steps to Reproduce:

1. Send PUT request to
   https://petstore.swagger.io/v2/pet
2. Set Header: Content-Type = application/json
3. Set Header: Accept = application/json
4. Send body with a non-existent pet ID:
   ```json
   {
     "id": 987987987,
     "category": { "id": 1, "name": "Dogs" },
     "name": "Ghost Dog",
     "photoUrls": ["https://example.com/ghost.jpg"],
     "tags": [{ "id": 1, "name": "test" }],
     "status": "available"
   }
   ```

## Expected Result:

404 Not Found. PUT is documented as an update
operation in the Swagger spec. A non-existent
ID should be rejected rather than silently
creating a new record.

## Actual Result:

200 OK returned. Response body contained the
submitted pet object confirming a new record
was created with ID 987987987. The endpoint
behaved as an upsert operation rather than
a pure update.

## Impact:

The PUT endpoint does not validate whether the
supplied ID corresponds to an existing resource
before processing the request. This has two
consequences:

1. Unintended resource creation. Clients
   intending to update an existing pet could
   accidentally create a new one if they
   supply an incorrect ID, with no error
   feedback to indicate anything went wrong.

2. Blurred REST semantics. The distinction
   between POST (create) and PUT (update)
   is lost. Clients cannot rely on PUT to
   validate resource existence before
   making changes.

## Severity Justification:

Rated Medium rather than High because the
operation does not crash the server or expose
security information. However the silent creation
of unintended resources represents a meaningful
data integrity concern that could cause
confusion in a production environment.
