package com.alienlabz.camera;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button;
	private ImageView imageView;
	private Uri imageUri;
	public static final int TAKE_PICTURE = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button1);
		imageView = (ImageView) findViewById(R.id.imageView1);

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				File photo = new File(Environment.getExternalStorageDirectory(), "Pic.jpg");

				intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(photo));

				imageUri = Uri.fromFile(photo);
				startActivityForResult(intent, TAKE_PICTURE);
			}

		});
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		switch (requestCode) {

		case TAKE_PICTURE:

			if (resultCode == Activity.RESULT_OK) {
				Uri selectedImage = imageUri;
				Bitmap bitmap;
				try {
					bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);

					imageView.setImageBitmap(bitmap);

					Toast.makeText(this, selectedImage.toString(), Toast.LENGTH_LONG).show();

				} catch (Exception e) {
					Log.e("Camera", e.toString());
				}
			}

		}

	}

}
