package com.davimatyi.angletool.viewmodels

import android.app.Application
import android.content.Context.SENSOR_SERVICE
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import kotlin.math.roundToInt

class AngleViewModel(
    application: Application,
    private val sensorManager: SensorManager = application.applicationContext.getSystemService(SENSOR_SERVICE) as SensorManager,
    sensor: Sensor? = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR),
    private val mRotationMatrix: FloatArray = FloatArray(16)
) : AndroidViewModel(application), SensorEventListener {

    var isLocked by mutableStateOf(false)
        private set
    var currentAngle by mutableIntStateOf(0)
    private var baseAngle by mutableIntStateOf(0)
    var angleText by mutableStateOf("0")
        private set

    init {
        mRotationMatrix[0] = 1f
        mRotationMatrix[4] = 1f
        mRotationMatrix[8] = 1f
        mRotationMatrix[12] = 1f

        sensorManager.registerListener(this, sensor, 10000)
    }

    override fun onCleared() {
        super.onCleared()
        sensorManager.unregisterListener(this)
    }


    fun switchLock() {
        if(!isLocked) {
            baseAngle = currentAngle
        }
        isLocked = !isLocked
    }

    override fun onSensorChanged(p0: SensorEvent?) {
        if (p0?.sensor?.type == Sensor.TYPE_ROTATION_VECTOR) {
            SensorManager.getRotationMatrixFromVector(mRotationMatrix, p0.values)
            val orientation = FloatArray(3)
            SensorManager.getOrientation(mRotationMatrix, orientation)
            currentAngle = (orientation[0].deg().roundToInt() + 180) - if(isLocked) baseAngle else 0
            if(currentAngle < 0) currentAngle += 360
            currentAngle -= 180
            if(currentAngle > 180) currentAngle -= 360
            if(currentAngle < -180) currentAngle += 360
            if(isLocked)
                angleText = "$currentAngle°"
        }
    }

    private fun Float.deg(): Float {
        return this * (180 / Math.PI).toFloat()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {

    }
}