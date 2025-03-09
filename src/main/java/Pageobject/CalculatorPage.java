package Pageobject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class CalculatorPage extends BasePage {

    static AndroidDriver driver;

    By btn_1 = AppiumBy.id("btn_1_s");
    By btn_2 = AppiumBy.id("btn_2_s");
    By btn_3 = AppiumBy.id("btn_3_s");
    By btn_4 = AppiumBy.id("btn_4_s");
    By btn_5 = AppiumBy.id("btn_5_s");
    By btn_6 = AppiumBy.id("btn_6_s");
    By btn_7 = AppiumBy.id("btn_7_s");
    By btn_8 = AppiumBy.id("btn_8_s");
    By btn_9 = AppiumBy.id("btn_9_s");
    By btn_0 = AppiumBy.id("btn_0_s");

    By btn_div = AppiumBy.id("btn_div_s");
    By btn_mul = AppiumBy.id("btn_mul_s");
    By btn_minus = AppiumBy.id("btn_minus_s");
    By btn_plus = AppiumBy.id("btn_plus_s");
    By btn_equal = AppiumBy.id("btn_equal_s");

    By result = AppiumBy.id("result");

//    By result = AppiumBy.className("android.widget.LinearLayout");

    public CalculatorPage(AndroidDriver driver){
        super(driver);
    }

    public CalculatorPage click_bottun(String str){
        switch (str){
            case "1":
                click(btn_1);
                break;
            case "2":
                click(btn_2);
                break;
            case "3":
                click(btn_3);
                break;
            case "4":
                click(btn_4);
                break;
            case "5":
                click(btn_5);
                break;
            case "6":
                click(btn_6);
                break;
            case "7":
                click(btn_7);
                break;
            case "8":
                click(btn_8);
                break;
            case "9":
                click(btn_9);
                break;
            case "0":
                click(btn_0);
                break;
            case "/":
                click(btn_div);
                break;
            case "*":
                click(btn_mul);
                break;
            case "-":
                click(btn_minus);
                break;
            case "+":
                click(btn_plus);
                break;
            case "=":
                click(btn_equal);
                break;

        }
        return this;
    }

    public String getResult(){
        return getText(result);
    }

}
