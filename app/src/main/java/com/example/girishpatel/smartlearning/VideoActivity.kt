package com.example.girishpatel.smartlearning

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import android.widget.VideoView
import kotlinx.android.synthetic.main.video_tutorial.*

class VideoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.video_tutorial)

        val videoView = findViewById<VideoView>(R.id.videoViewMy)
        val path = "android.resource://" + packageName + "/" + R.raw.geoscience1
        videoView?.setVideoURI(Uri.parse(path))

        val button = findViewById<Button>(R.id.button6)
        button.setOnClickListener({
            val isPlaying = videoView.isPlaying
            button.setText(if (isPlaying) R.string.play else R.string.pause)

            val msg = getString(if (isPlaying) R.string.paused else R.string.playing)
            Toast.makeText(this@VideoActivity, msg, Toast.LENGTH_SHORT).show()
            if (isPlaying) {
                videoView.pause()
            } else {
                videoView.start()
            }
        })
    }
}
