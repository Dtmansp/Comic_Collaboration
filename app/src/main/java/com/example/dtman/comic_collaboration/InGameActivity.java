package com.example.dtman.comic_collaboration;
/*
####################################################################################################
INGAME ACTIVITY
PURPOSE:
Used for drawing and submitting a frame of the comic.
---------------------------------------------------------------------------------------------------
Written by Brian Bolinder
Started 1/19/16
---------------------------------------------------------------------------------------------------
PROGRESS:
- 1/19/16
  Copied from the master and started making the drawing activity.
- 1/31/16
  Copied all files and stuff to the CC app
####################################################################################################
 */
//-IMPORTS:
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
//##################################################################################################
//-START APP:
public class InGameActivity extends AppCompatActivity
    {
    //==============================================================================================
    //- VARIABLES:
    private Dialog chooseColorDLG;
    private Dialog brushChooserDLG;

    private float xsmallBrush, smallBrush, mediumBrush, largeBrush;

    private ImageButton colorChooseBTN;

    private DrawingView drawView;

    private boolean erase = false;

    private View decorView;

    //==============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        //------------------------------------------------------------------------------------------
        //-NORMAL STUFF
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_game);

        drawView = (DrawingView) findViewById(R.id.drawing);

        decorView = getWindow().getDecorView();

        makeFullScreen();
        //------------------------------------------------------------------------------------------
        colorChooseBTN = (ImageButton)
                findViewById(R.id.paintColor_BUTTON);

        xsmallBrush = getResources().getInteger(R.integer.xsmall_size);
        smallBrush = getResources().getInteger(R.integer.small_size);
        mediumBrush = getResources().getInteger(R.integer.medium_size);
        largeBrush = getResources().getInteger(R.integer.large_size);
        //-SET THE DEFAULT BRUSH SIZE TO MEDIUM
        drawView.setBrushSize(mediumBrush);
        }

    //==============================================================================================
    //-WHEN THE USER PRESSES THE COLOR BUTTON SHOW THE AVAILABLE COLORS...
    public void ChooseColor(View v)
        {
        makeFullScreen();
        //-SHOW THE COLOR_CHOOSER LAYOUT DIALOG
        chooseColorDLG = new Dialog(this);
        chooseColorDLG.setTitle("Choose Color:");
        chooseColorDLG.setContentView(R.layout.iga_colorchooser);
        chooseColorDLG.show();
        //------------------------------------------------------------------------------------------
        //-SETUP THE COLOR BUTTONS THAT THE USER CAN CHOOSE FROM
        ImageButton color1Btn = (ImageButton) chooseColorDLG.findViewById(R.id.color1);
        ImageButton color2Btn = (ImageButton) chooseColorDLG.findViewById(R.id.color2);
        ImageButton color3Btn = (ImageButton) chooseColorDLG.findViewById(R.id.color3);
        ImageButton color4Btn = (ImageButton) chooseColorDLG.findViewById(R.id.color4);
        //------------------------------------------------------------------------------------------
        //-USER CHOSE THE 1ST COLOR (BLACK)
        color1Btn.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vcb)
            {
            //DisplayTestText("Black");
            chooseColorDLG.dismiss();
            ColorSelected(vcb);
            }
        });
        //-USER CHOSE THE 2ND COLOR (RED)
        color2Btn.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vcb)
            {
            //DisplayTestText("Red");
            chooseColorDLG.dismiss();
            ColorSelected(vcb);
            }
        });
        //-USER CHOSE THE 3RD COLOR (BLUE)
        color3Btn.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vcb)
            {
            //DisplayTestText("Blue");
            chooseColorDLG.dismiss();
            ColorSelected(vcb);
            }
        });
        //-USER CHOSE THE 4TH COLOR (GREEN)
        color4Btn.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vcb)
            {
            //DisplayTestText("Green");
            chooseColorDLG.dismiss();
            ColorSelected(vcb);
            }
        });
        }

    //----------------------------------------------------------------------------------------------
    //-USER CHOOSING THE COLOR THEY WANT...
    public void ColorSelected(View v)
        {
        String chosenColor = v.getTag().toString();
        drawView.setColor(chosenColor);
        //DisplayTestText(chosenColor);
        colorChooseBTN.setBackground(v.getBackground());
        if (erase) erase = false;
        //chooseColorDLG.hide();
        }

    //==============================================================================================
    //-WHEN THE USER PRESSES THE BRUSH BUTTON SHOW THE AVAILABLE SIZES...
    public void ChooseBrushSize(View v)
        {
        makeFullScreen();
        brushChooserDLG = new Dialog(this);

        if (!erase) brushChooserDLG.setTitle("Choose Brush Size:");
        else brushChooserDLG.setTitle("Erase Size:");

        brushChooserDLG.setContentView(R.layout.iga_brushsizechooser);
        brushChooserDLG.show();
        //------------------------------------------------------------------------------------------
        //- SETUP THE BRUSH SIZE BUTTONS THAT THE USER CAN CHOOSE FROM
        ImageButton sizeBtn1 = (ImageButton) brushChooserDLG.findViewById(R.id.xsmall_brush);
        ImageButton sizeBtn2 = (ImageButton) brushChooserDLG.findViewById(R.id.small_brush);
        ImageButton sizeBtn3 = (ImageButton) brushChooserDLG.findViewById(R.id.medium_brush);
        ImageButton sizeBtn4 = (ImageButton) brushChooserDLG.findViewById(R.id.large_brush);
        //------------------------------------------------------------------------------------------
        //-USER CHOSE THE XSMALL BRUSH
        sizeBtn1.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vsb)
            {
            drawView.setBrushSize(xsmallBrush);
            if (!erase) drawView.setLastBrushSize(xsmallBrush);
            brushChooserDLG.dismiss();
            }
        });
        //-USER CHOSE THE SMALL BRUSH
        sizeBtn2.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vsb)
            {
            drawView.setBrushSize(smallBrush);
            if (!erase) drawView.setLastBrushSize(smallBrush);
            brushChooserDLG.dismiss();
            }
        });
        //-USER CHOSE THE MEDIUM BRUSH
        sizeBtn3.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vsb)
            {
            drawView.setBrushSize(mediumBrush);
            if (!erase) drawView.setLastBrushSize(mediumBrush);
            brushChooserDLG.dismiss();
            }
        });
        //-USER CHOSE THE LARGE BRUSH
        sizeBtn4.setOnClickListener(new View.OnClickListener()
        {
        @Override
        public void onClick(View vsb)
            {
            drawView.setBrushSize(largeBrush);
            if (!erase) drawView.setLastBrushSize(largeBrush);
            brushChooserDLG.dismiss();
            }
        });
        }

    //==============================================================================================
    //-ERASE BUTTON
    public void EraseButton(View v)
        {
        if(!erase)
            {
            erase = true;
            drawView.setErase(true);
            }
        else
            {
            erase = false;
            drawView.setErase(false);
            }
        }

    //==============================================================================================
    //-NEW BUTTON
    /*
    STARTED - 1/5/16
    made the onClick method
    has a dialog that lets the user confirm that they want to clear the drawing screen and
    start a new one
     */
    public void NewButton(View v)
        {
        makeFullScreen();
        AlertDialog.Builder newDialog = new AlertDialog.Builder(this);
        newDialog.setTitle("New drawing");
        newDialog.setMessage("Start new drawing (you will lose the current drawing)?");
        newDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            drawView.startNew();
            dialog.dismiss();
            }
        });
        newDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            dialog.cancel();
            }
        });
        newDialog.show();

        //-TURN OFF ERASE IF ITS ON
        if(erase)
            {
            drawView.setErase(false);
            }
        }
    //==============================================================================================
    //-SAVE BUTTON
    /*
    STARTED - 1/5/16
    Made the onClick for the save button that gives the user a dialog that lets them confirm if
    they want to save the picture
    --- 1/12/16
    Trying to fix the save function.
     */
    public void SaveButton(View v)
        {
        makeFullScreen();
        AlertDialog.Builder saveDialog = new AlertDialog.Builder(this);
        saveDialog.setTitle("Save drawing");
        saveDialog.setMessage("Save drawing to device Gallery?");
        saveDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            //drawView.setDrawingCacheEnabled(true);
            //Bitmap b = drawView.getDrawingCache();
            //            FileOutputStream fos = null;
            //            try
            //                {
            //                fos = new FileOutputStream(getFileName());
            //                }
            //                catch (FileNotFoundException e)
            //                    {
            //                    e.printStackTrace();
            //                    }

            //            parent.setDrawingCacheEnabled(true);
            //            Bitmap b = parent.getDrawingCache();
            //
            //            FileOutputStream fos = null;
            //            try {
            //            fos = new FileOutputStream(getFileName());
            //            } catch (FileNotFoundException e) {
            //            e.printStackTrace();
            //            }
            //
            //            b.compress(CompressFormat.PNG, 95, fos);
            //            //-Do the save stuff here
            //            drawView.setDrawingCacheEnabled(true);
            //            String imgSaved = MediaStore.Images.Media.insertImage(
            //                    getContentResolver(), drawView.getDrawingCache(),
            //                    //- 1/12/16
            //                    //UUID.randomUUID().toString()+".png", "drawing");
            //                    "mypicture0192.png", "drawing");
            //            if(imgSaved!=null)
            //                {
            //                Toast savedToast = Toast.makeText(getApplicationContext(),
            //                        "Drawing saved to Gallery!", Toast.LENGTH_SHORT);
            //                savedToast.show();
            //                }
            //            else
            //                {
            //                Toast unsavedToast = Toast.makeText(getApplicationContext(),
            //                        "Oops! Image could not be saved.", Toast.LENGTH_SHORT);
            //                unsavedToast.show();
            //                }
            //            drawView.destroyDrawingCache();
            }
        });
        saveDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener()
        {
        public void onClick(DialogInterface dialog, int which)
            {
            dialog.cancel();
            }
        });
        saveDialog.show();
        }
    //=============================================================================================
    public void makeFullScreen()
        {
        //-Make the activity fullscreen
        decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LOW_PROFILE
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                //| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        }
    //############################################################################################
    //-DEBUG CODE:

    //############################################################################################
    }
//#################################################################################################