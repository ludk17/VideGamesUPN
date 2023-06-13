package com.example.vj20231.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.ImageView;

import androidx.activity.ComponentActivity;

public class CamaraUtils {

    private static final int OPEN_CAMERA_REQUEST = 1001;
    private static final int OPEN_GALLERY_REQUEST = 1002;

    public static void setUpOpenCamera(ComponentActivity activity) {
        if(activity.checkSelfPermission(Manifest.permission.CAMERA)  == PackageManager.PERMISSION_GRANTED)
        {
            openCamera(activity);
        } else {
            String[] permissions = new String[] {Manifest.permission.CAMERA};
            activity.requestPermissions(permissions, 1000);
        }
    }

    public static void setUpOpenGallery(ComponentActivity activity) {
        if(activity.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            openGallery(activity);
        }
        else {
            String[] permissions = new String[] {Manifest.permission.READ_EXTERNAL_STORAGE};
            activity.requestPermissions(permissions, 2000);
        }
    }

    private static void openCamera(ComponentActivity activity) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activity.startActivityForResult(intent, OPEN_CAMERA_REQUEST);
    }

    private static void openGallery(ComponentActivity activity) {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        activity.startActivityForResult(intent, OPEN_GALLERY_REQUEST);
    }

    public static Bitmap GetBitMap(ComponentActivity activity, int requestCode, Intent data) {
        Bitmap photo = null;
        if(requestCode == OPEN_CAMERA_REQUEST ) {
            photo = (Bitmap) data.getExtras().get("data");
        }

        if(requestCode == OPEN_GALLERY_REQUEST) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };
            Cursor cursor = activity.getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close(); // close cursor

            photo = BitmapFactory.decodeFile(picturePath);
        }

        return photo;
    }
}
