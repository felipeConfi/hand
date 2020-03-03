package com.example.suporthand;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;
import java.util.Set;

public class DispositivosBT extends AppCompatActivity {

    private static final String TAG = "DispositivosBT";
    ListView IdLista;
    public static String EXTRA_DEVICE_ADDRESS = "device_address";

    private BluetoothAdapter mBTAdapter;
    private ArrayAdapter<String> mPairedDevicesArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispositivos_bt);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        VerificarEstadoBT();

        mPairedDevicesArrayAdapter = new ArrayAdapter<String>(this, R.layout.nombre_dispositivos);

        IdLista = (ListView) findViewById(R.id.IdLista);
        IdLista.setAdapter(mPairedDevicesArrayAdapter);
        IdLista.setOnItemClickListener(mDeviceClickListener);

        mBTAdapter = BluetoothAdapter.getDefaultAdapter();

        Set<BluetoothDevice> pairedDevices = mBTAdapter.getBondedDevices();

        if(pairedDevices.size() > 0)
        {
            for(BluetoothDevice device: pairedDevices){
                mPairedDevicesArrayAdapter.add(device.getName() + "\n" + device.getAddress());
            }
        }
    }

    private AdapterView.OnItemClickListener mDeviceClickListener;

    //19:00 Video 1, Me da error cuando av se declara, el problema no lo logro encontrar
    /* = (av, v, arg2, arg3){
        String info = ((TextView) v).getText().toString();
        String address = info.substring(info.length() - 17);

        Intent i = new Intent(DispositivosBT.this, MainActivity.class);
        i.putExtra(EXTRA_DEVICE_ADDRESS, address);
        startActivity(i);
    };*/
    
    private void VerificarEstadoBT() {
        mBTAdapter = BluetoothAdapter.getDefaultAdapter();
        if(mBTAdapter==null){
            Toast.makeText(getBaseContext(), "El dispositivo no soporta Bluetooth", Toast.LENGTH_SHORT);
        } else{
            if(mBTAdapter.isEnabled()){
                Log.d(TAG, "...Bluetooth Activado...");
            } else{
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, 1);
            }
        }
    }
}
