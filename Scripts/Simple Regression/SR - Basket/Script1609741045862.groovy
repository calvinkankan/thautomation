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

//'check cart total should be 2'
//WebUI.verifyElementText(findTestObject('GlobalObjects/basket_ItemCount'), '2')
//
//'go back to brand listing page'
//WebUI.back()
//
//WebUI.enhancedClick(findTestObject('BrandLandingPage/brandLandingPage_Product1_QuickAddToBasketBtn'))
//
//'check cart total should be 3'
//WebUI.verifyElementText(findTestObject('GlobalObjects/basket_ItemCount'), '3')

'go to basket'
WebUI.enhancedClick(findTestObject('GlobalObjects/basket_Icon'))

'check elements visible\r\n'
WebUI.verifyElementVisible(findTestObject('Basket/bastket_PLP'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_productInfoImg'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_DeleteProductBtn'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_productInfoContent'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_productInfoUnitPrice'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_productInfoQty'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_productInfoSubtotal'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_deliveryMethods'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_deliveryFee'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_billBreakdown'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_promotionBox'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_rightCheckoutBtn'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_bottomBillBreakdown'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Basket/basket_bottomTotal'), FailureHandling.CONTINUE_ON_FAILURE)

'checkout'
WebUI.enhancedClick(findTestObject('Basket/basket_leftCheckoutBtn'))

