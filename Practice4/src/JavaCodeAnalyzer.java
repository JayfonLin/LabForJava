import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class JavaCodeAnalyzer {
	private int codeline, commentline, spaceline, totalline;
	private Map<String, Integer> table;
	private String filename;
	private static final String[] keywords = new String[]{
		"abstract","boolean","break","byte","case","catch",
		"char", "class","continue","default","do","double","else",
		"extends","false","final","finally","float","for","if",
		"implements","import","instanceof","int","interface","long",
		"native","new","null","package","private","protected",
		"public","return","short","static","super","switch","synchronized",
		"this","throw","throws","transient","true","try","void",
		"volatile","while","goto","const"};
	private String readFile(String filename){
		if (!filename.endsWith(".java")){
			System.out.println("该文本文件名不是以.java结尾的");
			return null;
		}
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			//e.printStackTrace();
		}
		String s;
		StringBuilder sb = new StringBuilder();
		if (in != null){
			try {
				while((s = in.readLine()) != null){
					sb.append(s+"\n");
				}
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	/**
	 * 构造函数
	 * */
	JavaCodeAnalyzer(String filename){
		this.filename = filename;
		String str = readFile(filename);
		//System.out.println("kewords.length: "+keywords.length);
		table = new HashMap<String, Integer>();
		for (String s:keywords){
			table.put(s, 0);
		}
		parse(str);
		
	}
	/*打印*/
	void print(){
		System.out.println("分析 "+filename+" 源程序的结果:");
		DecimalFormat decimalFormat = new DecimalFormat("00.00");
		System.out.println(String.format("代码行数：%03d, 占%s%%", codeline, 
				decimalFormat.format((float)codeline/(float)totalline*100.0f)));
		System.out.println(String.format("注释行数：%03d, 占%s%%", commentline,
				decimalFormat.format((float)commentline/(float)totalline*100.0f)));
		System.out.println(String.format("空白行数：%03d, 占%s%%", spaceline,
				decimalFormat.format((float)spaceline/(float)totalline*100.0f)));
		System.out.println(String.format("源程序行数：%04d", totalline));
		List<Map.Entry<String, Integer>> maplist = new ArrayList<>(table.entrySet());
		Collections.sort(maplist, new Comparator<Map.Entry<String, Integer>>(){

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2){
				if (o1.getValue() > o2.getValue())
					return -1;
				else if (o1.getValue() < o2.getValue())
					return 1;
				else 
					return 0;
			}
			
		});
		
		System.out.println("出现最多的 5 个关键字是:");
		for (int i = 0; i < maplist.size() && i < 5; ++i){
			System.out.println(String.format("%s: %d次", maplist.get(i).getKey(), maplist.get(i).getValue()));
		}
		Date date = new Date();
		DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
		String reTime = format2.format(date);
		System.out.println("分析时间:" + reTime);
	}
	void parse(String str){
		if (str != null){
			List<String> lines;
			int mode = 0;//0 for code, 1 for /*, 2 for //, 3 for space
		
			lines = Arrays.asList(str.split("\n"));
			for (String s: lines){
				++totalline;
				for (String ss : keywords){
					if (s.contains(ss)){
						table.put(ss, table.get(ss)+1);
					}
				}
				s = s.trim();
				if (mode == 1){
					++commentline;
					if (s.contains("*/")){
						mode = 0;
					}
					continue;
				}
				if (s.startsWith("/*")){
					++commentline;
					mode = 1;
					if (s.endsWith("*/")){
						mode = 0;
					}
				}else if (s.startsWith("//")){
					++commentline;
					mode = 2;
				}else if (s.equals("")){
					++spaceline;
					mode = 3;
				}else{
					++codeline;
					mode = 0;
				}
			}
		}
	}
	public static void main(String args[]) throws IOException{
		System.out.println("输入要分析的文件名：");
		String filename = new BufferedReader(new InputStreamReader(System.in)).readLine();
		JavaCodeAnalyzer analyzer = new JavaCodeAnalyzer(filename);
		analyzer.print();
	}
}
