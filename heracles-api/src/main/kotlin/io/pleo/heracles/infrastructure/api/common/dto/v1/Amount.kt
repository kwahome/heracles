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
 * @param value 
 * @param currency 
 * @param precision 
 */
data class Amount (
    @Json(name = "value")
    val value: kotlin.Long,
    @Json(name = "currency")
    val currency: kotlin.String,
    @Json(name = "precision")
    val precision: kotlin.Int
) {

}

