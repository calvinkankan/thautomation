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
String memberEmail = (('autotesting-' + randomNumber) + GlobalVariable.BU) + '@yopmail.com'

String memberFirstNameEnglish = 'Auto Testing'

String memberLastNameEnglish = 'ENG member'

String memberFirstNameOtherLang = 'Auto Testing ' + randomNumber

String memberLastNameOtherLang = 'TH member'

String memberMobile = '09' + randomNumber

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
WebUI.setText(findTestObject('OTP/otp_mobileField'), memberMobile)

'Click request OTP button'
WebUI.enhancedClick(findTestObject('OTP/otp_requestOTPBtn'))

'Fill in OTP'
WebUI.setText(findTestObject('OTP/otp_otpField'), GlobalVariable.defaultOTP)

'Submit OTP'
WebUI.enhancedClick(findTestObject('OTP/otp_submitOTPBtn'))

WebUI.check(findTestObject('Registration/registration_buyCardChkbox'))

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_english_firstName'), memberFirstNameEnglish)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_english_lastName'), memberLastNameEnglish)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_thai_firstName'), memberFirstNameOtherLang)

'Enter name with randomly generated number'
WebUI.setText(findTestObject('Registration/registration_thai_lastName'), memberLastNameOtherLang)

'Paste email'
WebUI.sendKeys(findTestObject('Registration/registraion_EmailField'), memberEmail)

'Enter pw'
WebUI.sendKeys(findTestObject('Registration/registration_PasswordField'), GlobalVariable.defaultPassword)

WebUI.scrollToElement(findTestObject('Registration/registration_tAndCChkbox'), 0)

'Accpet T&C'
WebUI.check(findTestObject('Registration/registration_tAndCChkbox'))

WebUI.enhancedClick(findTestObject('Registration/registration_birthYearDropdownBtn'))

WebUI.enhancedClick(findTestObject('Registration/registration_birthYear1'))

'submit'
WebUI.enhancedClick(findTestObject('Registration/registration_SubmitButton'))

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

KeywordLogger logger = new KeywordLogger()

logger.logInfo(memberEmail)

'change pw'
WebUI.enhancedClick(findTestObject('AccountSummary/account_changePw'))

'enter old pw'
WebUI.setText(findTestObject('ChangePassword/changePw_oldPw'), GlobalVariable.defaultPassword)

'enter new pw'
WebUI.setText(findTestObject('ChangePassword/changePw_newPw'), GlobalVariable.changePassword)

'enter new pw again'
WebUI.setText(findTestObject('ChangePassword/changePw_confirmNewPw'), GlobalVariable.changePassword)

'click update pw'
WebUI.enhancedClick(findTestObject('ChangePassword/changePw_updatePwBtn'))

'click update pw'
WebUI.enhancedClick(findTestObject('ChangePassword/changePw_updatePwBtn'))

'verify element present : pw updated message'
WebUI.verifyElementVisible(findTestObject('ChangePassword/changePw_PwUpdatedMsg'))

'mouse over the my account btn'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

'click the logout btn'
WebUI.enhancedClick(findTestObject('Home/home_logoutBtn'))

'Add cookie'
driver.manage().addCookie(language)

'Refresh to apply cookie'
WebUI.refresh()

'Go to my account'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_loginBtn'))

'enter login email'
WebUI.setText(findTestObject('Login/login_usernameField'), memberEmail)

'enter pw'
WebUI.setText(findTestObject('Login/login__passwordField'), GlobalVariable.changePassword)

'click login btn'
WebUI.enhancedClick(findTestObject('Login/login_loginButton'))

'mouse over the my account btn'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

'click the logout btn'
WebUI.enhancedClick(findTestObject('Home/home_logoutBtn'))

'Add cookie'
driver.manage().addCookie(language)

'Refresh to apply cookie'
WebUI.refresh()

'Go to my account'
WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_loginBtn'))

'forget pw'
WebUI.enhancedClick(findTestObject('Login/login_forgetPw'))

'click reset pw by email option'
WebUI.check(findTestObject('ForgetPassword/forgetPw_emailResetOption'))

'click next'
WebUI.enhancedClick(findTestObject('ForgetPassword/forgetPw_nextBtn'))

'set loop flag to false'
Boolean whileLoopRanOnce = false

'set email received flag to false'
Boolean resetPwEmailReceived = false

'run loop as long as email is not received'
while (resetPwEmailReceived == false) {
    'run if loop flag is true'
    if (whileLoopRanOnce == true) {
        'go to reset pw page'
        WebUI.navigateToUrl(GlobalVariable.forgetByEmailPageURL)
    }
    
    'enter email '
    WebUI.setText(findTestObject('ForgetPassword/forgetPw_emailField'), memberEmail)

    'confirm email'
    WebUI.enhancedClick(findTestObject('ForgetPassword/forgetPw_confirmEmailBtn'))

    'verify element present : reset pw email has been sent popup'
    WebUI.verifyTextPresent(GlobalVariable.pwResetToEmailMsg, false)

    'wait 10 sec'
    WebUI.delay(10)

    'go to yopmail'
    WebUI.navigateToUrl('http://www.yopmail.com/en/')

    'enter email'
    WebUI.setText(findTestObject('YopmailHomePage/yopmail_EmailField'), memberEmail)

    'click check email button'
    WebUI.enhancedClick(findTestObject('YopmailHomePage/yopmail_CheckInboxBtn'))

    WebUI.switchToFrame(findTestObject('YopmailInbox/iframe_Headers_ifmail'), 5)

    'click the link in the email'
    resetPwEmailReceived = WebUI.verifyElementPresent(findTestObject('YopmailInbox/yopmail_ResetPw'), 3, FailureHandling.OPTIONAL)

    'change loop flag to true'
    whileLoopRanOnce = true
}

'click reset pw link in the email'
WebUI.enhancedClick(findTestObject('YopmailInbox/yopmail_ResetPw'))

'switch to new tab'
WebUI.switchToWindowIndex(1)

'enter new pw'
WebUI.setText(findTestObject('CreateNewPassword/newPw_newPw'), GlobalVariable.defaultPassword)

//'enter new pw again'
//WebUI.setText(findTestObject('CreateNewPassword/newPw_Next'), GlobalVariable.defaultPassword)
'click next'
WebUI.enhancedClick(findTestObject('CreateNewPassword/newPw_Next'))

'verify element present : change pw successful msg'
WebUI.verifyTextPresent(GlobalVariable.changePwSucessfulMsg, false)

//'verify element present : the email is correct'
//WebUI.verifyTextPresent(memberEmail, false)
'click login now'
WebUI.enhancedClick(findTestObject('CreateNewPassword/newPw_LoginNowBtn'))

'fill in login'
WebUI.setText(findTestObject('Login/login_usernameField'), memberEmail)

'fill in pw'
WebUI.setText(findTestObject('Login/login__passwordField'), GlobalVariable.defaultPassword)

'click login btn'
WebUI.click(findTestObject('Login/login_loginButton'))

WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

WebUI.enhancedClick(findTestObject('Home/home_accountSummaryLink'))

'check if reached ac summary page'
WebUI.verifyElementText(findTestObject('AccountSummary/account_AccountSummaryTitle'), GlobalVariable.acSummary_Heading)

