package tw.radiation;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import android.content.ContentResolver;
import android.content.res.AssetManager;
import android.net.Uri;
import android.test.ActivityInstrumentationTestCase2;
import android.test.AndroidTestCase;
import android.database.Cursor;

public class TestContentProvider extends AndroidTestCase {

    protected ContentResolver mCR;

    public TestContentProvider () {
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mCR = getContext().getContentResolver();
    }


    public void testCount() {
        Uri uri = Uri.parse(Radiation.AUTHORITY + "/incidents");
        Cursor c = mCR.query(uri, null , null , null , null);
        assertEquals(c.getCount(), 9527);
    }
}
