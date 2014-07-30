package network.common;

public class Frame {
	//TODO Check wether object stream works, if so, use it
	private FrameType type;
	
	/**
	 * Length of the payload in Byte 
	 */
	private int length;
	
	/**
	 * Bytes of information
	 */
	private byte[] payload;
	
	public enum FrameType{
		FULL_MAP("FUMA"),CHANGESET("CHAS");
		private String typeDesignator;
		private FrameType(String typeDesignator) {
			this.typeDesignator=typeDesignator;
		}
	}
}
