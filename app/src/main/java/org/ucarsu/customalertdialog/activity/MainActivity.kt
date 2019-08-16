package org.ucarsu.customalertdialog.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatEditText
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.ucarsu.customalertdialog.R
import org.ucarsu.customalertdialog.enums.DialogType
import org.ucarsu.customalertdialog.ext.createCustomAlertDialog
import org.ucarsu.customalertdialog.ext.createCustomAlertDialogBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var inputEditText: AppCompatEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        Default Alert Dialog type Warning
        */
        showWarningAlertDialogButton.setOnClickListener {
            createCustomAlertDialog(
                title = "Warning",
                message = "This is warning message",
                positiveButtonText = "Ok",
                negativeButtonText = "Cancel",
                positiveButtonAction = {
                    //no-op
                },
                negativeButtonAction = {
                    //no-op
                }
            ).show()
        }

        /*
        Error alert dialog has one button, dialog type error
         */
        showErrorAlertDialogButton.setOnClickListener {
            createCustomAlertDialog(
                imageView = R.drawable.ic_error,
                title = "Error",
                message = "This is error message",
                positiveButtonText = "Ok",
                positiveButtonAction = {
                    //no-op
                },
                alertType = DialogType.ERROR
            ).show()
        }

        /*
        Input alert dialog dialog type Input
         */
        showInputAlertDialogButton.setOnClickListener {
            val customAlertDialogBuilder = createCustomAlertDialogBuilder(
                title = "Input title",
                positiveButtonText = "Ok",
                positiveButtonAction = {
                    val inputText = inputEditText.editableText?.toString()
                    Log.d("input message", inputText)
                },
                negativeButtonText = "Cancel",
                negativeButtonAction = {
                    //no-op
                },
                alertType = DialogType.INPUT
            )
            inputEditText = customAlertDialogBuilder.getInputEditText()
            customAlertDialogBuilder.create().show()
        }
    }
}
