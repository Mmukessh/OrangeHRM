package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.mukesh.utility.Dropdown.selectNationality;
import static com.mukesh.utility.waitHelper.waitJVM;

public class AddLocation extends CommonToAllPages {

    WebDriver driver;
    public AddLocation(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton=By.xpath("//div[@data-tooltip='Add Location']");
    private By nametext= By.xpath("//input[@id='name']");
    private By triggerdropdown=By.xpath("//select[@id='countryCode']/following-sibling::input[@class='select-dropdown']");


    public void addlocation(String Name,String location)
    {
        click(addButton);
        enterText(nametext,Name);
        waitJVM(10000);

        selectNationality(triggerdropdown,location);
    }

}
