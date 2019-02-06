package simulaCompra;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 
public class simulaCompra {
	// Declarando um objeto do tipo WebDriver, utilizado pelo Selenium WebDriver.
    private static WebDriver driver;
 
    // Método que inicia tudo que for necessário para o teste
    // Cria uma instância do navegador e abre a página inicial da DevMedia.
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.gecko.driver", "/home/gravina/eclipse-workspace/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("http://automationpractice.com/");
    }
 
    // Método que Acessa a categoria.
    @Test
    public void acessaCategoria() {
    	driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();
//		String a = driver.findElement(By.cssSelector("div.product-container.div.span")).getText();
		String a = driver.findElement(By.cssSelector("itemprop='price'")).getText();
		System.out.println(a);
    }
    
    // Método que finaliza o teste, fechando a instância do WebDriver.    
    @AfterClass
    public static void tearDownTest(){
        driver.quit();
    }
}
