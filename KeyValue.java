public class KeyValue {
	private String key, value;
	
	public KeyValue(String input) {
		int equal_index = input.indexOf('=');
		this.key = input.substring(0, equal_index);
		this.value = input.substring(equal_index+1, input.length());
	}
	
	public KeyValue(String key, String value) {
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return this.key;
	}
	
	public String getValue() {
		return this.value;
	}
}
