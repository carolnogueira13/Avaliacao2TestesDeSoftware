package automatizados.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.Keys;

import automatizados.pageObject.GooglePO;

public class GoogleRefatorado2Test extends BaseTest{
	
	private static GooglePO googlePage;
	
//	@Test
//	public void pesquisarNoGoogle() {
//		//Montagem do cenário já é feita quando são chamados @BeforeCLass -> public static void iniciar()
//		
//		//Preparação
//		WebElement inputPesquisa = driver.findElement(By.name("q"));
//		
//		//Execução
//		inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
//				
//		String resultado = driver.findElement(By.id("result-stats")).getText();
//				
//		//Verificação e análise
//		assertTrue(resultado, resultado.contains("Aproximadamente"));
//	}
	
	@Test
	public void pesquisarNoGoogle2() {
		
		googlePage.inputPesquisa.sendKeys("Receita de bolo de laranja" + Keys.ENTER);
				
		String resultado = googlePage.divResultadoPesquisa.getText();
				
		//Verificação e análise
		assertTrue(resultado, resultado.contains("resultados"));
	}
}
