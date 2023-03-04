package com.filmolike.filmolik.ui.AlertDialogs;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

public class AlertViewFilms {

    public void createAlert(Context context, ArrayList<String> arrayList){
        String[] itemsTranslate = arrayList.toArray(new String[0]);
        new AlertDialog.Builder(context).setItems(itemsTranslate, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int posTranslate) {
                switch (posTranslate){
                    case 0:
                        Toast.makeText(context, "Работает", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }).show();


    }

}
