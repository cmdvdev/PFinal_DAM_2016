package es.crimarde.core;

public enum Status {

	SUCCESS(200,"success");
	
	private int code;
	private String desc;
	
	private Status(int code, String desc){
		this.code = code;
		this.desc = desc;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}
	
}
