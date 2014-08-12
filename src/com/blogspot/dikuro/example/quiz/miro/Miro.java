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
   System.out.println("***�̷ΰ���***");
   System.out.print("��,�� �� �Է�(25,25���� ��õ):");
   h = sc.nextInt();
   w = sc.nextInt();
   if(h <= 2 || w <= 2 ){
    System.out.println("���� �ʹ� �۽��ϴ�.�ٽ� �Է� ���ֽʽÿ�.");
    continue;
   }else{
    break;
   }
  }
  System.out.printf("%d�� %d���� �̷θ� ����ڽ��ϴ�.\n", h, w);
  //�׷����� �ð���
  int timer = 10;
  //���� ����Ʈ ��ġ��
  int x=0,y=0;
  //�÷��̾� �迭 ���� �� ��ġ��
  //int [][] player = new int[h][w]; 
  int px = 0;
  int py = 0;

  //�̷� �� �迭�� ä���
  int [][] miro = new int[h][w];    //�̷�����
  int [][] answer_miro = new int[h][w];  //�̷� �ʱⰪ�� �����ϰ� �ִ� �ӽ� �迭
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    miro[i][j] = '��';
   }
  }
  //�̷� '��' ����� start~end
  Random rnd = new Random();
  int rnd1 = 0; //0(�Ʒ���),1(������) //Ȯ���� �� ����
  int rnd2 = 0; //0(����),2(����)     //Ȯ���� ����
  miro[0][0] = '��';//ù���� ������ '��'
  while(miro[h-1][w-1] != '��'){ //x != w && y != h
   Thread.sleep(timer);
   rnd1 = (int)rnd.nextInt(2);
   rnd2 = (int)rnd.nextInt(10);
   //���� �ȿ����� �׸�����!
   if( (x < w && x >= 0) || (y < h && y >= 0) )
   {
    System.out.println(x+","+y); //���� �̵� ��ǥ Ȯ��
    if(rnd1 == 0){ //�Ʒ���
     y++;
    }else if(rnd1 == 1){ //������
     x++;
    }else if(rnd2 == 0){ //����
     y--;
    }else if(rnd2 == 1){ //����
     x--;
    }
    //�ʰ����� ���� ���� ��Ų�� �ٽ� �׷����� �ֵ���
    if(x > w-1){ x--; continue; }
    else if(x < 0) { x = 0; }
    if(y > h-1){ y--; continue; }
    else if(y < 0) { y = 0; }
    miro[y][x] = '��';
   }
   show(miro);
  }
  //�ӽù̷ο� ���� �̷� ����
  answerInput(answer_miro, miro);
  answerShow(answer_miro);
  
  
  
  System.out.println("���� ������ �����");
  System.in.read();
  System.in.skip(2);
  //�� �����ϰ� �����
  rnd1 = 0; //0(�Ʒ���),1(������) //Ȯ���� �� ����
  rnd2 = 0; //0(����),2(����)     //Ȯ���� ����
  miro[0][0] = '��';//ù���� ������ '��'
  x=0;
  y=0;
  int count = 0;  
  while(h >count){ //h���� ��ŭ �ݺ�
   //Thread.sleep(timer);
   rnd1 = (int)rnd.nextInt(10);
   rnd2 = (int)rnd.nextInt(2);
   x = (int)rnd.nextInt(miro[0].length-1);
   y = (int)rnd.nextInt(miro.length-1);
   //�ʰ����� ���� ���� ��Ų�� �ٽ� �׷����� �ֵ���
   if(x > w-2){ x = w-2;  }
   else if(x < 2) { x = 2; }
   if(y > h-2){ y = h-2;  }
   else if(y < 2) { y = 2; }
   int makeCount = 0;
   while(w > makeCount){ //w��ŭ�� ���̸�ŭ �ݺ�
    //���� �ȿ����� �׸�����! ����!! ���¿� ��ĭ�� �����θ� �����ǵ���!
    if( (x < w-2 && x >= 2) || (y < h-2 && y >= 2) )
    {
     System.out.println(x+","+y); //���� �̵� ��ǥ Ȯ��
     if(rnd1 == 0){ //�Ʒ���
      //���� ��ġ�� ���̰� �� �� ��ġ�� ���̸� y�� ����
      if( miro[y][x] == '��'  && miro[y-1][x] != '��'){
       y++;
      }
     }else if(rnd1 == 1){ //������
      if( miro[y][x] == '��' && miro[y][x-1] != '��'){
       x++;
      }
     }
     if(rnd2 == 0){ //����
      if( miro[y][x] == '��' && miro[y-1][x] != '��'){
       y--;
      }
     }else if(rnd2 == 1){ //����
      if( miro[y][x] == '��' && miro[y][x-1] != '��'){
       x--; 
      }
     }
    }
    //�ʰ����� ���� ���� ��Ų�� �ٽ� �׷����� �ֵ���
    if(x > w-2){ x = w-2;  }  //-2�� �� ������ ��ĭ �������� �׷����� �ֵ���
    else if(x < 2) { x = 2; }
    if(y > h-2){ y = h-2;  }
    else if(y < 2) { y = 2; }
    miro[y][x] = '��';
    show(miro);
    makeCount++;
   }
   count++;
  }
  //�̷� ���
  show(miro);

  //�÷��̾� ���� ������
  playerShow(miro,px,py);
  while( !(px == w-1 && py == h-1) ){
   
   System.out.println("[[[ ��(1),��(2),��(3),�Ʒ�(4), �������(0) ]]]");
   System.out.print("�Է� : ");
   int move = sc.nextInt();
   if(move == 1){ //����
    if(0 >= px){ px=0; continue;}
    else if( miro[py][px-1] == '��')
     continue;
    else
     px -= 1;
   }
   else if(move ==2){ //����
    if(w-1 <= px){ px=w-1; continue;}
    else if( miro[py][px+1] == '��')
     continue;
    else
     px += 1;
   }
   else if(move ==3){ //����
    if(0 >= py){ py=0; continue;}
    else if( miro[py-1][px] == '��')
     continue;
    else
     py -= 1;
   }
   else if(move ==4){
    if(h-1 <= py){ py=h-1; continue;}
    else if( miro[py+1][px] == '��')
     continue;
    else
     py += 1;
   }
   else if(move ==0){
    System.out.println(">���� ���<");
    show(miro);
    answerShow(answer_miro);
    break;
   }
   else{
    System.out.println("�߸� �Է��ϼ̽��ϴ�.�ٽ��Է��ϰڽ��ϴ�.");
    continue;
   }
   playerShow(miro,px,py);
  }
  System.out.println("---���� �Ϸ�---");
 }
 
 //�ش� �ݳֱ�
 public static void answerInput(int [][] answer_miro, int [][] miro){
  for(int i=0; i<miro.length; i++){
   for(int j=0; j<miro[i].length; j++){
    answer_miro[i][j] = miro[i][j];
    
    if(answer_miro[i][j] == '��'){
     answer_miro[i][j] = '��';
    }
   }
  }
 }
 //�ش� ���
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
    int temp = '��';
    miro[py][px] ='��';
    System.out.printf("%c",(char)miro[i][j]);
    miro[py][px] = temp;
   }
   System.out.println();
  }
  System.out.println();
 }
} 
