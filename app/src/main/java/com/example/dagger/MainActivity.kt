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
    lateinit var button_hello:Button
    lateinit var button_login:Button
    lateinit var button_deposit:Button
    lateinit var button_withdraw:Button
    lateinit var button_logout:Button
    lateinit var output: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //after succesful build/install, the DaggerCommandRouter error should be gone
        val commandRouterFactory: CommandRouterFactory = DaggerCommandRouterFactory.create()
        editText=findViewById(R.id.command_line)
        button=findViewById(R.id.button)
        button_hello=findViewById(R.id.button_hello)
        button_deposit=findViewById(R.id.button_deposit)
        button_login=findViewById(R.id.button_login)
        button_withdraw=findViewById(R.id.button_withdraw)
        button_logout=findViewById(R.id.button_logout)
        output=findViewById(R.id.output)
        val commandRouter = commandRouterFactory.router()
        commandRouter.output=output
        button.setOnClickListener{commandRouter.route(editText.text.toString())}
        button_hello.setOnClickListener{editText.setText("hello")}
        button_deposit.setOnClickListener{editText.setText("deposit 100")}
        button_login.setOnClickListener{editText.setText("login user")}
        button_withdraw.setOnClickListener{editText.setText("withdraw 40")}
        button_logout.setOnClickListener{editText.setText("logout")}

    }
}
