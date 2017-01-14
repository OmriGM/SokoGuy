package policies;

import java.io.Serializable;

public class MySokobanPolicy implements Policy,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public MySokobanPolicy() {
	// TODO Auto-generated constructor stub
}
	@Override
	public boolean wallPolicy() {
		return false;
	}

	@Override
	public boolean boxBoxPushingPolicy() {
		return false;
	}

	@Override
	public boolean unLimitedBoxPushingPolicy() {
		return false;
	}

	@Override
	public boolean boxPullingPolicy() {
		return false;
	}

}
