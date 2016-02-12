package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Uriagesyukei5 {
	public static void main(String[] args) {
		File filepath = new File(args[0]);
		File[] filelist = filepath.listFiles();

		try {

			BufferedReader br = new BufferedReader(new FileReader(new File(
					args[0], "branch.lst")));
			HashMap<Integer, String> map = new HashMap<Integer, String>();
			String line;

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
