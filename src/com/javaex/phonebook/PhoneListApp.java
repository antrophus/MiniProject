package com.javaex.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneListApp {

	public static void main(String[] args) throws IOException {
		// 스캐너 준비
		Scanner sc = new Scanner(System.in);

		// 리스트 생성
		List<PhoneList> pArray = new ArrayList<PhoneList>();

		// 읽기 스트림
		InputStream in = new FileInputStream("C:\\javaStudy\\workspace\\PhoneDB.txt");
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);

		System.out.println("***********************************");
		System.out.println("*        전화번호 관리 프로그램        *");
		System.out.println("***********************************");

		// 읽어온 자료를 split 이용해서 쪼개서 pArray 리스트에 담는다.
		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}

			String[] pInfo = str.split(",");
			pArray.add(new PhoneList(pInfo[0], pInfo[1], pInfo[2]));

		}
		while (true) {
			System.out.println();
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("----------------------------------");
			System.out.print(">메뉴번호: ");
			int numLine = sc.nextInt();

			if (numLine == 5) {
				System.out.println("*******************************");
				System.out.println("*           감사합니다           *");
				System.out.println("*******************************");
				break;

			} else if (numLine < 1 || numLine > 5) {
				System.out.println("[다시 입력해 주세요.]");

			} else if (numLine == 1) {
				System.out.println("<1.리스트>");

				for (int i = 0; i < pArray.size(); i++) {
					System.out.println((i + 1) + "." + pArray.get(i).getName() + "\t" + pArray.get(i).getHp() + "\t"
							+ pArray.get(i).getCompany());

				}

			} else if (numLine == 2) {
				// 쓰기 스트림
				OutputStream out = new FileOutputStream("C:\\javaStudy\\workspace\\PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(osw);

				sc.nextLine();
				System.out.println("<2.등록>");
				System.out.print(">이름: ");
				String name = sc.nextLine();
				System.out.print(">휴대전화: ");
				String hp = sc.nextLine();
				System.out.print(">회사전화: ");
				String comp = sc.nextLine();

				pArray.add(new PhoneList(name, hp, comp));
				System.out.println("[등록되었습니다.]");

				// 리스트의 모든 정보를 파일에 다시 쓰기
				for (PhoneList person : pArray) {
					bw.write(person.getName() + "," + person.getHp() + "," + person.getCompany());
					bw.newLine();
				}

				bw.close(); // 파일 쓰기 완료 후 닫기

			} else if (numLine == 3) {
				// 쓰기 스트림
				OutputStream out = new FileOutputStream("C:\\javaStudy\\workspace\\PhoneDB.txt");
				OutputStreamWriter osw = new OutputStreamWriter(out);
				BufferedWriter bw = new BufferedWriter(osw);
				sc.nextLine();

				System.out.println("<3.삭제>");
				System.out.print(">번호 : ");
				int del = sc.nextInt();
				pArray.remove(del - 1);
				System.out.println("[삭제되었습니다.]");

				// 리스트의 모든 정보를 파일에 다시 쓰기
				for (PhoneList person : pArray) {
					bw.write(person.getName() + "," + person.getHp() + "," + person.getCompany());
					bw.newLine();
				}

				bw.close(); // 파일 쓰기 완료 후 닫기

				// 검색 기능(Chat GPT가 만들어줌: 공부합시다!!)
			} else if (numLine == 4) {
				sc.nextLine();
				System.out.println("<4.검색>");
				System.out.print(">이름: ");// 검색할 이름 입력 받기
				String search = sc.nextLine();

//				boolean found = false;
				for (int i = 0; i < pArray.size(); i++) {
					PhoneList person = pArray.get(i);
					if (person.getName().contains(search)) {
						System.out.println(
								(i + 1) + ". " + person.getName() + " " + person.getHp() + " " + person.getCompany());

//						found = true;

					}

				}

//				if (found == false) {
//					System.out.println("해당 이름을 가진 사람이 없습니다.");
//				}

			}

		} // while문 종료
		sc.close();
		br.close();
	}// main 종료

}
