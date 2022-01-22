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
    WebUI.click(findTestObject('GlobalObjects/basket_Icon'))

    Boolean crossBtnFound = WebUI.verifyElementPresent(findTestObject('Basket/basket_DeleteProductBtn'), 1, FailureHandling.OPTIONAL)

    while (crossBtnFound) {
        WebUI.click(findTestObject('Basket/basket_DeleteProductBtn'), FailureHandling.OPTIONAL)

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

WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_regressionTest'))

///
'Add list twice'
for (int addToBasketCount = 1; addToBasketCount <= 2; addToBasketCount++) {
    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_AddAllToBasketBtn'))

    WebUI.enhancedClick(findTestObject('ShoppingList/shoppingList_RemoveAllFromListPopUp_cancelBtn'))
}

'go to basket'
WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

'select HD'
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

'select payment method'
WebUI.enhancedClick(findTestObject('Checkout/Payment Method/checkout_billpaymentBtn'))

'pay'
WebUI.enhancedClick(findTestObject('Checkout/checkout_PayBtn'))

'check thank you page heading visible'
WebUI.verifyTextPresent(GlobalVariable.thankYouPageHeading, false)

GlobalVariable.pt_hd_bill = WebUI.getText(findTestObject('ThankYouPage/thankYouPage_orderNumber'))

