
package com.android.server;

import android.content.Context;
import android.os.Handler;
import android.os.ILIBZService;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class LIBZService extends ILIBZService.Stub {

	public static final String TAG = "libzsys";

	private long mNativePointer;

	public LIBZService(Context context) {
		super();
		mContext = context;

		Log.i(TAG, "LIBZ Service started");

		mNativePointer = init_native();

	}

	protected void finalize() throws Throwable {
		finalize_native(mNativePointer);
		super.finalize();
	}

	@Override
	public float getArgonPressure() {
		return read_pressure(mNativePointer);
	}

	private static native long init_native();
	private static native void finalize_native(long ptr);
	private static native float read_pressure(long ptr);
}