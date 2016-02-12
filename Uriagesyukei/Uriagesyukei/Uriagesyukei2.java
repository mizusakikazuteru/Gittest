package Uriagesyukei;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class UriageSyukei2 {
public static void main (String[] args) {

//�?定された�?ィレクトリ
File directory = new File(args[0]);
/*
* 1.支店定義ファイル
* */
File branchFile = new File(directory + "\\branch.lst");
//変数を宣�?
FileInputStream fis = null;
InputStreamReader isr = null;
BufferedReader br = null;
ArrayList<List<String>> branchData = new ArrayList<List<String>>();
//支店定義ファイル処�?
try {
if (!branchFile.exists()) {
System.out.println("支店定義ファイルが存在しません");
return;
}

fis = new FileInputStream(branchFile);
isr = new InputStreamReader(fis);
br = new BufferedReader(isr);
String line ;
while ((line = br.readLine()) != null) {
List<String> branch = line.split(",");
//配�?��?�長�?
if (branch.length != 2 || branch[0] == null || branch[1] == null) {
System.out.println("支店定義ファイルのフォーマットが不正で�?");
return;
}
branchData.add(branch);
}

/*
* 2.�?品定義ファイル
*/
File commodityFile = new File(directory + "\\commodity.lst");
ArrayList<String[]> commodityData = new ArrayList<String[]>();
//�?品定義ファイルの処�?
if (!commodityFile.exists()) {
System.out.println("�?品定義ファイルが存在しません");
return;
}

fis = new FileInputStream(commodityFile);
isr = new InputStreamReader(fis);
br = new BufferedReader(isr);
while ((line = br.readLine()) != null) {
String[] commodity = line.split(",");
//配�?��?�長�?
if (commodity.length != 2 || commodity[0] == null || commodity[1] == null) {
System.out.println("�?品定義ファイルのフォーマットが不正で�?");
return;
}
commodityData.add(commodity);

}
/*
* 3.�?�?
*/
//.rcdに該当する拡張子を検索
ArrayList<String[]> salesData = new ArrayList<String[]>();
String[] salesFiles = directory.list();
for (String salesFile : salesFiles) {
if (!salesFile.endsWith(".rcd")) {
continue;
}
File rcdFile = new File(directory + "\\" + salesFile);
fis = new FileInputStream(rcdFile);
isr = new InputStreamReader(fis);
br = new BufferedReader(isr);

String salesBranch = br.readLine();
String salesCommodity = br.readLine();
String price = br.readLine();
}
