package com.example;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class Pechinchou 
{
    @Test
    public void PreencherCampoEmail() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator");
        capabilities.setCapability("automationName", "uiautomator2");
        capabilities.setCapability("appPackage", "br.com.pechinchou.pechinchou");
        capabilities.setCapability("appActivity","br.com.pechinchou.pechinchou.MainActivity");

        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement el3 = driver.findElement(AppiumBy.className("android.widget.EditText"));
        el3.click();
        el3.sendKeys("testeemail.com");
        WebElement el4 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]"));
        el4.click();
        WebElement el5 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"E-mail inválido\"]"));
        el5.click();
        
        Assert.assertEquals("E-mail Inválido", el5.getText());

        driver.quit();
    }
 }
