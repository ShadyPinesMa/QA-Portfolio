# Bug ID: BUG-SP-04

**Endpoint:** POST /pet/{petId}/uploadImage
**Severity:** High

## Title: API accepts and stores invalid file types without any validation

## Steps to Reproduce:

1. Send POST request to
   https://petstore.swagger.io/v2/pet/10001/uploadImage
2. Set Header: Accept = application/json
3. Set Body to form-data
4. Add key: additionalMetadata (Type: Text)
   Value: "Invalid file type test"
5. Add key: file (Type: File)
   Value: invalid_file_test.txt (plain text file)
6. Send the request

## Expected Result:

400 Bad Request. Endpoint is documented as an
image upload endpoint and should reject non-image
file types with a descriptive validation error

## Actual Result:

200 OK returned. Server accepted the .txt file,
saved it to the filesystem, and confirmed the
upload in the response message:
"File uploaded to ./Invalid_file_test.txt, 52 bytes"

## Impact:

The API performs no file type validation on the
upload endpoint. Any file type can be uploaded
and stored on the server regardless of content.
This has two significant implications:

1. Data Integrity: non-image files are stored
   in what is intended to be an image repository,
   corrupting the purpose of the endpoint

2. Security: combined with the lack of file type
   validation, a malicious user could potentially
   upload harmful file types including executables.
   This represents a significant security risk.

## Severity Justification:

Rated High due to security implications. An
endpoint that accepts and stores any file type
without validation could be exploited to upload
malicious files to the server.

## Related Finding:

Inconsistency with BUG-SP-03. The same
endpoint crashes with 500 when no file is submitted
but accepts and stores any file type when one is
provided. This suggests file type validation is
entirely absent while basic request handling is
also broken.
