package com.example.dagger

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dagger.command.CommandRouterFactory
import com.example.dagger.command.DaggerCommandRouterFactory

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var button_login:Button
    lateinit var button_deposit:Button
    lateinit var output: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //after succesful build/install, the DaggerCommandRouter error should be gone
        val commandRouterFactory: CommandRouterFactory = DaggerCommandRouterFactory.create()
        editText=findViewById(R.id.command_line)
        button=findViewById(R.id.button)
        button_deposit=findViewById(R.id.button_deposit)
        button_login=findViewById(R.id.button_login)
        output=findViewById(R.id.output)
        val commandRouter = commandRouterFactory.router()
        commandRouter.output=output
        button.setOnClickListener{commandRouter.route(editText.text.toString())}
        button_deposit.setOnClickListener{editText.setText("deposit 100")}
        button_login.setOnClickListener{editText.setText("login user")}

    }
}
