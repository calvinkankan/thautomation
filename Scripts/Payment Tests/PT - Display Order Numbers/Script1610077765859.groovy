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
import org.codehaus.groovy.runtime.InvokerHelper as InvokerHelper
import com.kms.katalon.core.logging.KeywordLogger as KeywordLogger

KeywordLogger logger = new KeywordLogger()

logger.logInfo('HD + Master: ' + GlobalVariable.pt_hd_master)

logger.logInfo('HD + COD: ' + GlobalVariable.pt_hd_cod)

logger.logInfo('HD + Billpayment: ' + GlobalVariable.pt_hd_bill)

logger.logInfo('HD + QR: ' + GlobalVariable.pt_hd_qr)

logger.logInfo('FD + Master: ' + GlobalVariable.pt_fd_master)

logger.logInfo('FD + Billpayment: ' + GlobalVariable.pt_fd_bill)

logger.logInfo('FD + QR: ' + GlobalVariable.pt_fd_qr)

logger.logInfo('CCS + Visa: ' + GlobalVariable.pt_ccs_visa)

logger.logInfo('CCS + Billpayment: ' + GlobalVariable.pt_ccs_bill)

logger.logInfo('CCS + QR: ' + GlobalVariable.pt_ccs_qr)

logger.logInfo('CCE + JCB: ' + GlobalVariable.pt_cce_jcb)

logger.logInfo('CCE + Billpayment: ' + GlobalVariable.pt_cce_bill)

logger.logInfo('CCE + QR: ' + GlobalVariable.pt_cce_qr)

'calculate spent point amount'
if (GlobalVariable.pointRedemptionTest) {
    'wait 1 minute for point changes to catch up'
    WebUI.delay(60)

    WebUI.refresh()

    WebUI.mouseOver(findTestObject('Home/home_MyAccountBtn'))

    GlobalVariable.endingPointAmount = ((WebUI.getText(findTestObject('Home/home_pointAmount')).trim()) as int)

    int pointSpent = GlobalVariable.startingPointAmount - GlobalVariable.endingPointAmount

    logger.logInfo((((((('Point spent = ' + pointSpent) + ' (') + GlobalVariable.currencySymbol) + GlobalVariable.redeemAmount) + 
        ' redeemed per order, which is ') + GlobalVariable.pointsPerRedeemAmount) + ' points per order)')
}

logger.logInfo('Point redemption test = ' + GlobalVariable.pointRedemptionTest)
logger.logInfo('eVouchers applied ('+GlobalVariable.eVoucher+') = ' + GlobalVariable.eVoucherTest)

