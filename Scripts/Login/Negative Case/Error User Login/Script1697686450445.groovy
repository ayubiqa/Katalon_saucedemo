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

WebUI.openBrowser('')

WebUI.maximizeWindow()

WebUI.navigateToUrl(GlobalVariable.basicURL)

WebUI.sendKeys(findTestObject('LoginPage/Field/Username Field'), 'error_user')

WebUI.click(findTestObject('LoginPage/Button/Btn_Login'))

WebUI.verifyElementPresent(findTestObject('HomePage/Lable/Lb_Products'), 10)

WebUI.verifyElementClickable(findTestObject('HomePage/Button/Btn_Add to cart Clickable'))

WebUI.sendKeys(findTestObject('LoginPage/Field/Password Field'), GlobalVariable.Password)

WebUI.verifyTextPresent('Add to cart', true)

WebUI.click(findTestObject('HomePage/Button/Btn_Add to cart Clickable'))

WebUI.verifyTextPresent('Remove', true)

WebUI.click(findTestObject('HomePage/Button/Btn_Remove Cart'))

WebUI.verifyNotMatch('Remove', 'Add to cart', true)

WebUI.closeBrowser()

