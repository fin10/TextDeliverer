package com.fin10.android.textdeliverer;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

public class BrowserDeliverer extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String text = intent.getStringExtra(Intent.EXTRA_TEXT);
        Log.d("text:%s", text);
        if (!TextUtils.isEmpty(text)) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(text.startsWith("http://") ? text : "http://" + text));

            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e) {
                e.printStackTrace();
            }
        }

        finish();
    }
}
