package io.pleo.heracles.selenium

import io.github.bonigarcia.wdm.WebDriverManager
import java.util.concurrent.TimeUnit
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.ie.InternetExplorerDriver
import org.openqa.selenium.opera.OperaDriver
import org.openqa.selenium.safari.SafariDriver

/**
 * Web driver factory so that driver creation behaviour
 * is controlled from one place.
 */
object WebDriverFactory {

    fun getDriver(driverType: WebDriverType, timeout: Long? = 60): WebDriver {
        val driver: WebDriver
        val browserName = System.getProperty("browser", driverType.toString()).toUpperCase()
        when (WebDriverType.valueOf(browserName)) {
            WebDriverType.CHROME -> {
                WebDriverManager.chromedriver().setup()
                driver = ChromeDriver()
            }

            WebDriverType.EDGE -> {
                WebDriverManager.edgedriver().setup()
                driver = EdgeDriver()
            }
            WebDriverType.FIREFOX -> {
                WebDriverManager.firefoxdriver().setup()
                driver = FirefoxDriver()
            }

            WebDriverType.IE -> {
                WebDriverManager.iedriver().setup()
                driver = InternetExplorerDriver()
            }

            WebDriverType.OPERA -> {
                WebDriverManager.operadriver().setup()
                driver = OperaDriver()
            }

            WebDriverType.SAFARI -> {
                // WebDriverManager.setup()
                driver = SafariDriver()
            }
        }
        driver.manage().window().maximize()
        driver.manage().timeouts().implicitlyWait(timeout!!, TimeUnit.SECONDS)
        return driver
    }
}
