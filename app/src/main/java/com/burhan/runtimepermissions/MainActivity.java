package com.burhan.runtimepermissions;

import android.Manifest;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends RuntimePermissionsActivity {

    private static final int REQUEST_PERMISSION_READ_CONTACTS = 1;
    private static final int REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.super.requestAppPermissions(new
                        String[]{Manifest.permission.READ_CONTACTS,}, R.string
                        .runtime_permissions_txt, REQUEST_PERMISSION_READ_CONTACTS);

                MainActivity.super.requestAppPermissions(new
                        String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, R.string.runtime_permissions_txt, REQUEST_PERMISSION_READ_CONTACTS);
            }
        });
    }

    @Override
    public void onPermissionsGranted(final int requestCode) {
        if (requestCode == REQUEST_PERMISSION_READ_CONTACTS) {
            Toast.makeText(this, "Permissions Received for reading contacts.", Toast.LENGTH_LONG).show();
        } else if (requestCode == REQUEST_PERMISSION_WRITE_EXTERNAL_STORAGE) {
            Toast.makeText(this, "Permissions Received for writing SD card.", Toast.LENGTH_LONG).show();
        }


    }
}
