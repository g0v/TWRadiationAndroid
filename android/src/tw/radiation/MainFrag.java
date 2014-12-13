// vim: et sw=4 sts=4 tabstop=4
package tw.radiation;

import tw.radiation.R;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MainFrag extends Fragment {

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        Uri uri = Uri.parse(Radiation.AUTHORITY + "/incidents");
        Cursor c = getActivity().getContentResolver().query(uri, null , null , null , null);
        Log.d(Radiation.TAG, "cursor count:" + c.getCount());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }
}
