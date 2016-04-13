package org.benetech;

import java.util.HashMap;

import org.json.JSONArray;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class MainController {
	
	@RequestMapping(value = {"", "/", "/iconify/{token}"}, method = RequestMethod.GET)
    public @ResponseBody String sayHello(@PathVariable String token) {
		if (token == null || token.isEmpty())
			return "";

		String iconUrlAsString = new TokenToUrlMap().get(token);
		JSONArray values = new JSONArray();
		values.put(iconUrlAsString);

		return values.toString();
	}
	
	protected class TokenToUrlMap extends HashMap<String, String> {
		
		private static final long serialVersionUID = 1L;

		protected TokenToUrlMap() {
			put("1", "https://wiki.benetech.org/download/attachments/62652525/worddav28703aaa7c28bbdfcdafe360f7a4c0f7.png?version=1&modificationDate=1460523644099");
			put("2", "https://wiki.benetech.org/download/attachments/62652525/worddavbea7952bab678c8d5074431fd33bc15e.png?version=1&modificationDate=1460523643611");
			put("3", "https://wiki.benetech.org/download/attachments/62652525/worddava2c10762693dc35a19a27ef58dc9922b.png?version=1&modificationDate=1460523643990");
			put("4", "https://wiki.benetech.org/download/attachments/62652525/worddavf573413bfb90e14c50f1ae70f9442245.png?version=1&modificationDate=1460523644009");
			put("5", "https://wiki.benetech.org/download/attachments/62652525/worddav5be59b0e6c608d7c56d594eb9ac25992.png?version=1&modificationDate=1460523644063");
		}
		
		@Override
		public String get(Object key) {
			if (containsKey(key))
				return super.get(key);
			
			return "Error, could not find Icon for token, try token: " + key;
		}
	}
}
