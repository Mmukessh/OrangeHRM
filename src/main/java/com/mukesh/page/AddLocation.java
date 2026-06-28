package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.mukesh.utility.Dropdown.selectNationality;
import static com.mukesh.utility.Dropdown.selecttimeZone;
import static com.mukesh.utility.waitHelper.waitJVM;

public class AddLocation extends CommonToAllPages {

    WebDriver driver;
    public AddLocation(WebDriver driver) {
        this.driver = driver;
    }

    private By addButton=By.xpath("//div[@data-tooltip='Add Location']");
    private By nametext= By.xpath("//input[@id='name']");
    private By triggerdropdown=By.xpath("//div[select[@id='countryCode']]//input[@class='select-dropdown']");
    private By triggertimeZone=By.xpath("//div[select[@id='time_zone']]//input[@class='select-dropdown']");
    private By citytext=By.xpath("//input[@id='city' and not(ancestor::*[contains(@style, 'display: none')])]");
    private By zipcode=By.xpath("//input[@id='zipCode' and not(ancestor::*[contains(@style, 'display: none')])]");
    private By saveButton=By.xpath("//div[contains(@class, 'open')]//a[@ohrm-save-form='modal.save(locationsModalForm);']");
    private By tableRow=By.xpath("//table[contains(@class, 'highlight')]//tr[td]");
    private By namecolumn=By.xpath("//table[contains(@class, 'highlight')]//tr/td[2]");


   public List<String> getdata()
   {
       List<String> location=new ArrayList<>();
       List<WebElement> locationList= DriverManager.getDriver().findElements(tableRow);

       for(WebElement element:locationList)
       {
           String loca=element.getText();
           location.add(loca);
       }
       return location;


   }

    public boolean addlocation(String Name, String location, String time, String city, String ZipCode)
    {
        click(addButton);
        enterText(nametext,Name);
        waitJVM(10000);
        selectNationality(triggerdropdown,location);
        selecttimeZone(triggertimeZone,time);
        enterText(citytext,city);
        enterText(zipcode,ZipCode);
        click(saveButton);
        waitJVM(7000);
        List<String> locations=getdata();
        boolean found =locations.contains(Name);
        return found;
    }

}
