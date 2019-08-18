package com.deasmahaputra.mvparchitecture.base

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.deasmahaputra.mvparchitecture.R
import com.deasmahaputra.mvparchitecture.base.di.AppComponent
import com.deasmahaputra.mvparchitecture.common.LocaleHelper

open class BaseActivity : AppCompatActivity(){

    lateinit var dialog : Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected fun getAppComponent(): AppComponent = (application as Application).appComponent

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper(newBase).onAttach())
    }

    protected fun showLoadingDialog(){
        var builder : AlertDialog.Builder = AlertDialog.Builder(this)
        var inflater : LayoutInflater = layoutInflater
        var view : View = inflater.inflate(R.layout.dialog_loading, null)
        builder.setView(view)
        dialog = builder.create()
        dialog.setCancelable(false)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
    }

    protected fun dismissLoadingDialog(){
        dialog.dismiss()
    }

    protected fun customFontRobotoReg() : Typeface {
        return Typeface.createFromAsset(assets, "fonts/Roboto-Regular.ttf")
    }

    protected fun customFontRobotoThin() : Typeface {
        return Typeface.createFromAsset(assets, "fonts/Roboto-Thin.ttf")
    }

    protected fun customFontRobotoBlack() : Typeface {
        return Typeface.createFromAsset(assets, "fonts/Roboto-Black.ttf")
    }
}