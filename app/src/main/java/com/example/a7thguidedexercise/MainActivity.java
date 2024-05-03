package com.example.a7thguidedexercise;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    RatingBar ratingBar;
    TextView rate;
    Button click, close;
    AlertDialog.Builder alertDialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        alertDialogBuilder = new AlertDialog.Builder(this);
        ratingBar = findViewById(R.id.ratingBar);
        rate = findViewById(R.id.rateTxt);
        click = findViewById(R.id.clickBtn);
        close = findViewById(R.id.closeBtn);

        showRating();
        closeApplication();

    }

    public void showRating(){
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if(ratingBar.getRating() >= 2){
                    rate.setTextColor(Color.GREEN);
                    getWindow().getDecorView().setBackgroundColor(Color.GREEN);
                } else if (ratingBar.getRating()==3) {
                    rate.setTextColor(Color.YELLOW);
                    getWindow().getDecorView().setBackgroundColor(Color.YELLOW);
                } else{
                    rate.setTextColor(Color.RED);
                    getWindow().getDecorView().setBackgroundColor(Color.RED);
                }
                rate.setText("Rate: " + ratingBar.getRating());
            }
        });

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Rate: " + ratingBar.getRating(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void closeApplication(){
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialogBuilder.setTitle("Warning Message!")
                        .setMessage("Do you want to close the Application?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // once the Yes is selected it will close the application using
                                // this pre-defined method named finish() in android
                                finish();
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                // once the No is selected it will simply close/cancel the
                                // dialogInterface
                                dialogInterface.cancel();
                            }
                        })
                        // this will sets whether this dialog is cancelable or not, by default is TRUE
                        .setCancelable(false);
                // display our dialog builder
                alertDialogBuilder.show();
            }


        });
    }

    @Override
    public void onBackPressed() {
        alertDialogBuilder.setTitle("Warning Message!")
                .setMessage("Do you want to close the Application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setCancelable(false);
        alertDialogBuilder.show();
    }


}