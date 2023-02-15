package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class ApiMain {

	public static void main(String[] args) {
		
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		String serviceKey = "DYL8tbccBRtrNFiAqGKYBrQhg6wGylfT9Wrego1m0wpWCnxqXO+RaK70l46I87yLFAfGh2rhJAurUn5eR8VATA==";
		URL url = null;
		BufferedReader reader = null;
		BufferedWriter bw = null;
		HttpURLConnection con = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&searchYear=2021");
			sbURL.append("&sido=1100");
			sbURL.append("&guGun=1125");
			sbURL.append("&Type=json");
			sbURL.append("&numOfRows=10");
			sbURL.append("&pageNo=1");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			int response = con.getResponseCode();
			
			if(response == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line = null;
            while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			StringBuilder fileBuilder = new StringBuilder();
			List<Accident> accidents = new ArrayList<Accident>();
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray itemList = obj.getJSONObject("items").getJSONArray("item");
			for(int i = 0; i < itemList.length(); i++) {
				JSONObject item = itemList.getJSONObject(i);
				
				String occrrncDt = item.getString("occrrnc_dt");
				String[] week = {"", "일", "월", "화", "수", "목", "금", "토"};
				String occrrncDayCd = item.getString("occrrnc_day_cd");
				int dthDnvCnt = item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				
				fileBuilder.append("발생일자 ").append(occrrncDt).append(" ").append(week[Integer.parseInt(item.getString("occrrnc_day_cd"))]).append("요일, ");
				fileBuilder.append("사망자수 ").append(dthDnvCnt).append("명, ");
				fileBuilder.append("부상자수 ").append(injpsnCnt).append("명\n");
				
				Accident accident = new Accident();
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				accidents.add(accident);
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
			