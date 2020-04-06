package com.example.testjellybean;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int countJB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClickAdd(View view )
    {
        countJB++;
        updateCountTV();
    }//end add button handler

    public void onClickSubtract(View view)
    {
        countJB--;
        updateCountTV();
    }

    public void openDialogue (View view )
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Confirm reset Count");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick (DialogInterface dialogInterface, int i)
            {
                Toast.makeText (MainActivity.this, "yeppers", Toast.LENGTH_LONG).show();
                countJB = 0;
                updateCountTV();

            }//end onClick handler for positve button
        });//end set positive button

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i)
            {

            }//onClick

        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }//end handler to open dialog box for reset count

    //Brain methods
    private void updateCountTV()
    {
        TextView countTextview = (TextView) findViewById(R.id.countTV);
        countTextview.setText("Counting Jelly Beans gives me" + countJB);
    }//end method to update the counting text view

}
