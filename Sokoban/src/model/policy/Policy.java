package model.policy;

import common.Level;

public interface Policy  {
//	public boolean wallPolicy();
//	public boolean boxBoxPushingPolicy();
//	public boolean unLimitedBoxPushingPolicy();
//	public boolean boxPullingPolicy();
	
	public int move(Level lvl,String direction);
}
