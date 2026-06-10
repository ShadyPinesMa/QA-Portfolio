# Bug ID: BUG-SP-03

**Endpoint:** POST /pet/{petId}/uploadImage
**Severity:** High

## Title: API returns 500 Internal Server Error and unformatted HTML error page when file key is omitted from multipart request

## Steps to Reproduce:

1. Send POST request to https://petstore.swagger.io/v2/pet/10001/uploadImage
2. Set Header: Accept = application/json
3. Set Body to form-data
4. Add key: additionalMetadata (Type: text) Value: "Missing file test"
5. Do not add a file key
6. Send the request

## Expected Result:

200 OK. File field is marked as optional in the Swagger spec and should be handled gracefully, or 400 Bad Request with a structured JSON error message if the server requires a file.

## Actual Result:

500 Internal Server Error returned as raw HTML error page from the Jetty server. Response format is HTML despite Accept: application/json header being set. Server crashed before constructing a formatted API response.

## Impact:

The upload endpoint has no error handling for missing file input. The server crashes entirely rather than handling the missing field gracefully. Additionally the API ignores the Accept header when returning error responses, meaning clients cannot rely on consistent response formatting when errors occur.

## Severity Justification:

    Rated High because:
    1. Server crashes on a valid use case. The spec marks file as optional, so omitting it should be handled gracefully
    2. Response format contract is broken. HTML returned despite JSON being requested.
    3. This is the second 500 found in negative testing, suggesting a systemic pattern of missing input validation across the API
