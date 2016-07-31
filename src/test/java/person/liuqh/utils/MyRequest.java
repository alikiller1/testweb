package person.liuqh.utils;
/**
 * 
 * @author Administrator
 *
 */
public class MyRequest {
	public class Result {
		public Result() {
			super();
		}

		void get(String s) {
			
		};
	}

	public static void request(String ss, Request request, Result r) {
		String s = request.request(ss);
		if ("abc".equals(s)) {
			return;
		}
		r.get(s);

	}

	public static void main(String[] args) {
		Result r = new MyRequest().new Result(){
			@Override
			void get(String s) {
				System.out.println(s);
			}
		};
		MyRequest.request("123", new Request(), r);
	}
}
