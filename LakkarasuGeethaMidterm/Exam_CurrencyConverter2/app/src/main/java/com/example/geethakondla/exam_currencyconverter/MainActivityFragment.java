package com.example.geethakondla.exam_currencyconverter;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private EditText dollar;
    private TextView francs;
    private Button submit;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        dollar = (EditText) view.findViewById(R.id.dollar_currency);
        francs = (TextView) view.findViewById(R.id.francs_currency);
        submit = (Button) view.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
        return view;
    }
    private void convert(){
        double dollarval = Double.parseDouble(dollar.getText().toString().trim());
        double francsval = 439.36*dollarval;
        francs.setText(String.format("%.2f", francsval));
    }

}
