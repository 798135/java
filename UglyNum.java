/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author chandupavan
 */
public class UglyNum {
  
  public static int getMaxVal(int k, int l)
  {
    while (k % l == 0)
      k = k/l;
	  
    return k;
  }
  public static int isUgly(int no)
  {
    no = getMaxVal(no, 2);
    no = getMaxVal(no, 3);
    no = getMaxVal(no, 5);
	
	if (no == 1)
	{
	  return 1;
	}
	else
	{
	  return 0;
	}
  }
  public static int getUglyNum(int n) {
    int i = 1;
	int count = 1;
	
	while (n > count)
	{
	  i++;
	  if (isUgly(i) == 1)
	    count++;
	}
	return i;
  }
  public static void main(String[] args) {
    int d = getUglyNum(100);
	System.out.println("150th ugly number is - " + d);
  }
}