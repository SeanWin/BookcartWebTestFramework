# Defect Report: DEF-BOOKCART-001

## Title
Error message isn't shown on login with invalid credentials

## Environment
Browser: Chrome  
System: macOS

## Reported By
Sean

## Date Reported
2025-05-05

## Severity
HIGH

## Priority
HIGH

## Precondition
User is not authenticated

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net/login](https://bookcart.azurewebsites.net/login)
2. Enter any wrong credentials in the username and password fields
3. Press the login button

## Expected Result
A message should inform the user that the username or password is invalid.

## Actual Result
No error message is shown.

## Notes
Checking the browser console shows the request is unauthorised:  
`Failed to load resource: the server responded with a status of 401 ()`

## Status
Open                                                                 