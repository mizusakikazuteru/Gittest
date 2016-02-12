package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Uriagesyukei4 {

	File directory = new File(
			"C:\\Users\\Owner\\Desktop\\java\\pleiades\\workspace\\Uriagesyukei\\file\\branch.lst");

	public static void main(String[] args) {
		try {
			File file = new File(
					"C:\\Users\\Owner\\Desktop\\java\\pleiades\\workspace\\Uriagesyukei\\file\\branch.lst"); // 読み込みファイル記述

			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String s;
			if ((s = br.readLine()) != null) {
				System.out.println(s);
			} else {
				System.out.println("�x�X��`�t�@�C�������݂��܂���");
				return;
			}
			br.close();

		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
