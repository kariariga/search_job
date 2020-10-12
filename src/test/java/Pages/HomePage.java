package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends PageObject {

    @FindBy(className = "jobs-filter__input")
    private WebElement busca;

    @FindBy(xpath = "//h5[contains(text(), 'Cidade')]")
    private WebElement comboLocalidades;

    @FindBy(id = "facet-body-c")
    private WebElement opcoes;

    @FindBy(xpath = "//input[contains(@id, 'Paulo')]/..")
    private WebElement opSaoPaulo;

    @FindBy(xpath = "//input[@id='c-Curitiba']/..")
    private WebElement opCuritiba;

    @FindBy(xpath = "//input[@id='c-Rio de Janeiro']/..")
    private WebElement opRioJaneiro;

    @FindBy(className = "no-jobs")
    private WebElement semVagas;

    @FindBy(className = "vg-card-oportunidades")
    List<WebElement> vagas;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void preencherCargo(String cargo) {
        busca.sendKeys(cargo);
    }

    public void selecionarLocalidade(String cidade) {
        comboLocalidades.click();
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        wait.until(ExpectedConditions.elementToBeClickable(opcoes));

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (cidade) {
            case "Curitiba": opCuritiba.click();
                break;
            case "Rio de Janeiro": opRioJaneiro.click();
                break;
            case "Sao Paulo": opSaoPaulo.click();
                break;
            default:
                System.out.println("opção não existe");
        }
    }

    public DetalhesPages selecionarVaga(String cargo) {
        for (WebElement v :vagas) {
            String valor = v.findElement(By.className("box__title")).getText();

            if (valor.contains(cargo)) {
                v.findElement(By.className("button__text")).click();
                break;
            }
        }
        return new DetalhesPages(driver);
    }
}
