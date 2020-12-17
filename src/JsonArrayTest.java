import org.json.JSONArray;
import org.json.JSONObject;

public class JsonArrayTest {

	public static void main(String[] args) {
		String json = "[{\"Product\" : \"Mouse\", \"Maker\":\"Samsung\", \"Price\":23000},"
				+ "{\"Product\" : \"KeyBoard\", \"Maker\":\"LG\", \"Price\":12000},"
				+ "{\"Product\":\"HDD\", \"Maker\":\"Western Digital\", \"Price\":156000}]";
	
	
		String result = "";
		JSONArray ja = new JSONArray(json);
		for(int i=0; i<ja.length(); i++) {
			JSONObject order = ja.getJSONObject(i);
			result += "product:" + order.getString("Product") + ",maker:" + order.getString("Maker") + ",price:" + order.getInt("Price") + "\n";
			
		}
		
		System.out.println(result);
	}

}
