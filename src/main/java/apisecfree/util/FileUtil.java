package apisecfree.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class FileUtil {

	WebDriver driver;
	 static Properties prop;
	 
	// public static String TESTDATA_SHEET_PATH = "C:\\Users\\RED TAG\\Downloads\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\main\\java\\apisecfree\\testdata\\testdata.xlsx";
	 
//	 FileInputStream fs=null;
//	 
//	 public FileUtil() {
//			try {
//				prop = new Properties();
//				FileInputStream config = new FileInputStream("C:\\Users\\Asiya-APIsec\\Downloads\\ScanFree-20230907T175805Z-001 (3)\\ScanFree-20230907T175805Z-001\\ScanFree\\src\\main\\java\\apisecfree\\config\\config.properties");
//				prop.load(config);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	 String FileDirectoryPath="C:\\Users\\Asiya-APIsec\\Downloads\\SpecFiles";
	 
    
	 
		public File[] GetFiles() throws IOException, InterruptedException{
			 File directory = new File(FileDirectoryPath);
		     File[] files = directory.listFiles();
			return files;						
			}
		
}
