package com.mukesh.page;

import com.mukesh.base.CommonToAllPages;
import com.mukesh.driver.DriverManager;
import com.mukesh.utility.CalendarHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import static com.mukesh.utility.calenderHelper.selectDate;
import java.util.ArrayList;
import java.util.List;

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
    private By EditSaveButton=By.xpath("//button[@type='submit']");
    private By moreOption=By.xpath("//a[@data-automation-id='menu_top_more']");
    private By dependants=By.xpath("//div[contains(@class,'sub-menu-item')]//a[@data-automation-id='menu_employee_profile_Dependents']");
    private By emergancyContacts=By.xpath("//div[@class='sub-menu-item']//a[@data-automation-id='menu_employee_profile_EmergencyContacts']");
    private By addDependant=By.xpath("//div[@data-tooltip='Add Dependent']");
    private By addEmergancy=By.xpath("//div[@data-tooltip='Add Emergency Contact']");
   private By emergancyName=By.xpath("//input[@id='name']");
   private By emergancyRelationship=By.xpath("//input[@id='relationship']");
   private By homeContact=By.xpath("//input[@id='home_phone']");
   private By emergMobile=By.xpath("//input[@id='mobile_phone']");
   private By officeContact=By.xpath("//input[@id='office_phone']");
   private By emergancysavebutton=By.xpath("//button[@id='modal-save-button']");
    private By dependantName=By.xpath("//input[@id='name']");
    private By dependantDOBcal_trigger=By.xpath("//button[i[contains(@class, 'date-picker-open-icon')]]");
    private By dependantDOBMonth_trigger=By.xpath("//div[contains(@class, 'picker__select--month')]//button");
    private By dependantDOBYear_trigger=By.xpath("//div[contains(@class, 'picker__select--year')]//button");
    private By relationshipdropdown=By.xpath("//label[contains(text(), 'Relationship')]/following-sibling::div//button");
    private By savebutton=By.xpath("//button[@id='modal-save-button']");
    private By emecontctTable=By.xpath("//div[@class='list-container']//list[@listdata='listData']");
    private By terminatEmp_link=By.xpath("//a[@class='terminate-employment-button']//span[text()='Terminate Employment']");
    private By joboption=By.xpath("//a[@data-automation-id='menu_employee_profile_Job']");
    private By reasondropdown=By.xpath("//div[@id='reason']");
    private By Resignedreson=By.xpath("//span[text()='Resigned']");
    private By terminateNowCheckbox=By.xpath("//label[@for='terminate_now']");
    private By terminateSaveButton=By.xpath("//div[contains(@class, 'modal-footer')]/button[@id='modal-save-button']");
    private By profile=By.xpath("//a[@data-automation-id='menu_employee_profile_Profile']");
    private By inactivestatus=By.xpath("//span[@class='section-data-status-inactive' and text()='Inactive']");
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

    public String ingetactiveStatus()
    {
        return getTextWithWait(inactivestatus);
    }

    public String getfullname()
    {
        return getTextWithWait(fullname);
    }

    public void editEmployeeDetails(String maritalstatus)
    {
        maritalstatus(maritalstatusDropdown,maritalstatus);
        click(EditSaveButton);
    }

    public void addDependent(String name,String year,String month,String date,String relation)
    {
        clickonMoreOptions(moreOption,dependants);
        waitJVM(5000);
        click(addDependant);
        waitJVM(500);
        enterText(dependantName,name);
        dependantDOB(dependantDOBcal_trigger,dependantDOBYear_trigger,dependantDOBMonth_trigger,year,month,date);
        selectrelationship(relationshipdropdown,relation);
        click(savebutton);
    }

    public boolean addEmergancyContact(String emgName, String emgRelation, String homenumber, String mobile, String office)
    {
        clickonMoreOptions(moreOption,emergancyContacts);
        waitJVM(5000);
        click(addEmergancy);
        waitJVM(4000);
        enterText(emergancyName,emgName);
        enterText(emergancyRelationship,emgRelation);
        enterText(homeContact,homenumber);
        enterText(emergMobile,mobile);
        enterText(officeContact,office);
        click(emergancysavebutton);
        waitJVM(6000);

        List<String> users=new ArrayList<String>();
        List<WebElement> userlist= DriverManager.getDriver().findElements(emecontctTable);
        String expecteeName=emgName.trim();

        for(WebElement row:userlist)
        {
            String user=row.findElement(By.xpath(".//td[2]")).getText().trim();
            users.add(user);

            if(user.contains(emgName)|| emgName.contains(user))
            {
                return true;
            }
        }


        return false;
    }

    public String terminatEmployee()
    {
        click(joboption);
        waitJVM(15000);
        click(terminatEmp_link);
        waitJVM(4000);
        clickonMoreOptions(reasondropdown,Resignedreson);
        click(terminateNowCheckbox);
        click(terminateSaveButton);
        waitJVM(5000);
        click(profile);
        waitJVM(10000);

       return ingetactiveStatus();


    }

}
