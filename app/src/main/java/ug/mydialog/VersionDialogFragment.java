package ug.mydialog;

import android.app.AlertDialog;
import android.app.Dialog;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Administrator on 2018/2/25.
 */

public class VersionDialogFragment extends DialogFragment {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private View.OnClickListener positiveCallback;
    private String title;
    private String description;

    public static VersionDialogFragment getInstance(String title, String description) {
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        bundle.putString(DESCRIPTION, description);
        VersionDialogFragment versionDialogFragment = new VersionDialogFragment();
        versionDialogFragment.setArguments(bundle);
        return versionDialogFragment;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            DisplayMetrics dm = new DisplayMetrics();
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(dm);
            if (dialog.getWindow() != null) {
                dialog.getWindow().setLayout((int) (dm.widthPixels * 0.7), ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);

            }
        }
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        title = bundle.getString(TITLE);
        description = bundle.getString(DESCRIPTION);
    }

    public void show(FragmentManager fragmentManager, View.OnClickListener positiveCallback) {
        this.positiveCallback = positiveCallback;
        show(fragmentManager, "VersionDialogFragment");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog, null);
        TextView tv_title = (TextView) view.findViewById(R.id.tv_title);
        TextView tv_description = (TextView) view.findViewById(R.id.tv_description);
        Button btn_upgrade = (Button) view.findViewById(R.id.btn_upgrade);
        tv_title.setText(title);
        tv_description.setText(description);
        btn_upgrade.setOnClickListener(positiveCallback);
        builder.setView(view);
        return builder.create();
    }


}
