/**
* 
* 
*
* 
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package io.pleo.heracles.infrastructure.api.common.dto.v1

import io.pleo.heracles.infrastructure.api.common.dto.v1.Header

import com.squareup.moshi.Json
/**
 * 
 * @param header 
 * @param result 
 */
data class ApiErrorResponse (
    @Json(name = "header")
    val header: io.pleo.heracles.infrastructure.api.common.dto.v1.Header,
    @Json(name = "result")
    val result: kotlin.String? = null
) {

}

