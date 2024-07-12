package com.jemutai.androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginActivityScreen()
        }
    }
}

@Composable
fun LoginActivityScreen() {
    val activity = (LocalContext.current as? ComponentActivity)
    activity?.setContent {
        LoginActivityContent()
    }
}
