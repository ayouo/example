package com.blogspot.dikuro.example.quiz.miro;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
public class Miro {
 public static void main(String[] args) throws InterruptedException, IOException {
  Scanner sc = new Scanner(System.in);
  int h = 0;
  int w = 0;
  while(true){
   System.out.println("***미로게임***");
   System.out.print("행,열 값 입력(25,25부터 추천):");
   h = sc.nextInt();
   w = sc.nextInt();
   if(h <= 2 || w <= 2 ){
    System.out.println("값이 너무 작습니다.다시 입력 해주십시오.");
    continue;
   }else{
    break;
   }
  }
  System.out.printf("%d행 %d열의 미로를 만들겠습니다.\n", h, w);
  //그려지는 시간값
  int timer = 10;
  //현재 포인트 위치값
  int x=0,y=0;
  //플레이어 배열 생성 및 위치값
  //int [][] player = new int[h][w]; 
  int px = 0;
  int py = 0;

  //미로 ■ 배열에 채우기
  int [][] miro = new int[h][w];    //미로정보
  int [][] answer_miro = new int[h][w];  //미로 초기값을 저장하고 있는 임시 배열
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    miro[i][j] = '■';
   }
  }
  //미로 '□' 만들기 start~end
  Random rnd = new Random();
  int rnd1 = 0; //0(아래쪽),1(오른쪽) //확률이 더 높게
  int rnd2 = 0; //0(위쪽),2(왼쪽)     //확률을 낮게
  miro[0][0] = '□';//첫행은 무조건 '□'
  while(miro[h-1][w-1] != '□'){ //x != w && y != h
   Thread.sleep(timer);
   rnd1 = (int)rnd.nextInt(2);
   rnd2 = (int)rnd.nextInt(10);
   //범위 안에서만 그리도록!
   if( (x < w && x >= 0) || (y < h && y >= 0) )
   {
    System.out.println(x+","+y); //현재 이동 좌표 확인
    if(rnd1 == 0){ //아래쪽
     y++;
    }else if(rnd1 == 1){ //오른쪽
     x++;
    }else if(rnd2 == 0){ //위쪽
     y--;
    }else if(rnd2 == 1){ //왼쪽
     x--;
    }
    //초과했을 때는 감소 시킨후 다시 그려질수 있도록
    if(x > w-1){ x--; continue; }
    else if(x < 0) { x = 0; }
    if(y > h-1){ y--; continue; }
    else if(y < 0) { y = 0; }
    miro[y][x] = '□';
   }
   show(miro);
  }
  //임시미로에 정답 미로 저장
  answerInput(answer_miro, miro);
  answerShow(answer_miro);
  
  
  
  System.out.println("엔터 갈래길 만들기");
  System.in.read();
  System.in.skip(2);
  //길 복잡하게 만들기
  rnd1 = 0; //0(아래쪽),1(오른쪽) //확률이 더 높게
  rnd2 = 0; //0(위쪽),2(왼쪽)     //확률을 낮게
  miro[0][0] = '□';//첫행은 무조건 '□'
  x=0;
  y=0;
  int count = 0;  
  while(h >count){ //h길이 만큼 반복
   //Thread.sleep(timer);
   rnd1 = (int)rnd.nextInt(10);
   rnd2 = (int)rnd.nextInt(2);
   x = (int)rnd.nextInt(miro[0].length-1);
   y = (int)rnd.nextInt(miro.length-1);
   //초과했을 때는 감소 시킨후 다시 그려질수 있도록
   if(x > w-2){ x = w-2;  }
   else if(x < 2) { x = 2; }
   if(y > h-2){ y = h-2;  }
   else if(y < 2) { y = 2; }
   int makeCount = 0;
   while(w > makeCount){ //w만큼만 길이만큼 반복
    //범위 안에서만 그리도록! 또한!! ★좌우 한칸식 안으로만 생성되도록!
    if( (x < w-2 && x >= 2) || (y < h-2 && y >= 2) )
    {
     System.out.println(x+","+y); //현재 이동 좌표 확인
     if(rnd1 == 0){ //아래쪽
      //현재 위치가 □이고 그 전 위치가 □이면 y축 증가
      if( miro[y][x] == '□'  && miro[y-1][x] != '□'){
       y++;
      }
     }else if(rnd1 == 1){ //오른쪽
      if( miro[y][x] == '□' && miro[y][x-1] != '□'){
       x++;
      }
     }
     if(rnd2 == 0){ //위쪽
      if( miro[y][x] == '□' && miro[y-1][x] != '□'){
       y--;
      }
     }else if(rnd2 == 1){ //왼쪽
      if( miro[y][x] == '□' && miro[y][x-1] != '□'){
       x--; 
      }
     }
    }
    //초과했을 때는 감소 시킨후 다시 그려질수 있도록
    if(x > w-2){ x = w-2;  }  //-2를 한 이유는 한칸 전까지만 그려질수 있도록
    else if(x < 2) { x = 2; }
    if(y > h-2){ y = h-2;  }
    else if(y < 2) { y = 2; }
    miro[y][x] = '□';
    show(miro);
    makeCount++;
   }
   count++;
  }
  //미로 출력
  show(miro);

  //플레이어 동적 움직임
  playerShow(miro,px,py);
  while( !(px == w-1 && py == h-1) ){
   
   System.out.println("[[[ 좌(1),우(2),위(3),아래(4), 정답출력(0) ]]]");
   System.out.print("입력 : ");
   int move = sc.nextInt();
   if(move == 1){ //좌측
    if(0 >= px){ px=0; continue;}
    else if( miro[py][px-1] == '■')
     continue;
    else
     px -= 1;
   }
   else if(move ==2){ //우측
    if(w-1 <= px){ px=w-1; continue;}
    else if( miro[py][px+1] == '■')
     continue;
    else
     px += 1;
   }
   else if(move ==3){ //위쪽
    if(0 >= py){ py=0; continue;}
    else if( miro[py-1][px] == '■')
     continue;
    else
     py -= 1;
   }
   else if(move ==4){
    if(h-1 <= py){ py=h-1; continue;}
    else if( miro[py+1][px] == '■')
     continue;
    else
     py += 1;
   }
   else if(move ==0){
    System.out.println(">정답 출력<");
    show(miro);
    answerShow(answer_miro);
    break;
   }
   else{
    System.out.println("잘못 입력하셨습니다.다시입력하겠습니다.");
    continue;
   }
   playerShow(miro,px,py);
  }
  System.out.println("---게임 완료---");
 }
 
 //해답 ◎넣기
 public static void answerInput(int [][] answer_miro, int [][] miro){
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    answer_miro[i][j] = miro[i][j];
    
    if(answer_miro[i][j] == '□'){
     answer_miro[i][j] = '◎';
    }
   }
  }
 }
 //해답 출력
 public static void answerShow(int [][] answer_miro){
  for(int i=0; i<answer_miro.length; i++){
   for(int j=0; j<answer_miro[i].length; j++){
    System.out.printf("%c",(char)answer_miro[i][j]);
   }
   System.out.println();
  }
  System.out.println();
 }
 
 public static void show(int [][] miro){
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    System.out.printf("%c",(char)miro[i][j]);
   }
   System.out.println();
  }
  System.out.println();
 }
 public static void playerShow(int [][] miro,int px, int py){
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    int temp = '□';
    miro[py][px] ='▣';
    System.out.printf("%c",(char)miro[i][j]);
    miro[py][px] = temp;
   }
   System.out.println();
  }
  System.out.println();
 }
} 
