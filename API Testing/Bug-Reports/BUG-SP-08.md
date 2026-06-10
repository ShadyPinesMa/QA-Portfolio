# Bug ID: BUG-SP-08

**Endpoint:** PUT /pet
**Severity:** Medium
**Title:** PUT /pet returns 405 Method Not Allowed instead of 400 Bad Request for empty request body

## Steps to Reproduce:

1. Send PUT request to
   https://petstore.swagger.io/v2/pet
2. Set Header: Content-Type = application/json
3. Set Header: Accept = application/json
4. Set Body to empty JSON object: {}
5. Send the request

## Expected Result:

400 Bad Request with structured error indicating
the request body is empty or missing required
fields:

```json
{
  "code": 400,
  "type": "error",
  "message": "Invalid pet data supplied"
}
```

## Actual Result:

405 Method Not Allowed returned with response:

```json
{
  "code": 405,
  "type": "unknown",
  "message": "no data"
}
```

The server detected the empty body and responded
with the wrong status code. 405 implies the PUT
method is not supported on this endpoint which
is incorrect. PUT /pet is a documented and
functional endpoint.

## Impact:

1. Wrong status code. 405 communicates that
   the HTTP method is unsupported rather than
   that the request body was invalid. A client
   receiving this response would incorrectly
   conclude that PUT is not allowed on this
   endpoint.

2. Misleading error message. "no data"
   provides minimal context about what
   specifically was wrong with the request.

3. Inconsistent behavior. POST /pet silently
   accepts missing required fields with 200 OK
   while PUT /pet returns 405 for an empty body.
   The API handles missing data inconsistently
   across its own endpoints.

## Severity Justification:

Rated Medium. The server did detect the
invalid input and responded rather than
crashing or silently accepting it. However
the wrong status code and inconsistent
behavior across endpoints represent a
meaningful contract violation.
