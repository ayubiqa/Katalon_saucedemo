import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.basicURL)

WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'standard_user')

WebUI.sendKeys(findTestObject('LoginPage/Field/Password Field'), 'miawmiaw')

WebUI.click(findTestObject('LoginPage/Button/Btn_Login'))

WebUI.verifyElementPresent(findTestObject('LoginPage/Allert/Allert Wrong Password'), 0)

WebUI.verifyTextPresent('Epic sadface: Username and password do not match any user in this service', true)

WebUI.click(findTestObject('LoginPage/Button/Btn_Close Allert'))

WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Username Field'), 'value', 'standard_user', 0)

WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'value', 'miawmiaw', 0)

WebUI.clearText(findTestObject('LoginPage/Field/Password Field'))

//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('LoginPage/Field/Password Field'))
//element.sendKeys(Keys.chord(Keys.COMMAND, "a"))
//WebElement element = WebUiCommonHelper.findWebElement(findTestObject('LoginPage/Field/Password Field'))
//element.sendKeys(Keys.chord(Keys.DELETE))

WebUI.verifyElementAttributeValue(findTestObject('LoginPage/Field/Password Field'), 'value', '', 0)
WebUI.closeBrowser()

