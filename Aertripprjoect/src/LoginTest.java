import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginTest {

	
		public static void sendKeys(WebDriver driver1, WebElement element, int timeout, String value){
	new WebDriverWait(driver1, timeout).until(ExpectedConditions.visibilityOf(element));
	element.sendKeys(value);
	}
	public static void clickOn(WebDriver driver1, WebElement element, int timeout){
	new WebDriverWait(driver1, timeout).until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	}
		
		
		
		
		

		public static void main(String[] args) throws InterruptedException {
			// TODO Auto-generated method stub
			
			

			
			//chrome Browser starts
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Samir\\Desktop\\Workspace\\Aertripprjoect\\lib\\drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			//maximize windows
			driver.manage().window().maximize();
			//deletes all cookies
			driver.manage().deleteAllCookies();
			// pageload timeout
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 
			 // Implicit Wait for 20 seconds
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);   
			//Loads website
			driver.get("https://aertrip.com/");
			
			
			// 1. Logon to https://aertrip.com/
			
			//clicking on signin button for login
			driver.findElement(By.xpath("//div[@class='registerSignIn js-register-signin']")).click();
			WebElement firstname= driver.findElement(By.name("email"));
			WebElement lastname= driver.findElement(By.name("password"));
			sendKeys(driver, firstname, 10, "mradulamishra05.07@gmail.com");
			sendKeys(driver, lastname, 20, "#Travelling1#");
			WebElement forgotAccount= driver.findElement(By.id("login_submit"));
			clickOn(driver,forgotAccount, 10);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			 // fetch the title of the web page and save it into a string variable
			 String  expectedTitle="Flights | Aertrip";
			 //
	        String actualTitle = driver.getTitle();
	        System.out.println("Actual Title : " + actualTitle);

	        // compare the expected title of the page with the actual title of the page and print the result
	       
	          if(expectedTitle.equals(actualTitle))
	          {
	               System.out.println("Verification Successful - The correct title is displayed on the web page.");
	          }
	          else
	          {
	               System.out.println("Verification Failed - An incorrect title is displayed on the web page.");
	          }
	          
	          Thread.sleep(4000);
	          //2. Navigate to Hotels product.
	        driver.navigate().to("https://aertrip.com/hotels#/search");
	        
	        
	        //3. Search a location, 
	       WebElement search= driver.findElement(By.id("autocomplete-js"));
	    		   //  By.xpath("//jq-autocomplete[@id='autocomplete-tag']//input[@id='autocomplete-js']"));
	       Thread.sleep(3000);
	       search.clear();
	       Thread.sleep(5000);
	      search. sendKeys("New Delhi");
	       Thread.sleep(8000);
	       
	       
	       List <WebElement> list=driver.findElements(By.xpath("//ul[@id='ui-id-11']//li/descendant::span[@class='css-placename-col css-ellipsis']"));
	     // ArrayList <WebElement> list=(ArrayList<WebElement>) driver.findElements(By.xpath("//ul[@id='ui-id-11']//li/descendant::span[@class='css-placename-col css-ellipsis']"));
	       Thread.sleep(10000);
	      // System.out.println(list.get(index));
	     // System.out.println(list.);
	      for(int i=0;i<list.size();i++)
	      {
	    	  String listitem=list.get(i).getText();
	    	  if(listitem.contains("New Delhi, Delhi, India"))
	    	  {
	    		  list.get(i).click();
	    		  break;
	    		  
	    	  }
	      }
	      
	      
	      
	      //Click and open the datepickers
	      driver.findElement( By.xpath("//input[@placeholder='Check-in']")).click();
	      //This is from date picker table
	      WebElement checkin = driver.findElement(By.xpath("//input[@placeholder='Check-in']"));

	      //This are the rows of the from date picker table
	      //List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));

	      //This are the columns of the from date picker table
	      Thread.sleep(4000);
	      List<WebElement> columns = driver.findElements(By.xpath("//div[@class='datepickerContainer']"));
	      //int numbersize=columns.size();
	      for(int i=0;i<columns.size();i++)
	      {
	      	 String listitem=columns.get(i).getText();
	      	// System.out.println(listitem);
	      	 Thread.sleep(2000);
	      WebElement	 currentdate=driver.findElement(By.xpath("//td[@class='datepickerToday datepickerSelected']"));
	      	 if(currentdate.isDisplayed())
	      	 {
	      		 driver.findElement(By.xpath("//td[@class='datepickerSunday']")).click();
	      		// break;
	      	 }
	      	 Thread.sleep(1000);
	      	 
	           WebElement checkout=driver.findElement(By.xpath("//input[@placeholder='Check-out']"));
	      	 if(checkin.isDisplayed())
	      	 {
	      		 //checkout=3dayscheckin;
	      		 driver.findElement(By.xpath("//td[3]/table/tbody[2]/tr[5]/td[3]")).click();
	      		 break;
	      	 }
	      }
	        
	        
	        
	        
	        
	     //   4. Select 2 Rooms, Room 1: 2 Adult, 1 Child with age 10 & Room 2: 3 Adult, 2 Child with age 10 & 12.
	        //rooms
	        driver.findElement(By.xpath("//div[@class='icon-left']//i//i[@class='icon icon_home']")).click();
	        //room1:2 adults and 1 child
	        //selecting 1 child
	        driver.findElement(By.xpath("//div[@class='roomsGuestBox css-rooms-add dropdown-js rooms-dd-normal-js']//div[2]//div[3]//div[1]//i[1]")).click();
	        //enter childs age
	        WebElement childage=driver.findElement(By.xpath("//div[@class='roomsGuestBox css-rooms-add dropdown-js rooms-dd-normal-js']//div[2]//div[3]//div[2]//span[1]//input[1]"));
	       childage.click();
	        Thread.sleep(5000);
	        childage.clear();
	        childage.sendKeys("10");
	        
	        
	        //add room 2
	        
	        driver.findElement(By.xpath("//div[@class='css-addRooms addRooms addRooms-js']")).click();
	        //by default 2 adults are selected and 3rd adult is to be selected
	        driver.findElement(By.xpath("//div[@class='formBar formBarTop']//div[3]//div[2]//i[3]")).click();
	        
	        //2 childto be selected with age 10 and 12
	        
	        driver.findElement(By.xpath("//div[@class='formBar formBarTop']//div[3]//div[3]//div[1]//i[1]")).click();
	    
	    
	     WebElement childage10= driver.findElement(By.xpath("//body//div[3]//div[3]//div[2]//span[1]//input[1]"));
	     childage10.click();
	     Thread.sleep(5000);
	     childage10.clear();
	     childage10 .sendKeys("10");
	        
	     //selecting 2nd child with age 12
	        driver.findElement(By.xpath("//body//div[3]//div[3]//div[3]//i[1]")).click();
	        WebElement childage12= driver.findElement(By.xpath("//body//div[3]//div[3]//div[4]//span[1]//input[1]"));
	        childage12.click();
	        Thread.sleep(5000);
	        childage12.clear();
	        childage12 .sendKeys("12");
	        
	        
	        
	        
	       // Thread.sleep(3000);
	        //5. Hit the search button and wait until the hotels are loaded.
	     WebElement searchHotel=   driver.findElement(By.xpath("//button[@id='searchHotelButton']"));
	     clickOn(driver,searchHotel,5000);
	     
	     
//	 	6. Select hotel which is nearest to the selected location.
	     Thread.sleep(10000);
	     driver.findElement(By.xpath("//span[@class='nearby-tab-js']")).click();
			Thread.sleep(4000);
		        List<WebElement> nearby = (driver.findElements(By.xpath("//span[@class='nearby-tab-js']")));
		       // Thread.sleep(5000);
		        for(int i=0;i<nearby.size();i++)
		        {
		        	 String nearbyrange=columns.get(i).getText();
		        	 System.out.println(nearbyrange);
		        	 Thread.sleep(2000);
	        
		}

	}
	


	}


