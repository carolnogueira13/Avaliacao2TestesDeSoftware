package automatizados.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizados.pageObject.LoginPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class LoginTest extends BaseTest {

private static LoginPO loginPage;
	
	@BeforeClass
	public static void prepararTestes() {
		loginPage = new LoginPO(driver);	
	}
	
	/*@AfterClass
	public static void aposTestes() {
		loginPage.inputEmail.clear();
		loginPage.inputSenha.clear();
	}*/
	
	@Test
	public void TC001_naoDeveLogarNoSistemaComEmailESenhaVazios() {
		//loginPage.inputEmail.sendKeys("");
		//loginPage.inputSenha.sendKeys("");
		
		//melhoria 01
		//loginPage.escrever(loginPage.inputEmail,"");
		//loginPage.escrever(loginPage.inputEmail,"");
		
		//melhoria 02
		loginPage.executarAcaoDeLogar("","");
		
		
		//loginPage.buttonEntrar.click();
		
		//Mlehoria 03 
		String resultado = loginPage.obterMensagem();
		
		
		assertEquals(resultado, "Informe usuário e senha, os campos não podem ser brancos.");	
	}
	
	@Test
	public void TC002_naoDeveLogarNoSistemaComEmailPreenchidoESenhaVazia() {
		//loginPage.inputEmail.sendKeys("teste");
		//loginPage.inputSenha.sendKeys("");
		
		//loginPage.buttonEntrar.click();
		
		loginPage.executarAcaoDeLogar("teste","");
		
		String resultado = loginPage.obterMensagem();
		
		assertEquals(resultado, "Informe usuário e senha, os campos não podem ser brancos.");	
	}
	
	@Test
	public void TC003_naoDeveLogarNoSistemaComEmailVazioESenhaPreenchida() {
		//loginPage.inputEmail.sendKeys("");
		//loginPage.inputSenha.sendKeys("teste");
		
		//loginPage.buttonEntrar.click();
		
		loginPage.executarAcaoDeLogar("","teste");
		
		String resultado = loginPage.obterMensagem();
		
		assertEquals(resultado, "Informe usuário e senha, os campos não podem ser brancos.");	
	}
	
	@Test
	public void TC004_naoDeveLogarNoSistemaComEmailErradoESenhaErrada() {
		
		loginPage.executarAcaoDeLogar("teste","teste");
		
		String resultado = loginPage.obterMensagem();
		
		assertEquals(resultado, "E-mail ou senha inválidos");	
	}
	
	@Test
	public void TC005_naoDeveLogarNoSistemaComEmailCertoESenhaErrada() {
		
		loginPage.executarAcaoDeLogar("admin@admin.com","teste");
		
		String resultado = loginPage.obterMensagem();
		
		assertEquals(resultado, "E-mail ou senha inválidos");	
	}
	
	@Test
	public void TC006_naoDeveLogarNoSistemaComEmailErradoESenhaCerta() {
		
		loginPage.executarAcaoDeLogar("teste","admin@123");
		
		String resultado = loginPage.obterMensagem();
		
		assertEquals(resultado, "E-mail ou senha inválidos");	
	}
	
	@Test
	public void TC007_DeveLogarNoSistemaComEmailCertaESenhaCerta() {
		
		loginPage.executarAcaoDeLogar("admin@admin.com","admin@123");
		
		String paginaAtual = driver.getCurrentUrl();
		
		assertEquals(paginaAtual, "file:///C:/Users/36124872022.2N/Downloads/sistema/sistema/produtos.html?teste=123");	
	}

}
