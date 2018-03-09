package ca.richardf.selenium.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


public final class CommonUtils {
	public static JsonObject getJsonObject(String filePath){ 	
		JsonParser parse = new JsonParser();
        try {
        	return (JsonObject)parse.parse(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonIOException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        return null;
	}
	
	public static void getScreenshot(WebDriver driver, String filepath) throws IOException{
		//String filename=UUID.randomUUID().toString();
		SimpleDateFormat sdateformat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar calendar = Calendar.getInstance();
        Date curdate = calendar.getTime();
        String filename = sdateformat.format(curdate)+ ".png";
 		
	    File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);     
	    File targetFile=new File(filepath + filename);
	    FileUtils.copyFile(srcFile,targetFile);
	}
	
}
