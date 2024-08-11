package com.crissiiu.bai1;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.bai1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private String phoneNumberString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(toolbar);

        addEvents();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnContact){
            Intent intent = new Intent(MainActivity.this, ContactActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void addEvents() {
        binding.btnNumber1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Number 1", Toast.LENGTH_SHORT).show();
                phoneNumberString = phoneNumberString + binding.btnNumber1.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Number 1", Toast.LENGTH_SHORT).show();
                phoneNumberString = phoneNumberString + binding.btnNumber2.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber3.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber4.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber5.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber6.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber7.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber8.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber9.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });
        binding.btnNumber0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumberString+=binding.btnNumber0.getText().toString();
                binding.edtPhoneNumber.setText(phoneNumberString);
            }
        });

//        Delete
        binding.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                abc = do dai 3 a = 0 b =1 = c = 2 0->2 0 -1 0->3-1

                if(binding.edtPhoneNumber.getText().length() > 0){
                    phoneNumberString = phoneNumberString.substring(0, phoneNumberString.length()-1);
                    binding.edtPhoneNumber.setText(phoneNumberString);
                }
            }
        });
//        Go to Call
        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(binding.edtPhoneNumber.getText().toString().length() > 0 ){
                    Intent intent = new Intent(Intent.ACTION_CALL);
//                Uri uri = Uri.parse("tel:" + binding.edtPhoneNumber.getText().toString());
                    Uri uri = Uri.parse("tel:" + phoneNumberString);
                    intent.setData(uri);
                    startActivity(intent);
                }else{
//                    Notification 1:
//                    Toast.makeText(MainActivity.this, "Please enter phone number", Toast.LENGTH_SHORT).show();

//                    Notification 2:
//                    customAlertDialog();

//                    Notification3: custom dialog
//                    customDialog();

//                    Notification 4: xu ly
                    Dialog dialog = new Dialog(MainActivity.this);
                    dialog.setContentView(R.layout.activity_custom_dialog2);

                    //Goi button
                    Button ok = dialog.findViewById(R.id.btnOk);
                    ok.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                        }
                    });

                    //Exit app
                    Button exitApp = dialog.findViewById(R.id.btnExitApp);
                    exitApp.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            MainActivity.this.finish();
                        }
                    });


                    dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    dialog.show();

                }

            }
        });

    }


    private void customDialog(){
        Dialog dialog = new Dialog(MainActivity.this);
        dialog.setContentView(R.layout.custom_dialog);

        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.show();
    }

    private void customAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Warning");
        builder.setIcon(R.drawable.baseline_warning_24);
        builder.setMessage("Please enter phone number!");

        //Dong y
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        //Khong dong y - tat app
        builder.setNegativeButton("Exit App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.this.finish();
            }
        });

        Dialog dialog = builder.create();
        dialog.show();
    }
}