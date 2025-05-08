# Manual Test Case: User Registration

**Title**: Verify user can register successfully with valid data

## Preconditions
- User is on the **Home page**
- Browser is launched and application is reachable

## Test Steps

| Step No. | Action                                                                 | Expected Result                                                              |
|----------|------------------------------------------------------------------------|------------------------------------------------------------------------------|
| 1        | Click on the **Login** button in the navigation bar                    | User is redirected to the **Login page**                                    |
| 2        | Click on the **Register** button/link                                  | User is redirected to the **Registration page**                             |
| 3        | Enter `First` in the **First Name** field                              | Field accepts input                                                          |
| 4        | Enter `Last` in the **Last Name** field                                | Field accepts input                                                          |
| 5        | Enter a **unique username**, e.g. `testuser{timestamp}`                | Field accepts input                                                          |
| 6        | Enter a **valid password**, e.g. `Password1`                           | Field accepts input and meets password criteria                             |
| 7        | Enter the **same password** in the **Confirm Password** field          | Field accepts input                                                          |
| 8        | Select a gender option (e.g. **Male**)                                 | Option is selected                                                           |
| 9        | Click the **Register** button                                          | Registration is processed                                                    |
| 10       | Observe and verify the **toast message** or alert                      | Message: “Registration successful” is displayed                             |
| 11       | Click **Login** and enter the new credentials                         | User is redirected to Login page and can enter credentials                  |
| 12       | Click **Login** button after entering credentials                      | User is logged in and redirected to the Home page, username is visible      |

## Postconditions
- New user is registered
- User is logged in

## Notes
- Use `System.currentTimeMillis()` to generate unique usernames manually (e.g., `testuser1683481266732`)
- Confirm all fields clear properly between runs to avoid autofill issues
