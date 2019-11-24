import axios from "axios";
import uuid from "uuid/v4";
import Urls from "../resources/Urls";
import getHeaders from "../utils/ApiRequestHelper"

declare const tsConfig: any;

export default class FormatAmountService {

    public static formatAmount(data: any = {}) {
        const url = `${Urls.FORMAT_AMOUNT_URL}`;
        const headers = getHeaders()
        const request: any = {}

        const instance = axios.create({
            headers: headers,
        });

        request.header = {
            groupId: headers.groupId,
            messageId: headers.messageId,
            timestamp:  headers.timestamp,
        };

        request.amount = {
            currency: data.currency,
            value: data.value,
            precision: data.precision
        }

        request.locale = data.locale
        request.decimalPlaces = data.decimalPlaces
        request.thousandsSeparator = data.thousandsSeparator
        request.decimalSeparator = data.decimalSeparator

        return instance.post(url, request)
    }
}
