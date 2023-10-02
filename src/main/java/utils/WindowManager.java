package utils;

import org.openqa.selenium.WebDriver;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager (WebDriver driver){
        this.driver=driver;
        navigate=driver.navigate();
    }

    public void switchToWindow(String windowTitle){
      var windows =  driver.getWindowHandles();
       //System.out.println("Windows handles:");
        windows.forEach(System.out::println);

        for(String window:windows){
           // System.out.println("Switching to window: "+window);
            driver.switchTo().window(window);
         // System.out.println("current window : "+driver.getTitle());

          /*  if(windowTitle.equals(driver.getTitle())){
                break;
            }*/

            //test branch
        }
    }



}
