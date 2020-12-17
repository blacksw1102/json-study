import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
	public static void main(String[] args) {

		// ���� ���� (Article -> JSONObject -> JSONArray)
		List<Article> articleList = new LinkedList<>();
		articleList.add(new Article(3, "����", "����", "2020-12-12 12:12:12"));
		articleList.add(new Article(4, "����2", "�ι��� ����", "2020-12-13 10:08:43"));
		
		JSONArray jsonArr = new JSONArray();
		for(Article article : articleList) {
			JSONObject obj = new JSONObject();
			obj.put("id", article.getId());
			obj.put("title", article.getTitle());
			obj.put("body", article.getBody());
			obj.put("regDate", article.getRegDate());
			jsonArr.put(obj);
		}
		
		String strBuffer = jsonArr.toString();
		String fileName = "�Խñ� ���.txt";

		try {
			OutputStream output = new FileOutputStream(fileName);
			byte[] by = strBuffer.toString().getBytes();
			output.write(by);
			output.close();
		} catch (Exception e) {
			e.getStackTrace();
		}

		// ���� �б� (JSONArray -> JSONObject -> Article)
		try {
			InputStream input = new FileInputStream(fileName);
			byte[] readBuffer = new byte[input.available()];
			String rs = null;
			while(input.read(readBuffer) != -1) {
				rs = new String(readBuffer);
				System.out.println(rs);
			}
			
			jsonArr = new JSONArray(rs);
			for(int i=0; i<jsonArr.length(); i++) {
				JSONObject obj = jsonArr.getJSONObject(i);
				Article readArticle = new Article(obj.getInt("id"), obj.getString("title"), obj.getString("body"), obj.getString("regDate"));
				System.out.println(readArticle);
			}
			input.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

class Article {
	private int id;
	private String title;
	private String body;
	private String regDate;

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", body=" + body + ", regDate=" + regDate + "]";
	}

	public Article() {
		// TODO Auto-generated constructor stub
	}

	public Article(int id, String title, String body, String regDate) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.regDate = regDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

}
