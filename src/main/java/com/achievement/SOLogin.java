package com.achievement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SOLogin {

    public static void main(String[] args) {

        if(args.length != 2){
            usage();
            System.exit(1);
        }

        System.out.println("Running the stack script!");

        try {

            System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "http://stackoverflow.com/";

            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

            driver.get(baseUrl + "/");
            driver.findElement(By.xpath("(//a[contains(text(),'log in')])[2]")).click();
            driver.findElement(By.id("email")).click();
            driver.findElement(By.id("email")).clear();
            driver.findElement(By.id("email")).sendKeys(args[0]);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(args[1]);
            driver.findElement(By.id("submit-button")).click();


            try {
                Thread.sleep((int) (Math.random() * 10000l) + 5000);
            } catch (InterruptedException e) {
                System.out.println("The sleep got interrupted somehow...");
                e.printStackTrace();
            }

            driver.findElement(By.cssSelector("a[title=\"Questions with an active bounty\"]")).click();

            try {
                Thread.sleep((int) (Math.random() * 10000l) + 5000);
            } catch (InterruptedException e) {
                System.out.println("The sleep got interrupted somehow...");
                e.printStackTrace();
            }

            driver.close();
        } catch (Exception e) {
            System.out.println("Something failed somewhere....");
            System.out.println("Make sure chromedriver.exe is in C:\\");
        }
    }

    public static void usage(){
        System.out.println("Arg1: <user name> Arg2: <password>");
    }
}
