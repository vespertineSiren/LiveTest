package com.commentsold.livetest.data.remote

import com.commentsold.livetest.model.LTStatusJWT
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface LiveTestService {

    @GET("guest/token")
    suspend fun getGuestToken(): Response<LTStatusJWT>
}
