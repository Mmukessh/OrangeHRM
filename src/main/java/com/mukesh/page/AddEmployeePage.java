package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.utility.CalendarHelper;
import com.mukesh.utility.Dropdown;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//import static com.mukesh.utility.calenderHelper.selectDate;
import static com.mukesh.utility.CalendarHelper.*;
import static com.mukesh.utility.Dropdown.*;
import static com.mukesh.utility.waitHelper.*;

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
    private By dobcalenderbutton=By.xpath("//label[normalize-space()='Date of Birth']/following-sibling::span//i[contains(@class, 'date-picker-open-icon')]");
    private By dobyearbutton=By.xpath("//div[@class='select-wrapper picker__select--year']");
    private By dobmonthbutton=By.xpath("//div[@class='select-wrapper picker__select--month']");
    private By maritalstatusDropdown=By.xpath("//select[@id='emp_marital_status']/preceding-sibling::input[@class='select-dropdown']");
    private By genderdropdown=By.xpath("//select[@id='emp_gender']/preceding-sibling::input[@class='select-dropdown']");
    private By nationalitydropdown=By.xpath("//select[@id='nation_code']/preceding-sibling::input[@class='select-dropdown']");
    private By licensenumber=By.xpath("//input[@id='licenseNo']");
    private By licenseCalenderButton=By.xpath("//label[normalize-space()='License Expiry Date']/following-sibling::span//i[contains(@class,'date-picker-open-icon')]");
    private By licenseYearButton=By.xpath("//div[contains(@class, 'picker--opened')]//div[contains(@class, 'picker__select--year')]");
    private By licenseMonthButton=By.xpath("//div[contains(@class, 'picker--opened')]//div[contains(@class, 'picker__select--month')]");
    private By nextButton1=By.xpath("//button[@translate='Next']");
    private By onboardingDropdown=By.xpath("//div[contains(@class, 'select-wrapper')]/input[@class='select-dropdown']");
    private By saveButton=By.xpath("//button[text()='Save']");
    private By toastMessage = By.xpath("//div[@id='toast-container']//div[contains(@class,'toast-message')]");
    private By status=By.xpath("//span[@class='section-data-status-active' and text()='Active']");
    private By fullname=By.xpath("//span[@class='section-data' and ../text()[contains(., 'Full Name:')]]");



    public void addEmployee(String firstname,String middlename,String lastname,String year,String month,String date,String location,String otherid,String ssn,String dobyear,String dobmonth,String dobdate,String maritalstatus,String gender,String country,String licenseno,String expyear,String expmonth,String expdate,String onboarding)
    {
        enterText(fiestName,firstname);
        enterText(middleName,middlename);
        enterText(lastName,lastname);


        CalendarHelper.joindate(
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
        dobDate(dobcalenderbutton,dobyearbutton,dobmonthbutton,dobyear,dobmonth,dobdate);
        maritalstatus(maritalstatusDropdown,maritalstatus);
        selectGender(genderdropdown,gender);
        nationality(nationalitydropdown,country);
        enterText(licensenumber,licenseno);
        licenseExpiryCalender(licenseCalenderButton,licenseYearButton,licenseMonthButton,expyear,expmonth,expdate);
        click(nextButton1);
        waitJVM(5000);
        click(nextButton1);

        onBoarding(onboardingDropdown,onboarding);
        click(saveButton);
        waitJVM(15000);
    }
    public String getactiveStatus()
    {
        return getTextWithWait(status);
    }

    public String getfullname()
    {
        return getTextWithWait(fullname);
    }

}
