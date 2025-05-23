# Defect Report: DEF-BOOKCART-008

## Title
Items per page selector on My Orders page has no effect

## Environment
Browser: Chrome  
System: macOS

## Reported By
Sean

## Date Reported
2025-05-23

## Severity
LOW

## Priority
LOW

## Precondition
- User is authenticated
- User has more than 10 past orders

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Navigate to the My Orders page
3. Observe the default “Items per page” selector (showing 5 by default) but all orders are displayed
4. Change the selector to 10
5. Observe that the page continues to display all orders, unaffected by the selection

## Expected Result
- Selecting 5, 10, 25, or 50 in the “Items per page” dropdown should limit the number of orders displayed to that quantity, with pagination controls as needed.

## Actual Result
- Regardless of the chosen value, all orders are displayed on a single page and pagination controls do not appear or function.

## Notes
- The dropdown’s displayed value changes, but the table content does not update.

## Status
Open                                                                 