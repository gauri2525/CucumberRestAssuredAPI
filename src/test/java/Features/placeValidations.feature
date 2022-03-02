Feature: Validating Place API

Scenario: Verify if place is successfully added using AddPlace API.
Given Add Place Payload
When user calls "AddPlaceAPI" with POST http request.
Then the API call is success with status code 200
And "status" in response body is "OK".
And "scope" in response body is "APP". 