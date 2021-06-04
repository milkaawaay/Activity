package com.example.activityproject


import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.codility.pedometer.utils.StepDetector

class stepCount : AppCompatActivity(), SensorEventListener, StepListener  {

    private var simpleStepDetector: StepDetector? = null
    private var sensorManager: SensorManager? = null
    private val TEXT_NUM_STEPS = "Количество шагов: "
    private var numSteps: Int = 0

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (event!!.sensor.type == Sensor.TYPE_ACCELEROMETER) {
            simpleStepDetector!!.updateAccelerometer(event.timestamp, event.values[0], event.values[1], event.values[2])
        }
    }

    override fun step(timeNs: Long) {
        numSteps++
        val tvSteps = findViewById<TextView>(R.id.tvSteps)
        tvSteps.text = TEXT_NUM_STEPS.plus(numSteps)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_step_count)
        // Get an instance of the SensorManager
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        simpleStepDetector = StepDetector()
        simpleStepDetector!!.registerListener(this@stepCount )
    }
    fun btnStartSteps(view: View) {
        numSteps = 0
        sensorManager!!.registerListener(this, sensorManager!!.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_FASTEST)
    }

    fun btnStopSteps(view: View) {
        sensorManager!!.unregisterListener(this)
    }
}