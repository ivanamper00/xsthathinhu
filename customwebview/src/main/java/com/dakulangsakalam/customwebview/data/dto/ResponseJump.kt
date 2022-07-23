package com.dakulangsakalam.customwebview.data.dto

import androidx.annotation.Keep

@Keep
data class ResponseJump(
    val httpCode: Int,
    val response: List<Response>
)