package TESTNG_AMAZONPURCHASING.TESTNG_AMAZONPURCHASING;



import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class purchasingproduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\MAVEN\\Driver\\chromedriver.exe" );
		driver = (WebDriver) new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.amazon.in/");
		
		//Sign in
		WebElement sign = driver.findElement(By.xpath("//span[text()='Hello, Sign in']"));
		sign.click();
		//Email or Phone number
		WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
		email.click();
		email.sendKeys("8148874148");
		driver.findElement(By.xpath("//input[@id='continue']")).click();
	    //Password
		WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
		password.click();
		password.sendKeys("204029970");
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		
		//Click Mini Cart
		driver.findElement(By.xpath("(//span[@class='nav-line-2'])[3]")).click();
		
		// Validate whether cart is not empty
		String Cartnotempty = driver.findElement(By.xpath("//div[@class='a-row']//child::h1")).getText();
		System.out.println(Cartnotempty);
		
		
		if (Cartnotempty.equalsIgnoreCase("Shopping Cart"))
		{
		List<WebElement> CartItems = driver.findElements(By.xpath("//input[@value='Delete']")); // Get the list of items in cart
		int Cartscount = CartItems.size(); // count of the list of items 
		System.out.println(Cartscount); 
		for(int i=0 ;i<Cartscount; i++) // for loop for delete the list of items
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[@value='Delete']")).click(); // delete the list of items
			Thread.sleep(2000);	
			 WebElement Homepage =	driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
			 Homepage.click();
		}
		}
		else // if cart is empty go to homepage
		{
		 WebElement Homepage =	driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		 Homepage.click();
		}
		//searchbox
		WebElement searchbox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		searchbox.click();
		searchbox.sendKeys("Mobile");
		searchbox.sendKeys(Keys.ENTER);
		//first element
		WebElement Element =  driver.findElement(By.xpath("(//img[@class='s-image'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()", Element);//locate element by using scroll into view
		Element.click();
		//window handle
		String parentwindow = driver.getWindowHandle();//get the parent window id
		Set<String> Set = driver.getWindowHandles();// get all the window id in string
		Iterator<String> it = Set.iterator();//using iterator for switch to childwindow
		while(it.hasNext())
		{
			String Childwindow = it.next();
			 if (!parentwindow.equalsIgnoreCase(Childwindow))
			 {
				 driver.switchTo().window(Childwindow);
				WebElement Addtocart = driver.findElement(By.xpath("//input[@title='Add to Shopping Cart']"));//add to cart
				JavascriptExecutor js1 = (JavascriptExecutor)driver;
				js1.executeScript("arguments[0].scrollIntoView()", Addtocart);
				Addtocart.click();
				 
			 }
		
		}
		
		
		
		
	
		
	

	}

}
