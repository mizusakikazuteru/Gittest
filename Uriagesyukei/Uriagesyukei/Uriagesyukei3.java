package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Uriagesyukei3 {
	private static final String[] String = null;

	public static void main(String[] args) {
		File filepath = new File(args[0]);
		File[] filelist = filepath.listFiles();

		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(
					args[0], "branch.lst")));// ファイル読み込み

			String line;

			if (filepath.exists()) {
				if (filepath.isFile()) {
					System.out.println("支店定義ファイルが存在しません");
					// return;
				}
			}
			HashMap<Integer, String> map = new HashMap<Integer, String>();// キーと値を保持
			while ((line = br.readLine()) != null) {

				String[] code = line.split(","); //splitメソッドでlineのカンマで分割
				 
				Matcher m1 = p.matcher(line);
				String regex = "e.*o";
				Pattern p = Pattern.compile(regex);
				Matcher m = p.matcher(line);

				if (m.find()){
				  System.out.println("マッチしました");
				System.out.println(code[0]);//支店コード
				System.out.println(code[1]);//支店名
				// map.put(, String[0]);
				// System.out.println(line);
				// System.out.println(String.format("%1$3d", 123)); //

			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);

		}

	}
}
