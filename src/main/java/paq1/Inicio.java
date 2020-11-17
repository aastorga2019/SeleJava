package paq1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Inicio {

	public static void main(String[] args) {
// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
        String baseUrl = "https://emin.sii.cl/siaginternetui/#!/solicitud/";

        String expectedTitle = "Autenticación";
        String actualTitle = "";
        String tagName = "";
        String dato = "";
        String objeto= "";
               
// Abriendo y levantando URL segpun variable definida
        driver.get(baseUrl);
// get the actual value of the title
        actualTitle = driver.getTitle();

// Validando si estoy parado en la pagina deseada, según titulo esperado
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        tagName = driver.findElement(By.name("rutcntr")).getTagName();
        System.out.println(tagName);
        
        driver.findElement(By.name("rutcntr")).clear();               
        driver.findElement(By.name("rutcntr")).sendKeys("2-7");
        driver.findElement(By.name("clave")).sendKeys("aa11");
        driver.findElement(By.id("bt_ingresar")).click();  
        System.out.println("YA se autentico");

//Entrando a nueva pagina para Continuar y Cambiar Representante       
//Boton continuar
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/p[2]/a[1]")).click();
        System.out.println("Entrando a nueva pagina, despues del continuar...");
        dato = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/app-identificacion-solicitante[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[3]/td[1]")).getText();
        System.out.println(dato);

        if (dato != ""){
//Validando enrrollamiento segun caso de prueba
            System.out.println("Este contribuyente esta enrollado:  " + dato);
        } else {
            System.out.println("Contibuyente NO ENRROLADO, proceder...");
        }

 //Eligiendo tipo de solicitud RAF/ RAV
        objeto= "/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/app-identificacion-solicitante[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[4]/td[1]/select[1]";
        driver.findElement(By.xpath(objeto)).click();
 //Seleccionar datos desde una combo
        Select tsolicitud = new Select(driver.findElement(By.xpath(objeto)));
        tsolicitud.selectByVisibleText("RAV");	//V=RAV y F=RAF
        driver.findElement(By.xpath(objeto)).click();
//Obtener listado de actuaciones                       
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/app-tipo-actuaciones[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")).click();
        
        
//   driver.close();
       System.out.println("Fin proceso ...");
	
	}	
	
}
