package cordova.plugin.googleplayservices.check;

import org.apache.cordova.*;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.common;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.ErrorDialogFragment;

public class GooglePlayServicesCheck extends CordovaPlugin {

    // Debugging tag for the application
    private static final String APPTAG = "GooglePlayServicesCheck";

    @Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {
        JSONObject jo = new JSONObject();
        final CordovaInterface mCordova = this.cordova;
        if (action.equals("check")) {
            // Check that Google Play services is available
            final int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(mCordova.getActivity());
            callbackContext.success(jo.put("isGooglePlayServicesAvailable", resultCode == ConnectionResult.SUCCESS));

            // If Google Play services is available
            if (ConnectionResult.SUCCESS == resultCode) {
                // In debug mode, log the status
                Log.d(GooglePlayServicesCheck.APPTAG, "Google Play Services is available");
                // Continue
                return true;
            }
        }
        return false;
    }
}
