package com.project.uitoux;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.chootdev.csnackbar.Align;
import com.chootdev.csnackbar.Duration;
import com.chootdev.csnackbar.Snackbar;
import com.chootdev.csnackbar.Type;

public class BaseActivity  extends AppCompatActivity {

    public void showSnack_W(String message)
    {
        Snackbar.with(BaseActivity.this,null)
                .type(Type.WARNING)
                .message(message)
                .duration(Duration.LONG)
                .fillParent(true)
                .textAlign(Align.LEFT)
                .show();


    }


    public void showSnack_S(String message)
    {
        Snackbar.with(BaseActivity.this,null)
                .type(Type.SUCCESS)
                .message(message)
                .duration(Duration.LONG)
                .fillParent(true)
                .textAlign(Align.LEFT)
                .show();


    }


    public static void hideSoftKeyboard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
    }



}
