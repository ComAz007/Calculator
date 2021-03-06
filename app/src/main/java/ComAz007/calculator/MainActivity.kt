package ComAz007.calculator

import TokenScanner
import ComAz007.calculator.Libs.expression.Parser
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private val  fieldsV: TextView by lazy{ findViewById(R.id.math_operation)}
    private val  fieldsRes: TextView by lazy{ findViewById(R.id.result_text)}

    //val userName: String by lazy{ db.getUser().name}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
    }

    fun setTextFields(str: String){
        //val fieldsV: TextView = findViewById(R.id.math_operation)
        //val fieldsRes: TextView = findViewById(R.id.result_text)
        if( fieldsRes.text !="") {
            fieldsV.text = fieldsRes.text
            fieldsRes.text = ""
        }
        //btn10.setOncklickListener{setTextFields("0")}
        fieldsV.append(str)
    }

    fun setupViews(){
        val btn0: TextView = findViewById(R.id.btn_0)
        btn0.setOnClickListener{setTextFields("0")}

        val btn1: TextView = findViewById(R.id.btn_1)
        btn1.setOnClickListener{setTextFields("1")}

        val btn2: TextView = findViewById(R.id.btn_2)
        btn2.setOnClickListener{setTextFields("2")}

        val btn3: TextView = findViewById(R.id.btn_3)
        btn3.setOnClickListener{setTextFields("3")}

        val btn4: TextView = findViewById(R.id.btn_4)
        btn4.setOnClickListener{setTextFields("4")}

        val btn5: TextView = findViewById(R.id.btn_5)
        btn5.setOnClickListener{setTextFields("5")}

        val btn6: TextView = findViewById(R.id.btn_6)
        btn6.setOnClickListener{setTextFields("6")}

        val btn7: TextView = findViewById(R.id.btn_7)
        btn7.setOnClickListener{setTextFields("7")}

        val btn8: TextView = findViewById(R.id.btn_8)
        btn8.setOnClickListener{setTextFields("8")}

        val btn9: TextView = findViewById(R.id.btn_9)
        btn9.setOnClickListener{setTextFields("9")}

        val btnMinus: TextView = findViewById(R.id.btn_minus)
        btnMinus.setOnClickListener{setTextFields("-")}

        val btnPlus: TextView = findViewById(R.id.btn_plus)
        btnPlus.setOnClickListener{setTextFields("+")}

        val btnMult: TextView = findViewById(R.id.btn_mult)
        btnMult.setOnClickListener{setTextFields("*")}

        val btnDivis: TextView = findViewById(R.id.btn_division)
        btnDivis.setOnClickListener{setTextFields("/")}

        val btnLB: TextView = findViewById(R.id.btn_LeftBrace)
        btnLB.setOnClickListener{setTextFields("(")}

        val btnRB: TextView = findViewById(R.id.btn_RightBrace)
        btnRB.setOnClickListener{setTextFields(")")}

        val btnDT: TextView = findViewById(R.id.btn_dot)
        btnDT.setOnClickListener{setTextFields(".")}

        val btnAC: TextView = findViewById(R.id.btn_clear)
        btnAC.setOnClickListener{
            fieldsV.text=""
            fieldsRes.text=""
        }

        val btnBS: TextView = findViewById(R.id.btn_back)
        btnBS.setOnClickListener{
            //val fieldsV: TextView = findViewById(R.id.math_operation)
            val str= fieldsV.text.toString()
            fieldsV.text=str.substring(0,str.length-1)
            //val fieldsRes: TextView = findViewById(R.id.result_text)
            fieldsRes.text=""
        }

        val btnEQ: TextView = findViewById(R.id.btn_equal)
        //val fieldsV: TextView = findViewById(R.id.math_operation)
        //val fieldsRes: TextView = findViewById(R.id.result_text)
        btnEQ.setOnClickListener{
            try {

                val str= fieldsV.text.toString()
                val operations = TokenScanner(str).scanOperations()
                val result = Parser(operations).parse()

                fieldsRes.text=result.evaluate().toString()
                /*val ex=ExpressionBuilder(str).build()
                val result=ex.evaluate()

                val longRes=result.toLong()

                if (result==longRes.toDouble())
                    fieldsRes.text=longRes.toString()
                else
                    fieldsRes.text=result.toString()*/

            }
            catch (e:Exception){
                Log.d("????????????", "??????????????????: ${e.message}")
            }
        }
    }
}