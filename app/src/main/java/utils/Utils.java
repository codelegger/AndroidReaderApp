package utils;

import android.content.Context;

import news.agoda.com.sample.R;

/**
 * Created by uba on 25/08/2017.
 */

public class Utils {
    public static boolean isTablet(Context context){
        return context.getResources().getBoolean(R.bool.isTablet);
    }
}
