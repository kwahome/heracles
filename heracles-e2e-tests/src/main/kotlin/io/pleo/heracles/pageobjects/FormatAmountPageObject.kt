package io.pleo.heracles.pageobjects

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class FormatAmountPageObject(private val driver: WebDriver) {

    @FindBy(id = "formatAmountForm")
    internal val formatAmountForm: WebElement? = null

    @FindBy(id = "currency")
    internal val currencyInputField: WebElement? = null

    @FindBy(id = "currencyInputError")
    internal val currencyInputErrorField: WebElement? = null

    @FindBy(id = "value")
    internal val valueInputField: WebElement? = null

    @FindBy(id = "valueInputError")
    internal val valueInputErrorField: WebElement? = null

    @FindBy(id = "precision")
    internal val precisionInputField: WebElement? = null

    @FindBy(id = "precisionInputError")
    internal val precisionInputErrorField: WebElement? = null

    @FindBy(id = "locale")
    internal val localeInputField: WebElement? = null

    @FindBy(id = "decimalPlaces")
    internal val decimalPlacesInputField: WebElement? = null

    @FindBy(id = "thousandsSeparator")
    internal val thousandsSeparatorInputField: WebElement? = null

    @FindBy(id = "decimalSeparator")
    internal val decimalSeparatorInputField: WebElement? = null

    @FindBy(id = "formatAmountSubmit")
    internal val submitButton: WebElement? = null

    @FindBy(id = "formattedAmountPaper")
    internal val formattedAmountContainer: WebElement? = null

    init {
        PageFactory.initElements(driver, this)
    }

    fun openUrl(url: String) {
        this.driver.get(url)
    }
}
