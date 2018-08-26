package mypack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox
{
	WebDriver driver;
	public void Launch() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.navigate().to("file:///D:/Neelima/Institute%20Manuals/checkbox_1.html");
		//driver.navigate().to("http://only-testing-blog.blogspot.com/2014/01/textbox.html");
		driver.manage().window().maximize();
		Thread.sleep(5000);
	}
	
	public void Get_AllChkBoxes()
	{
		System.out.println("Getting all the checkboxes::");
		List<WebElement> chkboxlist=driver.findElements(By.xpath("html/body/form/div/input"));
		int size=chkboxlist.size();
		System.out.println("Number of Checkboxes::"+size);
		for(int i=1;i<size;i++)
		{		
			String itemname=chkboxlist.get(i).getAttribute("value");
			System.out.println(itemname);
			/*if(!chkboxlist.get(i).isSelected())
			chkboxlist.get(i).click();*/
		}
		System.out.println("");
	}
	public void Get_SelectedChkboxes() throws InterruptedException
	{
		int size=0;
		driver.findElement(By.xpath("html/body/form/div/input[6]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/div/input[5]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("html/body/form/div/input[4]")).click();
		Thread.sleep(1000);
		List<WebElement> chkboxlist=driver.findElements(By.xpath("html/body/form/div/input"));
		System.out.println("Selected check boxes are::");
		for (int j = 1; j <chkboxlist.size(); j++) {
			if (chkboxlist.get(j).isSelected()) {
				String strs = chkboxlist.get(j).getAttribute("value");
				System.out.println(strs);
				size=strs.length();
			}
		}
		System.out.println("Number of selected checkboxes are:" +size);
		System.out.println("");
	}
	
	public void Verify_CheckBox(String item) 
	{
		int found=0;
		System.out.println("Verifying "+item+" Checkbox is selected or not::");
		List<WebElement> chkboxlist=driver.findElements(By.xpath("html/body/form/div/input"));
		for(int k=1;k<chkboxlist.size();k++)
		{
			String itemname=chkboxlist.get(k).getAttribute("value");
			if(itemname.equalsIgnoreCase(item))
			{
				found++;
				if(chkboxlist.get(k).isSelected())
					System.out.println("Selected");
				else
					System.out.println("Not Selected");
			}
		}
		if(found==0)
		System.out.println(item+" Not available");			
	}

	
		
	public void CloseBrowser()
	{
		driver.quit();
	}

	public static void main(String[] args) throws InterruptedException {
		CheckBox checkBox=new CheckBox();
		checkBox.Launch();
		checkBox.Get_AllChkBoxes();   
		checkBox.Get_SelectedChkboxes();
		checkBox.Verify_CheckBox("ggg");
		checkBox.CloseBrowser();
		

	}

}
