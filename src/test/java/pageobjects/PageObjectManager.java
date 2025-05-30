package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    public WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public RegisterPage registerPage;
    public BookDetailsPage bookDetailsPage;
    public ShoppingCartPage shoppingCartPage;
    public WishlistPage wishlistPage;
    public CheckoutPage checkoutPage;
    public MyOrderDetailsPage myOrderDetailsPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage(driver);
        return homePage;
    }

    public LoginPage getLoginPage() {
        loginPage = new LoginPage(driver);
        return loginPage;
    }

    public RegisterPage getRegisterPage() {
        registerPage = new RegisterPage(driver);
        return registerPage;
    }

    public BookDetailsPage getBookDetailsPage() {
        bookDetailsPage = new BookDetailsPage(driver);
        return bookDetailsPage;
    }

    public ShoppingCartPage getShoppingCartPage() {
        shoppingCartPage = new ShoppingCartPage(driver);
        return shoppingCartPage;
    }

    public WishlistPage getWishlistPage() {
        wishlistPage = new WishlistPage(driver);
        return wishlistPage;
    }

    public CheckoutPage getCheckoutPage() {
        checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }

    public MyOrderDetailsPage getMyOrderDetailsPage() {
        myOrderDetailsPage = new MyOrderDetailsPage(driver);
        return myOrderDetailsPage;
    }
}
