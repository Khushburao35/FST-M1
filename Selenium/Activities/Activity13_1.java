package Activity;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class Activity13_1 {
	public static void main(String[] args) throws IOException, CsvException {
		/*
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Actions builder = new Actions(driver);

		driver.get("https://www.training-support.net/selenium/popups");
		System.out.println("Page tilte : " + driver.getTitle()); */
		
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\AbhishekMondal\\Desktop\\IBM_FST\\Selenuim\\Input_13_1.csv"));

        List<String[]> list = reader.readAll();
        System.out.println("No of rows: " + list.size());

        Iterator<String[]> itr = list.iterator();

        while(itr.hasNext()) {
            String[] str = itr.next();

            for(int i=0;i<str.length;i++) {
                System.out.print(str[i]+"\t");
            }
            System.out.println(" ");
        }
        
        reader.close();
	}
}