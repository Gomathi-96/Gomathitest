package task;



import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class methodcalling {
	 public static void main(String[] args) {
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.flipkart.com/");

		 WebElement closebutton = driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		 closebutton.click();
		       
		     WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		     search.sendKeys("iphone",Keys.ENTER);
		     
		     Map<String, String> m = new TreeMap<String, String>();
		     
		     List<WebElement> li = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		    
		// for(WebElement x: li) { //enhance for loop
		// String prod = x.getText();
		//// System.out.println(prod);
		 
		     List<WebElement> rate = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']")); 
		// for(WebElement R: rate) {
		// String text = R.getText();
		//// System.out.println(text);
		         for(int i=0; i<li.size();i++) {
		            WebElement Prodname = li.get(i);
		            WebElement prodRate = rate.get(i);
		            String PNAME = Prodname.getText();
		            String PRATE = prodRate.getText();
		            System.out.println(PNAME+" "+PRATE); //concordinate
		      
		            m.put(PNAME, PRATE);
		// System.out.println(m);
		// int s = m.size();
		// System.out.println(s);
		           }
		     
		     System.out.println("***** entry set iterate map ******");
		        Set<Entry<String, String>> es = m.entrySet();
		        System.out.println(es);

		System.out.println("$$$$$ enhance for loop $$$$");
			
		       for(Entry<String,String> x:es) {
		       // System.out.println(x);
		       // System.out.println(x.getKey());
		       // System.out.println(x.getValue());
		  
		       String key = x.getKey();
		       String value = x.getValue();
		       System.out.println(key+ " "+value);
		     }
		 }
		}


