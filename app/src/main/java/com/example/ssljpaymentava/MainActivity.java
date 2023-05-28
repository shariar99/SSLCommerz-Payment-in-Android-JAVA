package com.example.ssljpaymentava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCAdditionalInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;

public class MainActivity extends AppCompatActivity implements SSLCTransactionResponseListener {

    private Button button;
    private EditText editText;
    private SSLCommerzInitialization sslCommerzInitialization;
    private SSLCAdditionalInitializer additionalInitialization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.amountid);
        button = findViewById(R.id.payBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String amount = editText.getText().toString().trim();

                if (amount.isEmpty()) {
                    editText.setError("Error");

                } else {

                    sslSetUp(amount);
                }
            }
        });
    }

    private void sslSetUp(String amount) {
        sslCommerzInitialization = new SSLCommerzInitialization(
                "Here add your test id",
                "here your test password",
                Double.parseDouble(amount),
                SSLCCurrencyType.BDT,
                amount,
                "eshop",
                SSLCSdkType.TESTBOX
        );

        additionalInitialization = new SSLCAdditionalInitializer();
        additionalInitialization.setValueA("Value Option 1");
        additionalInitialization.setValueB("Value Option 2");
        additionalInitialization.setValueC("Value Option 3");
        additionalInitialization.setValueD("Value Option 4");

        IntegrateSSLCommerz.getInstance(MainActivity.this)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .addAdditionalInitializer(additionalInitialization)
                .buildApiCall(MainActivity.this);
    }

    @Override
    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
        Toast.makeText(getApplicationContext(), "Payment success", Toast.LENGTH_SHORT).show();
        Log.i("DONE", "Payment Done");
    }

    @Override
    public void transactionFail(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void closed(String s) {
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
    }
}