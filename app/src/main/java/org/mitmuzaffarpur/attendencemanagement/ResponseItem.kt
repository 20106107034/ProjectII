package org.mitmuzaffarpur.attendencemanagement

data class ResponseItem(
    val name: String,
    val reg_no: String,
    val total_no_of_days: Int,
    val No_of_Pres_dates: Int,
    val Present_percentage: Double,
    val Cropped_image_encoded:String
)
