
public class Dictionary {
	public int size;
	public String[] values;
	
	public Dictionary(int size) {
		this.size = size;
		values = new String[size];
	}
	
	public void addValue(int key, String value) {
		values[key] = value;
	}
	
	public void addToNext(String value) {
		for(int i = 0; i < this.size; i++) {
			if(values[i] == null) {
				addValue(i, value);
			}
			if(values[i].equals(value)) {
				return;
			}
		}
	}
	
	public String getValue(int key) {
		return values[key];
	}
	
	public int getKey(String value) {
		for(int i = 0; i < this.size; i++) {
			if(values[i].equals(value)) {
				return i;
			}
		}
		System.out.println("Could not find value " + value);
		return -1;
	}
	
	public boolean contains(String value) {
		return getKey(value) != -1;
	}
	
	public String linkedListToValues(String l) {
		String str = "";
		String[] strArr = l.split(" ");
		for(String val: strArr) {
			if(val == "") break;
			String s = this.getValue(Integer.parseInt(val));
			str += s + " ";
		}
		
		return str;
	}
	
	public String graphToValues(Graph g) {
		String str = "";
		String[] graphLines = g.toString().split("\n");
		
		for(String gline: graphLines) {
			String[] gline2 = gline.split(":");
			String vertex = gline2[0];
			String edge = gline2[1];
			
			String[] edgesAr = edge.split(" ");
			
			str += (this.getValue(Integer.parseInt(vertex)) + ":");
			for(String e: edgesAr) {
				str += (this.getValue(Integer.parseInt(e)) + " ");
			}
			str += "\n";
		}
		return str;
	}
}
