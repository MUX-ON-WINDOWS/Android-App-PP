package com.personalproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register) // Replace with the correct layout resource
    }
    fun regAccountButton(view: View) {
        Toast.makeText(this, "Account aangemaakt", Toast.LENGTH_SHORT).show()
        val accountMade = Intent(this, MainActivity::class.java)
        startActivity(accountMade)
    }
}