package io.pleo.heracles.infrastructure.api.common.errors

enum class ErrorCodes(val value: String) {
    UNKNOWN_FAILURE("unknownFailure"),
    INVALID_REQUEST_ERR("invalidRequest"),
    INVALID_METHOD_ERR("invalidMethod"),
    INVALID_API_KEY_ERR("invalidAPIKey"),
    MISSING_PARAMETER_ERR_MSG("invalidRequest.missingParameter"),
    MISSING_HEADER_ERR_MSG("invalidRequest.missingHeader"),
    MISSING_MESSAGE_ID_HEADER_ERR_MSG("invalidRequest.missingMessageIdHeader"),
    MISSING_TIMESTAMP_HEADER_ERR_MSG("invalidRequest.missingTimestampHeader"),
    CONFLICTING_GROUP_ID_ERR_MSG("invalidRequest.conflictingGroupId"),
    CONFLICTING_MESSAGE_ID_ERR_MSG("invalidRequest.conflictingMessageId"),
    INVALID_TIMESTAMP_ERR_MSG("invalidRequest.invalidTimestamp"),
}
