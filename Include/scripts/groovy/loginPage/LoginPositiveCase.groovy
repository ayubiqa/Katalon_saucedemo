package loginPage
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import cucumber.api.java.en.And
import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When



class Login {
	@Given("Make sure user navigate to login page")
	def navigate_to_login_page() {
		WebUI.openBrowser('', FailureHandling.STOP_ON_FAILURE)
		WebUI.navigateToUrl(GlobalVariable.basicURL)
	}

	@When("User input Username")
	def filled_username(){
		WebUI.click(findTestObject('LoginPage/Field/Username Field'))
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'placeholder', 'Username', 0)
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'standard_user')
	}

	@And("User input Password")
	def filled_password(){
		WebUI.click(findTestObject('LoginPage/Field/Password Field'))
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'placeholder', 'Password', 0)
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'type', 'password', 0)
		WebUI.setMaskedText(findTestObject('LoginPage/Field/Password Field'), GlobalVariable.Password)
	}

	@And("User click Login button")
	def click_login_button(){
		WebUI.click(findTestObject('LoginPage/Button/Btn_Login'))
	}

	@Then("User directed to Home Page")
	def successfully_login_verification(){
		WebUI.verifyElementPresent(findTestObject('HomePage/Lable/Lb_Products'), 10)
		WebUI.closeBrowser()
	}
}