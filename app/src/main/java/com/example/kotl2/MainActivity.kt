package com.example.kotl2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace

interface Communicator {
    fun passData(editTextInput: String, option: Number)
}

private fun calculator(firstNum: Int, secondNum: Int, operator: String): String {
    if (operator == "+") {
        val result = firstNum + secondNum
        return "$firstNum $operator $secondNum = $result"
    }

    if (operator == "-") {
        val result = firstNum - secondNum
        return "$firstNum $operator $secondNum = $result"
    }

    if (operator == "*") {
        val result = firstNum * secondNum
        return "$firstNum $operator $secondNum = $result"
    }

    if (operator == "/") {
        val result = firstNum / secondNum
        return "$firstNum $operator $secondNum = $result"
    }

    if (operator == "%") {
        val result = firstNum % secondNum
        return "$firstNum $operator $secondNum = $result"
    }

    return "result"
}

class MainActivity : AppCompatActivity(), Communicator {
    private var firstNum: Int = 0
    private var secondNum: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).visibility = View.INVISIBLE
        findViewById<Button>(R.id.button).setOnClickListener {
            supportFragmentManager.commit {
                val frag1 = supportFragmentManager.findFragmentByTag("first")
                if (frag1 != null) {
                    val count = supportFragmentManager.backStackEntryCount
                    for (i in count downTo 0) {
                        supportFragmentManager.popBackStack()
                    }
                    replace(R.id.containerView, frag1)
                }
            }
        }

        findViewById<Button>(R.id.button2).visibility = View.INVISIBLE
        findViewById<Button>(R.id.button2).setOnClickListener {
            supportFragmentManager.commit {
                val frag2 = supportFragmentManager.findFragmentByTag("second")
                if (frag2 != null) {
                    val count = supportFragmentManager.backStackEntryCount
                    for (i in count downTo 1) {
                        supportFragmentManager.popBackStack()
                    }
                    replace(R.id.containerView, frag2)
                    addToBackStack(null)
                }
            }
        }

        findViewById<Button>(R.id.button3).visibility = View.INVISIBLE
        findViewById<Button>(R.id.button3).setOnClickListener {
            supportFragmentManager.commit {
                val frag3 = supportFragmentManager.findFragmentByTag("third")
                if (frag3 != null) {
                    val count = supportFragmentManager.backStackEntryCount
                    for (i in count downTo 2) {
                        supportFragmentManager.popBackStack()
                    }
                    replace(R.id.containerView, frag3)
                    addToBackStack(null)
                }
            }
        }

        findViewById<Button>(R.id.button4).visibility = View.INVISIBLE
        findViewById<Button>(R.id.button4).setOnClickListener {
            supportFragmentManager.commit {
                val frag4 = supportFragmentManager.findFragmentByTag("fourth")
                if (frag4 != null) {
                    val count = supportFragmentManager.backStackEntryCount
                    for (i in count downTo 3) {
                        supportFragmentManager.popBackStack()
                    }
                    replace(R.id.containerView, frag4)
                    addToBackStack(null)
                }
            }
        }

        supportFragmentManager.commit {
            add<FirstFragment>(R.id.containerView, "first")
        }
    }

    override fun passData(editTextInput: String, option: Number) {
        if (option == 1) {
            firstNum = editTextInput.toInt()
            this.supportFragmentManager.commit {
                replace(R.id.containerView, SecondFragment(), "second")
                addToBackStack(null)
            }
        }

        if (option == 2) {
            secondNum = editTextInput.toInt()
            this.supportFragmentManager.commit {
                replace(R.id.containerView, ThirdFragment(), "third")
                addToBackStack(null)
            }
        }

        if (option == 3) {
            val bundle = Bundle()
            val frag = FourthFragment()

            bundle.putString("result", calculator(firstNum, secondNum, editTextInput))
            frag.arguments = bundle

            this.supportFragmentManager.commit {
                replace(R.id.containerView, frag, "fourth")
                addToBackStack(null)
            }
        }
    }
}
