package io.pleo.heracles

import io.pleo.heracles.pageobjects.FormatAmountPageObject

/**
 * Class containing end to end test cases.
 */
class TestCases(
    private val url: String,
    private val formatAmountPageObject: FormatAmountPageObject
) {
    fun formIsDisplayed() {
        formatAmountPageObject.openUrl(url)
        assert(formatAmountPageObject.formatAmountForm!!.isDisplayed)
        assert(formatAmountPageObject.currencyInputField!!.isDisplayed)
        assert(formatAmountPageObject.valueInputField!!.isDisplayed)
        assert(formatAmountPageObject.precisionInputField!!.isDisplayed)
        assert(formatAmountPageObject.localeInputField!!.isDisplayed)
        assert(formatAmountPageObject.decimalPlacesInputField!!.isDisplayed)
        assert(formatAmountPageObject.thousandsSeparatorInputField!!.isDisplayed)
        assert(formatAmountPageObject.decimalSeparatorInputField!!.isDisplayed)
        assert(formatAmountPageObject.submitButton!!.isDisplayed)
    }

    fun invalidAndMissingInputsBehaviour() {
        formatAmountPageObject.openUrl(url)
        formatAmountPageObject.currencyInputField!!.sendKeys("KES")
        formatAmountPageObject.submitButton!!.click()

        assert(!formatAmountPageObject.submitButton.isEnabled)
        assert(formatAmountPageObject.valueInputErrorField!!.text == "Amount value in minor units is required")
        assert(formatAmountPageObject.precisionInputErrorField!!.text == "Amount precision is required")
    }

    fun buttonActivatedAfterInputProvided() {
        formatAmountPageObject.openUrl(url)
        formatAmountPageObject.valueInputField!!.sendKeys("1000")
        formatAmountPageObject.submitButton!!.click()

        assert(!formatAmountPageObject.submitButton.isEnabled)
        assert(formatAmountPageObject.currencyInputErrorField!!.text == "Amount currency is required")
        assert(formatAmountPageObject.precisionInputErrorField!!.text == "Amount precision is required")

        formatAmountPageObject.currencyInputField!!.sendKeys("KES")
        formatAmountPageObject.precisionInputField!!.sendKeys("2")

        assert(formatAmountPageObject.submitButton.isEnabled)
    }

    fun validInputsSubmitted() {
        formatAmountPageObject.openUrl(url)
        formatAmountPageObject.currencyInputField!!.sendKeys("KES")
        formatAmountPageObject.valueInputField!!.sendKeys("100000")
        formatAmountPageObject.precisionInputField!!.sendKeys("2")
        formatAmountPageObject.submitButton!!.click()

        assert(formatAmountPageObject.formattedAmountContainer!!.text == "Formatted Amount: KES 1,000.00")
    }

    fun formatAmountWithLocaleIfSupplied() {
        formatAmountPageObject.openUrl(url)
        formatAmountPageObject.currencyInputField!!.sendKeys("DKK")
        formatAmountPageObject.valueInputField!!.sendKeys("100000")
        formatAmountPageObject.precisionInputField!!.sendKeys("2")
        formatAmountPageObject.localeInputField!!.sendKeys("da_DK")
        formatAmountPageObject.submitButton!!.click()

        assert(formatAmountPageObject.formattedAmountContainer!!.text == "Formatted Amount: DKK 1.000,000")
    }

    fun formatAmountWithCustomOptions() {
        formatAmountPageObject.openUrl(url)
        formatAmountPageObject.currencyInputField!!.sendKeys("DKK")
        formatAmountPageObject.valueInputField!!.sendKeys("100000")
        formatAmountPageObject.precisionInputField!!.sendKeys("2")
        formatAmountPageObject.localeInputField!!.sendKeys("da_DK")
        formatAmountPageObject.decimalPlacesInputField!!.sendKeys("4")
        formatAmountPageObject.thousandsSeparatorInputField!!.sendKeys(" ")
        formatAmountPageObject.decimalSeparatorInputField!!.sendKeys(";")
        formatAmountPageObject.localeInputField.sendKeys("da_DK")
        formatAmountPageObject.submitButton!!.click()

        assert(formatAmountPageObject.formattedAmountContainer!!.text == "Formatted Amount: DKK 1 000;0000")
    }
}
