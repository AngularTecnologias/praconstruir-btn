package utils;

import android.content.Context;
import android.net.Uri;

import java.util.List;

/**
 * Created by raphael on 19/10/17.
 */

public class Formatter {

    /**
     * Converts an array to an Uri
     * @param list Array list of arrays
     * @param context The activity calling the method
     * @return Uri with query parameters
     */
    public static Uri listToUri(List<long[]> list, String partnerToken, Context context) {
        Uri.Builder builder = new Uri.Builder();

        String protocol = "https";
        String authority = "praconstruir.com.br";
        String clientPath = "consumidor";
        String dashboardPath = "painel";
        String estimatePath = "orcamento/";

        builder.scheme(protocol)
                .authority(authority)
                .appendPath(clientPath)
                .appendPath(dashboardPath)
                .appendPath(estimatePath);

        if (list != null && !list.isEmpty()) {
            for (long[] array : list) {
                if (array != null && array.length == 3)
                    builder.appendQueryParameter("q", getItems(array));
            }
        }

        builder.appendQueryParameter("p", partnerToken);

        return builder.build();
    }

    /**
     * Gets a formatted string of items "productId,unitId,amount".
     * @param array Array of longs
     * @return A formatted String
     */
    private static String getItems(long[] array) {
        return array[0] + "," + array[1] + "," + array[2];
    }
}

