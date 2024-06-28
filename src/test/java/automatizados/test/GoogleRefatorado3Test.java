package automatizados.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import automatizados.pageObject.GooglePO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)  // anotação para fixar a ordem dos textos
public class GoogleRefatorado3Test extends BaseTest {
	
	private static GooglePO googlePage;
	
	@BeforeClass
	public static void prepararTestes() {
		driver.get("https://google.com");
		googlePage = new GooglePO(driver);
		
	}
	
	@Test
	public void pesquisarNoGoogle1() {
		googlePage.inputPesquisa.sendKeys("receita de bolo de banana" + Keys.ENTER);
		
		String resultado = googlePage.divPesq.getText();
		
		assertTrue(resultado, resultado.contains("relacionadas"));
		
	}
	
	@Test
	public void pesquisarNoGoogle2() {
//		googlePage.inputPesquisa.sendKeys("receita de bolo de banana" + Keys.ENTER);
		googlePage.pesquisar("receita de bolo de chocolate");
		
//		String resultado = googlePage.divPesq.getText();
		String resultado = googlePage.obterResultadoDaPesquisa();
		
		assertTrue(resultado, resultado.contains("relacionadas"));
		
	}

}
