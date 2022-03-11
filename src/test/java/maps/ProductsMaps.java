package maps;

import org.openqa.selenium.By;

public class ProductsMaps {

    public By fild(int i) {
        return new By.ByXPath("//div[@class='roboto-light list ng-scope']["+ i +"]//label[1]");
    }

    public By description(int i) {
        return new By.ByXPath("//div[@class='roboto-light list ng-scope']["+ i +"]//label[2]");
    }

}
