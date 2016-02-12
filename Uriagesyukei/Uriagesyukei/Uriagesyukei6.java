package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Uriagesyukei6 {
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

				//String[] line = line.split("String[1]");
				map.put(null, "String[0]");
				System.out.println("String[0]");
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
