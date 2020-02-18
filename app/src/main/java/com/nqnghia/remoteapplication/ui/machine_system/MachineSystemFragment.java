package com.nqnghia.remoteapplication.ui.machine_system;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;
import com.nqnghia.remoteapplication.MainActivity;
import com.nqnghia.remoteapplication.PageAdapter;
import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.machine_info.MachineInfoFragment;

import java.util.ArrayList;

public class MachineSystemFragment extends Fragment {
    private MachineSystemViewModel machineSystemViewModel;

    private MainActivity mainActivity;

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PageAdapter pagerAdapter;
    private TabItem machineList;
    private TabItem machineInfo;
    private TabItem chart;

    private ImageView machineImageView1;
    private ImageView machineImageView2;
    private ImageView machineImageView3;
    private ImageView machineImageView4;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
            mainActivity.getFab().hide();
        }
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        machineSystemViewModel =
                ViewModelProviders.of(this).get(MachineSystemViewModel.class);
        View root = inflater.inflate(R.layout.fragment_machine_system, container, false);

        toolbar = root.findViewById(R.id.toolbar);
        toolbar.setTitle("Tab Layout");

        tabLayout = root.findViewById(R.id.tab_layout);
        machineList = root.findViewById(R.id.tab_machine_list);
        machineInfo = root.findViewById(R.id.tab_machine_info);
        chart = root.findViewById(R.id.tab_chart);
        viewPager = root.findViewById(R.id.view_pager);

        pagerAdapter = new PageAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {
                    viewPager.setCurrentItem(tab.getPosition());
                    machineImageView1 = root.findViewById(R.id.machine_image_view1);
                    machineImageView2 = root.findViewById(R.id.machine_image_view2);
                    machineImageView3 = root.findViewById(R.id.machine_image_view3);
                    machineImageView4 = root.findViewById(R.id.machine_image_view4);

                    machineImageView1.setOnClickListener(v -> {
                        ArrayList<String> args = new ArrayList<>();
                        args.add("03");
                        args.add("12:30:25");
                        args.add("13:30:25");
                        args.add("65");
                        args.add("65");
                        args.add("Mít tươi");
                        args.add("100");
                        args.add("65");
                        args.add("65");
                        args.add("ON");
                        args.add("OFF");
                        pagerAdapter.setAgrsMachineInfoFragment(args);
                        viewPager.setAdapter(pagerAdapter);
                        viewPager.setCurrentItem(1);
//                    toolbar.setBackgroundColor(Color.rgb(0, 255, 0));
                        tabLayout.setBackgroundColor(Color.rgb(0, 255, 0));

                        pagerAdapter.getMachineInfoFragment().getChartImageView().setOnClickListener(k -> {
                            viewPager.setCurrentItem(2);
                            tabLayout.setBackgroundColor(Color.rgb(255, 0, 0));
                        });
                    });

                    machineImageView2.setOnClickListener(v -> {

                    });

                    machineImageView3.setOnClickListener(v -> {

                    });

                    machineImageView4.setOnClickListener(v -> {
//                        MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
//                        Bundle args = new Bundle();
//                        args.putString("machine_number", "04");
//                        machineInfoFragment.setArguments(args);
//
//                        FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
//                        fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
//                        fragmentTransaction.addToBackStack(null);
//
//                        fragmentTransaction.commit();
                    });

//                    toolbar.setBackgroundColor(Color.rgb(0, 0, 255));
                    tabLayout.setBackgroundColor(Color.rgb(0, 0, 255));
                } else if (tab.getPosition() == 1) {
                    ArrayList<String> args = new ArrayList<>();
                    args.add("03");
                    args.add("12:30:25");
                    args.add("13:30:25");
                    args.add("65");
                    args.add("65");
                    args.add("Mít tươi");
                    args.add("100");
                    args.add("65");
                    args.add("65");
                    args.add("ON");
                    args.add("OFF");
                    pagerAdapter.setAgrsMachineInfoFragment(args);
                    viewPager.setAdapter(pagerAdapter);
                    viewPager.setCurrentItem(1);
//                    toolbar.setBackgroundColor(Color.rgb(0, 255, 0));
                    tabLayout.setBackgroundColor(Color.rgb(0, 255, 0));

                    pagerAdapter.getMachineInfoFragment().getChartImageView().setOnClickListener(v -> {
                        viewPager.setCurrentItem(2);
                        tabLayout.setBackgroundColor(Color.rgb(255, 0, 0));
                    });
                } else {
                    viewPager.setCurrentItem(2);
                    tabLayout.setBackgroundColor(Color.rgb(255, 0, 0));
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        return root;
    }
}