package com.vtiger.comcast.pomrepository.library;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactPage {
	WebDriver driver;
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement pageHederText;
	

	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@value='T']")
	private WebElement groupRadioButton;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement userRadioButton;
	
	@FindBy(name="assigned_group_id")
	private WebElement AssignedToDropDown;
	
	@FindBy(name="assigned_user_id")
	private WebElement userAssignedToDropDown;

	@FindBy(name="leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement saveButton;

	@FindBy(xpath="//img[contains(@onclick,'selectContact')]")
	private WebElement reportsToAddButton;
	
	@FindBy(xpath="//img[contains(@onclick,'selectContact')]/following-sibling::input[@title='Clear']")
	private WebElement clearReportsToTextField;
	
	@FindBy(name="contact_id")
	private WebElement reportsToContacId;

	public WebElement getReportsToAddButton() {
		return reportsToAddButton;
	}

	public WebElement getClearReportsToTextField() {
		return clearReportsToTextField;
	}

	public WebElement getReportsToContacId() {
		return reportsToContacId;
	}
	
	public WebElement getPageHederText() {
		return pageHederText;
	}

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getGroupRadioButton() {
		return groupRadioButton;
	}

	public WebElement getAssignedToDropDown() {
		return AssignedToDropDown;
	}
	
	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	public WebElement getUserRadioButton() {
		return userRadioButton;
	}

	public WebElement getUserAssignedToDropDown() {
		return userAssignedToDropDown;
	}
	
	// to verify create contact page is displayed
	public void isCreateContactPageDisplayed() {
		if(pageHederText.getText().contains("Creating New Contact"))
			System.out.println("Create contact page is displayed");
		else
			System.out.println("Create contact page is Not displayed");
	}
	
	//method to save
	public ContactInformationPage save() {
		saveButton.click();
		return new ContactInformationPage(driver);
	}
	

	// to verify Reports to contact selected
		public void isReportsToSelected() {
			if(reportsToContacId.getAttribute("value").isEmpty()) {
				System.out.println("FAIL: Reports To contact not selected");
			}
			else {
				System.out.println("PASS: Reports To contact is selected");
			}
		}
		
	// to verify Reports to contact cleared
		public void isReportsTocleared() {
			if(reportsToContacId.getAttribute("value").isEmpty()) {
				System.out.println("PASS: Reports To contact is cleared");
			}
			else {
				System.out.println("FAIL: Reports To contact is Not cleared");
			}
		}
	
	
}