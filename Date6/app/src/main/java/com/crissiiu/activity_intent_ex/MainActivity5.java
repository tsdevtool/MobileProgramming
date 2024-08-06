package com.crissiiu.activity_intent_ex;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.crissiiu.activity_intent_ex.databinding.ActivityMain5Binding;
import com.crissiiu.activity_intent_ex.databinding.BottomSheetDialogBinding;

public class MainActivity5 extends AppCompatActivity {

    ActivityMain5Binding binding;
    ActivityResultLauncher<Intent> launcher;
    boolean openCam;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        addEvents();

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result->{
           if(result.getResultCode() == RESULT_OK && result.getData() != null){
               if(openCam){
                   Bitmap bitmap = (Bitmap) result.getData().getExtras().get("data");
                   assert bitmap != null;
                   binding.imvPhoto.setImageBitmap(bitmap);
               }else{
                   Uri uri = result.getData().getData();
                   binding.imvPhoto.setImageURI(uri);
               }
           }
        });
    }

    private void addEvents() {
        //Chuyen huong den man hinh quay so
        binding.btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);

                Uri uri = Uri.parse("tel:" + binding.edtPhoneNumber.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });

        binding.btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_CALL);
                Uri uri= Uri.parse("tel:" + binding.edtPhoneNumber.getText().toString());
                intent.setData(uri);
                startActivity(intent);
            }
        });

        binding.btnCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBottomSheet();
            }
        });
    }

    private void showBottomSheet() {
        Dialog dialog = new Dialog(MainActivity5.this);
        dialog.setContentView(R.layout.bottom_sheet_dialog);


        LinearLayout camera = dialog.findViewById(R.id.layoutCamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Opening camera
                openCam = true;
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivity(intent);
                launcher.launch(intent);
                dialog.dismiss();
            }
        });

        LinearLayout gallery  = dialog.findViewById(R.id.layoutGallery);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Opening photo gallery
                openCam = false;
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                launcher.launch(intent);
//                startActivity(intent);
                dialog.dismiss();
            }
        });
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setWindowAnimations(R.style.BottomSheetAnimation);
        dialog.show();
    }
}