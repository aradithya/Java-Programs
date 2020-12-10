
import java.io.*;
import java.util.*;
public class SharePriceMaximizeProfit{
	
	public static int computeForSingleBuyAndSell(int[] prices) {
		int maxProfit=0, minPrice=Integer.MAX_VALUE;
		for(int i:prices) {
			maxProfit=Math.max(maxProfit,i-minPrice);
			minPrice=Math.min(minPrice, i);
		}
		return maxProfit;
	}
	public static int computeForMultipleBuySells(int[] a) {
		int i=0,profit=0,sold=0,bought=0,max_profit=0,buy_flag=0;
		while(i<(a.length-1)) {
			
			if(buy_flag==0 && a[i]<a[i+1]) {
				buy_flag=1;
				bought=a[i];
			}
			
			if(buy_flag==1 && a[i]>a[i+1]) {
				buy_flag=0;
				sold=a[i];
				profit+=sold-bought;
			}
			i++;
		}
		if(buy_flag==1 && bought<a[a.length-1])
			profit+=a[a.length-1]-bought;
		
	return profit;
	
		
	}
	public static void main(String args[]) {
		int[] a = new int[]{1,5,3,6};
		System.out.println(computeForMultipleBuySells(a));
		System.out.println(computeForSingleBuyAndSell(a));
		
}}