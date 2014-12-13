package tw.radiation.test;

import tw.radiation.Radiation;

import android.app.SearchManager;
import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.content.res.AssetManager;
import android.database.AbstractCursor;
import android.database.Cursor;
import android.net.Uri;
import android.provider.BaseColumns;
import android.util.Log;
import java.util.ArrayList;

/* if you are going to make a really ContentProvider
 * you have to implement the function to provide data. */

public class MockDataProvider extends ContentProvider {

    public static final Uri CONTENT_URI = Uri.parse(Radiation.AUTHORITY + "/incidents");

    @Override
    public boolean onCreate() {
        Log.d(Radiation.TAG, "mock data provider on create");
        AssetManager am = this.getContext().getAssets();
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {

        return new MyCursor();
    }

    @Override
    public int update(Uri url, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri url, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public String getType(Uri uri) {
        return "Unknown";
    }

    class MyCursor extends AbstractCursor {

        MyCursor () {
        }

        @Override
        public int getCount() {
            return 9527;
        }

        @Override
        public String[] getColumnNames() {
            String[] ar = new String[0];
            return ar;
        }

        @Override
        public String getString(int column) {
            return "unknown";
        }

        @Override
        public short getShort(int column) {
            return -1;
        }

        @Override
        public int getInt(int column) {
            return -1;
        }

        @Override
        public long getLong(int column) {
            return -1;
        }

        @Override
        public float getFloat(int column) {
            return -1;
        }

        @Override
        public double getDouble(int column) {
            return -1;
        }

        @Override
        public boolean isNull(int column) {
            return false;
        }
    }
}
