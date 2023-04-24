package rpa;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Automacao {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// Atualiza e roda com a vers�o mais atualizada do webdriver
		WebDriverManager.chromedriver().setup();
	}
/*	
	@After
	public void tearDown() throws Exception {
		// Comando para fechar o navegador
		 driver.quit();
}
*/
	@Test
	public void test() throws NoSuchElementException {		
		// Comando para acessar o site desejado		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--start-maximized");
	    options.addArguments("--disable-extensions");
        WebDriver driver = new ChromeDriver(options);
        
        System.setProperty("webdriver.chrome.logfile", "chromedriver.log");
        System.setProperty("webdriver.chrome.verboseLogging", "true");
        // Acessa o site da FIPE
        driver.get("https://veiculos.fipe.org.br/");

        // Seleciona o tipo de veículo
        
        WebElement tipoCarro = driver.findElement(By.xpath("//*[@id=\"front\"]/div[1]/div[2]/ul/li[1]/a"));
        tipoCarro.click();
        WebElement selectMarcaCarro = driver.findElement(By.xpath("//*[@id=\"selectMarcacarro_chosen\"]/a"));
        selectMarcaCarro.click();
        driver.findElement(By.xpath("//*[@id=\\\"selectMarcacarro_chosen\\\"]/a")).sendKeys("Hyundai", Keys.ENTER);

/*
        // Seleciona a marca do carro
        driver.findElement(By.xpath("//*[@id=\"principal\"]/ul/li[2]/a")).click();
        WebElement hyundai = driver.findElement(By.xpath("//*[@id=\"selectMarcacarro\"]"));
        System.out.println(hyundai);
        wait.until(ExpectedConditions.elementToBeClickable(hyundai)).click();
        System.out.println("clicou");
*/
        
	}
}
