package com.angularlabs.praconstruir;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.angularlabs.praconstruirbtn.ui.PraConstruirButton;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    // Lista de itens
    List<long[]> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String partnerToken = "MEU-TOKEN";

        PraConstruirButton praConstruirButton = (PraConstruirButton) findViewById(R.id.praconstruir_save_button);
        /* Para criar um novo item:
         long[] item = new long[]{productId, unitId, amount};
          */
        list = new ArrayList<>();
        list.add(new long[]{111007, 9531, 30});
        list.add(new long[]{111006, 9531, 20});

        praConstruirButton.addProductListAndSetListener(list, partnerToken, this);
    }
}
