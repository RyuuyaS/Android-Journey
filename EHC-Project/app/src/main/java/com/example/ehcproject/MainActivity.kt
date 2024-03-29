package com.example.ehcproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.ehcproject.ui.navigation.EhcScreen
import com.example.ehcproject.ui.theme.EHCProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EHCProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EhcApp()
                }
            }
        }
    }
}

@Composable
fun EhcApp() {
    EhcScreen()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EHCProjectTheme {
        EhcApp()
    }
}