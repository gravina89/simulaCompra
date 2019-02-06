package simulaCompra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class teste {
	static WebDriver driver ;
	
	public static void main(String[] args) {
		//System.setProperty("webdriver.gecko.driver.driver", "/home/gravina/eclipse-workspace/geckodriver");
		System.setProperty("webdriver.gecko.driver", "/home/gravina/eclipse-workspace/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to("http://automationpractice.com/");
		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul/li[2]")).click();
		String a = driver.findElement(By.xpath("//div[@class='product-container']/div")).getText();
		System.out.println(a);
	}

}
