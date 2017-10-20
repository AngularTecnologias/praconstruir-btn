package com.angularlabs.praconstruirbtn.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

import com.angularlabs.praconstruirbtn.R;

import java.util.List;

import utils.Formatter;

/**
 * Created by raphael on 19/10/17.
 */

public class PraConstruirButton extends android.support.v7.widget.AppCompatButton {

    public PraConstruirButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setText(getResources().getString(R.string.praconstruir_action_save));
        this.setAllCaps(true);
    }

    /**
     * Creates a product list at Pra Construir website
     * @param list Array list of arrays
     * @param context The activity calling the method
     */
    public void addProductListAndSetListener(final List<long[]> list, final Context context) {
        this.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Formatter.listToUri(list, context));
                context.startActivity(intent);
            }
        });
    }
}
