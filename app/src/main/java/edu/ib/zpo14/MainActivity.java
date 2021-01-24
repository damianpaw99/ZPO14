package edu.ib.zpo14;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static final String TAG="EDUIB";
    private SensorManager sensorManager;
    private BallView ballView;
    private long lastTime;
    private static final double NANO_TO_SEC=1./1000000000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        ballView=new BallView(this);
        setContentView(ballView);
        sensorManager =(SensorManager) getSystemService(SENSOR_SERVICE);
        sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


    }
    @Override
    public void onSensorChanged(SensorEvent event){

        float [] values=event.values;
        float ax=values[0];
        float ay=values[1];

        float timeStamp=event.timestamp;
        float actualTime=(float) (timeStamp*NANO_TO_SEC);
        if(actualTime-lastTime>0.05) {
            ballView.getBall().setAx(-ax*0.1);
            ballView.getBall().setAy(ay*0.1);
            lastTime=(long) actualTime;
        }
    }

    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
                SensorManager.SENSOR_DELAY_GAME);
    }
    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener((this));
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

}