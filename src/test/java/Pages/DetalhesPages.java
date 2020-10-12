package Pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DetalhesPages extends PageObject {

    @FindBy(className = "section__title--big")
    private WebElement cargo;

    @FindBy(className = "icon-label")
    private WebElement localidade;

    public DetalhesPages(WebDriver driver) {
        super(driver);
    }

    public String obterCargo() {
        return cargo.getText();
    }

    public String obterLocalidade() {
        return StringUtils.stripAccents(localidade.getText());
    }
}
