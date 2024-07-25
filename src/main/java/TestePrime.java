import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestePrime {
	
	private WebDriver driver;
	private DSL dsl;

	@Before
	public void inicializa(){
		driver = new FirefoxDriver();
		driver.manage().window().setSize(new Dimension(1200, 765));
		driver.get("https://www.primefaces.org/showcase/ui/input/oneRadio.xhtml");
		dsl = new DSL(driver);
	}
	
	@After
	public void finaliza(){
//		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioPrime() {
		dsl.clicarRadio(By.xpath("//input[@id='j_idt249:line:2']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:2"));
		dsl.clicarRadio(By.xpath("//label[.='Option2']/../..//span"));
		Assert.assertTrue(dsl.isRadioMarcado("j_idt249:line:1"));
	}
	
	@Test 
	public void deveInteragirComSelectPrime() {
		driver.get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml"); 
		dsl.clicarNoCheck("//*[@id='j_idt248:option']/div[2]");
		dsl.selecionarComboPrime("j_idt248:option_items", "Option3");
//		dsl.clicarNoCheck("//*[@id='j_idt248:option_items']//li[.='Option2']");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt248:option"));
		
	}
}
