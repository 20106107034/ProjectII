package org.mitmuzaffarpur.attendencemanagement

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ViewScreen(context: Context){

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ){
        Image(painter = painterResource(id = R.drawable.ams),
            contentDescription ="Login screen",
            modifier = Modifier.size(250.dp))
        Spacer(modifier = Modifier.height(4.dp))
        Text("search for individual or all ")
        Spacer(modifier = Modifier.height(32.dp))

        OutlinedButton(onClick = { /*TODO*/
            val intent = Intent(context, ByRegistration::class.java)
            /*intent.putExtras(bundle) used bundle for passing data*/
            context.startActivity(intent)
        }) {
            Text(text = "click for individual")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = { /*TODO*/
            val intent = Intent(context,SpecificDate::class.java)
            /*intent.putExtras(bundle) used bundle for passing data*/
            context.startActivity(intent)
        }) {
            Text(text = "specific date")
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(onClick = { /*TODO*/
            val intent = Intent(context, ForAll::class.java)
            /*intent.putExtras(bundle) used bundle for passing data*/
            context.startActivity(intent)}) {
            Text(text = "all")
        }


    }
    
    
    
}