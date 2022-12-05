package com.example.dagger

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var output: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        editText=findViewById(R.id.command_line)
        button=findViewById(R.id.button)
        output=findViewById(R.id.output)
        val commandRouter = CommandRouter(output)
        button.setOnClickListener{commandRouter.route(editText.text.toString())}

    }
}
