package com.example.termp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var gallery_btn : ImageButton
    lateinit var camera_btn : ImageButton
    lateinit var function_btn : ImageButton

//    lateinit var cameraView: CameraView


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
//        cameraView = findViewById(R.id.cameraView)

        // 카메라 preview를 surfaceView에 띄우기
        // ...
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



}