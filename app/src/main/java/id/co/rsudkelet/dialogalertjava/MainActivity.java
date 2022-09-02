package id.co.rsudkelet.dialogalertjava;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.developer.kalert.KAlertDialog;
import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    MaterialButton btnShowMaterialProcess, btnBasicMessage, btnErrorMessage, btnWarningMessage, btnSuccessMessage, btnMessageCustomIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShowMaterialProcess = findViewById(R.id.btn_show_material_progress);
        btnBasicMessage = findViewById(R.id.btn_basic_message);
        btnErrorMessage = findViewById(R.id.btn_error_message);
        btnWarningMessage = findViewById(R.id.btn_warning_message);
        btnSuccessMessage = findViewById(R.id.btn_success_message);
        btnMessageCustomIcon = findViewById(R.id.btn_message_custom_icon);

        btnShowMaterialProcess.setOnClickListener(this);
        btnBasicMessage.setOnClickListener(this);
        btnErrorMessage.setOnClickListener(this);
        btnWarningMessage.setOnClickListener(this);
        btnSuccessMessage.setOnClickListener(this);
        btnMessageCustomIcon.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.btn_show_material_progress) {
            KAlertDialog pDialog = new KAlertDialog(this, KAlertDialog.PROGRESS_TYPE, 0);
            pDialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
            pDialog.setTitleText("Loading");
            pDialog.setCancelable(true);
            pDialog.show();
        }

        if (id == R.id.btn_basic_message) {
            new KAlertDialog(this, 0)
                    .setTitleText("Here's a message!")
                    .setContentText("It's pretty, isn't it?")
                    .show();
        }

        if (id == R.id.btn_error_message) {
            new KAlertDialog(this, KAlertDialog.ERROR_TYPE, 0)
                    .setTitleText("Oops...")
                    .setContentText("Something went wrong!")
                    .show();
        }

        if (id == R.id.btn_warning_message) {
//            new KAlertDialog(this, KAlertDialog.WARNING_TYPE, 0)
//                    .setTitleText("Are you sure?")
//                    .setContentText("Won't be able to recover this file!")
//                    .setConfirmText("Yes,delete it!")
//                    .show();

//            new KAlertDialog(this, KAlertDialog.WARNING_TYPE, 0)
//                .setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setConfirmText("Yes,delete it!")
//                .setConfirmClickListener(new KAlertDialog.KAlertClickListener() {
//                    @Override
//                    public void onClick(KAlertDialog sDialog) {
//                        sDialog.dismissWithAnimation();
//                    }
//                })
//                .show();

//            new KAlertDialog(this, KAlertDialog.WARNING_TYPE, 0)
//                .setTitleText("Are you sure?")
//                .setContentText("Won't be able to recover this file!")
//                .setCancelText("No,cancel plx!")
//                .setConfirmText("Yes,delete it!")
//                .showCancelButton(true)
//                .setCancelClickListener(new KAlertDialog.KAlertClickListener() {
//                    @Override
//                    public void onClick(KAlertDialog sDialog) {
//                        sDialog.cancel();
//                    }
//                })
//                .show();

            new KAlertDialog(this, KAlertDialog.WARNING_TYPE, 0)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .setConfirmClickListener(new KAlertDialog.KAlertClickListener() {
                    @Override
                    public void onClick(KAlertDialog sDialog) {
                        sDialog
                                .setTitleText("Deleted!")
                                .setContentText("Your imaginary file has been deleted!")
                                .setConfirmText("OK")
                                .setConfirmClickListener(null)
                                .changeAlertType(KAlertDialog.SUCCESS_TYPE);
                    }
                })
                .show();
        }

        if (id == R.id.btn_success_message) {
            new KAlertDialog(this, KAlertDialog.SUCCESS_TYPE, 0)
                    .setTitleText("Good job!")
                    .setContentText("You clicked the button!")
                    .show();
        }

        if (id == R.id.btn_message_custom_icon) {
            new KAlertDialog(this, KAlertDialog.CUSTOM_IMAGE_TYPE, 0)
                    .setTitleText("Sweet!")
                    .setContentText("Here's a custom image.")
                    // .setCustomImage(R.drawable.cat)
                    .setConfirmText("OK") //Do not call this if you don't want to show confirm button
                    .setCancelText("CANCEL")//Do not call this if you don't want to show cancel button
                    .show();
        }
    }
}