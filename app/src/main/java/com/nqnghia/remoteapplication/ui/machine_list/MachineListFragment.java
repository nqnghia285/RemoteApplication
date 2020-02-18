package com.nqnghia.remoteapplication.ui.machine_list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nqnghia.remoteapplication.MainActivity;
import com.nqnghia.remoteapplication.R;
import com.nqnghia.remoteapplication.ui.machine_info.MachineInfoFragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MachineListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MachineListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MachineListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private MainActivity mainActivity;

    private ImageView machineImageView1;
    private ImageView machineImageView2;
    private ImageView machineImageView3;
    private ImageView machineImageView4;

    private OnFragmentInteractionListener mListener;

    public MachineListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MachineList.
     */
    // TODO: Rename and change types and number of parameters
    public static MachineListFragment newInstance(String param1, String param2) {
        MachineListFragment fragment = new MachineListFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_machine_list, container, false);

        machineImageView1 = root.findViewById(R.id.machine_image_view1);
        machineImageView2 = root.findViewById(R.id.machine_image_view2);
        machineImageView3 = root.findViewById(R.id.machine_image_view3);
        machineImageView4 = root.findViewById(R.id.machine_image_view4);

        machineImageView1.setOnClickListener(v -> {

        });

        machineImageView2.setOnClickListener(v -> {

        });

        machineImageView3.setOnClickListener(v -> {

        });

        machineImageView4.setOnClickListener(v -> {
//            MachineInfoFragment machineInfoFragment = new MachineInfoFragment();
//            Bundle args = new Bundle();
//            args.putString("machine_number", "04");
//            machineInfoFragment.setArguments(args);
//
//            FragmentTransaction fragmentTransaction = mainActivity.getSupportFragmentManager().beginTransaction();
//            fragmentTransaction.replace(R.id.nav_host_fragment, machineInfoFragment);
//            fragmentTransaction.addToBackStack(null);
//
//            fragmentTransaction.commit();
        });

        return inflater.inflate(R.layout.fragment_machine_list, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            mainActivity = (MainActivity) context;
            mainActivity.getFab().hide();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
