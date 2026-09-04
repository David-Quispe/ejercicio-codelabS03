package com.example.piuntosadicionales

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.piuntosadicionales.ui.theme.PiuntosAdicionalesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PiuntosAdicionalesTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ExercisePicker()
                }
            }
        }
    }
}

@Composable
fun ExercisePicker() {
    var selectedExercise by remember { mutableIntStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
        ) {
            Button(
                onClick = { selectedExercise = 0 },
                modifier = Modifier.weight(1f)
            ) {
                Text("Article")
            }
            Button(
                onClick = { selectedExercise = 1 },
                modifier = Modifier.weight(1f)
            ) {
                Text("Tasks")
            }
            Button(
                onClick = { selectedExercise = 2 },
                modifier = Modifier.weight(1f)
            ) {
                Text("Quadrant")
            }
        }
        when (selectedExercise) {
            0 -> ComposeArticleScreen(modifier = Modifier.weight(1f))
            1 -> TaskCompletedScreen(modifier = Modifier.weight(1f))
            else -> ComposeQuadrantScreen(modifier = Modifier.weight(1f))
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PiuntosAdicionalesTheme {
        Greeting("Android")
    }
}
