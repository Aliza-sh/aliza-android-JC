package com.aliza.alizaandroidJC

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.aliza.alizaandroidJC.ui.basic_screen.BasicScreen
import com.aliza.alizaandroidJC.ui.theme.AlizaAndroidJCTheme

lateinit var context: MainActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        context = this
        setContent {
            AlizaAndroidJCTheme {
                BasicScreen()
            }
        }
    }
}

