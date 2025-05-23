# Defect Report: DEF-BOOKCART-009

## Title
Search box on My Orders page does not filter results

## Environment
Browser: Chrome  
System: macOS

## Reported By
Sean

## Date Reported
2025-05-23

## Severity
MEDIUM

## Priority
MEDIUM

## Precondition
- User is authenticated
- User has multiple orders in their history

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Navigate to the My Orders page
3. Enter a specific Order ID or date substring (e.g. “329-955297” or “May 22”)
4. Press Enter

## Expected Result
- The table should refresh to show only the orders matching the search term.
- If no match is found, the table should display a message e.g. “No orders found.”

## Actual Result
- After performing the search, all orders remain visible and no filtering occurs.
- No feedback or “no orders found” message appears for non‐matching terms.

## Notes
- The search box’s input value changes, but no network request or table update is observed.

## Status
Open                                                                 