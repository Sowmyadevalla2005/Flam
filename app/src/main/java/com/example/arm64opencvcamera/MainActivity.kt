package com.example.arm64opencvcamera

import android.os.Bundle
import android.view.SurfaceView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.opencv.android.CameraBridgeViewBase
import org.opencv.android.OpenCVLoader
import org.opencv.android.JavaCameraView

class MainActivity : AppCompatActivity(), CameraBridgeViewBase.CvCameraViewListener2 {
    private lateinit var textViewStatus: TextView
    private lateinit var cameraView: JavaCameraView
    private var isOpenCvInitialized = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewStatus = findViewById(R.id.textViewStatus)
        cameraView = findViewById(R.id.cameraView)
        cameraView.visibility = SurfaceView.VISIBLE
        cameraView.setCvCameraViewListener(this)

        isOpenCvInitialized = OpenCVLoader.initDebug()
        updateControls()
    }

    private fun updateControls() {
        textViewStatus.text =
            if (isOpenCvInitialized) "OpenCV initialized successfully"
            else "OpenCV initialization failed"
    }

    override fun onPause() {
        super.onPause()
        cameraView.disableView()
    }

    override fun onResume() {
        super.onResume()
        cameraView.enableView()
    }

    override fun onCameraFrame(inputFrame: CameraBridgeViewBase.CvCameraViewFrame?) =
        inputFrame?.rgba() // Returns the camera frame as an OpenCV Mat

    override fun onCameraViewStarted(width: Int, height: Int) {}
    override fun onCameraViewStopped() {}
}
