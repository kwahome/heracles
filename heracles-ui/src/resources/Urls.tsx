declare const tsConfig: any;

export default class Urls {

    // tsConfig.FORMAT_AMOUNT_HOST not found with jest
    // need to fix this but in the meantime

    public static FORMAT_AMOUNT_URL = "http://localhost:8080" + "/api/v1/formatAmount";
}
