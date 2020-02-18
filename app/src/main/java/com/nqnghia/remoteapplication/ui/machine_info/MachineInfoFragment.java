package com.nqnghia.remoteapplication.ui.machine_info;

import androidx.annotation.RequiresApi;
import androidx.lifecycle.ViewModelProviders;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
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
import com.nqnghia.remoteapplication.MainActivity;
import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.humidity_temperature_chart.HumidityTemperatureFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;

public class MachineInfoFragment extends Fragment {
    private View root;
    private MachineInfoViewModel machineInfoViewModel;
    private ImageView chartImageView;
    private Switch blowerFanSwitch;
    private Switch exhaustFanSwitch;

    private MainActivity mainActivity;

    private static final ArrayList<String> args = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
            mainActivity.getFab().hide();
        }
    }

    public MachineInfoFragment(ArrayList<String> args) {
        if (args != null && args.size() == 11) {
            for (String arg : args) {
                this.args.add(arg);
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        machineInfoViewModel =
                ViewModelProviders.of(this).get(MachineInfoViewModel.class);
        root = inflater.inflate(R.layout.fragment_machine_info, container, false);

        TextView machineTextView = root.findViewById(R.id.machine_text_view);
        TextView beginTimeTextView = root.findViewById(R.id.begin_time_text_view);
        TextView completedTimeTextView = root.findViewById(R.id.completed_time_text_view);
        TextView temperatureTextView = root.findViewById(R.id.temperature_text_view);
        TextView humidityTextView = root.findViewById(R.id.humidity_text_view);
        TextView foodTypeTextView = root.findViewById(R.id.food_type_text_view);
        TextView weighTextView = root.findViewById(R.id.weigh_text_view);
        TextView currentTemperatureTextView = root.findViewById(R.id.current_temperature_text_view);
        TextView currentHumidityTextView = root.findViewById(R.id.current_humidity_text_view);
        chartImageView = root.findViewById(R.id.chart_image_view);
        blowerFanSwitch = root.findViewById(R.id.blower_fan_switch);
        exhaustFanSwitch = root.findViewById(R.id.exhaust_fan_switch);

        if (args.size() == 11) {
            machineTextView.setText("Máy số " + args.get(0));
            beginTimeTextView.setText(args.get(1));
            completedTimeTextView.setText(args.get(2));
            temperatureTextView.setText(args.get(3));
            humidityTextView.setText(args.get(4));
            foodTypeTextView.setText(args.get(5));
            weighTextView.setText(args.get(6));
            currentTemperatureTextView.setText(args.get(7));
            currentHumidityTextView.setText(args.get(8));
            if (args.get(9).equals("ON")) {
                blowerFanSwitch.setChecked(true);
            } else {
                blowerFanSwitch.setChecked(false);
            }

            if (args.get(10).equals("ON")) {
                exhaustFanSwitch.setChecked(true);
            } else {
                exhaustFanSwitch.setChecked(false);
            }
        }

        chartImageView.setOnClickListener(v -> {
            HumidityTemperatureFragment humidityTemperatureFragment = new HumidityTemperatureFragment();
//                Bundle args = new Bundle();
//                args.putInt(MachineInfoFragment.ARG_POSITION, 1);
//                machineInfoFragment.setArguments(args);

            FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.nav_host_fragment, humidityTemperatureFragment);
            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        });

        blowerFanSwitch.setOnClickListener(v -> {
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
        });

        exhaustFanSwitch = root.findViewById(R.id.exhaust_fan_switch);
        exhaustFanSwitch.setOnClickListener(v -> {
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
        });

        return root;
    }

    public TextView getMachineTextView() {
        return root.findViewById(R.id.machine_text_view);
    }

    public TextView getBeginTimeTextView() {
        return root.findViewById(R.id.begin_time_text_view);
    }

    public TextView getCompletedTimeTextView() {
        return root.findViewById(R.id.completed_time_text_view);
    }

    public TextView getTemperatureTextView() {
        return root.findViewById(R.id.temperature_text_view);
    }

    public TextView getHumidityTextView() {
        return root.findViewById(R.id.humidity_text_view);
    }

    public TextView getFoodTypeTextView() {
        return root.findViewById(R.id.food_type_text_view);
    }

    public TextView getWeighTextView() {
        return root.findViewById(R.id.weigh_text_view);
    }

    public TextView getCurrentTemperatureTextView() {
        return root.findViewById(R.id.current_temperature_text_view);
    }

    public TextView getCurrentHumidityTextView() {
        return root.findViewById(R.id.current_humidity_text_view);
    }
    public ImageView getChartImageView() {
        return root.findViewById(R.id.chart_image_view);
    }
    public Switch getBlowerFanSwitch() {
        return root.findViewById(R.id.blower_fan_switch);
    }

    public Switch getExhaustFanSwitch() {
        return root.findViewById(R.id.exhaust_fan_switch);
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}