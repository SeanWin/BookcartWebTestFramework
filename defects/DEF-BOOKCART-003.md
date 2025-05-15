# Defect Report: DEF-BOOKCART-003

## Title
Book Details page shows “No books found” when refreshed

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
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Click on any book
3. Press the browser’s Refresh button
4. Observe the content

## Expected Result
The same book’s details (title, author, description, etc.) reload correctly after refresh

## Actual Result
The page displays “No books found” and a “Back to Home” button instead of the book details

## Notes
- No console errors are logged

- Likely a routing or data‑fetch issue when loading the details page without application state.

- This affects all books tested

## Status
Open                                                                 