package com.ssyanhuo.akrnightshelper_plannerplugin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.activity_main, null);
        TextView versionInfo = linearLayout.findViewById(R.id.text_version_info);
        versionInfo.setText(getResources().getString(R.string.dialog_version, BuildConfig.VERSION_NAME));
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogTheme);
        builder.setTitle(R.string.dialog_title)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        finish();
                    }
                })
                .setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        finish();
                    }
                })
                .setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        finish();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        finish();
                    }
                })
                .setView(linearLayout)
                .setPositiveButton(R.string.dialog_button, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPackageManager().setComponentEnabledSetting(getComponentName(), PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
                    }
                })
                .show();
    }
}
