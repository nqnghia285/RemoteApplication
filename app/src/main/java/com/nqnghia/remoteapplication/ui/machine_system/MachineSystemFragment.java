package com.nqnghia.remoteapplication.ui.machine_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.nqnghia.remoteapplication.ChartActivity;
import com.nqnghia.remoteapplication.MachineInfoActivity;
import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.about.AboutFragment;

public class MachineSystemFragment extends Fragment {

    private MachineSystemViewModel machineSystemViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        machineSystemViewModel =
                ViewModelProviders.of(this).get(MachineSystemViewModel.class);
        View root = inflater.inflate(R.layout.activity_machine_info, container, false);
//        final TextView textView = root.findViewById(R.id.text_machine_system);
//        machineSystemViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}