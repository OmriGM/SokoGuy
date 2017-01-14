package model.policy;

import java.io.Serializable;

public class MySokobanRules implements Policy,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
public MySokobanRules() {
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
