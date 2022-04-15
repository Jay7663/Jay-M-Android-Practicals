package com.example.androidpractical.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidpractical.R
import com.example.androidpractical.databinding.ActivityPermissionBinding
import com.example.androidpractical.utils.Constants.PACKAGE

class PermissionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPermissionBinding
    private var hasLocationPermission = false
    private var hasStoragePermission = false
    private var hasCameraPermission = false
    private val requestLocationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                generateToast(getString(R.string.permission_activity_already_granted))
            } else {
                showRationaleDialog(
                    getString(R.string.permission_activity_location_permission),
                    getString(R.string.permission_activity_dialog_location_message)
                )
            }
        }
    private val requestFilePermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                generateToast(getString(R.string.permission_activity_already_granted))
                fileChooserLauncher.launch(
                    Intent()
                        .setType(getString(R.string.media_storage_type_image))
                        .setAction(Intent.ACTION_GET_CONTENT)
                )
            } else {
                showRationaleDialog(
                    getString(R.string.permission_activity_dialog_title_file_permission),
                    getString(R.string.permission_activity_dialog_message_file_permission)
                )
            }
        }
    private val requestCameraPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) {
            if (it) {
                generateToast(getString(R.string.permission_activity_already_granted))
                takePicture.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
            } else {
                showRationaleDialog(
                    getString(R.string.permission_activity_dialog_title_camera_permission),
                    getString(R.string.permission_activity_dialog_message_camera_permission)
                )
            }
        }
    private var takePicture =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK) {
                handleData(it.data)
            }
        }
    private var fileChooserLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val fileLocation = it?.data
                Toast.makeText(this, fileLocation.toString(), Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialData()
    }

    private fun initialData() {
        checkForPermissions()
        binding.btnLocation.setOnClickListener {
            if (hasLocationPermission) {
                generateToast(getString(R.string.permission_activity_already_have_permission))
            } else {
                requestLocationPermissionLauncher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
            }
        }

        binding.btnFile.setOnClickListener {
            if (hasStoragePermission) {
                generateToast(getString(R.string.permission_activity_already_have_permission))
                val intent = Intent()
                    .setType("*/*")
                    .setAction(Intent.ACTION_GET_CONTENT)
                fileChooserLauncher.launch(intent)
            } else {
                requestFilePermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }

        binding.btnCamera.setOnClickListener {
            if (hasCameraPermission) {
                takePicture.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
                generateToast(getString(R.string.permission_activity_already_have_permission))
            } else {
                requestCameraPermissionLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    private fun handleData(data: Intent?) {
        binding.ivImage.setImageBitmap(data?.extras?.get(getString(R.string.implicit_intent_data)) as Bitmap)
    }

    private fun generateToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showRationaleDialog(title: String, message: String) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle(title)
            .setMessage(message)
            .setPositiveButton(getString(R.string.permission_activity_settings)) { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri: Uri = Uri.fromParts(PACKAGE, packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        builder.create().show()
    }

    private fun checkForPermissions() {
        hasLocationPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        hasStoragePermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED
        hasCameraPermission = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }
}