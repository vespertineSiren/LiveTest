package com.commentsold.livetest.model

import com.google.gson.annotations.SerializedName

class LTStatusJWT {
    @SerializedName("message")
    var message: String? = null

    @SerializedName("jwt")
    val jwt: String? = null
        get() = field ?: ""

    @SerializedName("success")
    val isSuccessful = false
}
