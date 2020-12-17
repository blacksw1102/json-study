import org.json.JSONObject;

public class JsonObjectTest {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject("{\"이름\":\"홍길동\", \"나이\":\"23\",}");
		System.out.println(jo.toString());
		
		JSONObject obj = new JSONObject();
		obj.put("이름", "덩치");
		obj.put("거주지", "서울");
		obj.put("나이", 23);
		
		// JSONObject 출력
		String data = obj.toString();
		System.out.println(data);
		
		// 키에 해당하는 값만 출력
		System.out.println(obj.get("거주지"));
		
	}
}
