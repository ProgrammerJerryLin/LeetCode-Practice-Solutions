/**Auther: Wenhao Lin
 *Question: 
 *Given an array with n integers, your task is to check if it could become non-decreasing by     *modifying at most 1 element.We define an array is non-decreasing if array[i] <= array[i + 1]  * *holds for every i (1 <= i < n).
 *
 *Example 1:
 *Input: [4,2,3]
 *Output: True
 *Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 *
 *Example 2:
 *Input: [4,2,1]
 *Output: False
 *Explanation: You can't get a non-decreasing array by modify at most one element.
 */

class Solution {
      public boolean checkPossibility(int[] nums) {
      	     boolean answer = true;
             boolean firstTime=true;
             for(int i= 1; i < nums.length; i++){
             	 if(nums[i]<nums[i-1]&&firstTime==true){
                     if(i==1) nums[i-1]=1;            //example: [5,1,2,3],i=1change i=0 to smallest number(1)
                     else if(nums[i-1]==nums[i-2]||nums[i]<nums[i-2]){//example: i=3 [1,3,3,2] or [1,3,5,2]
                     	   nums[i]=nums[i-1];      
                     }else if(nums[i]>=nums[i-2]){//example:i=3 [1,3,7,5]
                           nums[i-1]=nums[i-2];
                     }
                     firstTime=false;
                 }else if(nums[i]<nums[i-1] && firstTime==false){
                     answer=false;
                     break;
                 }
             }
             return answer;
      }
}
//Note:Iterate through array, if find a descrease fix it. then continue, if find a descrease a again, break 
//return false;
//When find a descrease, fix the either the number on index i or index i-1;
//if i =1, set i=0 to 1(the smallest)
//else if:i-1==i-2 or i< i-2; set i=i-1;
//else if:i >= i-2; set i-1=i-2
//basically three cases:  i-1==i-2; i<i-2; i>=i-2: NOTE:i always < i-1, so we dont need to check that,that's the //condition for it to enter into the first if
