package com.example.controllerbluetoothserial;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.harrysoft.androidbluetoothserial.BluetoothManager;

import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    String VRE_MAC = "AC:67:B2:36:23:0E"; // TODO : Create activity to select  device from list
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup our BluetoothManager
        BluetoothManager bluetoothManager = BluetoothManager.getInstance();
        if (bluetoothManager == null) {
            // Bluetooth unavailable on this device :( tell the user
            Toast.makeText(this, "Bluetooth not available.", Toast.LENGTH_LONG).show(); // Replace context with your context instance.
            finish();
        }

        Collection<BluetoothDevice> pairedDevices = bluetoothManager.getPairedDevicesList();
        for (BluetoothDevice device : pairedDevices) {
            Log.d("My Bluetooth App", "Device Name: " + device.getName());
            Log.d("My Bluetooth App", "Device MAC Address: " + device.getAddress());
            if (device.getAddress().equals(VRE_MAC)) {
                Log.d(TAG, "onCreate: FOUND DEVICE");
                connect(device.getAddress(), device.getName());
            }
        }
    }

    protected void connect(String MAC, String name) {
        Intent intent = new Intent(getApplicationContext(), Controller.class);
        intent.putExtra("MAC", MAC);
        intent.putExtra("NAME", MAC);
        startActivity(intent);
    }
}