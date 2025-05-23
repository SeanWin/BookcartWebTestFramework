# Defect Report: DEF-BOOKCART-007

## Title
Cart items lost when redirecting to checkout after login

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
HIGH

## Precondition
- User is not authenticated
- Cart is empty at start

## Steps to Reproduce
1. Go to [https://bookcart.azurewebsites.net](https://bookcart.azurewebsites.net)
2. Search for any book (e.g. “Roomies”) and click Add to Cart
3. Click the Checkout button
4. You are redirected to the Login page
5. Log in with valid credentials
6. You are redirected to the Checkout page

## Expected Result
- After logging in, the checkout page should display the cart contents and allow order completion.

## Actual Result
- The checkout page displays: “There are no items in your cart.”
- Cart is empty, and the item added before login is not retained

## Notes
- Returning to the homepage or clicking the cart icon also confirms the cart is empty post-login
- This issue results in loss of user cart state across the login process when starting checkout while logged out

## Status
Open                                                                 