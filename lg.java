package com.example.linearlogin
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
class MainActivity : AppCompatActivity() {
override fun onCreate(savedInstanceState: Bundle?) {
super.onCreate(savedInstanceState)
setContentView(R.layout.activity_main)
val loginButton: Button = findViewById(R.id.login_button)
val usernameEditText: EditText = findViewById(R.id.username)
val passwordEditText: EditText = findViewById(R.id.password)
loginButton.setOnClickListener {
val username = usernameEditText.text.toString()
val password = passwordEditText.text.toString()
if (username == "admin" && password == "password") {
Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
} else {
Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
}
}
}
}