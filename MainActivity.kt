package com.example.loginpage

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
import com.example.loginpage.ui.theme.LoginPageTheme

class MainActivity : ComponentActivity() {
    private lateinit var username:EditText
    private lateinit var password:EditText
    private lateinit var loginbtn:Button

    private val validUsername="user"
    private var validPassword="pass123"

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        username = findViewById(R.id.editTextUname)
        password = findViewById(R.id.editTextPassword)
        loginbtn = findViewById(R.id.loginbtn)

        loginbtn.setOnClickListener{
            val uname = username.text.toString()
            val pass = password.text.toString()
            if(uname == validUsername && pass == validPassword){
                Toast.makeText(this,"Login successful",Toast.LENGTH_SHORT).show()


                val intent = Intent(this, home::class.java)
                startActivity(intent)
            }
            else{
                Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show()
            }
        }

        val regact = findViewById<TextView>(R.id.textViewReg)
        regact.setOnClickListener{
            val intent = Intent(this,reg::class.java)
            startActivity(intent)

        }

    }
}

