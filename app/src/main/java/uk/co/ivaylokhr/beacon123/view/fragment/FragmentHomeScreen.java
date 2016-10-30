package uk.co.ivaylokhr.beacon123.view.fragment;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.estimote.sdk.Beacon;
import com.estimote.sdk.BeaconManager;
import com.estimote.sdk.Region;
import com.estimote.sdk.Utils;

import java.util.List;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import pl.bclogic.pulsator4droid.library.PulsatorLayout;
import uk.co.ivaylokhr.beacon123.R;
import uk.co.ivaylokhr.beacon123.model.services.BeaconQuestService;
import uk.co.ivaylokhr.beacon123.view.activity.MainActivity;

/**
 * Created by Ivaylo on 29/10/2016.
 */

public class FragmentHomeScreen extends BaseFragment {

    //Views
    @BindView(R.id.homescreen_profile_button) View profileButton;
    @BindView(R.id.homescreen_magic_button) View magicButton;
    @BindView(R.id.shano) PulsatorLayout pulsatorLayout;

    private boolean isShaning = false;

    private BeaconManager beaconManager;

    //Retrofit
    BeaconQuestService beaconQuestService;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_homescreen, container, false);

        ButterKnife.bind(this, rootView);

        setListeners();
        setUpService();

        return rootView;
    }

    private void setListeners(){
        final Fragment selfRef = this;
        profileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)selfRef.getActivity()).onChangeFragment(FragmentProfilePaged.class, new Bundle(), true);
            }
        });

        magicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askForPermission();
//                if(!isShaning){
//                    pulsatorLayout.start();
//                    isShaning = true;
//                }else {
//                    pulsatorLayout.stop();
//                    isShaning = false;
//                }
            }
        });

    }

    private void setUpService(){
        beaconQuestService = retrofit.create(BeaconQuestService.class);
    }

    private void initBeaconManager(){
        beaconManager = new BeaconManager(this.getActivity().getApplicationContext());

        beaconManager.setMonitoringListener(new BeaconManager.MonitoringListener() {
            @Override
            public void onEnteredRegion(Region region, List<Beacon> list) {
//                showNotification(
//                        "Your gate closes in 47 minutes.",
//                        "Current security wait time is 15 minutes, "
//                                + "and it's a 5 minute walk from security to the gate. "
//                                + "Looks like you've got plenty of time!");
            }

            @Override
            public void onExitedRegion(Region region) {
                Log.i("exited region", "gbye");
            }
        });

        beaconManager.setRangingListener(new OurRangingListener((MainActivity) this.getActivity()));
    }

    private void doMagic(){
//                if(!isShaning){
        pulsatorLayout.start();
        initBeaconManager();
        final Region region = new Region("our Beacon", UUID.fromString("B9407F30-F5F8-466E-AFF9-25556B57FE6D"),null,null);
        beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
            @Override
            public void onServiceReady() {
                beaconManager.startRanging(region);
            }
        });
//        Toast toast = Toast.makeText(this.getActivity(), "Looking for beacons", Toast.LENGTH_SHORT);
//        toast.show();
//                    isShaning = true;
//                }else {
//                    pulsatorLayout.stop();
//                    isShaning = false;
//                }

    }

    private void askForPermission(){
        if (ContextCompat.checkSelfPermission(this.getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
//                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

//            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this.getActivity(),
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        420);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
//            }
        } else {
            doMagic();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 420: {
                boolean areAllGranted = true;
                if (grantResults.length <= 0) {
                    areAllGranted = false;
                }
                for (int grantResult : grantResults) {
                    if (grantResult != PackageManager.PERMISSION_GRANTED){
                        areAllGranted = false;
                    }
                }
                if (areAllGranted) {
                    //TODO: GET SHIT DONE
                    doMagic();
                } else {
                    Toast toast = Toast.makeText(this.getActivity(), "Permission not granted, can't procede", Toast.LENGTH_SHORT);
                    toast.show();
                }
                return;
            }
        }
    }



    private class OurRangingListener implements BeaconManager.RangingListener {
        MainActivity activity;
        public OurRangingListener(MainActivity mainActivity) {
            activity =  mainActivity;
        }

        @Override
        public void onBeaconsDiscovered(Region region, List<Beacon> list) {
            if (!list.isEmpty()) {
                for(int i=0;i<list.size();i++){
                    Log.i(""+i, ""+list.get(i).getMacAddress() +" "+ Utils.computeAccuracy(list.get(i)));
                }
                Beacon nearestBeacon = list.get(0);
//                Toast toast = Toast.makeText(activity,String.valueOf(nearestBeacon.getRssi()),Toast.LENGTH_SHORT);
                Toast toast = Toast.makeText(activity,"Beacon found",Toast.LENGTH_SHORT);
                toast.show();
//                Log.i("nearest at ", ""+nearestBeacon.getMacAddress() +" "+ Utils.computeAccuracy(nearestBeacon)+ " "+Utils.computeProximity(nearestBeacon));

                //TODO: update the UI here
                //TODO: lots of stuff
            }
        }
    }
}
