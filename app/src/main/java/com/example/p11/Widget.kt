package com.example.p11

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.p11.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

    private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =  ActivityWidgetBinding.inflate(layoutInflater)

        setContentView(binding.root)

        binding.btnToast.setOnClickListener{
            Toast.makeText(this, "Ini Toast. Great Job!", Toast.LENGTH_SHORT).show()

        }


        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it,"Ini Snackbar. Hebat!",Snackbar.LENGTH_SHORT).show()

        }

        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Message")
                setMessage("Ini adalah Alert!")

                setPositiveButton("OK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda memilih OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
                setNegativeButton("BACK"){dialog, _ ->
                    Toast.makeText(applicationContext, "Anda memilih OK", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }
            }.show()
        }


        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btnCancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btnCancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Canceled", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

                btnContinue.setOnClickListener {
                    Toast.makeText(applicationContext, "Continue", Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }

            }.show()


        }

    }
}