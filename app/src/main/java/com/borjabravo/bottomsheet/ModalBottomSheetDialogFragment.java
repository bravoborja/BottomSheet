package com.borjabravo.bottomsheet;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by borjabravo on 12/4/16.
 */
public class ModalBottomSheetDialogFragment extends BottomSheetDialogFragment {

    static ModalBottomSheetDialogFragment newInstance() {
        return new ModalBottomSheetDialogFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_bottom_sheet, container, false);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        ModalBottomSheetAdapter adapter = new ModalBottomSheetAdapter(getActivity(), getInstalledApps(getActivity()));
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return v;
    }

    public List<ApplicationInfo> getInstalledApps(Context context) {
        int flags = PackageManager.GET_META_DATA;
        List<ApplicationInfo> installedApps = new ArrayList<>();
        PackageManager pm = context.getPackageManager();
        List<ApplicationInfo> applications = pm.getInstalledApplications(flags);
        for (ApplicationInfo appInfo : applications) {
            if ((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 1) {
                installedApps.add(appInfo);
            }
        }
        return installedApps;
    }
}
