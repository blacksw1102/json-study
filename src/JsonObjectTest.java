import org.json.JSONObject;

public class JsonObjectTest {
	public static void main(String[] args) {
		JSONObject jo = new JSONObject("{\"�̸�\":\"ȫ�浿\", \"����\":\"23\",}");
		System.out.println(jo.toString());
		
		JSONObject obj = new JSONObject();
		obj.put("�̸�", "��ġ");
		obj.put("������", "����");
		obj.put("����", 23);
		
		// JSONObject ���
		String data = obj.toString();
		System.out.println(data);
		
		// Ű�� �ش��ϴ� ���� ���
		System.out.println(obj.get("������"));
		
	}
}
