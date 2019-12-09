package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.BrowserUtils;

public class VehiclesPage extends BasePage {

    @FindBy(css = "[title='Create Car']")
    public WebElement createACarElement;

    public void clickToCreateACar(){
        /**
         * Use this method to click on "Create a Car" button
         * Method already contains waits to handle synchronization issues
         */
        BrowserUtils.waitForVisibility(createACarElement, 10);
        BrowserUtils.waitForVisibility(createACarElement, 10);
        createACarElement.click();

    }











}
