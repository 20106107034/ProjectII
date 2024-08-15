package org.mitmuzaffarpur.attendencemanagement.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.mitmuzaffarpur.attendencemanagement.ResponseItemList

class MainViewModel2(val repository: Repository2): ViewModel() {


    val response : MutableLiveData<ResponseItemList> = MutableLiveData()

    fun getAllDetails(college: String,course:String,batch:String){
        viewModelScope.launch {
            response.value = repository.getAllDetails(college,course,batch)
            Log.d("ram","${response.value}")

        }
    }

}