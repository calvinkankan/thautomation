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
import java.util.concurrent.ThreadLocalRandom as Keyword
import org.openqa.selenium.Cookie as Cookie
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

'Generate random number'
String randomNumber = String.valueOf(Math.abs(new Random().nextInt() % (99999999 - 11111111)) + 11111111)

'Declare strings'
String eShopperEmail = (('autotesting-' + randomNumber) + GlobalVariable.BU) + '@yopmail.com'

String eShopperFirstNameEnglish = 'Auto Testing'

String eShopperLastNameEnglish = 'ENG eShopper'

String eShopperFirstNameOtherLang = 'Auto Testing ' + randomNumber

String eShopperLastNameOtherLang = 'TH eShopper'

String eShopperMobile = '09' + randomNumber

WebUI.openBrowser('')

'Go to WTCTH UAT'
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

'Go to my account'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_loginBtn'))

//Registration
'click register button'
WebUI.enhancedClick(findTestObject('Login/login_RegisterButton'))

'Enter mobile number'
WebUI.setText(findTestObject('OTP/otp_mobileField'), eShopperMobile)

'Click request OTP button'
WebUI.enhancedClick(findTestObject('OTP/otp_requestOTPBtn'))

'Fill in OTP'
WebUI.setText(findTestObject('OTP/otp_otpField'), GlobalVariable.defaultOTP)

'Submit OTP'
WebUI.enhancedClick(findTestObject('OTP/otp_submitOTPBtn'))

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_english_firstName'), eShopperFirstNameEnglish)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_english_lastName'), eShopperLastNameEnglish)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_thai_firstName'), eShopperFirstNameOtherLang)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_thai_lastName'), eShopperLastNameOtherLang)

'Paste email'
WebUI.sendKeys(findTestObject('Registration/registraion_EmailField'), eShopperEmail)

'Enter pw'
WebUI.sendKeys(findTestObject('Registration/registration_PasswordField'), GlobalVariable.defaultPassword)

WebUI.scrollToElement(findTestObject('Registration/registration_tAndCChkbox'), 0)

'Accpet T&C'
WebUI.check(findTestObject('Registration/registration_tAndCChkbox'))

'submit'
WebUI.enhancedClick(findTestObject('Registration/registration_SubmitButton'))

'Verify welcome text line 1'
WebUI.verifyTextPresent(GlobalVariable.reg_Success_Welcome, false)

'Verify welcome text line 2'
WebUI.verifyTextPresent(GlobalVariable.reg_Success_eShopperText, false)

WebUI.delay(10)

KeywordLogger logger = new KeywordLogger()

logger.logInfo(eShopperEmail)

'Go to my account'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_accountSummaryLink'))

WebUI.enhancedClick(findTestObject('AccountSummary/account_applyCard'))

WebUI.enhancedClick(findTestObject('Registration/registration_eShopperBuyCardBirthYearDropdownBtn'))

WebUI.enhancedClick(findTestObject('Registration/registration_birthYear1'))

WebUI.scrollToElement(findTestObject('Registration/registration_tAndCChkboxEShopperBuyCard'), 0)

'Accpet T&C'
WebUI.check(findTestObject('Registration/registration_tAndCChkboxEShopperBuyCard'))

WebUI.enhancedClick(findTestObject('Registration/registration_buyCardSubmitBtn'))

'Fill in OTP'
WebUI.setText(findTestObject('OTP/otp_otpField'), GlobalVariable.defaultOTP)

'Submit OTP'
WebUI.enhancedClick(findTestObject('OTP/otp_submitOTPBtnEShopperBuyCard'))

WebUI.enhancedClick(findTestObject('Checkout/Payment Method/checkout_creditCardOneTimePayBtn'))

WebUI.enhancedClick(findTestObject('Checkout/checkout_PayBtn'))

'enter credit card credentials'
WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment__creditCardName'), GlobalVariable.masterCard_cardName)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_cardNo'), GlobalVariable.masterCard_cardNo, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_expiryDate'), GlobalVariable.masterCard_expiryDate, 
    FailureHandling.STOP_ON_FAILURE)

WebUI.setText(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabelPayment_cvv'), GlobalVariable.masterCard_cvv)

'confirm credentials'
WebUI.enhancedClick(findTestObject('PaymentGateway/WhiteLabel (TH Only)/whiteLabel_confirmPaymentBtn'))

WebUI.enhancedClick(findTestObject('PaymentGateway/KasikornBank (TH Only)/kasikornBank_requestOTPBtn'))

WebUI.setText(findTestObject('PaymentGateway/KasikornBank (TH Only)/kasikornBank_otpField'), GlobalVariable.masterCard_otp)

WebUI.enhancedClick(findTestObject('PaymentGateway/KasikornBank (TH Only)/kasikornBank_submitBtn'))

'check thank you page heading visible'
WebUI.verifyTextPresent(GlobalVariable.thankYouPageHeading, false)

'check if reached ac summary page'
WebUI.verifyElementVisible(findTestObject('AccountSummary/account_AccountSummaryTitle'), FailureHandling.STOP_ON_FAILURE)

