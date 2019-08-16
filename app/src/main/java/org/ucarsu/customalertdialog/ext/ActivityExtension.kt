package org.ucarsu.customalertdialog.ext

import android.app.Activity
import android.app.AlertDialog
import org.ucarsu.customalertdialog.R
import org.ucarsu.customalertdialog.component.CustomAlertDialog
import org.ucarsu.customalertdialog.enums.DialogType


/*
 * Creates custom alert dialog
 */
fun Activity.createCustomAlertDialog(
    imageView: Int? = R.drawable.ic_warning,
    title: CharSequence? = null,
    message: CharSequence? = null,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    positiveButtonAction: (() -> Unit)? = null,
    negativeButtonAction: (() -> Unit)? = null,
    alertType: DialogType? = DialogType.WARNING,
    isAllCaps: Boolean = false
): AlertDialog = createCustomAlertDialogBuilder(
    imageView,
    title,
    message,
    positiveButtonText,
    negativeButtonText,
    positiveButtonAction,
    negativeButtonAction,
    alertType,
    isAllCaps
).create()

/*
 * Creates custom alert dialog builder
 */
fun Activity.createCustomAlertDialogBuilder(
    imageView: Int? = null,
    title: CharSequence? = null,
    message: CharSequence? = null,
    positiveButtonText: CharSequence? = null,
    negativeButtonText: CharSequence? = null,
    positiveButtonAction: (() -> Unit)? = null,
    negativeButtonAction: (() -> Unit)? = null,
    alertType: DialogType? = DialogType.WARNING,
    isAllCaps: Boolean = false
): CustomAlertDialog {
    return CustomAlertDialog(this).apply {

        setIsAllCaps(isAllCaps)

        imageView?.let {
            setImageResource(this@createCustomAlertDialogBuilder, imageView)
        }

        title?.let {
            setTitle(title)
        }
        message?.let {
            setMessage(message)
        }

        positiveButtonText?.let {
            setPositiveCustomButton(positiveButtonText) {
                positiveButtonAction?.invoke()
            }
        }

        negativeButtonText?.let {
            setNegativeCustomButton(negativeButtonText) {
                negativeButtonAction?.invoke()
            }
        }
        alertType?.let {
            setAlertType(alertType)
        }
    }
}

