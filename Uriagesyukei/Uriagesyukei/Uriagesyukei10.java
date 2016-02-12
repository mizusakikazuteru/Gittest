package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Uriagesyukei10 {
	public static void main(String[] args) {
		File filepath = new File(args[0]);
		File[] filelist = filepath.listFiles();

		HashMap<String, String> branchlist = new HashMap<String, String>();
		HashMap<String, Long> branchlist2 = new HashMap<String, Long>();

		String branchFormatcheck ="^\\d{3}";
		//支店定義ファイル読込みメソッド呼び出し
			String result = readFile(args[0],"branch.lst",branchlist,salesBranch,branchFormatcheck);

			if (filepath.exists()) {
				if (filepath.isFile()) {
					System.out.println("支店定義ファイルが存在しません");
					// return;
				}
			}
			while ((line = br.readLine()) != null) { // read
				// System.out.println(s);
				// String[] words = line.split("\\s"); //
				// System.out.println(String.format("%1$3d", 123)); //
				System.out.println(line);
			}
			Pattern p = Pattern.compile(regex);

			Matcher m = p.matcher(str);
			if(m.find(^\d{3}){
			 System.out.println("支店定義ファイルのフォーマットが不正です");
			 }

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
			return;
		}

	}
}
