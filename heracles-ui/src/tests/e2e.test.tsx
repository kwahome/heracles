import {Builder, By, until} from 'selenium-webdriver';
import firefox from "selenium-webdriver/firefox";
import chrome from "selenium-webdriver/chrome";
import path from "path";

const getElementById = async (driver, id, timeout = 2000) => {
    const el = await driver.wait(until.elementLocated(By.id(id)), timeout);
    return driver.wait(until.elementIsVisible(el), timeout)
        .then(function() {
            driver.navigate().back();
        }, function (error) {
            console.log("Error happened!");
            console.log(error);
        });
};

const getElementByXPath = async (driver, xpath, timeout = 2000) => {
    const el = await driver.wait(until.elementLocated(By.xpath(xpath)), timeout)
    // return await driver.wait(until.elementIsVisible(el), timeout)
    return driver.wait(until.elementIsVisible(el), timeout)
        .then(function() {
            driver.navigate().back();
        }, function (error) {
            console.log("Error happened!");
            console.log(error);
        });
}

describe("format amount end to end tests", () => {
    const url = 'http://localhost:3000'
    let driver;

    describe("chrome browser", () => {

        beforeAll(async () => {
            const options = new chrome.Options();
            options.headless();
            driver = new Builder()
                .forBrowser("chrome")
                .setChromeOptions(options)
                .build();
        });

        afterAll(async () => {
            await driver.quit();
        });

        it('initialises the context', async () => {
            await driver.get(url)
        })

        test("return the correct formatted amount", async () => {
            const btn = await getElementById(driver, "formatAmountSubmit");
            await btn.click();

            const output = await getElementById(driver, "output");
            const outputVal = await output.getAttribute("value");

            expect(outputVal).toEqual("");
        });
    })

    describe("firefox browser", () => {

        const url = "http://localhost:3000"

        beforeAll(async () => {
            const options = new firefox.Options();
            options.headless();
            driver = new Builder()
                .forBrowser("firefox")
                .setFirefoxOptions(options)
                .build();
        });

        afterAll(async () => {
            await driver.quit();
        });

        it('initialises the context', async () => {
            await driver.get(url)
        })

        test("return the correct formatted amount", async () => {

            const btn = await getElementById(driver, "value");
            await btn.click();

            const output = await getElementById(driver, "output");
            const outputVal = await output.getAttribute("value");

            expect(outputVal).toEqual("");
        });
    })
});
