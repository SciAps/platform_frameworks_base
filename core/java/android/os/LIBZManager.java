
package android.os;

import android.content.Context;
import android.os.ILIBZService;

public class LIBZManager {

	private Context mContext;
	private ILIBZService mService;

	public LIBZManager(Context context, ILIBZService service) {
		mContext = context;
		mService = service;
	}
}