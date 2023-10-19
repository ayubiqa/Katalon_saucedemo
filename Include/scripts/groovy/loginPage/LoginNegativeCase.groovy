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



class CheckEmptyAllField {
	
	@When("User Empty All the Field")
	def empty_all(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), '')
		WebUI.setMaskedText(findTestObject('LoginPage/Field/Password Field'), '')
		
	}
	
	@And("Allert Username is Required Appear")
	def allert_UsernameReq(){
		WebUI.verifyElementPresent(findTestObject('LoginPage/Allert/Allert Username is required'), 0)
		WebUI.verifyTextPresent('Epic sadface: Username is required', true)
	}
	
	@And("User Close Allert")
	def close_allert(){
		WebUI.click(findTestObject('LoginPage/Button/Btn_Close Allert'))
	}
	
	@Then("Username Field is Empty")
	def check_field(){
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'value', '', 0)
		WebUI.closeBrowser()
	}
	
}

class CheckEmptyPassword {
	
	@And("Allert Password is Required Appear")
	def allert_UsernameReq(){
		WebUI.verifyElementPresent(findTestObject('LoginPage/Allert/Allert Password is required'), 0)
		WebUI.verifyTextPresent('Epic sadface: Password is required', true)
	}
	
	
	@Then("Username Field still Filled")
	def check_field(){
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'value', 'standard_user', 0)
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'value', '', 0)
		WebUI.closeBrowser()
	}
}

class CheckEmptyUsername {
	
	@Then("Password Field still Filled")
	def check_field(){
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'value', GlobalVariable.Password, 0)
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'value', '', 0)
		WebUI.closeBrowser()
	}
}

class CheckErrorUser {
	@When("User input Error Username")
	def filled_error_username(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'error_user')
	}
	
	@And("User Add to Cart")
	def add_cart(){
		WebUI.verifyElementClickable(findTestObject('HomePage/Button/Btn_Add to cart Clickable'))
		
		WebUI.sendKeys(findTestObject('LoginPage/Field/Password Field'), GlobalVariable.Password)
		
		WebUI.verifyTextPresent('Add to cart', true)
		
		WebUI.click(findTestObject('HomePage/Button/Btn_Add to cart Clickable'))
	}
	
	@Then("User cant Remove Cart")
	def remove_cart(){
		WebUI.verifyTextPresent('Remove', true)
		
		WebUI.click(findTestObject('HomePage/Button/Btn_Remove Cart'))
		
		WebUI.verifyNotMatch('Remove', 'Add to cart', true)
		
		WebUI.closeBrowser()
	}
}

class LockedOutUser {
	@When("User input LockedOut Username")
	def lockedout_username(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'locked_out_user')
	}
	
	@And("Allert LockedOut User Appear")
	def allert_lockedout_username(){
		WebUI.verifyElementPresent(findTestObject('LoginPage/Allert/Allert LockedOut User'), 0)
		
		WebUI.verifyTextPresent('Epic sadface: Sorry, this user has been locked out.', true)
	}
	
	@Then("Username and Password Field still Fiiled")
	def check_field(){
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'value', GlobalVariable.Password, 0)
		WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'value', 'locked_out_user', 0)
		WebUI.closeBrowser()
	}
}

class PerfomanceGlitchUser {
	@When("User input Glitch Username")
	def glicth_username(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'performance_glitch_user')
	}
	
	@And("Load HomePage need more time")
	def load_homepage(){
		WebUI.waitForPageLoad(25)
		
		WebUI.verifyElementPresent(findTestObject('HomePage/Lable/Lb_Products'), 25)
		
		WebUI.closeBrowser()
		
	}
	
}

class ProbemUser {
	@When("User input Problem Username")
	def problem_username(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'problem_user')
	}
	
	@Then("Wrong Image of Product Appear")
	def check_product_image(){
		WebUI.verifyNotEqual(findTestObject('HomePage/Source/Img_168b1cce'), findTestObject('HomePage/Source/Img_0a0b85a3'))
		
		WebUI.closeBrowser()
	}
}

class WrongPassword {
	@When("User input wrong password")
	def wrong_username(){
		WebUI.sendKeys(findTestObject('LoginPage/Field/Password Field'), 'miawmiaw')
	}
	
	@And("Allert wrong password Appear")
	def allert_password(){
		WebUI.verifyElementPresent(findTestObject('LoginPage/Allert/Allert Wrong Password'), 0)
		
		WebUI.verifyTextPresent('Epic sadface: Username and password do not match any user in this service', true)
	}
	
}