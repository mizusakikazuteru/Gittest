package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Uriagesyukei {
	// ******支店定義ファイル*********//
	public static void main(String[] args) {
		// コマンドライン引数でパスを受ける
		File filepath = new File(args[0]);
		// 指定したディレクトリ・ファイル一覧をFile型の配列で返す。
		File[] filelist = filepath.listFiles();
		// ファイルの存在確認
		File branch = new File(args[0], "branch.lst");
		if (!branch.isFile()) {
			System.out.println("支店定義ファイルが存在しません");
		}
		// 支店コードを配列に入れる
		ArrayList<Integer> branchcode = new ArrayList<Integer>();
		// 支店名を配列に入れる
		ArrayList<String> branchname = new ArrayList<String>();
		// キーと値を保持
		HashMap<Integer, String> branchlst = new HashMap<Integer, String>();
		try {
			// ファイル読み込み
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0], "branch.lst")));
			String line;

			// 一行ずつファイルを読み込む。
			while ((line = br.readLine()) != null) {

				String[] code = line.split(","); // splitメソッドでlineをカンマで分割

				if (!args[0].matches("^\\d{3}")) {
					System.out.print(code[0]);// 支店コード3桁ならtrue
				} else {
					System.out.println("支店ファイルのフォーマットが不正です");
				}

				System.out.println(code[1]);// 支店名出力

			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// *******商品定義ファイル**********//
		// コマンドライン引数でパスを受ける
		// File filepath = new File(args[0]);
		// 指定したディレクトリ・ファイル一覧をFile型の配列で返す。
		// File[] filelist = filepath.listFiles();

		File commodity = new File(args[0], "commodity.lst");
		if (!commodity.isFile()) {
			System.out.println("商品定義ファイルが存在しません");
		}
		// 商品コードを入れる配列を作った。
		ArrayList<String> commoditycode = new ArrayList<String>();
		// 商品名を配列に入れる配列を作った。
		ArrayList<String> commodityname = new ArrayList<String>();

		// キーと値を保持
		HashMap<Integer, String> commoditylst = new HashMap<Integer, String>();
		try {
			// ファイル読み込み
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0], "commodity.lst")));
			String line;

			// 一行ずつファイルを読み込む。
			while ((line = br.readLine()) != null) {

				String[] code = line.split(","); // splitメソッドでlineをカンマで分割
				// 商品コード,商品名を検索

				if (!args[0].matches("[a-zA-Z0-9]{8}")) {
					commoditycode.add(code[0]);
					commodityname.add(code[1]);
					System.out.print(code[0]);// 商品コードアルファベットと数字。8桁固定ならtrue
				} else {

					System.out.println("商品ファイルのフォーマットが不正です");
				}

				System.out.println(code[1]);// 商品名出力

			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// ***********集計（売上ファイル関連）**********

		// 売上支店コードを配列に入れる(作る）
		ArrayList<String> EarningsFileNameList = new ArrayList<String>();
		// 売上商品コードを配列に入れる(作る）
		ArrayList<Integer> EarningsFileProductcodeList = new ArrayList<Integer>();
		// キーと値を保持
		HashMap<String, String> Earningslst = new HashMap<String, String>();
		// 抽出したファイル⇒ファイル名と拡張子をわけ、ファイル名と拡張子をそれぞれ保持
		for (int i = 0; Earningslst.size() > i; i++) {
			// 後列から部分文字列を検索する
			String listFileName = Earningslst.get(".rcd");
			int index = listFileName.lastIndexOf(".");
			String fileName = listFileName.substring(0, index);
			String extension = listFileName.substring(index + 1);

			// 拡張子が[rcd]且つ(AND演算)ファイル名が8桁の数字かどうか
			if (args[0].matches("\\d{8}") && "rcd".equals(extension) && listFileName.length() == 12) {
				// 売上ファイル用リストに入れる（作る）
				EarningsFileNameList.add(listFileName);
				Integer fileNameNumber = Integer.parseInt(listFileName);
				// 連番チェック用リストに入れる（作る）
				EarningsFileProductcodeList.add(fileNameNumber);
			}
		}
		// 売上ファイル用リストの要素数が2つ以上あるか確認
		if (EarningsFileNameList.size() >= 2) {
			// 売上ファイル用リストの要素数分処理を繰り返す
			for (int j = 1; EarningsFileNameList.size() > j; j++) {
				if (EarningsFileProductcodeList.get(j) - EarningsFileProductcodeList.get(j - 1) != 1) {
					System.out.println("売上ファイルが連番になっていません");
					return;
				}
			}

			// 売上ファイル用の要素数分処理を繰り返す
			ArrayList<String> EarningsList = new ArrayList<String>();
			for (int k = 0; EarningsFileNameList.size() > k; k++) {
				// EarningsList = new ArrayList<String>();

				// コマンドライン引数に集計リストのファイル名を文字列連結し、ファイルを開く

				String Aggregate = null;
				BufferedReader br = null;// ここで宣言、変数のスコープ（範囲）
				try {

					br = new BufferedReader(new FileReader(new File(args[0], EarningsFileNameList.get(k))));
					// 売上ファイルを一行ずつ読み込む
					while ((Aggregate = br.readLine()) != null) {
						// 読込んだデータを集計リストに追加する
						EarningsList.add(Aggregate);
						// 集計リストの要素数が3かどうか
						if (EarningsList.size() != 3) {
							System.out.println("<" + EarningsFileNameList.get(k) + ">のフォーマットが不正です");
							return;
						}
						// 支店定義用HashMapキーの有無。
						if (!branchlst.containsKey(EarningsList.get(0))) {
							System.out.println("<" + EarningsFileNameList.get(k) + ">の支店コードが不正です");
							return;
						}
						// 商品定義用HashMapのキーの有無
						if (!commoditylst.containsKey(EarningsList.get(1))) {
							System.out.println("<" + EarningsFileNameList.get(k) + ">の商品コードが不正です");
							return;
						}
					}
				} catch (IOException e) {
					System.out.println("ファイル入出力の際にエラーが発生しました。");
				} finally {
					try {
						br.close();
					} catch (IOException e) {
						System.out.println("ファイル入出力の際にエラーが発生しました。");
					}
				}
			}
		}
	}
}