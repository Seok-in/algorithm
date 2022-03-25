import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
		ArrayList<String> user_id = new ArrayList<>();
		ArrayList<String> user_method = new ArrayList<>();
		for (int i = 0; i < record.length; i++) {
			String str_split[] = record[i].split(" ");
			
			if (str_split[0].equals("Enter")) {
				map.put(str_split[1], str_split[2]);
				user_id.add(str_split[1]);
				user_method.add("님이 들어왔습니다.");
			}
			
			else if (str_split[0].equals("Leave")) {				
				user_id.add(str_split[1]);
				user_method.add("님이 나갔습니다.");
			}
			
			else if (str_split[0].equals("Change")) {
				map.put(str_split[1], str_split[2]);				
			}
		}
		String result[] = new String[user_id.size()];
		for(int t=0;t<user_id.size();t++) {
			result[t] = map.get(user_id.get(t))+user_method.get(t);			
		}
        return result;
    }
}
