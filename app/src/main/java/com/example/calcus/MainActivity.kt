package com.example.calcus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //Числа и точка
        c_One.setOnClickListener {pokazat_Na_Gendalphe("1", true)}
        c_Two.setOnClickListener {pokazat_Na_Gendalphe("2", true)}
        c_Three.setOnClickListener {pokazat_Na_Gendalphe("3", true)}
        c_Four.setOnClickListener {pokazat_Na_Gendalphe("4", true)}
        c_Five.setOnClickListener {pokazat_Na_Gendalphe("5", true)}
        c_Six.setOnClickListener {pokazat_Na_Gendalphe("6", true)}
        c_Seven.setOnClickListener {pokazat_Na_Gendalphe("7", true)}
        c_Eight.setOnClickListener {pokazat_Na_Gendalphe("8", true)}
        c_Nine.setOnClickListener {pokazat_Na_Gendalphe("9", true)}
        c_Zero.setOnClickListener {pokazat_Na_Gendalphe("0", true)}
        c_Dot.setOnClickListener {pokazat_Na_Gendalphe(".", true)}


        //Операции
        c_Plus.setOnClickListener {pokazat_Na_Gendalphe("+", false)}
        c_Minus.setOnClickListener {pokazat_Na_Gendalphe("-", false)}
        c_Div.setOnClickListener {pokazat_Na_Gendalphe("/", false)}
        c_Multi.setOnClickListener {pokazat_Na_Gendalphe("*", false)}
        c_Open.setOnClickListener {pokazat_Na_Gendalphe("(", false)}
        c_Close.setOnClickListener {pokazat_Na_Gendalphe(")", false)}



        //Очистка
        c_Ass.setOnClickListener {
            c_Expression.text = ""
            c_Result.text = ""
        }


        //Вычисление
        c_Equals.setOnClickListener{
            try {
                val Vopros_Gendalfa = ExpressionBuilder(c_Expression.text.toString()).build()
                val Otvet_Gendalfa = Vopros_Gendalfa.evaluate()
                val Dlinniy_Otvet = Otvet_Gendalfa.toLong()
                if(Otvet_Gendalfa == Dlinniy_Otvet.toDouble())
                    c_Result.text =  Dlinniy_Otvet.toString()
                else
                    c_Result.text = Otvet_Gendalfa.toString()



            }
            catch (e:Exception)
            {
                Log.d("Исключение:"," " +e.message )
            }



        }




        //Стереть 1 символ
        c_Del.setOnClickListener {
            val stroka = c_Expression.text.toString()
            if(stroka.isNotEmpty())
            {
                c_Expression.text = stroka.substring(0, stroka.length-1)
            }
            c_Result.text = ""
        }




    }


    fun pokazat_Na_Gendalphe(stroka: String, Mozhno_Ochistit: Boolean)
    {

        if(c_Result.text.isNotEmpty())
        {
            c_Expression.text = ""
        }
        if(Mozhno_Ochistit)
        {
            c_Result.text = ""
            c_Expression.append(stroka) }
        else
        {
            c_Expression.append(c_Result.text)
            c_Expression.append(stroka)
            c_Result.text = ""
        }

    }



    }