package com.example.androidpractical.fragments

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.androidpractical.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class GalleryAddImageFragment : Fragment() {

    private lateinit var ivImage: ImageView

    private var getImageFromGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        if (it.resultCode == Activity.RESULT_OK) {
            ivImage.setImageURI(it.data?.data)
        }
    }

    private var takePicture =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                handleData(it.data)
            }
        }

    private fun handleData(data: Intent?) {
        val bitMap = data?.extras?.get(getString(R.string.implicit_intent_data)) as Bitmap
        ivImage.setImageBitmap(bitMap)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_gallery_add_image, container, false)

        val fabGalleryTrigger: FloatingActionButton = view.findViewById(R.id.fabGalleryTrigger)
        val fabCameraTrigger: FloatingActionButton = view.findViewById(R.id.fabCameraTrigger)
        ivImage = view.findViewById(R.id.ivImage)
        val imgUri = activity?.intent?.getParcelableExtra(Intent.EXTRA_STREAM) as? Uri

        ivImage.setImageURI(imgUri)

        fabGalleryTrigger.setOnClickListener {
            val i = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
            getImageFromGallery.launch(i)
        }

        fabCameraTrigger.setOnClickListener {
            val i = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            takePicture.launch(i)
        }
        return view
    }
}