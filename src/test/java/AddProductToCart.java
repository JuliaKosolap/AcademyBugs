import org.example.pages.FindBugsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToCart extends BaseTest {

    @Test
    public void addFirstProductToCart() throws Exception {
        FindBugsPage findBugsPage = new FindBugsPage(driver);

        //Add product to the cart; if "Add To Cart" button is not available for this product throw exception
        findBugsPage.addProductToCart(1);

        //Verify that button was changed to "Chekout Now";
        //This is only one of possible verifications; also we need to verify if this product is present in the Cart
        //and it has appropriate title, price and amount there
        String buttonName = findBugsPage.getButtonName(1);
        Assert.assertEquals(buttonName, "CHECKOUT NOW");
    }

}
