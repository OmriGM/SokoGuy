package model.policy;

public interface Policy  {
	public boolean wallPolicy();
	public boolean boxBoxPushingPolicy();
	public boolean unLimitedBoxPushingPolicy();
	public boolean boxPullingPolicy();
}
