import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.model.FailureHandling

import java.nio.file.Files
import java.nio.file.Path as Path
import java.nio.file.Paths as Paths

import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable as GlobalVariable

/**
 * TC5 verifies 2 profile photo in the target web page are similar each other
 */


WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

TestObject testObject1 = findTestObject('Object Repository/Page_Katalon Discussion/img_Commentator', ['index':1])
TestObject testObject6 = findTestObject('Object Repository/Page_Katalon Discussion/img_Commentator', ['index':8])


WebUI.verifyElementPresent(testObject6, 10)

CustomKeywords.'com.kazurayam.ksbackyard.ScreenshotDriver.verifyImagesAreDifferent'(
	testObject1,
	testObject6,
	5.0,
	FailureHandling.CONTINUE_ON_FAILURE)

WebUI.closeBrowser()
