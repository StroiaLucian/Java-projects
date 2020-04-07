
package Start;

public class MonitoredData {

	private String start_time;
	private String end_time;
	private String action;
	
	public MonitoredData(String start_time, String end_time, String action) {
		super();
		this.start_time = start_time;
		this.end_time = end_time;
		this.action = action;
	}

	public MonitoredData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStart_time() {
		return start_time;
	}

	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	@Override
	public String toString() {
		return "MonitoredData [start_time=" + start_time + ", end_time=" + end_time + ", action=" + action + "]";
	}
	
	
	
}
