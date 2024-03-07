package com.personalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import java.io.File
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun registerButton (view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun readJSONFromAsset(): String? {
        var json: String? = null
        try {
            val  inputStream:InputStream = assets.open("users.json")
            json = inputStream.bufferedReader().use{it.readText()}
            println(json)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    fun parseJSON() {
        Gson().fromJson(readJSONFromAsset(), HomepageActivity::class.java)
    }

    fun loginButton(view: View) {
        val username = findViewById<EditText>(R.id.username)
        val user = username.text.toString()
        val password = findViewById<EditText>(R.id.password)
        val pass = password.text.toString()

        if (pass == "pass" && user == "user") {
            Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomepageActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
        }
    }

}
