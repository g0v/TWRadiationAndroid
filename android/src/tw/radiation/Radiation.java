// vim: et sw=4 sts=4 tabstop=4
package tw.radiation;

import android.provider.BaseColumns;

public final class Radiation {
    public final static String TAG = "Radiation";
    public final static String AUTHORITY = "tw.radiation.data.provider";
    public final static String[] QUERY_COLUMNS = {
        BaseColumns._ID
    };
}
