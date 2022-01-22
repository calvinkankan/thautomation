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

//WebUI.openBrowser('')
'Go to brand listing page'
WebUI.navigateToUrl(GlobalVariable.brandPage_URL)

'click adidas'
WebUI.enhancedClick(findTestObject('BrandListingPage/brandPage_Biore'))

WebUI.enhancedClick(findTestObject('BrandLandingPage/brandLandingPage_ShowAllProducts'))

'check banner'
WebUI.verifyElementVisible(findTestObject('BrandLandingPage/brandLandingPage_Banner'), FailureHandling.CONTINUE_ON_FAILURE)

'check filter bar'
WebUI.verifyElementVisible(findTestObject('BrandLandingPage/brandLandingPage_PLPFilter'), FailureHandling.CONTINUE_ON_FAILURE)

'check PLP list'
WebUI.verifyElementVisible(findTestObject('BrandLandingPage/brandLandingPage_PLP'), FailureHandling.CONTINUE_ON_FAILURE)

'check category filter on the left'
WebUI.verifyElementVisible(findTestObject('BrandLandingPage/brandLandingPage_CategoryFilter'), FailureHandling.CONTINUE_ON_FAILURE)

'check default sorting is 暢銷商品'
WebUI.verifyElementText(findTestObject('BrandLandingPage/brandLandingPage_PLPFilterDefaultSorting'), GlobalVariable.subCat_defaultSorting)

WebUI.check(findTestObject('BrandLandingPage/brandLandingPage_inStockFilter'))

WebUI.scrollToElement(findTestObject('BrandLandingPage/brandLandingPage_PLP_Product1'), 3)

'go to pdp'
WebUI.enhancedClick(findTestObject('BrandLandingPage/brandLandingPage_PLP_Product1'))

'check pdp heading'
WebUI.verifyElementVisible(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_Heading'), FailureHandling.CONTINUE_ON_FAILURE)

'check buy bar'
WebUI.verifyElementVisible(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_buyBar'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementVisible(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_AddToWishListBtn'), FailureHandling.CONTINUE_ON_FAILURE)

'add 2 to qty'
WebUI.enhancedClick(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_AddQtyBtn'))

WebUI.enhancedClick(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_AddQtyBtn'))

'remove 1 qty'
WebUI.enhancedClick(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_RmQtyBtn'))

'add to cart'
WebUI.enhancedClick(findTestObject('PDP_BrandProduct1/PDP_BrandProduct1_AddToBasketBtn'))

