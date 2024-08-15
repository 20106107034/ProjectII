package org.mitmuzaffarpur.attendencemanagement.domain

import com.google.gson.annotations.SerializedName
import org.mitmuzaffarpur.attendencemanagement.ResponseItemList
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface APIService2 {


    @FormUrlEncoded
    @POST("/retrieve_whole_class_attendance")
    suspend fun getAllStudentInfo(@Field("college") collage: String,
                                  @Field("course") course:String,
                                  @Field("batch") batch: String
    ): Response<ResponseItemList>


}

data class ALLStudent(@SerializedName("college") val collage:String,
    @SerializedName("course") val course:String,
    @SerializedName("batch") val batch:String


)