package automatizados.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleFirstTest {
	
	private WebDriver driver;
	private String URL_BASE = "https://google.com";
	private String PATH_DRIVE = "src/test/resources/chromedriver.exe";
	
	private void iniciar() {
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver(); // Abre o navegador 
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenario
		iniciar();
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.name("q")); // faz o cursor do selenium chegar na entrada de texto do campo de busca do google
		
		//Execução
		inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);
		
		String resultado = driver.findElement(By.id("result-stats")).getText();
		
		//Verificacao e analise
		assertTrue(resultado, resultado.contains("Aproximadamente"));
		
		//Finalizaçao
		driver.quit();
		
	}
	

}
