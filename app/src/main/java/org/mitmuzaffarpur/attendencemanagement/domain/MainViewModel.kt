package org.mitmuzaffarpur.attendencemanagement.domain

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.mitmuzaffarpur.attendencemanagement.ResponseItem
import org.mitmuzaffarpur.attendencemanagement.ResponseItemList

class MainViewModel(val repository: Repository):ViewModel() {


    val response : MutableLiveData<ResponseItemList> = MutableLiveData()

    fun getDetails(registration: String){
        viewModelScope.launch {
            response.value = repository.getDetails(registration)
//            Log.d("ram","${response.value}")

        }
    }

}