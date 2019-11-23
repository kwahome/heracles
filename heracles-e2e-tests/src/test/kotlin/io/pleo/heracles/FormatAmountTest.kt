package io.pleo.heracles

import io.pleo.heracles.config.Config
import io.pleo.heracles.pageobjects.FormatAmountPageObject
import io.pleo.heracles.selenium.WebDriverFactory
import io.pleo.heracles.selenium.WebDriverType
import org.junit.jupiter.api.Test
import org.openqa.selenium.WebDriver

class FormatAmountTest {

    private val url = Config.HERACLES_HOST

    // list of browsers to test against
    // we can add in more
    // we can also make it more configurable without code intervention
    private val browsers: List<WebDriverType> = listOf(WebDriverType.FIREFOX)

    @Test
    fun testAgainstSeveralBrowsers() {
        browsers.forEach { browser ->
            // initialize once for each browser's tests gives better performance
            val webDriver: WebDriver = WebDriverFactory.getDriver(browser)
            val testCases = TestCases(url, FormatAmountPageObject(webDriver))

            try {
                testCases.formIsDisplayed()
                testCases.invalidAndMissingInputsBehaviour()
                testCases.buttonActivatedAfterInputProvided()
                testCases.validInputsSubmitted()
                testCases.formatAmountWithLocaleIfSupplied()
                testCases.formatAmountWithCustomOptions()
            } finally {
                // clean up the driver after this browser tests have run
                webDriver.quit()
            }
        }
    }
}
