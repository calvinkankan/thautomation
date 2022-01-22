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

WebUI.navigateToUrl(GlobalVariable.defaultURL)

//Delete items in shopping cart if found any
Boolean shoppingCartItemCountNotZero = !(WebUI.getText(findTestObject('GlobalObjects/basket_ItemCount')).equals('0'))

'see if there is anything in the cart, delete if any'
if (shoppingCartItemCountNotZero) {
    'go to basket'
    WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

    Boolean crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)

    while (crossBtnFound) {
        WebUI.enhancedClick(findTestObject('Basket/basket_DeleteProductBtn'), FailureHandling.OPTIONAL)

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

WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_cce'))

///
'Add list twice'
for (int addToBasketCount = 1; addToBasketCount <= 2; addToBasketCount++) {
    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_AddAllToBasketBtn'))

    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_RemoveAllFromListPopUp_cancelBtn'))
}

'go to basket'
WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

'select cc'
WebUI.enhancedClick(findTestObject('Basket/Delivery Method/basket_deliveryMethodDropdownBtn'))

'select cc'
WebUI.enhancedClick(findTestObject('Basket/Delivery Method/basket_ccOption'))

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

Boolean viewMapBtnIsNotVisible = WebUI.verifyElementNotVisible(findTestObject('Checkout/CC - Select Store/checkout_selectCCStore_viewMapBtn'), 
    FailureHandling.OPTIONAL)

'select a store if none selected'
if (viewMapBtnIsNotVisible) {
    'click select store btn'
    WebUI.enhancedClick(findTestObject('Checkout/CC - Select Store/checkout_selectCCStoreBtn'))

    //    'open the town dropdown'
    //    WebUI.enhancedClick(findTestObject('Checkout/CC - Select Store/checkout_selectCCStore_townDropdownArrow'))
    //
    //    WebUI.enhancedClick(findTestObject('Checkout/CC - Select Store/checkout_selectCCStore_townDropdownBox'))
    'confirm selection'
    WebUI.enhancedClick(findTestObject('Checkout/CC - Select Store/checkout_selectCCStore_confirmStoreBtn'))
}

'select payment method'
WebUI.enhancedClick(findTestObject('Checkout/Payment Method/checkout_creditCardOneTimePayBtn'))

'pay'
WebUI.enhancedClick(findTestObject('Checkout/checkout_PayBtn'))

'enter credit card credentials'
WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment__creditCardName'), GlobalVariable.jcb_cardName)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_cardNo'), GlobalVariable.jcb_cardNo, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_expiryDate'), GlobalVariable.jcb_expiryDate, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_cvv'), GlobalVariable.jcb_cvv)

'confirm credentials'
WebUI.enhancedClick(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabel_confirmPaymentBtn'))

WebUI.enhancedClick(findTestObject('JCB_PaymentGateway (TH Only)/jcb_requestOTPBtn'))

WebUI.setText(findTestObject('JCB_PaymentGateway (TH Only)/jcb_otpField'), GlobalVariable.jcb_otp)

WebUI.enhancedClick(findTestObject('JCB_PaymentGateway (TH Only)/jcb_submitOTPBtn'))

'check thank you page heading visible'
WebUI.verifyTextPresent(GlobalVariable.thankYouPageHeading, false)

GlobalVariable.pt_cce_jcb = WebUI.getText(findTestObject('ThankYouPage/thankYouPage_orderNumber'))

