import org.example.pages.FindBugsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortProductsTest extends BaseTest {

    @Test
    public void checkProductsSortingByPrice() throws MalformedURLException {
        // Open Find Bugs page, expand sorting list and select sort by price (Low-to-High)
        FindBugsPage findBugsPage = new FindBugsPage(driver);
        findBugsPage.sortProducts();

        //Get prices of all products on the list
        List<Double> productPrices = findBugsPage.getListOfAllProductPrices();

        //Create new list with products sizes and sort it by means of programming code
        List<Double> sortedPrices = new ArrayList<>(productPrices);
        Collections.sort(sortedPrices);

        //Verify that list of prices on the page equals to the list of prices sorted by Java
        Assert.assertEquals(productPrices, sortedPrices);
    }
}
