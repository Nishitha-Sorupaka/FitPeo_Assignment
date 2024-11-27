package mypackage;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FitPeo_Assignment {

	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = null;
		try {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nishi\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();   //exception
		
		// Task-1: Navigate to the FitPeo Homepage:
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.fitpeo.com/");	//exception
		Thread.sleep(2000);

		
		// Task-2: Navigate to the Revenue Calculator Page:

		driver.findElement(By.linkText("Revenue Calculator")).click();	//exception
		Thread.sleep(2000);
		
		
		// Task-3: Scroll Down to the Slider section:
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement scrollToElement = driver.findElement(By.xpath("//p[contains(@class,'MuiTypography-root MuiTypography-body1 inter css-1fefu7m')]"));		
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		Thread.sleep(1000);
		
		// Task-4: Adjust the Slider: to 820

		WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
		//WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root')]//input[@type='range']"));
		String defaultSliderValue = slider.getAttribute("aria-valuenow");
		System.out.println("Existing Default Slider Value: "+ defaultSliderValue);
		String newSliderValue = "820";
		Thread.sleep(2000);
		while(true)
		{
			String setSliderValue = slider.getAttribute("aria-valuenow");
			if(setSliderValue.equals(newSliderValue))
				break;
			else
				slider.sendKeys(Keys.RIGHT);
		}
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		String setSliderValue = slider.getAttribute("aria-valuenow");
		System.out.println("Adjusted Slider to :" + setSliderValue);
		if(setSliderValue.equals(newSliderValue))
		{
			System.out.println("Default Slider Value: "+defaultSliderValue+", is Successfully updated with New Slider Value: "+newSliderValue+ " by adjusting the slider");
		}
				
		/*
		
		// Task-4: Adjust the Slider: to 820
		
		WebElement slider = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root')]//input[@type='range']"));
		Actions a = new Actions(driver);
		a.click(slider);
		Thread.sleep(2000);
		while(true)
		{
			String setSliderValue = slider.getAttribute("aria-valuenow");
			if(setSliderValue.equals("820"))
				break;
			else
				a.sendKeys(Keys.RIGHT).build().perform();
		}
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToElement);
		String setSliderValue = slider.getAttribute("aria-valuenow");
		System.out.println(setSliderValue);
		
		*/
		
		// Task-5: Update the Text Field: & Task-6: Validate Slider Value:
		
		WebElement sliderInput = driver.findElement(By.xpath("//div[contains(@class,'MuiInputBase-root')]//input[@type='number']"));
		
		Thread.sleep(5000);
        String numberToEnter1 = "560";
        String numberToEnter2 = "820";
		
        //updating to 560
        Actions a = new Actions(driver);
        a.click(sliderInput).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(numberToEnter1).build().perform(); 
        String sliderValueUpdated = slider.getAttribute("aria-valuenow");
        if(sliderValueUpdated.equals(numberToEnter1))
        {
        	System.out.println("Slider changed accordingly w.r.t input text field and validated successfully");
        }
        Thread.sleep(3000);
        a.click(sliderInput).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.BACK_SPACE).sendKeys(numberToEnter2).build().perform(); 
        Thread.sleep(3000);
		String SliderValue = slider.getAttribute("aria-valuenow");
		System.out.println("Slider Value : "+SliderValue);
        
        // Task-7: Select CPT Codes: select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474.
        
        WebElement scrollToCodes = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-root')]//input[@type='range']"));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToCodes);
		 Thread.sleep(3000);
		 
		 
		// List of CPT codes to select
		String[] cptCodes = {"CPT-99091", "CPT-99453", "CPT-99454", "CPT-99474"};
		
		for(String cptcode : cptCodes)
		{
			driver.findElement(By.xpath("//div/p[contains(text(),'"+cptcode+"')]/..//input[@type='checkbox']")).click();
			Thread.sleep(1000);
			System.out.println("Selected CPT-Code: "+cptcode);
		}

		
		// Task-8: Validate Total Recurring Reimbursement
		Thread.sleep(2000);
		int expectedTotal = 110700;
		WebElement checkTotalText = driver.findElement(By.xpath("(//div[contains(@class,'MuiBox')]/header/div/p)[4]"));
		String text = checkTotalText.getText();
		System.out.println(text);
		System.out.println("---------------------------------------------------");
		String[] subText = text.split("\n");
		String subText1 = subText[0];
		System.out.println(subText1);
		System.out.println("---------------------------------------------------");
		String subText2 = subText[1];
		System.out.println(subText2);
		System.out.println("---------------------------------------------------");
		int totalVal = Integer.parseInt(subText2.replace("$",""));
		System.out.println(totalVal);
		System.out.println("---------------------------------------------------");
		System.out.println(totalVal);
		System.out.println("---------------------------------------------------");
		
		// Task-9: Verify that the header displaying
		if(totalVal==expectedTotal) 
		{
			System.out.println("Successfully verified the header. It is displaying the below text: \n"+text+"");
		}
		

	}
	catch(Exception e) 
		{
			System.out.println("An error occurred during execution: "+e.getMessage());
		}
	finally {
		if(driver != null)
			driver.quit();
	}

}
}
