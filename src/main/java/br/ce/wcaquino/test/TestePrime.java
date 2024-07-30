package br.ce.wcaquino.test;
import static br.ce.wcaquino.core.DriverFactory.getDriver;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.wcaquino.core.DSL;
import br.ce.wcaquino.core.DriverFactory;


public class TestePrime {
	
	private DSL dsl;

	@Before
	public void inicializa(){
		dsl = new DSL();
	}
	
	@After
	public void finaliza(){
		DriverFactory.killDriver();
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
		getDriver().get("https://www.primefaces.org/showcase/ui/input/oneMenu.xhtml"); 
		dsl.clicarCheck("//*[@id='j_idt248:option']/div[2]");
		dsl.selecionarComboPrime("j_idt248:option_items", "Option3");
//		dsl.clicarNoCheck("//*[@id='j_idt248:option_items']//li[.='Option2']");
		Assert.assertEquals("Option3", dsl.obterTexto("j_idt248:option"));
		
	}
}
