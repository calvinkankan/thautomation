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

WebUI.navigateToUrl(GlobalVariable.defaultURL)

WebDriver driver = DriverFactory.getWebDriver()

WebElement watsonLogo = driver.findElement(By.xpath('//cx-page-slot[@class="SiteLogo has-components ng-star-inserted"]/*/*/*/img'))

Actions actions = new Actions(driver)

actions.keyDown(Keys.SHIFT).click(watsonLogo).keyUp(Keys.SHIFT).perform()

WebUI.switchToWindowIndex(0)

//Delete items in shopping cart if found any
Boolean shoppingCartItemCountNotZero = !(WebUI.getText(findTestObject('GlobalObjects/basket_ItemCount')).equals('0'))

'see if there is anything in the cart, delete if any'
if (shoppingCartItemCountNotZero) {
    'go to basket'
    WebUI.click(findTestObject('GlobalObjects/basket_Icon'))

    Boolean crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)

    while (crossBtnFound) {
        WebUI.click(findTestObject('Basket/basket_DeleteProductBtn'), FailureHandling.CONTINUE_ON_FAILURE)

        crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)
    }
}

WebUI.enhancedClick(findTestObject('Home/home_MyAccountBtn'))

///
'mouse over the my account btn'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

'go to shopping list'
WebUI.enhancedClick(findTestObject('Home/home_shoppingList'))

//make sure the default shopping list is selected
WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_dropdownBtn'))

WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_fd'))

///
'Add list twice'
for (int addToBasketCount = 1; addToBasketCount <= 2; addToBasketCount++) {
    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_AddAllToBasketBtn'))

    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_RemoveAllFromListPopUp_cancelBtn'))
}

'go to basket'
WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

'select FD'
WebUI.enhancedClick(findTestObject('Basket/Delivery Method/basket_deliveryMethodDropdownBtn'))

WebUI.enhancedClick(findTestObject('Basket/Delivery Method/basket_hdOption'))

'apply evoucher if enabled in global variable'
if (GlobalVariable.eVoucherTest) {
	WebUI.setText(findTestObject('Basket/basket_promoCodeField'), GlobalVariable.eVoucher)

	WebUI.enhancedClick(findTestObject('Basket/basket_applyPromoBtn'))
}

'checkout'
WebUI.enhancedClick(findTestObject('Basket/basket_leftCheckoutBtn'))

'redeem points if point redemption test is required'
if (GlobalVariable.pointRedemptionTest) {
    'open ewallet'
    WebUI.enhancedClick(findTestObject('Checkout/checkout_codeVoucherSection'))

    WebUI.setText(findTestObject('Checkout/checkout_pointRedemptionField'), GlobalVariable.redeemAmount)

    WebUI.enhancedClick(findTestObject('Checkout/checkout_pointRedemptionbtn'))
}

WebUI.enhancedClick(findTestObject('Checkout/checkout_fdBtn'))

'select payment method'
WebUI.enhancedClick(findTestObject('Checkout/Payment Method/checkout_qrCodeBtn'))

'pay'
WebUI.enhancedClick(findTestObject('Checkout/checkout_PayBtn'))

WebUI.delay(10)

WebUI.switchToFrame(findTestObject('PaymentGateway/WhiteLabel (TH Only)/iframe_View my notify me _kpaymentframe'), 3)

String qrID = WebUI.getText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_qrCodeID'))

WebUI.switchToWindowIndex(1, FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(GlobalVariable.kpaymentGatewayQRCodeSimulator)

WebUI.setText(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_loginField'), GlobalVariable.kpaymentGateway_login)

WebUI.setText(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_pwField'), GlobalVariable.kpaymentGateway_pw)

WebUI.sendKeys(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_pwField'), Keys.chord(Keys.ENTER))

WebUI.delay(5)

WebUI.enhancedClick(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_QRCodeSimulator'))

WebUI.setText(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_qrIDField'), qrID)

WebUI.click(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_qrSubmitBtn'))

WebUI.click(findTestObject('K_PaymentGateway (TH Only)/kPaymentGateway_qrPayBtn'))

WebUI.delay(3)

WebUI.closeWindowIndex(1)

WebUI.switchToWindowIndex(0)

WebUI.delay(3)

'check thank you page heading visible'
WebUI.verifyTextPresent(GlobalVariable.thankYouPageHeading, false)

GlobalVariable.pt_fd_qr = WebUI.getText(findTestObject('ThankYouPage/thankYouPage_orderNumber'))

