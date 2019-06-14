package com.example.pesselectteams;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends AppCompatActivity implements Animation.AnimationListener {

    boolean blnButtonRotation = true;
    int intNumber = 21;
    long lngDegrees = 0;
    TextView displayScore;
    String teamName;
    SharedPreferences sharedPreferences;

    ImageView selected, imageRoulette;

    Button b_start, b_up, b_down;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        displayScore = (TextView) findViewById(R.id.score);
        b_start = (Button) findViewById(R.id.buttonStart);
        b_up = (Button) findViewById(R.id.buttonUp);
        b_down = (Button) findViewById(R.id.buttonDown);

        selected = (ImageView) findViewById(R.id.imageSelected);
        imageRoulette = (ImageView) findViewById(R.id.rouletteImage);

        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(Main2Activity.this);
        this.intNumber = this.sharedPreferences.getInt("INT_NUMBER", 21);
        setImageRoulette(this.intNumber);

    }

    @Override
    public void onAnimationStart(Animation animation) {
        this.blnButtonRotation = false;
        b_start.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationEnd(Animation animation) {

        int a = (int) (((double) this.intNumber)
                - Math.floor(((double) this.lngDegrees) / (360.0d / ((double) this.intNumber))));
        setTeam(a, this.intNumber);

        this.blnButtonRotation = true;
        b_start.setVisibility(View.VISIBLE);


    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    public void onClickButtonRotation(View v) {
        if (this.blnButtonRotation) {
            int ran = new Random().nextInt(359) + 3600;
            RotateAnimation rotateAnimation = new RotateAnimation((int) this.lngDegrees, (int)
                    (this.lngDegrees + ((long) ran)), 1, 0.5f, 1, 0.5f);

            this.lngDegrees = (this.lngDegrees + ((long) ran)) % 360;
            rotateAnimation.setDuration((long) ran);
            rotateAnimation.setFillAfter(true);
            rotateAnimation.setInterpolator(new DecelerateInterpolator());
            rotateAnimation.setAnimationListener(Main2Activity.this);
            imageRoulette.setAnimation(rotateAnimation);
            imageRoulette.startAnimation(rotateAnimation);

        }
    }

    public void buttonUp(View v) {
        if (this.intNumber == 20) {
            intNumber++;
            setImageRoulette(this.intNumber);
            b_down.setVisibility(View.VISIBLE);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putInt("INT_NUMBER", this.intNumber);
            editor.commit();

        }

    }


    public void buttonDown(View v) {
        if (this.intNumber == 21) {
            intNumber--;
            setImageRoulette(this.intNumber);
            b_up.setVisibility(View.VISIBLE);
            SharedPreferences.Editor editor = this.sharedPreferences.edit();
            editor.putInt("INT_NUMBER", this.intNumber);
            editor.commit();

        }

    }

    private void setImageRoulette(int myNumber) {
        switch (myNumber) {
            case 20:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.national_teams));
                break;
            case 21:
                imageRoulette.setImageDrawable(getResources().getDrawable(R.drawable.fc_teams));
                break;
        }
    }

    public void setTeam(int numbteam, int size) {

        if (size == 20) {
            switch (numbteam) {
                case 1:
                    displayScore.setText("PORTUGAL");
                    break;
                case 2:
                    displayScore.setText("CHILE");
                    break;
                case 3:
                    displayScore.setText("COLOMBIA");
                    break;
                case 4:
                    displayScore.setText("ALGERIA");
                    break;
                case 5:
                    displayScore.setText("BRAZIL");
                    break;
                case 6:
                    displayScore.setText("BRAZIL");
                    break;
                case 7:
                    displayScore.setText("GERMANY");
                    break;
                case 8:
                    displayScore.setText("WALES");
                    break;
                case 9:
                    displayScore.setText("COOOTE D'IVORIE");
                    break;
                case 10:
                    displayScore.setText("ITALY");
                    break;
                case 11:
                    displayScore.setText("NETHERLANDS");
                    break;
                case 12:
                    displayScore.setText("MEXICO");
                    break;
                case 13:
                    displayScore.setText("SOUTH KOREA");
                    break;
                case 14:
                    displayScore.setText("URUGUAY");
                    break;
                case 15:
                    displayScore.setText("JAPAN");
                    break;
                case 16:
                    displayScore.setText("FRANCE");
                    break;
                case 17:
                    displayScore.setText("ENGLAND");
                    break;
                case 18:
                    displayScore.setText("BELGIUM");
                    break;
                case 19:
                    displayScore.setText("ARGHENTINA");
                    break;
                case 20:
                    displayScore.setText("POLAND");
                    break;
            }

        }

        if (size == 21) {
            switch (numbteam) {
                case 1:
                    displayScore.setText("BAYER");
                    break;
                case 2:
                    displayScore.setText("LIVERPOOL");
                    break;
                case 3:
                    displayScore.setText("ATLENTICO MADRID");
                    break;
                case 4:
                    displayScore.setText("DORTMUND");
                    break;
                case 5:
                    displayScore.setText("EVERTON");
                    break;
                case 6:
                    displayScore.setText("NAPOLI");
                    break;
                case 7:
                    displayScore.setText("MANCHESTER CITY");
                    break;
                case 8:
                    displayScore.setText("LEICESTER CITY");
                    break;
                case 9:
                    displayScore.setText("PARI SAINTGERMAINT");
                    break;
                case 10:
                    displayScore.setText("CHELSEA");
                    break;
                case 11:
                    displayScore.setText("ARSERNAL");
                    break;
                case 12:
                    displayScore.setText("FIORENTINA");
                    break;
                case 13:
                    displayScore.setText("AS ROMA");
                    break;
                case 14:
                    displayScore.setText("AC MINAL");
                    break;
                case 15:
                    displayScore.setText("REAL MADRID");
                    break;
                case 16:
                    displayScore.setText("JUVENTUS");
                    break;
                case 17:
                    displayScore.setText("FC BARCELONA");
                    break;
                case 18:
                    displayScore.setText("MANCHESTER UNITED");
                    break;
                case 19:
                    displayScore.setText("INTERMINAL");
                    break;
                case 20:
                    displayScore.setText("TOTTENHAMHOSPUR");
                    break;
                case 21:
                    displayScore.setText("ASMONACO");
                    break;
            }
        }
    }

}

