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

'Generate random number'
String eShopperFirstNameEnglish = 'Auto Testing'

String eShopperLastNameEnglish = 'ENG eShopper'

String eShopperMobile = '09' + String.valueOf(Math.abs(new Random().nextInt() % (99999999 - 11111111)) + 11111111)

String addressFiller = '43120'

'check elements visible'
WebUI.verifyElementVisible(findTestObject('Checkout/checkout_deliveryInfoSection'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_deliveryOptionsSection'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_codeVoucherSection'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Checkout/Payment Method/checkout_paymentMethodSection'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('Checkout/checkout_PayBtn'), FailureHandling.CONTINUE_ON_FAILURE)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Checkout/HD - New Address/checkout_newAddress_firstName'), eShopperFirstNameEnglish)

WebUI.setText(findTestObject('Checkout/HD - New Address/checkout_newAddress_lastName'), eShopperLastNameEnglish)

'Enter TH mobile'
WebUI.setText(findTestObject('Checkout/HD - New Address/checkout_newAddress_mobile'), eShopperMobile)

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_ProvinceDropdownBtn'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_Province1'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_DistrictDropdownBtn'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_District1'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_SubDistrictDropdownBtn'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_SubDistrict1'))

WebUI.setText(findTestObject('Checkout/HD - New Address/checkout_newAddress_Address1'), addressFiller)

WebUI.scrollToElement(findTestObject('Checkout/HD - New Address/checkout_newAddress_AddToAddressBkChkbox'), 0)

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_AddToAddressBkChkbox'))

WebUI.enhancedClick(findTestObject('Checkout/HD - New Address/checkout_newAddress_Save and Ship to this address'))

'verify address has been added'
WebUI.verifyTextPresent(eShopperFirstNameEnglish, false)

WebUI.verifyTextPresent(eShopperMobile, false)

WebUI.verifyTextPresent(addressFiller, false)

