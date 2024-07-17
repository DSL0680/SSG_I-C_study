package org.example;

import org.example.salary.CalcSalary;
import org.example.salary.ContractWorker;
import org.example.salary.Freelancer;
import org.example.salary.PartTimer;
import org.example.vend.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("list.txt");

        Scanner scanner = new Scanner(file);

        int cntA = 0;
        int cntC = 0;
        int cntF = 0;

        Map<Character, Integer> langMap = new HashMap<>();



        while (scanner.hasNextLine()) {

            String line = scanner.nextLine();

            String[] arr = line.split(",");

            String firstChar = arr[0].toLowerCase();


            if(firstChar.equals("a")){ //이 직원 파트타이머
                cntA++;
            }else if(firstChar.equals("c")){
                cntC++;
            }else if(firstChar.equals("f")){
                cntF++;
            }

        }//end while



        langMap.put('a',cntA);
        langMap.put('c',cntC);
        langMap.put('f',cntF);

        System.out.println("a: " + langMap.get('a'));
        System.out.println("c: " + langMap.get('c'));
        System.out.println("f: " + langMap.get('f'));







//        langMap.put("ko", new KoreanMsg());
//        langMap.put("fr", new CongoMsg());
//        langMap.put("it", new ItalianMsg());
//        langMap.put("th", new ThaiMsg());
//        langMap.put("ge", new GermanMsg());
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("언어 선택");
//
//        Msg msg = langMap.get(scanner.nextLine());
//
//        VendingMachine machine = new VendingMachine(msg);
//
//        machine.start();



//        VendingMachine machine = new VendingMachine(new GermanMsg());
//
//        machine.start();


    }
}