package com.plenarysof.calldialer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button callBtn;
    private Button dialBtn;
    private TextView number;
    private Button btnNine, btnEight, btnSeven, btnSix, btnFive, btnFour, btnThree, btnTwo, btnOne, btnZero, btnAterisk, btnHash;
    private String getNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();
        initListener();

        // add PhoneStateListener for monitoring
        MyPhoneListener phoneListener = new MyPhoneListener();
        TelephonyManager telephonyManager =
                (TelephonyManager) this.getSystemService(Context.TELEPHONY_SERVICE);
        // receive notifications of telephony state changes
        telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);

        callBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    // set the data
                    String uri = "tel:" + number.getText().toString();
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse(uri));

                    startActivity(callIntent);

                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Your call has failed...",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        dialBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try {
                    String uri = "tel:" + number.getText().toString();
                    Intent dialIntent = new Intent(Intent.ACTION_DIAL, Uri.parse(uri));

                    startActivity(dialIntent);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Your call has failed...",
                            Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_main);

        number = (TextView) findViewById(R.id.phoneNumber);
        callBtn = (Button) findViewById(R.id.call);
        dialBtn = (Button) findViewById(R.id.dial);
        btnNine = (Button) findViewById(R.id.btnNine);
        btnEight = (Button) findViewById(R.id.btnEight);
        btnSeven = (Button) findViewById(R.id.btnSeven);
        btnSix = (Button) findViewById(R.id.btnSix);
        btnFive = (Button) findViewById(R.id.btnFive);
        btnFour = (Button) findViewById(R.id.btnFour);
        btnThree = (Button) findViewById(R.id.btnThree);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        btnOne = (Button) findViewById(R.id.btnOne);
        btnZero = (Button) findViewById(R.id.btnZero);
        btnAterisk = (Button) findViewById(R.id.btnAterisk);
        btnHash = (Button) findViewById(R.id.btnHash);
    }

    private void initListener() {
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnOne.getText().toString();
                number.setText(getNumber);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnTwo.getText().toString();
                number.setText(getNumber);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnThree.getText().toString();
                number.setText(getNumber);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnFour.getText().toString();
                number.setText(getNumber);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnFive.getText().toString();
                number.setText(getNumber);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnSix.getText().toString();
                number.setText(getNumber);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnSeven.getText().toString();
                number.setText(getNumber);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnEight.getText().toString();
                number.setText(getNumber);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnNine.getText().toString();
                number.setText(getNumber);
            }
        });

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnZero.getText().toString();
                number.setText(getNumber);
            }
        });

        btnAterisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnAterisk.getText().toString();
                number.setText(getNumber);
            }
        });

        btnHash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNumber = number.getText() + btnHash.getText().toString();
                number.setText(getNumber);
            }
        });
    }

    private class MyPhoneListener extends PhoneStateListener {

        private boolean onCall = false;

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            switch (state) {
                case TelephonyManager.CALL_STATE_RINGING:
                    // phone ringing...
                    Toast.makeText(MainActivity.this, incomingNumber + " calls you",
                            Toast.LENGTH_LONG).show();
                    break;

                case TelephonyManager.CALL_STATE_OFFHOOK:
                    // one call exists that is dialing, active, or on hold
                    Toast.makeText(MainActivity.this, "on call...",
                            Toast.LENGTH_LONG).show();
                    //because user answers the incoming call
                    onCall = true;
                    break;

                case TelephonyManager.CALL_STATE_IDLE:
                    // in initialization of the class and at the end of phone call

                    // detect flag from CALL_STATE_OFFHOOK
                    if (onCall == true) {
                        Toast.makeText(MainActivity.this, "restart app after call",
                                Toast.LENGTH_LONG).show();

                        // restart our application
                        Intent restart = getBaseContext().getPackageManager().
                                getLaunchIntentForPackage(getBaseContext().getPackageName());
                        restart.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(restart);

                        onCall = false;
                    }
                    break;
                default:
                    break;
            }

        }
    }
}
