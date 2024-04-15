package com.comst.data.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Intent
import android.content.pm.ServiceInfo
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import androidx.lifecycle.lifecycleScope
import com.comst.data.model.BoardParam
import com.comst.data.model.BoardParcel
import com.comst.data.model.ContentParam
import com.comst.data.retrofit.BoardService
import com.comst.domain.model.ACTION_POSTED
import com.comst.domain.usecase.file.UploadImageUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class PostingService : LifecycleService() {

    @Inject
    lateinit var uploadImageUseCase: UploadImageUseCase

    @Inject
    lateinit var boardService: BoardService

    companion object {
        const val EXTRA_BOARD = "extra board"
        const val CHANNEL_ID = "게시글 업로드"
        const val CHANNEL_NAME = "게시글 업로드 채널"
        const val FOREGROUND_NOTIFICATION_ID = 1000
    }

    // 서비스 호출할 때마다 불리는 것
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        startForeground()
        intent?.run {
            if (hasExtra(EXTRA_BOARD)){
                val boardParcel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    getParcelableExtra(EXTRA_BOARD, BoardParcel::class.java)
                } else {
                    getParcelableExtra(EXTRA_BOARD)
                }
                boardParcel?.run {
                    lifecycleScope.launch(Dispatchers.IO){
                        postBoard(this@run)
                    }
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }


    private fun createNotificationChannel(){
        val channel = NotificationChannel(
            CHANNEL_ID,
            CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )

        channel.description = "백그라운드에서 글을 업로드 합니다."

        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)
    }

    private fun startForeground(){
        val notification = NotificationCompat.Builder(this, CHANNEL_ID).build()

        // 안드로이드 14부터 포그라운드 서비스 타입 추가, shot 서비스는 보장 못받음
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            startForeground(
                FOREGROUND_NOTIFICATION_ID,
                notification,
                ServiceInfo.FOREGROUND_SERVICE_TYPE_SHORT_SERVICE
            )
        }else{
            startForeground(
                FOREGROUND_NOTIFICATION_ID,
                notification,
            )
        }
    }

    private suspend fun postBoard(boardParcel: BoardParcel){
        // 업로드
        val uploadImages = boardParcel.images.mapNotNull { image ->
            uploadImageUseCase(image).getOrNull()
        }
        val contentParam = ContentParam(
            text = boardParcel.content,
            images = uploadImages
        )
        val boardParam = BoardParam(boardParcel.title, contentParam.toJson())
        val requestBody = boardParam.toRequestBody()
        boardService.postBoard(requestBody)
        sendBroadcast(
            Intent(
                ACTION_POSTED
            ).apply {
                setPackage(packageName)
            }
        )
        stopForeground(STOP_FOREGROUND_DETACH)
    }
}