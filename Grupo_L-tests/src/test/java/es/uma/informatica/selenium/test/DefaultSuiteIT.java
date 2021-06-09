package es.uma.informatica.selenium.test;

// Generated by Selenium IDE
import org.junit.Test;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultSuiteIT {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@Before
	public void setUp() {
		driver = new FirefoxDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	@Ignore
	@Test
	public void inicioSesion() {
		driver.get("http://localhost:8080/Grupo_L-war/");
		driver.manage().window().setSize(new Dimension(977, 715));
		driver.findElement(By.id("inicio")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
		driver.findElement(By.id("j_idt7:pass")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Rocio."));
	}
	@Ignore
	@Test
	public void logginSecretaria() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(1158, 655));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
	}

	@Ignore
	@Test
	public void leerTitulaSec() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/");
		driver.manage().window().setSize(new Dimension(679, 616));
		driver.findElement(By.id("inicio")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:entrar")).click();
		driver.findElement(By.id("leerTitulacion")).click();
		assertThat(driver.findElement(By.id("titulacion:dtTitulacion:0:j_idt32")).getText(), is("1041"));
		assertThat(driver.findElement(By.id("titulacion:dtTitulacion:4:j_idt32")).getText(), is("1073"));
	}
	@Ignore
	@Test
	public void leertituusu() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/");
		driver.manage().window().setSize(new Dimension(679, 616));
		driver.findElement(By.id("inicio")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
		driver.findElement(By.id("j_idt7:entrar")).click();
		driver.findElement(By.id("leerTitulacion")).click();
		assertThat(driver.findElement(By.id("titulacionalum:dtTitulacion:0:j_idt25")).getText(), is("1041"));
		assertThat(driver.findElement(By.id("titulacionalum:dtTitulacion:1:j_idt25")).getText(), is("1043"));
	}

	@Test
	public void expedienteAlumno() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/");
		driver.manage().window().setSize(new Dimension(679, 616));
		driver.findElement(By.id("inicio")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
		driver.findElement(By.id("j_idt7:entrar")).click();
		driver.findElement(By.id("leerExpediente")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("a"));
			assert(elements.size() > 0);
		}
		assertThat(driver.findElement(By.id("expediente:dtExpediente:0:j_idt26")).getText(), is("104195486"));
		assertThat(driver.findElement(By.id("expediente:dtExpediente:1:j_idt26")).getText(), is("104300002"));
	}
	@Ignore
	@Test
	public void testPrincipalSecretaria() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(1158, 655));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
		{
			List<WebElement> elements = driver.findElements(By.id("leerAlumnos"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerMatricula"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerGrupo"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerExpediente"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerTitulacion"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerEncuesta"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerAsignaturas"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerCentro"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("leerAsigMa"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("exportarDatos"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("importarHorario"));
			assert(elements.size() > 0);
		}
	}
	@Ignore
	@Test
	public void testPrincipalAlumno() {
		driver.get("http://localhost:8080/Grupo_L-war/");
		driver.manage().window().setSize(new Dimension(977, 715));
		driver.findElement(By.id("inicio")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
		driver.findElement(By.id("j_idt7:pass")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Rocio."));
		{
			List<WebElement> elements = driver.findElements(By.id("rellenarEncuesta"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("solicitarCambioGrupo"));
			assert(elements.size() > 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("caja"));
			assert(elements.size() > 0);
		}
		assertThat(driver.findElement(By.linkText("Cerrar Sesion")).getText(), is("Cerrar Sesion"));
	}
	@Ignore
	@Test
	public void testGrupo() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(1158, 655));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
		driver.findElement(By.id("leerGrupo")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("tabla"));
			assert(elements.size() > 0);
		}
		assertThat(driver.findElement(By.id("tabla:dtGrupos:0:j_idt21")).getText(), is("1"));
		assertThat(driver.findElement(By.id("tabla:dtGrupos:6:j_idt21")).getText(), is("7"));
		{
			List<WebElement> elements = driver.findElements(By.id("tabla:crear"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("tabla:crear")).click();
		driver.findElement(By.id("j_idt19:asignar")).click();
		driver.findElement(By.id("j_idt19:asignar")).sendKeys("150");
		driver.findElement(By.id("j_idt19:curso")).click();
		driver.findElement(By.id("j_idt19:curso")).sendKeys("4");
		driver.findElement(By.id("j_idt19:letra")).click();
		driver.findElement(By.id("j_idt19:letra")).sendKeys("B");
		driver.findElement(By.id("j_idt19:turno")).click();
		driver.findElement(By.id("j_idt19:turno")).sendKeys("MANIANA");
		driver.findElement(By.id("j_idt19:ingles")).click();
		driver.findElement(By.id("j_idt19:ingles")).sendKeys("SI");
		driver.findElement(By.cssSelector("table")).click();
		driver.findElement(By.id("j_idt19:plazas")).click();
		driver.findElement(By.id("j_idt19:plazas")).sendKeys("90");
		driver.findElement(By.id("j_idt19:visible")).click();
		driver.findElement(By.id("j_idt19:visible")).sendKeys("90");
		driver.findElement(By.id("j_idt19:titulacion")).click();
		{
			WebElement dropdown = driver.findElement(By.id("j_idt19:titulacion"));
			dropdown.findElement(By.xpath("//option[. = 'Grado en Ingenieria del Software']")).click();
		}
		driver.findElement(By.cssSelector("option:nth-child(2)")).click();
		driver.findElement(By.id("j_idt19:crear")).click();
		driver.findElement(By.cssSelector(".ui-widget-content:nth-child(8) > td:nth-child(1)")).click();
		assertThat(driver.findElement(By.id("tabla:dtGrupos:7:j_idt21")).getText(), is("8"));
		driver.findElement(By.id("tabla:dtGrupos:7:j_idt22")).click();
		assertThat(driver.findElement(By.id("tabla:dtGrupos:7:j_idt22")).getText(), is("4"));
		assertThat(driver.findElement(By.id("tabla:dtGrupos:7:j_idt23")).getText(), is("B"));
		{
			List<WebElement> elements = driver.findElements(By.id("tabla:dtGrupos:7:eliminar"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("tabla:dtGrupos:7:eliminar")).click();
		driver.findElement(By.cssSelector(".ui-widget-content:nth-child(7) > td:nth-child(1)")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("tabla:dtGrupos:7:j_idt21"));
			assert(elements.size() == 0);
		}
		{
			List<WebElement> elements = driver.findElements(By.id("tabla:dtGrupos:6:modificar"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("tabla:dtGrupos:6:modificar")).click();
		driver.findElement(By.id("j_idt19:plazas")).click();
		driver.findElement(By.id("j_idt19:plazas")).clear();
		driver.findElement(By.id("j_idt19:plazas")).sendKeys("180");
		driver.findElement(By.id("j_idt19:modificar")).click();
		driver.findElement(By.cssSelector(".ui-widget-content:nth-child(7) > td:nth-child(8)")).click();
		assertThat(driver.findElement(By.id("tabla:dtGrupos:6:j_idt28")).getText(), is("180"));
	}
	@Ignore
	@Test
	public void testCentro() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(1158, 655));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
		driver.findElement(By.id("leerCentro")).click();
		assertThat(driver.findElement(By.id("centro:dtCentro:0:j_idt21")).getText(), is("1"));
		assertThat(driver.findElement(By.id("centro:dtCentro:0:j_idt22")).getText(), is("E.T.S Ingenieria Informatica"));
		assertThat(driver.findElement(By.id("centro:dtCentro:1:j_idt21")).getText(), is("2"));
		assertThat(driver.findElement(By.id("centro:dtCentro:1:j_idt22")).getText(), is("Escuela de Ingenierias Industriales"));
		{
			List<WebElement> elements = driver.findElements(By.id("centro"));
		}
	}
	@Ignore
	@Test
	public void testAsigMatS() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(826, 694));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
		driver.findElement(By.id("leerAsigMa")).click();
		{
			List<WebElement> elements = driver.findElements(By.id("asigm"));
			assert(elements.size() > 0);
		}
		assertThat(driver.findElement(By.id("asigm:dtAsigM:0:j_idt35")).getText(), is("306000002"));
		assertThat(driver.findElement(By.id("asigm:dtAsigM:1:j_idt35")).getText(), is("306000005"));
		assertThat(driver.findElement(By.id("asigm:dtAsigM:2:j_idt35")).getText(), is("306000001"));
		assertThat(driver.findElement(By.id("asigm:dtAsigM:3:j_idt35")).getText(), is("306000003"));
		assertThat(driver.findElement(By.id("asigm:dtAsigM:4:j_idt35")).getText(), is("306000004"));
		assertThat(driver.findElement(By.id("asigm:dtAsigM:5:j_idt35")).getText(), is("306000006"));
		driver.findElement(By.id("asigm:dtAsigM:matricula:filter")).click();
		driver.findElement(By.id("asigm:dtAsigM:matricula:filter")).sendKeys("306000005");
		driver.findElement(By.id("asigm:dtAsigM:matricula:filter")).sendKeys(Keys.ENTER);
	}
	@Ignore
	@Test
	public void generarNuevaContrasea() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(826, 694));
		driver.findElement(By.linkText("¿Has olvidado tu contraseña?")).click();
		driver.findElement(By.id("j_idt8:email")).click();
		driver.findElement(By.id("j_idt8:passwd")).sendKeys("123");
		driver.findElement(By.id("j_idt8:email")).sendKeys("marta@uma.es");
		driver.findElement(By.id("j_idt8:passwd2")).click();
		driver.findElement(By.id("j_idt8:passwd2")).sendKeys("123");
		driver.findElement(By.name("j_idt8:j_idt19")).click();
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:user")).sendKeys("marta@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Marta."));
		{
			List<WebElement> elements = driver.findElements(By.id("caja"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.linkText("Cerrar Sesion")).click();
	}
	@Ignore
	@Test
	public void leerMatriculaA() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(826, 694));
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:user")).sendKeys("marta@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Marta."));
		{
			List<WebElement> elements = driver.findElements(By.id("caja"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("leerMatricula")).click();
		assertThat(driver.findElement(By.id("j_idt25:dtMat:0:j_idt34")).getText(), is("105600003"));
		assertThat(driver.findElement(By.id("j_idt25:dtMat:0:j_idt29")).getText(), is("306000004"));
		assertThat(driver.findElement(By.id("j_idt25:dtMat:0:j_idt31")).getText(), is("2019-12-29"));
		driver.findElement(By.linkText("Cerrar Sesion")).click();
	}
	@Ignore
	@Test
	public void leerAsignturaA() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(826, 694));
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:user")).sendKeys("marta@uma.es");
		driver.findElement(By.id("j_idt7:pass")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Marta."));
		{
			List<WebElement> elements = driver.findElements(By.id("caja"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("leerAsignaturas")).click();
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt28")).getText(), is("40660"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt29")).getText(), is("Grado en Ingenieria de la Salud"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt30")).getText(), is("103"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt31")).getText(), is("6"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt32")).getText(), is("0"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt33")).getText(), is("6"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt34")).getText(), is("Si"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt35")).getText(), is("EDA"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt36")).getText(), is("3"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt38")).getText(), is("1 Semestre"));
		assertThat(driver.findElement(By.id("j_idt25:dtAsig:0:j_idt39")).getText(), is("No"));
		driver.findElement(By.linkText("Cerrar Sesion")).click();
	}
	@Ignore
	@Test
	public void leerAsignaturaS() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(887, 631));
		driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		driver.findElement(By.cssSelector(".inicio")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
		driver.findElement(By.id("leerAsignaturas")).click();
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:0:j_idt43")).getText(), is("40658"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:0:j_idt44")).getText(), is("Grado en Ingenieria del Software"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:1:j_idt43")).getText(), is("40659"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:2:j_idt43")).getText(), is("40660"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:2:j_idt44")).getText(), is("Grado en Ingenieria de la Salud"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:3:j_idt43")).getText(), is("50658"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:3:j_idt44")).getText(), is("Grado en Ingenieria Informatica"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:4:j_idt43")).getText(), is("50659"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:4:j_idt44")).getText(), is("Grado en Ingenieria Informatica"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:5:j_idt43")).getText(), is("50660"));
		assertThat(driver.findElement(By.id("j_idt41:dtAsignaturas:5:j_idt44")).getText(), is("Doble Grado en Ingenieria Informatica y Matematicas"));
		driver.findElement(By.linkText("Cerrar Sesion")).click();
	}
	@Ignore
	@Test
	public void leerAlumnoA() {
		driver.get("http://0.0.0.0:8080/Grupo_L-war/faces/Login.xhtml");
		driver.manage().window().setSize(new Dimension(826, 694));
		driver.findElement(By.id("j_idt7:user")).click();
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:user")).sendKeys("marta@uma.es");
		driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Marta."));
		{
			List<WebElement> elements = driver.findElements(By.id("caja"));
			assert(elements.size() > 0);
		}
		driver.findElement(By.id("leerAlumnos")).click();
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt26")).getText(), is("57400152C"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt27")).getText(), is("Marta"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt28")).getText(), is("Lopez"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt29")).getText(), is("Perez"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt30")).getText(), is("marta@uma.es"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt31")).getText(), is("IsidreBlancoZambrano@dayrep.com"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt32")).getText(), is("760544184"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt33")).getText(), is("Reisedor 77"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt34")).getText(), is("Almassera"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt35")).getText(), is("MALAGA"));
		assertThat(driver.findElement(By.id("alumnos:dtAlumno:0:j_idt36")).getText(), is("46132"));
		driver.findElement(By.linkText("Cerrar Sesion")).click();
	}
	
	@Ignore
	@Test
	  public void leerEncuestaA() {
		driver.get("http://localhost:8080/Grupo_L-war/");
	    driver.manage().window().setSize(new Dimension(977, 715));
	    driver.findElement(By.id("inicio")).click();
	    driver.findElement(By.id("j_idt7:user")).click();
	    driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).click();
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
	    assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Rocio."));
	    driver.findElement(By.id("leerEncuesta")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("encuesta"));
	      assert(elements.size() > 0);
	    }
	    {
	      List<WebElement> elements = driver.findElements(By.id("caja"));
	      assert(elements.size() > 0);
	    }
	    assertThat(driver.findElement(By.id("encuesta:dtEncuesta:0:j_idt27")).getText(), is("104195486"));
	  }
	@Ignore
	 @Test
	  public void leerEncuestaS() {
		driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
	    driver.manage().window().setSize(new Dimension(1158, 655));
	    driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
	    driver.findElement(By.id("leerEncuesta")).click();
	    assertThat(driver.findElement(By.id("encuestaAlum:dtEncuesta:0:j_idt37")).getText(), is("104100002"));
	    assertThat(driver.findElement(By.id("encuestaAlum:dtEncuesta:0:j_idt39")).getText(), is("2021-06-08 05:54:59.0"));
	    {
	      List<WebElement> elements = driver.findElements(By.id("encuestaAlum"));
	      assert(elements.size() > 0);
	    }
	    assertThat(driver.findElement(By.id("encuestaAlum:dtEncuesta:1:j_idt37")).getText(), is("104195486"));
	    assertThat(driver.findElement(By.id("encuestaAlum:dtEncuesta:1:j_idt39")).getText(), is("2020-06-08 05:55:07.0"));
	}
	 @Ignore
	  @Test
	  public void leerAsigMatrA() {
		  driver.get("http://localhost:8080/Grupo_L-war/");
		    driver.manage().window().setSize(new Dimension(977, 715));
		    driver.findElement(By.id("inicio")).click();
		    driver.findElement(By.id("j_idt7:user")).click();
		    driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
		    driver.findElement(By.id("j_idt7:pass")).click();
		    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		    driver.findElement(By.id("j_idt7:entrar")).click();
		    assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Rocio."));
	    driver.findElement(By.id("leerAsigMa")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("asigmatri"));
	      assert(elements.size() > 0);
	    }
	    assertThat(driver.findElement(By.id("asigmatri:dtAsigM:0:j_idt27")).getText(), is("306000002"));
	    assertThat(driver.findElement(By.id("asigmatri:dtAsigM:1:j_idt27")).getText(), is("306000003"));
	  }
	  @Ignore
	  @Test
	  public void solicitarCambioGrupo() {
		driver.get("http://localhost:8080/Grupo_L-war/");
	    driver.manage().window().setSize(new Dimension(1211,1028));
	    driver.findElement(By.id("inicio")).click();
	    driver.findElement(By.id("j_idt7:user")).click();
	    driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).click();
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
	    assertThat(driver.findElement(By.id("nombre")).getText(), is("Hola, Rocio."));
	    driver.findElement(By.id("solicitarCambioGrupo")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("desplegable"));
	      assert(elements.size() > 0);
	    }
	    {
	      List<WebElement> elements = driver.findElements(By.id("caja"));
	      assert(elements.size() > 0);
	    }
	    driver.findElement(By.id("desplegable:titulacion")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("desplegable:titulacion"));
	      dropdown.findElement(By.xpath("//option[. = 'Grado en Ingenieria Informatica']")).click();
	    }
	    driver.findElement(By.cssSelector("option:nth-child(2)")).click();
	    js.executeScript("window.scrollTo(0,0)");
	    driver.findElement(By.id("desplegable:curso")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("desplegable:curso"));
	      dropdown.findElement(By.xpath("//option[. = '1']")).click();
	    }
	    driver.findElement(By.cssSelector("#desplegable\\3A curso > option:nth-child(2)")).click();
	    js.executeScript("window.scrollTo(0,0)");
	    driver.findElement(By.id("desplegable:letra")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("desplegable:letra"));
	      dropdown.findElement(By.xpath("//option[. = 'B']")).click();
	    }
	    driver.findElement(By.cssSelector("#desplegable\\3Aletra > option:nth-child(3)")).click();
	    js.executeScript("window.scrollTo(0,0)");
	    driver.findElement(By.id("desplegable")).click();
	    driver.findElement(By.id("desplegable:asignatura")).click();
	    {
	      WebElement dropdown = driver.findElement(By.id("desplegable:asignatura"));
	      dropdown.findElement(By.xpath("//option[. = 'Fundamentos Fisicos de la Informatica']")).click();
	    }
	    driver.findElement(By.cssSelector("#desplegable\\3A asignatura > option:nth-child(3)")).click();
	    {
	      WebElement element = driver.findElement(By.id("motivo"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).clickAndHold().perform();
	    }
	    {
	      WebElement element = driver.findElement(By.id("motivo"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).perform();
	    }
	    {
	      WebElement element = driver.findElement(By.id("motivo"));
	      Actions builder = new Actions(driver);
	      builder.moveToElement(element).release().perform();
	    }
	    driver.findElement(By.id("motivo")).click();
	    driver.findElement(By.id("motivo")).sendKeys("hOLA");
	    driver.findElement(By.id("desplegable:aceptar")).click();
	    driver.findElement(By.id("leerAsigMa")).click();
	    assertThat(driver.findElement(By.id("asigmatri:dtAsigM:1:j_idt28")).getText(), is("50659"));
	    assertThat(driver.findElement(By.id("asigmatri:dtAsigM:1:j_idt29")).getText(), is("1"));
	    assertThat(driver.findElement(By.id("asigmatri:dtAsigM:1:j_idt30")).getText(), is("B"));
	  }
	  
	  @Ignore
	  @Test
	  public void alumnoSecretaria() {
	    driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
	    driver.manage().window().setSize(new Dimension(1235, 900));
	    driver.findElement(By.id("j_idt7:user")).click();
	    driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).click();
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
	    driver.findElement(By.id("leerAlumnos")).click();
	    driver.findElement(By.id("j_idt39:dtAlumnos:0:j_idt42")).click();
	    assertThat(driver.findElement(By.id("j_idt39:dtAlumnos:0:j_idt42")).getText(), is("57400152B"));
	    driver.findElement(By.id("j_idt39:dtAlumnos:4:j_idt42")).click();
	    assertThat(driver.findElement(By.id("j_idt39:dtAlumnos:4:j_idt42")).getText(), is("57400152D"));
	    driver.findElement(By.id("j_idt39:dtAlumnos:0:j_idt43")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("j_idt39:crear"));
	      assert(elements.size() > 0);
	    }
	    driver.findElement(By.id("j_idt39:crear")).click();
	    driver.findElement(By.id("j_idt19:user")).sendKeys("79162145D");
	    driver.findElement(By.id("j_idt19:nom")).sendKeys("Alejandro");
	    driver.findElement(By.id("j_idt19:ape")).sendKeys("Merino");
	    driver.findElement(By.id("j_idt19:a2")).sendKeys("Molina");
	    driver.findElement(By.id("j_idt19:e")).sendKeys("ale@uma.es");
	    driver.findElement(By.id("j_idt19:ep")).sendKeys("ale@gmail.com");
	    driver.findElement(By.id("j_idt19:m")).sendKeys("664184557");
	    driver.findElement(By.id("j_idt19:d")).sendKeys("Benamargoas");
	    driver.findElement(By.id("j_idt19:l")).sendKeys("Mijas");
	    driver.findElement(By.id("j_idt19:pr")).sendKeys("Malaga");
	    driver.findElement(By.id("j_idt19:c")).sendKeys("29651");
	    driver.findElement(By.id("j_idt19:c")).sendKeys(Keys.ENTER);
	    assertThat(driver.findElement(By.id("j_idt39:dtAlumnos:5:j_idt42")).getText(), is("79162145D"));
	    driver.findElement(By.id("j_idt39:dtAlumnos:5:Modificar")).click();
	    driver.findElement(By.id("j_idt19:d")).sendKeys("Benamargosa");
	    driver.findElement(By.id("j_idt19:modificar")).click();
	    assertThat(driver.findElement(By.id("j_idt39:dtAlumnos:5:j_idt49")).getText(), is("Benamargosa"));
	    driver.findElement(By.id("j_idt39:dtAlumnos:5:eliminar")).click();
	    {
	      List<WebElement> elements = driver.findElements(By.id("j_idt39:dtAlumnos:5:j_idt42"));
	      assert(elements.size() == 0);
	    }
	  }
	  
	  @Test
	  public void importarHorario(){
	    driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
	    driver.manage().window().setSize(new Dimension(1235, 900));
	    driver.findElement(By.id("j_idt7:user")).click();
	    driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).click();
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
	    driver.findElement(By.id("importarHorario")).click();
	    WebElement element = driver.findElement(By.id("j_idt18:j_idt19_input"));
	    element.sendKeys("/home/alumno/eclipse-workspace/Grupo_L/Grupo_L-ejb/Oferta asignaturas.xlsx");
	    
	    List<WebElement> listBtn = driver.findElements(By.tagName("button"));
	    listBtn.get(0).click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.findElement(By.cssSelector(".inicio > input")).click();
	    driver.findElement(By.linkText("Cerrar Sesion")).click();
	    driver.findElement(By.id("j_idt7:user")).click();
	    driver.findElement(By.id("j_idt7:user")).sendKeys("rocio22@uma.es");
	    driver.findElement(By.id("j_idt7:pass")).click();
	    driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
	    driver.findElement(By.id("j_idt7:entrar")).click();
	    driver.findElement(By.id("leerClase")).click();
	    assertThat(driver.findElement(By.id("clase:dtClase:0:j_idt20")).getText(), is("Calculo para la Computacion"));
	    driver.findElement(By.cssSelector(".ui-widget-content:nth-child(1) > td:nth-child(2)")).click();
	    assertThat(driver.findElement(By.id("clase:dtClase:0:j_idt22")).getText(), is("Lunes"));
	    driver.findElement(By.id("clase:dtClase:0:j_idt24")).click();
	    assertThat(driver.findElement(By.id("clase:dtClase:0:j_idt24")).getText(), is("08:45"));
	    driver.findElement(By.id("clase:dtClase:0:j_idt26")).click();
	    assertThat(driver.findElement(By.id("clase:dtClase:0:j_idt26")).getText(), is("10:30"));
	  }   
	    
	  
	  @Test
	  public void importarExpediente() {
	    driver.get("http://localhost:8080/Grupo_L-war/faces/Login.xhtml");
	    driver.manage().window().setSize(new Dimension(697, 770));
	    driver.findElement(By.id("j_idt7:user")).sendKeys("pepe@uma.es");
		driver.findElement(By.id("j_idt7:pass")).sendKeys("123");
		driver.findElement(By.id("j_idt7:entrar")).click();
		driver.findElement(By.cssSelector(".inicio")).click();
		assertThat(driver.findElement(By.id("nombre2")).getText(), is("Hola, Jefe."));
	    driver.findElement(By.id("leerExpediente")).click();
	    driver.findElement(By.id("z")).click();
	    WebElement element = driver.findElement(By.id("j_idt18:j_idt19_input"));
	    element.sendKeys("/home/alumno/eclipse-workspace/Grupo_L/Grupo_L-ejb/Datos alumnadoFAKE.xlsx");
	    
	    List<WebElement> listBtn = driver.findElements(By.tagName("button"));
	    listBtn.get(0).click();
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    driver.findElement(By.cssSelector(".inicio > input")).click();
	    driver.findElement(By.id("leerExpediente")).click();
	    driver.findElement(By.id("j_idt38:dtExpediente:1:j_idt41")).click();
	    driver.findElement(By.id("j_idt38:dtExpediente:1:j_idt41")).click();
	    driver.findElement(By.id("j_idt38:dtExpediente:1:j_idt41")).click();
	    assertThat(driver.findElement(By.id("j_idt38:dtExpediente:1:j_idt41")).getText(), is("104100003"));
	  }
	}
	    
	  

