
package android.os;

public class FPGADataBuffer implements Parcelable, Closeable {

	protected void finalize() {
		close();
	}

	@Override
	public void close() {

	}

}