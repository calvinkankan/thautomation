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

'Create cookie to change language to English'
Cookie language = new Cookie('language', 'en_TH')

WebDriver driver = DriverFactory.getWebDriver()

'Add cookie'
driver.manage().addCookie(language)

'Refresh to apply cookie'
WebUI.refresh()

'Click Accpet to accept all cookies'
WebUI.enhancedClick(findTestObject('GlobalObjects/acceptCookies'), FailureHandling.OPTIONAL)

'enter keyword to search bar (mask)'
WebUI.setText(findTestObject('GlobalObjects/home_searchBar'), GlobalVariable.search_Keyword)

'press enter'
WebUI.sendKeys(findTestObject('GlobalObjects/home_searchBar'), Keys.chord(Keys.ENTER))

'"no result" text not present'
WebUI.verifyTextNotPresent(GlobalVariable.search_NoResult, false)

'verify elements visible'
WebUI.verifyElementVisible(findTestObject('Search/search_CategoryFilter'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Search/search_ResultCountWithKeyword'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Search/search_ResultCount'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Search/search_PLPFilter'), FailureHandling.CONTINUE_ON_FAILURE)

'default sorting in search should be "Most Relevant"'
WebUI.verifyElementText(findTestObject('Search/search_DefaultSorting'), GlobalVariable.search_DefaultSorting)

WebUI.verifyElementVisible(findTestObject('Search/search_PLP'), FailureHandling.CONTINUE_ON_FAILURE)

'apply a category filter'
WebUI.enhancedClick(findTestObject('Search/search_Category_ClickCollect'))

'verify category filter applied'
WebUI.verifyElementText(findTestObject('Search/search_AppliedCategoryFilter'), 'Click & Collect')

'remove applied filter'
WebUI.enhancedClick(findTestObject('Search/search_RemoveAppliedCategoryFilterCrossBtn'))

'applied filter bubble no longer present'
WebUI.verifyElementNotPresent(findTestObject('Search/search_AppliedCategoryFilter'), 3)

