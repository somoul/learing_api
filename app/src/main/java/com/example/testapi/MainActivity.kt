package com.example.testapi

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapi.model.listData
import com.example.testapi.ui.theme.TestAPITheme
import com.example.testapi.viewmodel.MainViewModel
import com.example.testapi.viewmodel.PlaceHolderViewModel
import com.example.testapi.viewmodel.PutPlaceHolderViewModel
import com.example.testapi.viewmodel.TestMainViewModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: PlaceHolderViewModel by viewModels() // from get MainViewModel
//        viewModel.fetchData()// from call function get data api
//         val testViewModel : TestMainViewModel by viewModels()
//        testViewModel.getDataAPi()
        val viewPlaceHolderViewModel: PlaceHolderViewModel by viewModels()
//        viewPlaceHolderViewModel.pushPlaceHolder()
        val viewUpdatePlaceHolderViewModel: PutPlaceHolderViewModel by viewModels()

        setContent {
            HomeScreen(viewModel, viewPlaceHolderViewModel, viewUpdatePlaceHolderViewModel)
//            if (listData.isEmpty()) {
//
//                CircularProgressIndicator(
//                    color = Color.Red,
//                    strokeWidth = 5.dp,
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .wrapContentWidth(align = Alignment.CenterHorizontally)
//                        .wrapContentHeight(align = Alignment.CenterVertically)
//                )
//
//            } else
//                Column() {
//                    Text(text = "Show API : ${listData[0].name}")
//                    Text(text = "Show API : ${listData[0].actor}")
//                    Text(text = "Show API : ${listData[0].ancestry}")
//
//                }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    viewModel: PlaceHolderViewModel,
    viewModelPush: PlaceHolderViewModel,
    viewUpdateModel: PutPlaceHolderViewModel
) {
    Scaffold() {
//        val viewModel: MainViewModel by viewModels()
//        val viewModel: MainViewModel

        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(align = Alignment.CenterVertically)
                .padding(start = 15.dp, end = 15.dp)
        ) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .clip(shape = RoundedCornerShape(15f))
                .background(Color.Red)
                .clickable {
                    println("============ GET DATA=========")
                    viewModel.getPlaceHolder()
                }) {
                Text(
                    text = "GET DATA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )

            }

            Box(modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
                .height(50.dp)
                .clip(shape = RoundedCornerShape(15f))
                .background(Color.Red)
                .clickable {
                    println("============ PUSH DATA=========")

                    viewModelPush.pushPlaceHolder()
                }) {
                Text(
                    text = "PUSH DATA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )

            }

            Box(modifier = Modifier
                .padding(top = 15.dp)
                .fillMaxWidth()
                .height(50.dp)

                .clip(shape = RoundedCornerShape(15f))
                .background(Color.Red)
                .clickable {
                    println("============ UPDATE DATA=========")
                    viewUpdateModel.putPlaceHolderViewModel()
                }
            ) {
                Text(
                    text = "UPDATE DATA",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )

            }

        }

    }

}


