package org.mitmuzaffarpur.attendencemanagement

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.DelicateCoroutinesApi
import okhttp3.OkHttpClient
import org.mitmuzaffarpur.attendencemanagement.domain.MainViewModel
import org.mitmuzaffarpur.attendencemanagement.domain.MainViewModelFactory
import org.mitmuzaffarpur.attendencemanagement.domain.Registration
import org.mitmuzaffarpur.attendencemanagement.domain.Repository
import org.mitmuzaffarpur.attendencemanagement.ui.theme.AttendenceManagementTheme
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ByRegistration : ComponentActivity() {


    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository = repository)
        viewModel =
            ViewModelProvider(this@ByRegistration, viewModelFactory)[MainViewModel::class.java]
         viewModel.response.observe(this, Observer{
             Log.d("ram", "$it")

          if (it != null){
              val intent = Intent(this@ByRegistration, ResultPage::class.java)
              intent.putExtra("name",it[0].name)
              intent.putExtra("reg",it[0].reg_no)
              intent.putExtra("PDay",it[0].No_of_Pres_dates)
              intent.putExtra("TDay",it[0].total_no_of_days)
              intent.putExtra("p",it[0].Present_percentage)
              intent.putExtra("crpImage",it[0].Cropped_image_encoded)
              startActivity(intent)
          }
        })

        setContent {
            RegistrationScreen(this, null) {
                viewModel.getDetails(it)
            }
        }
    }
}

@Composable
fun RegistrationScreen(context: Context, data: ResponseItem?, onCall: (String) -> Unit) {

    var regNumber by remember {
        mutableStateOf("")
    }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.individual),
            contentDescription = "Login screen",
            modifier = Modifier.size(250.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "find the details of individuals")
        Spacer(modifier = Modifier.height(36.dp))
        OutlinedTextField(
            value = regNumber, onValueChange = {
                regNumber = it
            },
            label = {
                Text(text = "Reg. Number")
            }, singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(onClick = { /*TODO*/

            onCall(regNumber)

        }) {
            Text(text = "submit")
        }

//        Text(text = "Ram $data")

    }
}

@OptIn(DelicateCoroutinesApi::class)
fun Devl(context: Context, reg: String) {

    Toast.makeText(context, "hey", Toast.LENGTH_SHORT).show()

//    val httpClient = OkHttpClient.Builder()
//    httpClient.connectTimeout(50000, TimeUnit.MILLISECONDS)
//        .readTimeout(50000, TimeUnit.MILLISECONDS)

//    val retrofit = Retrofit.Builder()
//        .baseUrl()
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//        .create(UsedInterface::class.java)
//
//    val response=retrofit.getStudentInfo(reg)

}
