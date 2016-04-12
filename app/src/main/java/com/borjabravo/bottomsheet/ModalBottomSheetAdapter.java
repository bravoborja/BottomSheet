package com.borjabravo.bottomsheet;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

/**
 * Created by borjabravo on 12/4/16.
 */
public class ModalBottomSheetAdapter extends RecyclerView.Adapter<ModalBottomSheetAdapter.ModalBottomSheetViewHolder> {

    private PackageManager mPackageManager;
    private Context mContext;

    public ModalBottomSheetAdapter(Context context, List<ApplicationInfo> mApplications) {
        this.mApplications = mApplications;
        mContext = context;
        mPackageManager = mContext.getPackageManager();
    }

    private List<ApplicationInfo> mApplications;

    @Override
    public ModalBottomSheetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_modal_bottom_sheet, parent, false);
        return new ModalBottomSheetViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ModalBottomSheetViewHolder holder, int position) {
        ApplicationInfo applicationInfo = mApplications.get(position);
        holder.appName.setText(applicationInfo.loadLabel(mPackageManager));
        holder.appIcon.setImageDrawable(applicationInfo.loadIcon(mPackageManager));
    }

    @Override
    public int getItemCount() {
        return mApplications == null ? 0 : mApplications.size();
    }

    static class ModalBottomSheetViewHolder extends RecyclerView.ViewHolder {

        ImageView appIcon;
        TextView appName;

        private ModalBottomSheetViewHolder(View itemView) {
            super(itemView);
            appIcon = (ImageView) itemView.findViewById(R.id.app_icon);
            appName = (TextView) itemView.findViewById(R.id.app_name);
        }
    }
}