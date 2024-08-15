package org.mitmuzaffarpur.attendencemanagement

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UsedInterface {
    @FormUrlEncoded
    @POST("/get_student_info")
    fun getStudentInfo(@Field("registration_number") registrationNumber: String):Call<ResponseItem>
}