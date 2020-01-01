package com.nqnghia.remoteapplication.ui.machine_system;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;

import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.machine_info.MachineInfoFragment;

public class MachineSystemFragment extends Fragment {

    FragmentActivity ctx;

    private MachineSystemViewModel machineSystemViewModel;
    private ImageView machineImageView1;
    private ImageView machineImageView2;
    private ImageView machineImageView3;
    private ImageView machineImageView4;

    @Override
    public void onAttach(Context context) {
        ctx = (FragmentActivity) context;
        super.onAttach(context);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        machineSystemViewModel =
                ViewModelProviders.of(this).get(MachineSystemViewModel.class);
        View root = inflater.inflate(R.layout.fragment_machine_system, container, false);

        machineImageView1 = root.findViewById(R.id.machine_image_view1);
        machineImageView2 = root.findViewById(R.id.machine_image_view2);
        machineImageView3 = root.findViewById(R.id.machine_image_view3);
        machineImageView4 = root.findViewById(R.id.machine_image_view4);

        machineImageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
                Bundle args = new Bundle();
                args.putString("machine_number", "01");
                machineInfoFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = ctx.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        machineImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
                Bundle args = new Bundle();
                args.putString("machine_number", "02");
                machineInfoFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = ctx.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        machineImageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
                Bundle args = new Bundle();
                args.putString("machine_number", "03");
                machineInfoFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = ctx.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });

        machineImageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
                Bundle args = new Bundle();
                args.putString("machine_number", "04");
                machineInfoFragment.setArguments(args);

                FragmentTransaction fragmentTransaction = ctx.getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
                fragmentTransaction.addToBackStack(null);

                fragmentTransaction.commit();
            }
        });
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