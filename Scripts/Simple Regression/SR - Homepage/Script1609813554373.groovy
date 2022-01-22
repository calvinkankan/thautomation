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

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.defaultURL)

Cookie lang = new Cookie('language', 'en_TH')

WebDriver driver = DriverFactory.getWebDriver()

driver.manage().addCookie(lang)

WebUI.verifyElementPresent(findTestObject('Home/home_watsonsLogo'), 0)

WebUI.verifyElementPresent(findTestObject('Home/home_banners'), 0)

WebUI.verifyElementPresent(findTestObject('Home/home_quickLinks'), 0)

WebUI.verifyElementPresent(findTestObject('Home/home_PLP'), 0)

WebUI.verifyElementPresent(findTestObject('Home/home_promotionBanners'), 0)

WebUI.verifyElementPresent(findTestObject('Home/home_bottomBannerCarousel'), 0)

WebUI.verifyElementPresent(findTestObject('GlobalObjects/siteCookiePrompt'), 0, FailureHandling.OPTIONAL)

