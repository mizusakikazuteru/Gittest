package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Uriagesyukei11 {

	public static void main(String[] args) {
		//コマンドライン引数でパスを受ける
		File filepath = new File(args[0]);
		
		File[] filelist = filepath.listFiles();
		//search.listFiles("C:/filepath/", "*.lst");


		
		if (filepath.exists() FilePath = "C:branch.lst")FileExist = Dir(FilePath) {
			if (filepath.isFile()) {
				System.out.println("支店定義ファイルが存在しません");


				ArrayList<Integer> branchlist = new ArrayList<Integer>();
				ArrayList<String> branchlist2 = new ArrayList<String>();

				}
				try {
					// ファイル読み込み
					BufferedReader br = new BufferedReader(new FileReader(
							new File(args[0], "branch.lst")));

					String line;
					// キーと値を保持
					HashMap<Integer, String> map = new HashMap<Integer, String>();
					//一行ずつファイルを読み込む。
					while ((line = br.readLine()) != null) {

						String[] code = line.split(","); // splitメソッドでlineをカンマで分割

						if (args[0].matches("^\\d{3}")) {
							System.out.println(code[0]);// 支店コード
						} else {
							System.out.println("支店ファイルのフォーマットが不正です");
						}

						System.out.println(code[1]);// 支店名
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
}
