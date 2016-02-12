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
		File hoge = new File(args[0], "branch.lst");
		if (hoge.isFile()) {
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

				if (args[0].matches("^\\d{3}")) {
					System.out.println(code[0]);// 支店コード3桁ならtrue
				} else {
					System.out.println("支店ファイルのフォーマットが不正です");
				}

				System.out.println(code[1]);// 支店名

			}

			br.close();
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}
		// *******商品定義ファイル**********//
		// コマンドライン引数でパスを受ける
		File filepath2 = new File(args[0]);
		// 指定したディレクトリ・ファイル一覧をFile型の配列で返す。
		File[] filelist2 = filepath.listFiles();
		File hoge2 = new File(args[0], "commodity.lst");
		if (hoge.isFile()) {
			System.out.println("商品定義ファイルが存在しません");
		}
		// 商品コードを配列に入れる
		ArrayList<Integer> commoditycode = new ArrayList<Integer>();
		// 商品名を配列に入れる
		ArrayList<String> commodityname = new ArrayList<String>();
		// キーと値を保持
		HashMap<Integer, String> commditylst = new HashMap<Integer, String>();
		try {
			// ファイル読み込み
			BufferedReader br = new BufferedReader(new FileReader(new File(args[0], "commdity.lst")));
			String line;

			// 一行ずつファイルを読み込む。
			while ((line = br.readLine()) != null) {

				String[] code = line.split(","); // splitメソッドでlineをカンマで分割

				if (args[0].matches("[a-zA-Z0-9]{8}")) {
					System.out.println(code[0]);// 商品コードアルファベットと数字。8桁固定ならtrue
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
		// ***********売上ファイル**********
		File fileArgs = new File(args[0]);
		// 指定ディレクトリにあるフォルダ、ファイル名をリスト化する
		File[] filelist3 = filepath.listFiles();
		// 売上支店コードを配列に入れる
		ArrayList<String> EarningsFileNameList = new ArrayList<String>();
		// 売上商品コードを配列に入れる
		ArrayList<Integer> EarningsFileProductcodeList = new ArrayList<Integer>();

		HashMap<String, String> Earningslst = new HashMap<String, String>();
		// 抽出したファイル名のファイル名と拡張子をわけ、ファイル名と拡張子をそれぞれ保持する
		for (int i = 0; filelist3.length > i; i++) {
			// フィールド作成でエラー消える
			String listFileName = listFile[i];
			int index = listFileName.lastIndexOf(".");
			String fileName = listFileName.substring(0, index);
			String extension = listFileName.substring(index + 1);

			// 拡張子が[rcd]且つ(AND演算)ファイル名が8桁の数字かどうか
			if (args[0].matches("\\d{8}") && "rcd".equals(extension) && listFileName.length() == 12) {
				// 売上ファイル用コレクションに追加
				EarningsFileNameList.add(listFileName);
				Integer fileNameNumber = Integer.parseInt(listFileName);
				// 連番チェック用コレクション
				EarningsFileProductcodeList.add(fileNameNumber);
			}
		}
	}
}
