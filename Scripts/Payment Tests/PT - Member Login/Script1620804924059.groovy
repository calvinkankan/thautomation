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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory

'Generate random number'
String randomNumber = String.valueOf(Math.abs(new Random().nextInt() % 99) + 1)

String randomPhoneNumber = '9' + String.valueOf(Math.abs(new Random().nextInt() % (999999999 - 111111111)) + 111111111)

String randomAddress = String.valueOf(randomNumber)

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.defaultURL)

'Create cookie to change language to English'
Cookie language = new Cookie('language', 'en_TH')

WebDriver driver = DriverFactory.getWebDriver()

'Add cookie'
driver.manage().addCookie(language)

'Refresh to apply cookie'
WebUI.refresh()

'Click Accpet to accept all cookies'
WebUI.enhancedClick(findTestObject('GlobalObjects/acceptCookies'), FailureHandling.OPTIONAL)

WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_loginBtn'))

'fill in login'
WebUI.setText(findTestObject('Login/login_usernameField'), GlobalVariable.defaultLogin)

'fill in pw'
WebUI.setText(findTestObject('Login/login__passwordField'), GlobalVariable.defaultPassword)

'click login btn'
WebUI.enhancedClick(findTestObject('Login/login_loginButton'))

WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_accountSummaryLink'))

'check if reached ac summary page'
WebUI.verifyElementVisible(findTestObject('AccountSummary/account_AccountSummaryTitle'), FailureHandling.STOP_ON_FAILURE)

'capture starting point balance'
if (GlobalVariable.pointRedemptionTest) {
    WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

    GlobalVariable.startingPointAmount = ((WebUI.getText(findTestObject('Home/home_pointAmount')).trim()) as int)
}

