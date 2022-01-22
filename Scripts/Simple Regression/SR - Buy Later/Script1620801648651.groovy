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

WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_loginBtn'))

'fill in login'
WebUI.setText(findTestObject('Login/login_usernameField'), GlobalVariable.defaultLogin)

'fill in pw'
WebUI.setText(findTestObject('Login/login__passwordField'), GlobalVariable.defaultPassword)

'click login btn'
WebUI.click(findTestObject('Login/login_loginButton'))

WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_accountSummaryLink'))

'check if reached ac summary page'
WebUI.verifyElementText(findTestObject('AccountSummary/account_AccountSummaryTitle'), GlobalVariable.acSummary_Heading)

WebUI.navigateToUrl(GlobalVariable.defaultURL)

//Delete items in shopping cart if found any
Boolean shoppingCartItemCountNotZero = !(WebUI.getText(findTestObject('GlobalObjects/basket_ItemCount')).equals('0'))

'see if there is anything in the cart, delete if any'
if (shoppingCartItemCountNotZero) {
    'go to basket'
    WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

    Boolean crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)

    while (crossBtnFound) {
        WebUI.enhancedClick(findTestObject('Basket/basket_DeleteProductBtn'), FailureHandling.CONTINUE_ON_FAILURE)

        crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)
    }
}

///
'mouse over the my account btn'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

'go to shopping list'
WebUI.enhancedClick(findTestObject('Home/home_shoppingList'))

//make sure the default shopping list is selected
WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_dropdownBtn'))

WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_regressionTest'))

///
'Add list twice'
for (int addToBasketCount = 1; addToBasketCount <= 2; addToBasketCount++) {
    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_AddAllToBasketBtn'))

    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_RemoveAllFromListPopUp_cancelBtn'))
}

//'check cart total should be 6'
//WebUI.verifyElementText(findTestObject('GlobalObjects/basket_ItemCount'), '6')
'go to basket'
WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

for (int buyNextTimeCount = 1; buyNextTimeCount <= 2; buyNextTimeCount++) {
    WebUI.enhancedClick(findTestObject('Basket/basket_buyNextTime'))
}

//'check cart total should be 2'
//WebUI.verifyElementText(findTestObject('GlobalObjects/basket_ItemCount'), '2')
WebUI.enhancedClick(findTestObject('Basket/basket_addToBag'))

WebUI.enhancedClick(findTestObject('Basket/basket_DeleteProductBtn_buyNextTime'))

