package stepDefinitions;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.coverFox.DriverConfig.DriverFactory;
import com.coverFox.Pages.CoverFoxAddressDetailPage;
import com.coverFox.Pages.CoverFoxHealthPlanPage;
import com.coverFox.Pages.CoverFoxHomePage;
import com.coverFox.Pages.CoverFoxMemberDetailsPage;
import com.coverFox.Pages.CoverFoxResultPage;

import io.cucumber.java.en.*;

public class CoverFoxHealthInsurance {
	
	
	CoverFoxHomePage coverFoxHomePage = new CoverFoxHomePage(DriverFactory.getDriver());
	CoverFoxHealthPlanPage coverFoxHealthPlanPage= new CoverFoxHealthPlanPage(DriverFactory.getDriver());
	CoverFoxMemberDetailsPage coverFoxMemberDetailsPage= new CoverFoxMemberDetailsPage(DriverFactory.getDriver());
	CoverFoxAddressDetailPage coverFoxAddressDetailPage = new CoverFoxAddressDetailPage(DriverFactory.getDriver());
	CoverFoxResultPage coverFoxResultPage = new CoverFoxResultPage(DriverFactory.getDriver());
	SoftAssert softAssert = new SoftAssert();
	
	@Given("I am on home page")
	public void i_am_on_home_page() {
	    System.out.println("I am on home page");
	}
	@When("I click on get started button")
	public void i_click_on_get_started_button() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I click on get started button");
	    coverFoxHomePage.clickOnFemaleOption();
	}

	@When("I click on next button")
	public void i_click_on_next_button() throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I click on next button");
	    coverFoxHealthPlanPage.clickonNextButton();
	}
	@When("I provide age as {string} and click on next button")
	public void i_provide_age_as_and_click_on_next_button(String age) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I provide age as" +age+" and click on next button");
	    coverFoxMemberDetailsPage.handlingDropdown(age);
	    coverFoxMemberDetailsPage.clickOnNextBtnMemberDetailsPage();
	}

	@When("I provide pincode as {string} , mobNum as {string} and click on continue button")
	public void i_provide_pincode_as_mob_num_as_and_click_on_continue_button(String pincode, String mobNum) throws InterruptedException {
		Thread.sleep(4000);
		System.out.println("I provide pincode as"+ pincode + "mobNum as" + mobNum + " and click on next button");
	    coverFoxAddressDetailPage.enterPincode(pincode);
	    coverFoxAddressDetailPage.enterMobileNumber(mobNum);
	    coverFoxAddressDetailPage.ClickOnContinueButton();
	}

	@Then("matching Health Insurance Plans should be displayed as {string}")
	public void matching_health_insurance_plans_should_be_displayed_as(String expResult) throws InterruptedException {
		Thread.sleep(6000);
		System.out.println("matching Health Insurance Plans should be displayed as " + expResult);
	    String actualResult = coverFoxResultPage.getMatchingResultNumber();
	    Reporter.log("Actual result is "+actualResult, true);
	    //Assert.fail();
	    Assert.assertEquals(actualResult, expResult );
	    Thread.sleep(1000);
	}
	@When("I click on continue button")
	public void i_click_on_continue_button() throws InterruptedException {
		Thread.sleep(4000);
		coverFoxAddressDetailPage.ClickOnContinueButton();
	}

	@Then("Validate error messages")
	public void validate_error_messages() throws InterruptedException {
		Thread.sleep(1000);
	   String actErrorMsgPin = coverFoxAddressDetailPage.getPincodeErrorMsg();
	    System.out.println(actErrorMsgPin);
	   String actErrorMsgMobile = coverFoxAddressDetailPage.getMobileNoErrorMsg();
	   System.out.println(actErrorMsgMobile);
	   String expErrorMsgPin = "Please enter a valid PIN code";
	   String expErrorMsgMobile = "Please enter a valid mobile number";
	   softAssert.assertEquals(actErrorMsgPin, expErrorMsgPin, "Pincode error message not matched");
	   softAssert.assertEquals(actErrorMsgMobile, expErrorMsgMobile, "Mobile number error message not matched");
	}


}
