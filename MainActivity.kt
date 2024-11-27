package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.counter.ui.theme.CounterTheme
import android.widget.TextView
import android.widget.Button


class MainActivity : ComponentActivity() {

    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val counterTextView: TextView = findViewById(R.id.counterTextView)
        val incrementbtn: Button = findViewById(R.id.incrementbtn)
        val decrementbtn: Button = findViewById(R.id.decrementbtn)

        incrementbtn.setOnClickListener{
            counter++
            counterTextView.text = counter.toString()
        }

        decrementbtn.setOnClickListener{
            counter--
            counterTextView.text = counter.toString()
        }


    }
}

