package rpa;


import java.util.List;
import java.util.Scanner;

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

public class Automacao{
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		// Atualiza e roda com a vers�o mais atualizada do webdriver
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void test() throws NoSuchElementException {	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite a marca do Carro:");
		String strMarca = sc.nextLine();
		System.out.println("Digite o modelo do Carro");
		String strModelo = sc.nextLine();
		sc.nextLine();
		System.out.println("Digite o Ano do Carro");
		String strAno = sc.nextLine();
		sc.close();
		
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
        WebElement element = driver.findElement(By.xpath("//*[@id=\"selectMarcacarro_chosen\"]/a"));
        element.click();
        driver.findElement(By.xpath("//*[@id=\"selectMarcacarro_chosen\"]/a"));
        element.click();
        //Seleciona a marca do carro
        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"selectMarcacarro_chosen\"]/div/div/input"));
        element1.sendKeys(strMarca, Keys.ENTER);
          
        //Seleciona o modelo do Carro
        WebElement selectModel = driver.findElement(By.xpath("//*[@id=\"selectAnoModelocarro_chosen\"]/a"));
        selectModel.click();        
        WebElement model = driver.findElement(By.xpath("//*[@id=\"selectAnoModelocarro_chosen\"]/div/div/input"));
        model.sendKeys(strModelo, Keys.ENTER);
        
        //Seleciona o modelo do Carro
        WebElement selectAno = driver.findElement(By.xpath("//*[@id=\"selectAnocarro_chosen\"]/a"));
        selectAno.click();        
        WebElement ano = driver.findElement(By.xpath("//*[@id=\"selectAnocarro_chosen\"]/div/div/input"));
        ano.sendKeys(strAno, Keys.ENTER);  
      
        
        WebElement enter = driver.findElement(By.xpath("//*[@id=\"buttonPesquisarcarro\"]"));
        enter.click();
        
        
        WebElement tabela = driver.findElement(By.tagName("table"));
        List<WebElement> linhas = tabela.findElements(By.tagName("tr"));
        for (WebElement linha : linhas) {
            List<WebElement> colunas = linha.findElements(By.tagName("td"));
            for (WebElement coluna : colunas) {
                System.out.print(coluna.getText() + "\t");
            }
            System.out.println();
        }
        driver.quit();
	}
}
