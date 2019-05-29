package com.qa.Cheapair.Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.qa.Cheapair.TestBase.Test_Base;

public class AirTrip_Page extends Test_Base{

	@FindBy (xpath="//div[@class='form-group col city']/input[@id='to1']") WebElement city;
	@FindBy (xpath="//div[@class='ui-datepicker-group ui-datepicker-group-first']/table[@class='ui-datepicker-calendar']/tbody/tr[5]/td[2]") WebElement date;
	@FindBy (xpath="//div[@class='ui-datepicker-group ui-datepicker-group-last']/table[@class='ui-datepicker-calendar']/tbody/tr[3]/td[3]") WebElement return_date;

	@FindBy (xpath="//button[contains(text(),'Search Flights')]") WebElement button;

	public  List<WebElement> name_1,name_2;

	public AirTrip_Page() {

		PageFactory.initElements(driver, this);

	}

	public void city_search() throws InterruptedException
	{


		city.sendKeys("Delhi");	
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//ul[@id='ui-id-3']/li[1]/a/span[@class='suggest-type' ]")).click();
		Thread.sleep(3000);
		date.click();
		return_date.click();
		button.click();

		String parent=driver.getWindowHandle();
		Set<String>s1=driver.getWindowHandles();
		Iterator<String> I1= s1.iterator();
		while(I1.hasNext())
		{
			String child_window=I1.next();
			if(!parent.equals(child_window))
			{
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[@class='btn btn-close']")).click();

				for(int i=0;i<11;i++)
				{

					//air india 0  3 4 5 6 10
					//vistara 1 2 7 8 9
					if(i==0 ||(i%2)==0 && i!=2&&i!=8||i==3||i==5)
					{
						WebElement name=driver.findElement(By.xpath("//div[@data-fare-id='AI"+i+"-F0']/span"));
						System.out.println("Air India prices:"+name.getText());

					}

					else if(i==1||(i%2)!=0&& i!=2||i==2||i==8)
					{
						WebElement name=driver.findElement(By.xpath("//div[@data-fare-id='UK"+i+"-F0']/span")); 
						System.out.println("Vistara prices:"+name.getText());

					}


					// driver.close();
				}
				Thread.sleep(3000);
				WebElement el=driver.findElement(By.xpath("//div[@data-fare-id='AI0-F0']"));
				el.click(); 
				Thread.sleep(3000);
				driver.findElement(By.xpath("//div[@data-fare-id='UK0-F0']")).click();

			}
			//	driver.switchTo().window(parent);
			//System.out.println(driver.switchTo().window(parent).getTitle());
		}
	}

	public String verify_Date() throws InterruptedException
	{
		Thread.sleep(3000);
		WebElement date_name=driver.findElement(By.xpath("//*[@id='flightReviewTarget']/div/div/div/div/div[2]/div/div[1]/div/div[2]"));

		return date_name.getText();
	}

	public String verify_Date_Arrival()
	{
		WebElement date_name2=driver.findElement(By.xpath("//*[@id='flightReviewTarget']/div/div/div/div/div[3]/div/div[1]/div/div[2]"));

		return date_name2.getText();
	}

}


