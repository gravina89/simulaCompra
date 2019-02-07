package simulaCompra;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class simulaCompra {
    private static WebDriver driver;
    private static String url = "http://automationpractice.com/";
    @BeforeClass
    public static void setUpTest(){
    	System.setProperty("webdriver.gecko.driver", "../geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to(url);
    }
 
    @Test
    public void realizaCompra() {
    	acessaCategoria();
    	incluirProduto();
    	concluiCompra();
    }
    
    private void concluiCompra() {
    	aguardaVisibilidadeClicar("//p[@class='cart_navigation clearfix']/a");
    	realizaLogin();
    	driver.findElement(By.name("processAddress")).submit();
	}

	private void incluirProduto() {
    	driver.findElement(By.xpath("//div[@class='product-container']")).click();
    	driver.findElement(By.xpath("//button[@class='exclusive']")).click();
    	aguardaVisibilidadeClicar("//div[@class='button-container']/a[@title='Proceed to checkout']");
    }

	private void aguardaVisibilidadeClicar(String xpathClick) {
		WebElement element = driver.findElement(By.xpath(xpathClick));
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOf(element));
    	element.click();
	}

	private void acessaCategoria() {
    	driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();
    }
    
    private void realizaLogin() {    		
    	WebElement email = driver.findElement(By.id("email"));
    	email.sendKeys("rafaelgravina@hotmail.com");
    	WebElement senha = driver.findElement(By.id("passwd"));
    	senha.sendKeys("123456789");
    	driver.findElement(By.id("SubmitLogin")).click();
    }
    
    
    @AfterClass
    public static void tearDownTest(){
//        driver.quit();
    }
}
