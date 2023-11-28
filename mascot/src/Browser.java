
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
	
	

	
  	public Browser(String keyword){
		// driverの設定
  		System.setProperty("webdriver.chrome.driver","C:/workspace/mascot/driver/chromedriver.exe");
  		
  	    // Webdriverのインスタンスを作成 
  	    WebDriver driver = new ChromeDriver();  

  	    // 開くサイトのURLを設定する
  	    driver.get("https://www.google.com");
  	    
  	    // 入力フォームの要素を取得
  		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/textarea")).sendKeys(keyword);

  		// 検索ボタンの要素を取得する
  	    driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();

  	    }
			
		
	}
