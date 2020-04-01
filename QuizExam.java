/**
게임을 시작하면 
일단

1 .게임 머니 +1000
 아래와 같이 진행

	1) 주먹, 2) 가위, 3) 보자기 ,0) 게임종료 
	당신의 선택 :

2. 배팅 금액 제시

3. 결과 보려면 enter를 입력

4. 랜덤값으로 산출
 you : 주먹, com : 바위

 승리시 잔액??

 5. 메뉴로 이동.
*/

import java.io.*;

public class QuizExam{
	public static void main (String []ar)throws IOException{
		
		BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		//게임머니 지급
		int money = 1000;
		int batt = 0;

		int game = 0;
		int com =0;
		String comch = "";
		String you ="";
		
		boolean choose = true;

		while( choose){
			System.out.println( "1: 바위 ");
			System.out.println( "2: 가위 ");
			System.out.println( "3: 보 ");
			System.out.print( "0: 게임을 종료 ");


				System.out.println();
				System.out.println(" ----- 가위 바위 보 중 하나를 선택해주세요 -----");
				game = Integer.parseInt(br.readLine());	

					switch(game){
						case 1 :
							 you = ("바위");
							break;
						case 2 :
							you = ("가위");
							break;
						case 3 :
							you = ("보");
							break;

						case 0 :// 게임 종료 처리
							game = 0;
							System.out.println();
							System.out.print(" 정말 게임을 종료하시겠습니까 ???  [ y /n ]");
								char gmover = (char)(System.in.read());
									System.in.read(); System.in.read();// enter값 처리
								if ( gmover == 'y' || gmover == 'Y' ){
								choose = false;
									}
								System.out.println();
								continue ;	
						default :// 재입력시키기
							System.out.println();
							System.out.println(" 숫자를 다시 입력하세요 . [1] [2] [3] ");
							continue ;
					
				}//end switch 
				System.out.println(" 당신은 " + you + " 을 선택하였습니다." );

				System.out.println();
				System.out.println("배팅 금액을 입력하세요." );
					batt = Integer.parseInt(br.readLine());
						
						if(batt > money){// 배팅 > 기존일시 자동배정
							System.out.println();
							System.out.println(" 배팅 금액이 현재 가진 돈보다 큽니다." + money +
								" 만큼 자동으로 배정됩니다 ");
							batt = money;
						}
				
				System.out.println();
				System.out.println(" enter를 눌러 게임결과를 확인하세요.");
				System.in.read(); System.in.read();//\n 값 내림			

					com = (int)(Math.random()*3 +1);// 1~3값으로 랜덤
					switch (com){
						case 1 :
							comch = (" 바위 ");
							break;
						case 2 :
							comch = (" 가위 ");
							break;
						case 3 :
							comch = (" 보 ");
						}//end com랜덤 switch 

				System.out.println("");
				System.out.println(" 결과 : 당신은 " + you + " 이고, 컴퓨터는 " +
					 comch + " 입니다. ");// 결과


				if((game ==1 && com == 2) || 
						(game == 2 && com ==3) ||
							(game ==3 && com ==1)){
								System.out.println();
								System.out.println(" 당신이 이겼습니다 . +" + batt); 
								money += batt;
							}else if((game ==1 && com == 3) || 
											(game == 2 && com == 1) ||
												(game == 3 && com == 2)){
								System.out.println();
								System.out.println(" 당신이 졌습니다 . -" + batt); 
								money -= batt;
								
							}else{
								System.out.println();
								System.out.println(" 둘이 비겼습니다. . " ); 
							}// 겜 결과 배팅.

				System.out.println();
				System.out.println("현재 남은 잔액은 :" + money + " 입니다.");



		}//end while 
		System.out.println();
		System.out.println("프로그램을 종료합니다."); 

	}//end main
}