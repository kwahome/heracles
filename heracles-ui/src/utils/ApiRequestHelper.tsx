import uuid from "uuid/v4";

declare const tsConfig: any;

export default function getHeaders() {
    return {
        "groupId": uuid(),
        "messageId" : uuid(),
        "timestamp" : new Date().toISOString(),
        "Authorization" : tsConfig.API_KEY,
        "Content-Type": "application/json",
        "sessionId": localStorage.getItem("sessionId"),
    }
}
