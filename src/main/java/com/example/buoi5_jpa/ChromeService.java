package com.example.buoi5_jpa;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;

@Service
@Slf4j
public class ChromeService {
    //private Logger logger = LoggerFactory.getLogger(ChromeService.class);
    public void startChrome() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver",
                "E:\\SeleniumWebdriver\\chromedriver2.exe");
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://shopee.vn/buyer/login?is_from_signup=true&next=https%3A%2F%2Fshopee.vn%2F%3Fis_from_signup%3Dtrue");

        // Maximize the browser
        driver.manage().window().maximize();
        Thread.sleep(1000);
        //social-white-google-png
        WebElement uname= driver.findElement(By.name("loginKey"));
        if(uname!=null){
            System.out.println("ggLog !=null");
            uname.sendKeys("quang5320");
            WebElement pass= driver.findElement(By.name("password"));
            pass.sendKeys("Qdev5323");
            Thread.sleep(2000);
            WebElement login= driver.findElement(By.className("wyhvVD"));
            login.click();
            //uname.click();
            Thread.sleep(2000);
            //identifierId

            WebElement adCloseButton = null;
            try {
                adCloseButton = driver.findElement(By.cssSelector("button.shopee-popup__close-btn"));
                Thread.sleep(1000);
            } catch (NoSuchElementException e){
                System.out.println();
            }
            if(adCloseButton!= null){
                adCloseButton.click();
            }
        }

        WebElement cart= null;
        try {
            Thread.sleep(2000);
            cart= driver.findElement(By.className("icon-shopping-cart-2"));
            Thread.sleep(1000);
        } catch (NoSuchElementException e){
            log.error("Không tìm thấy cart");
        }
        if(cart!=null){
            log.info("cart!=null");
            cart.click();
        }
    }
}
