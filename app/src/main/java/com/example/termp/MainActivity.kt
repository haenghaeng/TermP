package com.example.termp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceView
import android.widget.ImageButton
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner

class MainActivity : AppCompatActivity() {
    lateinit var gallery_btn : ImageButton
    lateinit var camera_btn : ImageButton
    lateinit var function_btn : ImageButton

    lateinit var previewView: PreviewView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init(){
        // 버튼 연결
        gallery_btn = findViewById(R.id.galleryBtn)
        camera_btn = findViewById(R.id.cameraBtn)
        function_btn = findViewById(R.id.functionBtn)

        // 버튼에 리스너 설정
        gallery_btn.setOnClickListener{
            gallery_btn_click()
        }
        camera_btn.setOnClickListener{
            camera_btn_click()
        }
        function_btn.setOnClickListener{
            function_btn_click()
        }

        // view 연결
        previewView = findViewById(R.id.previewView)

        // 카메라 실행
        startCamera()
    }

    fun gallery_btn_click(){
        // 갤러리로 이동, 사진 선택
        Toast.makeText(this, "gallery", Toast.LENGTH_SHORT).show();
    }
    fun camera_btn_click(){
        // 현재 화면 촬영
        Toast.makeText(this, "camera", Toast.LENGTH_SHORT).show();
    }
    fun function_btn_click(){
        // ?
        Toast.makeText(this, "function", Toast.LENGTH_SHORT).show();
    }


    /**
     * 카메라 실행 함수
     * https://developer.android.com/media/camera/camerax/preview?hl=ko
     * 현재 화면이 약간 잘려서 나옴. 수정 해야 함
     */
    fun startCamera(){
        // 1. CameraProvider 요청
        // ProcessCameraProvider는 Camera의 생명주기를 LifeCycleOwner의 생명주기에 Binding 함
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        // 2. CameraProvier 사용 가능 여부 확인
        cameraProviderFuture.addListener(Runnable {
            val cameraProvider = cameraProviderFuture.get()
            bindPreview(cameraProvider)
        }, ContextCompat.getMainExecutor(this))
    }



    fun bindPreview(cameraProvider : ProcessCameraProvider) {
        var preview : Preview = Preview.Builder()
            .build()

        var cameraSelector : CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        preview.setSurfaceProvider(previewView.getSurfaceProvider())

        var camera = cameraProvider.bindToLifecycle(this as LifecycleOwner, cameraSelector, preview)
    }



}