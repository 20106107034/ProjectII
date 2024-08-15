package org.mitmuzaffarpur.attendencemanagement.domain

import org.mitmuzaffarpur.attendencemanagement.ResponseItem
import org.mitmuzaffarpur.attendencemanagement.ResponseItemList

class Repository {

    suspend fun getDetails(registration: String): ResponseItemList {
       return RetrofitInstance.api.getStudentInfo(registration).body()!!
    }

}