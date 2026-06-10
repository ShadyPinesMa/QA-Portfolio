# Bug ID: BUG-SP-09

**Endpoint:** PUT /pet
**Severity:** High
**Title:** PUT /pet silently removes fields from pet record when omitted from payload. No warning returned

## Steps to Reproduce:

1. Ensure pet with ID 10001 exists with a
   name field set
2. Send PUT request to
   https://petstore.swagger.io/v2/pet
3. Set Header: Content-Type = application/json
4. Set Header: Accept = application/json
5. Send payload omitting the name field:
   ```json
   {
     "id": 10001,
     "category": { "id": 1, "name": "Dogs" },
     "tags": [{ "id": 1, "name": "friendly" }],
     "status": "available"
   }
   ```

## Expected Result:

400 Bad Request. Name is a required field
and should be rejected when missing, or at
minimum the existing name value should be
preserved if partial updates are supported

## Actual Result:

200 OK returned. The name field was completely
removed from the pet record with no warning
or error. Response body contained no name
field confirming the data was wiped from
the database.

## Impact:

This is the most dangerous manifestation of
the missing required field validation identified
in BUG-SP-01. The consequences are:

1. Silent data loss. Existing field values
   are permanently overwritten with nothing
   when omitted from a PUT payload, with no
   warning to the client

2. No recovery path. Once the name is wiped
   the client has no way of knowing the
   original value unless it was stored
   elsewhere

3. Compounded by BUG-SP-01. The same
   missing validation that allows incomplete
   creates also allows incomplete updates
   that destroy existing data

## Severity Justification:

Rated High because this results in permanent,
silent data loss. A client performing a partial
PUT update without knowing all fields are
required would unknowingly destroy existing
data with no error feedback.

## TC-SP-N-14c confirmation:

When only photoUrls was omitted, name was preserved
correctly. This confirms the data loss behavior in
TC-SP-N-14b was directly caused by omitting name
from the payload and not a random or intermittent issue.
PUT /pet performs a full replacement of exactly the
fields provided, silently removing any field not
included in the payload with no warning to the client.
