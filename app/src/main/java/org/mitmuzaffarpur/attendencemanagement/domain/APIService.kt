package org.mitmuzaffarpur.attendencemanagement.domain

import com.google.gson.annotations.SerializedName
import org.mitmuzaffarpur.attendencemanagement.ResponseItem
import org.mitmuzaffarpur.attendencemanagement.ResponseItemList
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST


interface APIService {


    @FormUrlEncoded
    @POST("/retrieve_image_uploaded_reg")
    suspend fun getStudentInfo(@Field("reg_no") reg_no: String): Response<ResponseItemList>


}

data class Registration(@SerializedName("reg_no") val registration: String)
