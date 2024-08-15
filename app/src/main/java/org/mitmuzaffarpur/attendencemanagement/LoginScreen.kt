package org.mitmuzaffarpur.attendencemanagement

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(context: Context){

    var userId by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()

    ){
        Image(painter = painterResource(id = R.drawable.lasm),
            contentDescription ="Login screen",
            modifier = Modifier.size(250.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = "welcome back", fontSize = 32.sp, fontWeight= FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "login for attendance view")

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value =userId, onValueChange ={
            userId=it
        }, label = {
            Text(text = "UserId")
        }, singleLine = true )

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(value =password, onValueChange ={
            password=it
        }, label = {
            Text(text = "Password")
        }, singleLine = true)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = {

//            if(userId=="Sudhir119" && password=="Sudhir@123"){
            val intent = Intent(context, AttendenceUsing::class.java)
            /*intent.putExtras(bundle) used bundle for passing data*/
            context.startActivity(intent)
//        }
//            else{
//                Toast.makeText(context,"password or userId not matched ", Toast.LENGTH_SHORT).show()
//            }


        }) {
            Text(text = "Login")

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "forgot Password?", modifier = Modifier.clickable {  })
        Spacer(modifier = Modifier.height(100.dp))




    }


}



