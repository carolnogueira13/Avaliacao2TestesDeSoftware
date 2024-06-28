package automatizados.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import automatizados.pageObject.ProdutoPO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING) 
public class ProdutoTest extends BaseTest {

private static ProdutoPO produtoPage;
	
	@BeforeClass
	public static void prepararTestes() {
		// Para direcionar o driver para a pagina de cadastro de produtos 
		driver.get("file:///C:/Users/36124872022.2N/Downloads/sistema/sistema/produtos.html");
		produtoPage = new ProdutoPO(driver);
		produtoPage.abrirModal();
	}
	
	@AfterClass
	public static void aposTestes() {
		produtoPage.inputCodigo.clear();
		produtoPage.inputNome.clear();
		produtoPage.inputQuantidade.clear();
		produtoPage.inputValor.clear();
		produtoPage.inputData.clear();
		produtoPage.sair();
	}
	
	/**
	 * Metodo que realiza o teste basico da cadastro de um produto com todos os campos da tela de cadastro 
	 * de produtos em branco
	 * 
	 * @author Ana Caroline
	 * @date 28/06/2024
	 */
	@Test
	public void TC001_naoDevePermitirCadastrarProdutoComTodosOsCamposVazios() {

		produtoPage.executarPreencherDadosProduto("", "", "", "", "");
		
		String resultado = produtoPage.obterMensagem();
		
		assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");	
		
	}
	
	/**
	 * Metodo que realiza o teste basico da cadastro de um produto com os campos "Nome", "Quantidade", "Valor" 
	 * e "Data" preenchidos da tela de cadastro de produtos e o campo "Codigo" em branco
	 * 
	 * @author Ana Caroline
	 * @date 28/06/2024
	 */
	@Test
	public void TC002_naoDevePermitirCadastrarProdutoComOCampoCodigoVazioETodosOsOutrosCamposPreenchidos() {	

		produtoPage.executarPreencherDadosProduto("", "geladeira", "2", "2000", "2024-06-28");
		
		String resultado = produtoPage.obterMensagem();
		
		assertEquals(resultado, "Todos os campos são obrigatórios para o cadastro!");
		
	}
	
	/**
	 * Metodo que realiza o teste basico da cadastro de um produto com todos os campos da tela de cadastro de produtos preenchidos
	 * 
	 * @author Ana Caroline
	 * @date 28/06/2024
	 */
	@Test
	public void TC003_devePermitirCadastrarProdutoComTodosOsCamposPreenchidos() {
		
		String textoCodigo = "1";

		produtoPage.executarPreencherDadosProduto(textoCodigo, "geladeira", "2", "2000", "2024-06-28");
		
		// Texto do input de Codigo apos cadastrar um produto
		String codigo = produtoPage.inputCodigo.getText();
		
		// Texto da primeira linha da tabela na coluna de "Codigo"
		String codigoDaTabela = produtoPage.obterCodigoDaTabela();
		
		assertEquals(codigo, "");
		assertEquals(codigoDaTabela, textoCodigo);
	}
	

}
