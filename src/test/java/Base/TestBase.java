package Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.jcraft.jsch.*;

public class TestBase {
	
	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	protected void takeScreenshot(WebDriver driver)
	{
		try{
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("output\\"+getDateTime()+".png"));
		} catch(Exception e){
			e.getMessage();
		}		
	}
	
	protected static String getDateTime() 
	{
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
	
	protected static boolean isElementPresent(WebDriver driver, By by) 
	{
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
	    }
	}
	
	@SuppressWarnings("resource")
	protected void updateResult(String sheetName, String message, int rowIndex, int colIndex)
	{
		try{
	        FileInputStream input_document = new FileInputStream("datasource.xls");
	        HSSFWorkbook my_xls_workbook = new HSSFWorkbook(input_document); 
	        HSSFSheet my_worksheet = my_xls_workbook.getSheet(sheetName);
	        Cell cell = null; 
	        cell = my_worksheet.getRow(rowIndex).getCell(colIndex);
	        cell.setCellValue(message);
	        input_document.close();
	        FileOutputStream output_file =new FileOutputStream("datasource.xls");
	        my_xls_workbook.write(output_file);
	        output_file.close();
		}
		catch(IOException e) {
			e.getMessage();
		}		
	}
	
	protected static String pathFile(String relativePath)
	{
		String curDir = System.getProperty("user.dir");
		String absolutePath = curDir + relativePath;
		return absolutePath;
	}
	
	protected void clearAndType(WebElement element, String key)
	{
		element.clear();
		element.sendKeys(key);		
	}
	
	protected void selectOption(WebElement element, String key)
	{
		new Select(element).selectByVisibleText(key);
	}
	
	protected static void pause(long timeInMillis) {
		try 
		{
			Thread.sleep(timeInMillis);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	protected void getFileViaSftp()
	{
		JSch jsch = new JSch();
        Session session = null;
        try {
            session = jsch.getSession("t24dev", "10.37.24.116", 22); // ***** username / IP / port
            session.setConfig("StrictHostKeyChecking", "no");
            session.setPassword("t24dev@2016"); // ***** pass
            session.connect();

            Channel channel = session.openChannel("sftp");
            channel.connect();
            ChannelSftp sftpChannel = (ChannelSftp) channel;
            sftpChannel.get("/t24data/t24dev/t24if/atm/CARD.ISS.BP/SUP.CARD.INFOR.2385516__9704321100756436.txt", "C:/localfile.txt");
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }
	}
	
	protected void createFile()
	{
		String data = "Test data";
		FileOutputStream out;
		
		try 
		{
			out = new FileOutputStream("c://testFile2.txt");
			out.write(data.getBytes());
			out.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}