package org.mitmuzaffarpur.attendencemanagement

import android.app.DatePickerDialog
import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.mitmuzaffarpur.attendencemanagement.ui.theme.AttendenceManagementTheme
import java.util.Calendar

class SpecificDate : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpecificScreen(context = this)
        }
    }
}

@Composable
fun SpecificScreen(context: Context){
        var date by remember {
            mutableStateOf("")
        }
        var college by remember {
            mutableStateOf("")
        }
        var course by remember {
            mutableStateOf("")
        }
        var batch by remember {
            mutableStateOf("")
        }

        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            date = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day
    )

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.datei),
                contentDescription = "Login screen",
                modifier = Modifier.size(250.dp)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Search Details of Whole Class on specific Date", textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = date,
                onValueChange = { date = it },
                label = { Text(text = "Date") },
                modifier = Modifier.clickable { datePickerDialog.show() }
            )

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
//                viewModel.getAllDetails(college,course,batch)

            }) {
                Text(text = "submit")
            }


    }
}

