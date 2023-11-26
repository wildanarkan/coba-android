package com.example.coba1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.coba1.ui.theme.Coba1Theme
import com.example.coba1.view.UserListActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Coba1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(
                        name = "Adi",
                        onClick = {
                            startActivity(
                                Intent(this, UserListActivity::class.java)
                            )
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, onClick: () -> Unit = {}) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.clickable {
            onClick()
        }

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Coba1Theme {
        Greeting("Android")
    }
}