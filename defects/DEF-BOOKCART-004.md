# Defect Report: DEF-BOOKCART-004

## Title
Deep‑linking to `/books/details/{id}` shows “No books found”

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
User is not already on the site (fresh browser tab)

## Steps to Reproduce
1. Open a new browser tab
2. Paste a book details URL directly (e.g. https://bookcart.azurewebsites.net/books/details/2)
3. Press Enter
4. Observe the content

## Expected Result
The book details for ID 2 are displayed (same as clicking from Home)

## Actual Result
The page displays “No books found” and a “Back to Home” button instead of the book details

## Notes
- The book details can be accessed if you navigate via the Home → book card link, but Direct deep‑links should work for bookmarking/shareability

- Likely a routing or data‑fetch issue when loading the details page without application state.

- This affects all books tested

## Status
Open                                                                 