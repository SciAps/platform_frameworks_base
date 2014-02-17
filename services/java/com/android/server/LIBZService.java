
package com.android.server;

import android.content.Context;
import android.os.Handler;
import android.os.ILIBZService;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;

public class LIBZService extends ILIBZService.Stub {

	public static final String TAG = "LIBZService";

	private Context mContext;
	private long mNativePointer;

	public LIBZService(Context context) {
		super();
		mContext = context;

		mNativePointer = init_native();

		Log.i(TAG, "LIBZ Service started");
	}

	protected void finalize() throws Throwable {
		finalize_native(mNativePointer);
		super.finalize();
	}

	private void invoke(Parcel request, Parcel reply) {
		int retcode = native_invoke(request, reply);
		reply.setDataPosition(0);
		if(retcode != 0){
			throw new RuntimeException("failure code: " + retcode);
		}
	}

	@Override
	public float getArgonPressure() {
		return read_pressure(mNativePointer);
	}

	@Override
	int readFPGARegister(int index) {
		return 0;
	}

	@Override
	void writeFPGARegister(int index, int value) {

	}

	@Override
	void registerFPGACallback(in IFPGACallback cb) {

	}

	@Override
	void unregisterFPGACallback(in IFPGACallback cb) {

	}

	@Override
	void go() {

	}

	@Override
	void halt() {

	}

	private static native long init_native();
	private static native void finalize_native(long ptr);
	private static native float read_pressure(long ptr);
}