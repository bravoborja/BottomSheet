package com.borjabravo.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener {

    Button btnHideBottomSheet, btnContractBottomSheet, btnExpandBottomSheet, btnShowModelBottomSheet;
    BottomSheetBehavior bottomSheetBehavior;
    TextView bottomSheetState, bottomSheetOffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Bottom Sheet");
        LinearLayout bottomSheet = (LinearLayout) findViewById(R.id.bottomSheet);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet);
        btnHideBottomSheet = (Button) findViewById(R.id.btn_hide_bottom_sheet);
        btnContractBottomSheet = (Button) findViewById(R.id.btn_contract_bottom_sheet);
        btnExpandBottomSheet = (Button) findViewById(R.id.btn_expand_bottom_sheet);
        btnShowModelBottomSheet = (Button) findViewById(R.id.btn_show_modal_bottom_sheet);
        bottomSheetState = (TextView) findViewById(R.id.bottom_sheet_state);
        bottomSheetOffset = (TextView) findViewById(R.id.bottom_sheet_offset);
        btnHideBottomSheet.setOnClickListener(this);
        btnContractBottomSheet.setOnClickListener(this);
        btnExpandBottomSheet.setOnClickListener(this);
        btnShowModelBottomSheet.setOnClickListener(this);

        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                            case BottomSheetBehavior.STATE_COLLAPSED:
                                bottomSheetState.setText("STATE_COLLAPSED");
                                break;
                            case BottomSheetBehavior.STATE_EXPANDED:
                                bottomSheetState.setText("STATE_EXPANDED");
                                break;
                            case BottomSheetBehavior.STATE_HIDDEN:
                                bottomSheetState.setText("STATE_HIDDEN");
                                break;
                            case BottomSheetBehavior.STATE_DRAGGING:
                                bottomSheetState.setText("STATE_DRAGGING");
                                break;
                            case BottomSheetBehavior.STATE_SETTLING:
                                bottomSheetState.setText("STATE_SETTLING");
                                break;
                        }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                bottomSheetOffset.setText(String.valueOf(slideOffset));
            }
        });
        //bottomSheetBehavior.setBottomSheetCallback(this);
        //btnModalBottomSheet = (Button)findViewById(R.id.btnModalBottomSheet);
        //btnModalBottomSheet.setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View v) {
        //
        //    }
        //});
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_hide_bottom_sheet:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                break;
            case R.id.btn_contract_bottom_sheet:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.btn_expand_bottom_sheet:
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                break;
            case R.id.btn_show_modal_bottom_sheet:
                //BottomSheetDialogFragment bsdFragment =
                //                MiBottomSheetDialogFragment.newInstance();
                //
                //        bsdFragment.show(
                //                MainActivity.this.getSupportFragmentManager(), "BSDialog");
                break;
        }
    }
}