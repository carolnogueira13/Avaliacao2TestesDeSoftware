package automatizados.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleRefatorado1Test extends BaseTest {
	
	@Test
	public void pesquisarNoGoogle() {
		//Montagem do cenario já é feita quando são chamados 
		//@BeforeClass -> public static void iniciar()
		
		//Preparação
		WebElement inputPesquisa = driver.findElement(By.name("q")); // faz o cursor do selenium chegar na entrada de texto do campo de busca do google
		
		//Execução
		inputPesquisa.sendKeys("receita de bolo de laranja" + Keys.ENTER);
		
		String resultado = driver.findElement(By.id("result-stats")).getText();
		
		//Verificacao e analise
		assertTrue(resultado, resultado.contains("Aproximadamente"));
	}

}
