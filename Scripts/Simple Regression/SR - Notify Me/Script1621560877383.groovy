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
import org.openqa.selenium.By as By
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.interactions.Actions as Actions
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger
import org.openqa.selenium.Cookie as Cookie

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

'enter keyword(mask) to search bar'
WebUI.setText(findTestObject('GlobalObjects/home_searchBar'), 'BP_')

'press enter'
WebUI.sendKeys(findTestObject('GlobalObjects/home_searchBar'), Keys.chord(Keys.ENTER))

'"no result" text not present'
WebUI.verifyTextNotPresent(GlobalVariable.search_NoResult, false)

WebUI.enhancedClick(findTestObject('Search/search_notifyMeBtn1'))

WebUI.enhancedClick(findTestObject('Search/search_notifyMeBtn2'))

'mouse over the my account btn'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

'go to notify me'
WebUI.enhancedClick(findTestObject('Home/home_notifyMe'))

String eleCount = driver.findElements(By.className('price')).size()

assert eleCount == '2'

WebUI.enhancedClick(findTestObject('Notify Me/notifyMe_removeProductCrossBtn'))

eleCount = driver.findElements(By.className('price')).size()

assert eleCount == '1'

WebUI.enhancedClick(findTestObject('Notify Me/notifyMe_emptylist'))

WebUI.verifyElementNotPresent(findTestObject('Notify Me/notifyMe_product'), 3)

