package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var editText: EditText
    lateinit var editTextUser: EditText
    lateinit var checkDigit: CheckBox
    lateinit var checkCase: CheckBox
    var blackList:List<String> = listOf("pizdec","cyka")
    //var message: Message= Message(0,0,"")
    var currentId = 0
    var senderId = 0
    val messages:MutableList<Message> = arrayListOf()
    var chat=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        editText = findViewById(R.id.editTextTextPersonName2)
        editTextUser= findViewById(R.id.editTextNumber)
        checkDigit=findViewById(R.id.checkBox)
        checkCase=findViewById(R.id.checkBox2)
        button.setOnClickListener {
            chat=""
            if (editText.text.isNotEmpty()&& editTextUser.text.isNotEmpty()) {
                senderId=editTextUser.text.toString().toInt()
                val currentMessage = Message(id = currentId, text = editText.text.toString(),senderId = senderId)
                if(checkCase.isChecked){
                    currentMessage.Lower()
                }
                if(checkDigit.isChecked){
                    currentMessage.NoDigit()
                }
                currentMessage.WordFilter(blackList)
                if (currentId==0){
                    messages.add(currentMessage)
                }else
                {
                    if(messages.last()!!.senderId !=senderId) {
                        messages.add(currentMessage)
                    }else {
                        messages.last()+currentMessage
                    }
                }
                currentId++
                editText.setText("")
                editTextUser.setText("")
                textView.text = ""
                if (messages.isNotEmpty()) {
                    messages.forEach {
                        chat+=it.toString()
                    }
                }
                textView.text =chat
            }

        }
    }
}