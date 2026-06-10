# Bug ID: BUG-SP-05 (Final Update)

**Endpoint:** Multiple - all endpoints using {petId} as a path parameter
**Severity:** High

## Title: Non-numeric petId returns 404 with exposed raw Java exception instead of 400 Bad Request. Confirmed across all {petId} endpoints

## Confirmed Endpoints:

- GET /pet/{petId} TC-SP-N-09
- POST /pet/{petId} TC-SP-N-08
- DELETE /pet/{petId} TC-SP-N-07
- POST /pet/{petId}/uploadImage TC-SP-N-10

## Steps to Reproduce (any affected endpoint):

1. Send a request to any {petId} endpoint using
   a non-numeric value as the path parameter
   Example: GET /pet/abc
2. Set Header: Accept = application/json
3. Send the request

## Expected Result:

400 Bad Request with a clean structured
error response:

```json
{
  "code": 400,
  "type": "error",
  "message": "Invalid ID supplied"
}
```

## Actual Result:

404 Not Found returned on all four endpoints
with identical response body exposing a raw
Java exception:

```json
{
  "code": 404,
  "type": "unknown",
  "message": "java.lang.NumberFormatException: For input string: \"abc\""
}
```

## Root Cause Assessment:

The API has no path parameter validation layer.
Non-numeric values passed as {petId} bypass
validation entirely and propagate to the Java
runtime where they trigger an unhandled
NumberFormatException that is returned directly
to the client. The fix required is structural.
A shared validation layer needs to be
implemented at the path parameter level rather
than patching each endpoint individually.

## Impact:

1. Wrong status code: 404 implies a valid
   request with no matching resource. 400 should
   be returned for invalid input format across
   all four endpoints.

2. Internal stack exposure: raw Java exception
   reveals the server's underlying technology
   stack and implementation details to any client
   sending a malformed request. This information
   could be leveraged by a malicious user to
   craft targeted attacks.

3. Systemic scope: all four endpoints sharing
   the {petId} path parameter are affected,
   confirming the absence of any centralized
   input validation for path parameters
   across the API.

## Severity Justification:

Rated High due to:

1. Security implication of exposed internal
   stack information
2. Systemic scope across all {petId} endpoints
3. Architectural nature of the fix required
