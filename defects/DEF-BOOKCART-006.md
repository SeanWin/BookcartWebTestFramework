# Defect Report: DEF-BOOKCART-006

## Title
Cart quantity resets to 0 after page refresh when logged out

## Environment
Browser: Chrome  
System: macOS

## Reported By
Sean

## Date Reported
2025-05-23

## Severity
HIGH

## Priority
MEDIUM

## Precondition
- User is not authenticated
- Cart is empty at start

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Search for any book (e.g. “Roomies”) and click Add to Cart
3. Observe cart icon badge shows 1
4. Press the browser Refresh button
5. Observe cart icon badge immediately shows 0
6. Click the Cart icon
7. Observe cart icon badge updates back to 1

## Expected Result
- After refreshing the page, the cart icon badge should continue to show 1 (the item remains in the cart even when logged out).

## Actual Result
- Immediately after refresh the badge shows 0, suggesting the cart was cleared in the UI.
- Only after clicking the cart icon does the badge correct itself back to 1.

## Notes
- This only occurs when the user is not logged in.

## Status
Open                                                                 