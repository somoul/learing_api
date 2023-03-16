package com.example.testapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapi.model.listData
import com.example.testapi.ui.theme.TestAPITheme
import com.example.testapi.viewmodel.MainViewModel
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: MainViewModel by viewModels()

        viewModel.fetchData()
        setContent {
            if (listData.isEmpty()) {

                CircularProgressIndicator(
                    color = Color.Red,
                    strokeWidth = 5.dp,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentWidth(align = Alignment.CenterHorizontally)
                        .wrapContentHeight(align = Alignment.CenterVertically)
                )

            } else
                Column() {
                    Text(text = "Show API : ${listData[0].name}")
                    Text(text = "Show API : ${listData[0].actor}")
                    Text(text = "Show API : ${listData[0].ancestry}")

                }
            }
        }
    }


