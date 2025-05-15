# Defect Report: DEF-BOOKCART-005

## Title
Book details mismatch: cover image does not match book metadata for "Magic for Liars"

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
2. Search for Magic for Liars and click the book
3. Observe the cover image and compare it with the title, author, and other metadata

## Expected Result
The cover image for Magic for Liars

## Actual Result
The cover image for Evvie Drake Starts Over

## Notes
- This may confuse users and affect purchasing decisions

- Other metadata (price, author, category) appears correct

- Image file may be incorrectly linked in the database or frontend

## Status
Open                                                                 