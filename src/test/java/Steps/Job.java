package Steps;

import Pages.DetalhesPages;
import Pages.HomePage;
import Utils.Global;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Job {
    WebDriver driver;
    HomePage home;
    DetalhesPages detalhes;

    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", Global.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Dado("^que o usuario acessa o site de vaga$")
    public void queOUsuarioAcessaOSiteDeVaga() {
        driver.get(Global.URL);
    }

    @E("^preenche o campo de busca com \"([^\"]*)\"$")
    public void preencheOCampoDeBuscaCom(String cargo) {
        home.preencherCargo(cargo);
    }

    @E("^seleciona a \"([^\"]*)\" para exibir o resultado da busca$")
    public void selecionaA(String localidade) {
        home.selecionarLocalidade(localidade);
    }

    @Quando("^o usuario clicar na vaga do \"([^\"]*)\" desejado$")
    public void oUsuarioClicarNaVagaDoDesejado(String cargo) {
       detalhes = home.selecionarVaga(cargo);
    }

    @Entao("^visualiza o \"([^\"]*)\" e a \"([^\"]*)\" na vaga exibida$")
    public void visualizaOEANaVagaExibida(String cargo, String localidade) {
        Assert.assertTrue(detalhes.obterCargo().contains(cargo));
        Assert.assertTrue(detalhes.obterLocalidade().contains(localidade));
    }

}
