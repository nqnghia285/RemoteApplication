package com.nqnghia.remoteapplication.ui.machine_info;

import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.humidity_temperature_chart.HumidityTemperatureFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

public class MachineInfoFragment extends Fragment {

    private MachineInfoViewModel machineInfoViewModel;
    private ImageView chartImageView;
    private Switch blowerFanSwitch;
    private Switch exhaustFanSwitch;

    private FragmentActivity ctx;

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket("http://192.168.137.128:3000");
        } catch (URISyntaxException e) {
            Log.e("Socket", "Can not connect to server.");
        }
    }

    private Emitter.Listener listenerBlowerFanSwitch = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject object = (JSONObject) args[0];
            try {

//                String data = object.getString("noidung");
                JSONObject data = object.getJSONObject("noidung");
                String enable = data.getString("status");
//                String enable = object.getString("enable");
                Log.d("data receive led", enable);
                if (enable.equals("1")) {
                    blowerFanSwitch.setChecked(true);
                } else {
                    blowerFanSwitch.setChecked(false);
                }
                //--------------------------------------------------
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    private Emitter.Listener listenerExhaustFanSwitch = new Emitter.Listener() {
        @Override
        public void call(Object... args) {
            JSONObject object = (JSONObject) args[0];
            try {

//                String data = object.getString("noidung");
                JSONObject data = object.getJSONObject("noidung");
                String enable = data.getString("status");
//                String enable = object.getString("enable");
                Log.d("data receive led", enable);
                if (enable.equals("1")) {
                    exhaustFanSwitch.setChecked(true);
                } else {
                    exhaustFanSwitch.setChecked(false);
                }
                //--------------------------------------------------
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onAttach(Context context) {
        ctx = (FragmentActivity) context;
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        machineInfoViewModel =
                ViewModelProviders.of(this).get(MachineInfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_machine_info, container, false);

        TextView machineTextView = root.findViewById(R.id.machine_text_view);
        if (savedInstanceState != null) {
            machineTextView.setText("Máy số " + savedInstanceState.getString("machine_number"));
        }

        chartImageView = root.findViewById(R.id.chart_image_view);
        chartImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HumidityTemperatureFragment humidityTemperatureFragment = new HumidityTemperatureFragment();
//                Bundle args = new Bundle();
//                args.putInt(MachineInfoFragment.ARG_POSITION, 1);
//                machineInfoFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = ctx.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, humidityTemperatureFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        blowerFanSwitch = root.findViewById(R.id.blower_fan_switch);
        blowerFanSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject message = new JSONObject();
                if (blowerFanSwitch.isChecked()) {
                    try {
                        Log.d("Switch", "ON");
                        message.put("server_send_sensorData", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Log.d("Switch", "OFF");
                        message.put("server_send_sensorData", "0");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        exhaustFanSwitch = root.findViewById(R.id.exhaust_fan_switch);
        exhaustFanSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                JSONObject message = new JSONObject();
                if (exhaustFanSwitch.isChecked()) {
                    try {
                        Log.d("Switch", "ON");
                        message.put("exhaust_fan", "1");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        Log.d("Switch", "OFF");
                        message.put("exhaust_fan", "0");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                mSocket.connect();
                mSocket.on("server_send_sensorData", listenerBlowerFanSwitch);
                mSocket.on("exhaust_fan", listenerExhaustFanSwitch);
            }
        });
        thread.start();
    }
}