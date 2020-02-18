package com.nqnghia.remoteapplication;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.nqnghia.remoteapplication.ui.humidity_temperature_chart.HumidityTemperatureFragment;
import com.nqnghia.remoteapplication.ui.machine_info.MachineInfoFragment;
import com.nqnghia.remoteapplication.ui.machine_list.MachineListFragment;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    private ArrayList<String> argsMachineInfoFragment;
    private MachineListFragment machineListFragment;
    private MachineInfoFragment machineInfoFragment;
    private HumidityTemperatureFragment humidityTemperatureFragment;

    public PageAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    public void setAgrsMachineInfoFragment(ArrayList<String> args) {
        if (args != null && args.size() == 11) {
            argsMachineInfoFragment = args;
        }
    }

    public MachineListFragment getMachineListFragment() { return machineListFragment; }
    public MachineInfoFragment getMachineInfoFragment() { return machineInfoFragment; }
    public HumidityTemperatureFragment getHumidityTemperatureFragment() { return humidityTemperatureFragment; }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0: {
                machineListFragment = new MachineListFragment();
                return machineListFragment;
            }
            case 1: {
                machineInfoFragment = new MachineInfoFragment(argsMachineInfoFragment);
                return machineInfoFragment;
            }
            case 2: {
                humidityTemperatureFragment = new HumidityTemperatureFragment();
                return humidityTemperatureFragment;
            }
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
