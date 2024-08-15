package org.mitmuzaffarpur.attendencemanagement.domain

import org.mitmuzaffarpur.attendencemanagement.ResponseItemList

class Repository2 {

    suspend fun getAllDetails(college: String, course:String, batch:String): ResponseItemList {
        return RetrofitInstance2.api.getAllStudentInfo(college,course,batch).body()!!
    }
}