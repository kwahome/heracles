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


import com.squareup.moshi.Json
/**
 * 
 * @param status 
 * @param errorCode 
 * @param errorMessage 
 */
data class Status (
    @Json(name = "status")
    val status: kotlin.String,
    @Json(name = "errorCode")
    val errorCode: kotlin.String? = null,
    @Json(name = "errorMessage")
    val errorMessage: kotlin.String? = null
) {

}

