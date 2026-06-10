package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.utility.CalendarHelper;
import com.mukesh.utility.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static com.mukesh.utility.calenderHelper.selectDate;
import static com.mukesh.utility.CalendarHelper.selectDate;
import static com.mukesh.utility.Dropdown.selectLocation;
import static com.mukesh.utility.waitHelper.checkVisibility;
import static com.mukesh.utility.waitHelper.waitJVM;

public class AddEmployeePage extends CommonToAllPages {

    WebDriver driver;


    public AddEmployeePage(WebDriver driver) {
        this.driver = driver;
    }

    private By fiestName=By.xpath("//input[@placeholder='First Name']");
    private By middleName=By.xpath("//input[@placeholder='Middle Name']");
    private By lastName=By.xpath("//input[@placeholder='Last Name']");
    private By calenderButton=By.xpath("//button[contains(@class, 'date-picker-button')]");
    private By yearButton=By.xpath("//div[contains(@class, 'picker__select--year')]//button");
    private By monthButton=By.xpath("//div[contains(@class, 'picker__select--month')]//button[@data-toggle='dropdown']");
    private By locationDropdown=By.xpath("//div[@id='location']");
    private By nextButton=By.xpath("//button[@id='modal-save-button']");
    private By otherID=By.xpath("//input[@id='otherId']");
    private By Ssn=By.xpath("//input[@id='ssn']");



    public void addEmployee(String firstname,String middlename,String lastname,String year,String month,String date,String location,String otherid,String ssn)
    {
        enterText(fiestName,firstname);
        enterText(middleName,middlename);
        enterText(lastName,lastname);


        CalendarHelper.selectDate(
                calenderButton,
                yearButton,
                monthButton,
                year,
                month,
                date
        );
        selectLocation(locationDropdown,location);
        click(nextButton);
        checkVisibility(otherID);
        enterText(otherID,otherid);
        enterText(Ssn,ssn);





        waitJVM(15000);
    }

}
