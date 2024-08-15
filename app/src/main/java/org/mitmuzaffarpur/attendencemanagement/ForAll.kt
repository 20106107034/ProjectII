package org.mitmuzaffarpur.attendencemanagement

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import org.mitmuzaffarpur.attendencemanagement.domain.ALLStudent
import org.mitmuzaffarpur.attendencemanagement.domain.MainViewModel2
import org.mitmuzaffarpur.attendencemanagement.domain.MainViewModelFactory2
import org.mitmuzaffarpur.attendencemanagement.domain.Repository2

class ForAll : ComponentActivity() {

    private lateinit var viewModel: MainViewModel2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = Repository2()
        val viewModelFactory = MainViewModelFactory2(repository = repository)
        viewModel =
            ViewModelProvider(this@ForAll, viewModelFactory)[MainViewModel2::class.java]
        viewModel.response.observe(this, Observer {
            Log.d("ram", "$it")

            if (it != null) {
                val intent = Intent(this@ForAll, ResultPage2All::class.java)
                intent.putExtra("name", it[0].name)
                intent.putExtra("reg", it[0].reg_no)
                intent.putExtra("PDay", it[0].No_of_Pres_dates)
                intent.putExtra("TDay", it[0].total_no_of_days)
                intent.putExtra("p", it[0].Present_percentage)
                intent.putExtra("crpImage", it[0].Cropped_image_encoded)
                startActivity(intent)
            }
        })

        setContent {

//            AllScreen(this,null)
            var college by remember {
                mutableStateOf("")
            }
            var course by remember {
                mutableStateOf("")
            }
            var batch by remember{
                mutableStateOf("")
                
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.all),
                    contentDescription = "Login screen",
                    modifier = Modifier.size(250.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Search Details of Whole Class overall", textAlign = TextAlign.Center)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = college, onValueChange = {
                    college = it
                },
                    label = {
                        Text(text = "College")
                    }, singleLine = true)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = course, onValueChange = {
                    course = it
                },
                    label = {
                        Text(text = "Course")
                    }, singleLine = true)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(value = batch, onValueChange = {
                    batch = it
                },
                    label = {
                        Text(text = "batch")
                    }, singleLine = true)
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedButton(onClick = { /*TODO*/
                    viewModel.getAllDetails(college,course,batch)

                }) {
                    Text(text = "submit")
                }
            }



        }
    }
}

//