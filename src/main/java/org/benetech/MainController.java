package org.benetech;

import java.util.HashMap;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;

@RestController
public class MainController {
	
	@RequestMapping(value = "/iconify/{token}", method = RequestMethod.GET)
    public @ResponseBody String sayHello(@PathVariable String token) {
		String iconUrlAsString = new TokenToUrlMap().get(token);
		JSONObject responseJson = new JSONObject();
		JSONObject value = new JSONObject();
		value.put(token, iconUrlAsString);
		responseJson.put("tokenToIconResponse", value.toJSONString());
		
		return responseJson.toJSONString();
    }
	
	protected class TokenToUrlMap extends HashMap<String, String> {
		
		private static final long serialVersionUID = 1L;

		protected TokenToUrlMap() {
			put("1", "https://design.google.com/icons/#ic_accessibility");
			put("2", "https://design.google.com/icons/#ic_lightbulb_outline");
			put("3", "https://design.google.com/icons/#ic_home");
			put("4", "https://design.google.com/icons/#ic_motorcycle");
			put("5", "https://design.google.com/icons/#ic_pregnant_woman");
		}
		
		@Override
		public String get(Object key) {
			if (containsKey(key))
				return super.get(key);
			
			return "Error, could not find Icon for token, try token 1";
		}
	}
}
