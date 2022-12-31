package day09_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class C03_MoveToElement extends TestBase {

    /*
    1- https://www.amazon.com/ adresine gidin
    2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
    3- “Create a list” butonuna basin
    4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
     */

    @Test
    public void test(){

        driver.get("https://www.amazon.com/");
        WebElement accountList= driver.findElement(By.id("nav-link-accountList-nav-line-1"));

        Actions action = new Actions(driver);

        action.moveToElement(accountList);



    }
}
