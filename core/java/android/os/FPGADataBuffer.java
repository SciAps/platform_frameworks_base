
package android.os;

import java.io.Closeable;

public class FPGADataBuffer implements Parcelable, Closeable {

	protected void finalize() {
		close();
	}

	@Override
	public void close() {

	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

	}

	private FPGADataBuffer(Parcel in) {

	}

	public static final Parcelable.Creator<FPGADataBuffer> CREATOR 
			= new Parcelable.Creator<FPGADataBuffer>() {
		public FPGADataBuffer createFromParcel(Parcel in) {
             return new FPGADataBuffer(in);
         }

         public FPGADataBuffer[] newArray(int size) {
             return new FPGADataBuffer[size];
         }
	};

}