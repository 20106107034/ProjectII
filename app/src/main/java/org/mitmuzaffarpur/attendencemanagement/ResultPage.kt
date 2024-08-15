package org.mitmuzaffarpur.attendencemanagement

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.tooling.preview.Preview
import org.mitmuzaffarpur.attendencemanagement.ui.theme.AttendenceManagementTheme
import android.util.Base64
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


class ResultPage : ComponentActivity() {

    private var name: String? = null
    private var reg: String? = null
    private var PDay: Int? = null
    private var TDay: Int? = null
    private var PP:Double?=null
    private  var crpI:String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = intent.extras
        intent?.let {
            name = it.getString("name")
            reg = it.getString("reg")
            PDay = it.getInt("PDay")
            TDay = it.getInt("TDay")
            PP= it.getDouble("p")
            crpI=it.getString("crpImage")

        }

        setContent {

//            val byteArray = Base64.decode(crpI, Base64.DEFAULT)
        fun decodeBase64(crp: String?): ByteArray {
            val byteArray = Base64.decode(crp, Base64.DEFAULT)
            return byteArray
        }
            val byteArray=decodeBase64(crpI)
            val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.size)
            Text(text = "Attendance Details of $reg", fontSize = 18.sp, fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(8.dp,8.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()

            ) {
                Image(bitmap = bitmap.asImageBitmap(),
                    contentDescription =null, modifier = Modifier.size(250.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text("Name : $name", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Reg.No: $reg", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Presence % : $PP",fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Your presence day : $PDay")
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Total class day : $TDay")
                Spacer(modifier = Modifier.height(8.dp))


            }



        }
    }
}



