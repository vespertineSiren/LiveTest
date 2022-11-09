package com.commentsold.livetest.data.remote

import com.commentsold.livetest.model.LTStatusJWT
import retrofit2.Call
import retrofit2.http.GET

interface LiveTestService {

    @GET("guest/token")
    fun getGuestToken(): Call<LTStatusJWT>
}
