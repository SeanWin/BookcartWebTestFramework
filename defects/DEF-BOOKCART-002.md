# Defect Report: DEF-BOOKCART-002

## Title
“Generate book plot summary using Google Gemini” button spins indefinitely and never loads content

## Environment
Browser: Chrome  
System: macOS

## Reported By
Sean

## Date Reported
2025-05-05

## Severity
MEDIUM

## Priority
MEDIUM

## Precondition
User is not authenticated

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Click on any book
3. Click the Generate book plot summary using Google Gemini button
4. Wait and observe the loading spinner

## Expected Result
A generated plot summary appears below the button once processing completes

## Actual Result
The loading spinner remains visible indefinitely; no summary is ever displayed

## Notes
- No error message or timeout feedback is shown

- Developer console shows no network activity for the Gemini call

- This affects all books tested

## Status
Open                                                                 