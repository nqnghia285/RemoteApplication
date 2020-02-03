package com.nqnghia.remoteapplication.ui.device_sensor;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.nqnghia.remoteapplication.R;

public class DeviceSensorFragment extends Fragment {

    private DeviceSensorViewModel deviceSensorViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        deviceSensorViewModel =
                ViewModelProviders.of(this).get(DeviceSensorViewModel.class);
        View root = inflater.inflate(R.layout.fragment_device_sensor, container, false);
        final TextView textView = root.findViewById(R.id.text_device_sensor);
        deviceSensorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}