
package android.os;

import android.util.Log;
import android.content.Context;
import android.os.ILIBZService;

public class LIBZManager {

	private static final String LOG_TAG = "LIBZManager";

	private Context mContext;
	private ILIBZService mService;

	public LIBZManager(Context context, ILIBZService service) {
		mContext = context;
		mService = service;
	}

	public float getArgonPressure() {
		try {
			return mService.getArgonPressure();
		} catch (RemoteException e) {
			Log.e(LOG_TAG, "", e);
			return -50;
		}
	}
}