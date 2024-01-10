package com.example;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AppTest 
{
    @Test
    public void shouldAnswerWithTrue() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "com.google.android.calculator");
        capabilities.setCapability("appActivity","com.android.calculator2.Calculator");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
        
        WebElement el1 = driver.findElement(AppiumBy.accessibilityId("2"));
        el1.click();
        WebElement el2 = driver.findElement(AppiumBy.accessibilityId("plus"));
        el2.click();
        WebElement el3 = driver.findElement(AppiumBy.accessibilityId("2"));
        el3.click();
        WebElement el4 = driver.findElement(AppiumBy.accessibilityId("equals"));
        el4.click();
        WebElement el5 = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_final"));
        el5.click();
        Assert.assertEquals("5", el5.getText());
        driver.quit();
    }
 }
