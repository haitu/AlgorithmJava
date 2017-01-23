package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution sol = new Solution();
		int t = sol.guessNumber(20);
		t = sol.guessNumber(10);
		
		int arr1[] = {1,4,5,10,20,21,0,0,0,0,0,0};
		
		int arr2[] = {2,4,10};
		sol.merge(arr1,6,arr2,3);
		
		sol.test();
		System.out.println("end of main");
	}
	
	public  void test()
	{
		int[][] matrix = new int[][]{{1}}; 
		spiralOrder(matrix);
		//testSet();
		List<List<Integer>>  listList = subsets(new int[]{1,2,3});
		print(listList);
		
		testSet1();
		
	}
	int countQ;
	public int totalNQueens(int n) {
	        countQ = 0;
	        
	        int usedColumns[] = new int[n];
	        placeQueen(n,usedColumns,0);
	        return countQ;
	}
	void placeQueen(int n,int usedColumns[],int row)
	{
		if(row == n)
		{
			countQ ++;
			return;
		}
		for(int i = 0;i < n;i ++)
		{
			if(isValid(usedColumns,row,i))
			{
				usedColumns[row] = i;
				placeQueen(n,usedColumns,row + 1);
			}
		}
		
	}
	boolean isValid(int[] usedColumns,int row,int column)
	{
		for(int i = 0;i < row;i ++)
		{
			if(usedColumns[i] == column || Math.abs(usedColumns[i] - column) == Math.abs(row - i))
			{
				return false;
			}
		}
		return true;
	}
	
	
	public int search(int[] nums, int target) {
		 int index = SearchIndex(nums);
         int bsL = BinarySearch(nums,0,index - 1, target);
         if(bsL >= 0)
         {
             return bsL;
         }
         bsL = BinarySearch(nums, index, nums.length - 1, target);
         if (bsL >= 0)
         {
             return bsL;
         }
         return -1;
    }
	int BinarySearch(int []a,int l, int r, int target)
    {
        while(l <= r)
        {
            int m = (r - l) / 2 + l;
            if(target == a[m])
            {
                return m;
            }else if (target < a[m])
            {
                r = m - 1;
            }else
            {
                l = m + 1;
            }
        }
        return -1;
    }
    int SearchIndex(int []a)
    {
        int l = 0, r = a.length - 1;
        while(r - l  > 2)
        {
            int m = (r - l) / 2 + l;
            if(a[m- 1] < a[m] && a[m] < a[m + 1])
            {
                if(a[m] > a[r])
                {
                    l = m ;
                }
                else
                {
                    r = m;
                }
            }else
            {
                return FindIndex(a, m -1, m + 1);
            }
        }
        return FindIndex(a, l, r);

    }
    int FindIndex(int []a,int l, int r)
    {
        if(r - l == 1)
        {
            if (a[r] > a[l])
                return l;
            else
                return r;
        }
        if(r - l == 2)
        {
            if(a[l] < a[l + 1] && a[l + 1] < a[r])
            {
                return r < a.length - 1 ? r + 1 : 0;
            }
            else if(a[l] > a[l + 1] && a[l + 1] > a[r])
            {
                return l > 0 ? l - 1 : 0;
            }else  if(a[l] < a[l + 1] && a[l + 1] > a[r])
            {
                return r;
            }
            else if (a[l] > a[l + 1] && a[l + 1] < a[r])
            {
                return l  + 1;
            }
        }
        return l;
    }
	
//    public boolean search(int[] nums, int target) {
//    	
//    	return false;
//    }
    int FindSplitPosition(int[] nums)
    {
    	int l = 0;
    	int r = nums.length - 1;
    	while(l < r)
    	{
    		int m = (r - l)/2 + l;
    		if(nums[m - 1] <= nums[m] && nums[m] <= nums[m + 1])
    		{
    			
    			if(nums[m] < nums[r])
    			{
    				r = m;
    			}else
    			{
    				l = m;
    			}
    		}else
    		{
    			return m;
    		}
    	}
    	return r + 1;
    }
	
	void print(List<List<Integer>> listlist)
	{
		for(List<Integer> list : listlist)
		{
			System.out.println(list);
		}
	}
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> listList = new ArrayList<List<Integer>>();
		
		backTracking(nums,0,listList,new ArrayList<Integer>());
		return listList;
    }
	void backTracking(int[] nums,int start,List<List<Integer>> listList,List<Integer> tmpList)
	{
		listList.add(new ArrayList<Integer>(tmpList));
		for(int i = start;i < nums.length;i ++)
		{
			tmpList.add(nums[i]);
			backTracking(nums,i + 1,listList,tmpList);
			tmpList.remove(tmpList.size() - 1);
		}
		
	}
	void testSet1()
	{
		System.out.println("------------Join array -----------");
		ArrayList<String> arL1 =new ArrayList<String>();
		ArrayList<String> arL2 =new ArrayList<String>();
		ArrayList<String> arL =new ArrayList<String>();
		arL1.add("s1");
		arL1.add("s2");
		arL1.add("s3");
		
		arL2.add("s21");
		arL2.add("s22");
		arL2.add("s22");
		arL.addAll(arL1);
		arL.addAll(arL2);
		System.out.println(arL);
		
	}
	void testSet()
	{
		//http://beginnersbook.com/2014/08/difference-between-hashset-and-treeset/
		HashSet<String> hs = new HashSet<String>();
		hs.add("Hai");
		hs.add("Tu");
		hs.add("Hai");
		for(String s: hs)
		{
			System.out.println(s);
		}
		System.out.println("--------");
		
		//Tree Set: log(n) for operations
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("Tu");
		ts.add("Minh");
		ts.add("Hai");
		ts.add("Truc");
		ts.add("Phuong");
		
		for(String s: ts)
		{
			System.out.println(s);
		}
		
		HashMap<Integer,String> hMap = new HashMap<Integer,String>();
		hMap.put(1, "Hello");
		hMap.put(2, "World");
		hMap.put(2, "World1");
		hMap.put(1, "Hello1");
		if(hMap.containsKey(1))
		{
			System.out.println("Has: " + hMap.get(1));
		}
		// TreeMap,ordered by key
		TreeMap<Integer,String> treeMap = new TreeMap<Integer,String>();
		treeMap.put(10, "Test1");
		treeMap.put(11, "Test");
		treeMap.put(9, "Hello");
		Set set1 = treeMap.entrySet();
		Iterator it = set1.iterator();
		
		System.out.println("--------");
		
		while(it.hasNext())
		{
			Map.Entry et = (Map.Entry)it.next();
			System.out.println(et.getValue());
		}
		
		System.out.println("--------LinkedHashSet--------Preserver insertion order");
		LinkedHashSet<Integer> linkedHs = new LinkedHashSet<Integer>();
		linkedHs.add(10);
		linkedHs.add(9);
		linkedHs.add(11);
		for(Integer i : linkedHs)
		{
			System.out.println(i);
		}
		
		System.out.println("--------LinkedList------------");
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("Tu");
		linkedList.add("Minh");
		linkedList.add("Hai");
		ListIterator lit = linkedList.listIterator();
		while(lit.hasNext())
		{
			lit.next();
		}
		
		while(lit.hasPrevious())
		{
			System.out.println(lit.previous());
		}
		
		System.out.println("--------ArrayList------------");
		ArrayList<String> arrL = new ArrayList<String>();
		arrL.add("Tran");
		arrL.add("Thi");
		arrL.add("truc");
		arrL.add("Phuong");
		for(int i = 0;i < arrL.size();i ++)
		{
			System.out.println(arrL.get(i));
		}
	}
	
	public List<Integer> spiralOrder(int[][] matrix)
    {
		int len0 = matrix.length;
		
		if(len0 == 0) return new  ArrayList<Integer>();
		
		int len1 = matrix[0].length;
		
		List<Integer> list =  Arrays.asList(new Integer[len0 * len1]);
        int index = 0;
        
        int rTop = 0, cLeft = 0, rBottom = len0 - 1, cRight = len1 - 1;
        
        while(rBottom - rTop > 0 && cRight - cLeft > 0 )
        {
            
            for(int i = cLeft; i <= cRight; i++)
            {
                list.set(index ++, matrix[rTop][ i]) ;
            }
            for (int i = rTop + 1; i <= rBottom; i++)
            {
                list.set(index++, matrix[i][ cRight]);
            }

            for (int i = cRight - 1; i >= cLeft; i--)
            {
                list.set(index++ , matrix[rBottom][ i]);
            }
            
            for (int i = rBottom - 1; i > rTop; i--)
            {
                list.set(index++ , matrix[i][ cLeft]);
            }
            rTop++;
            cLeft++;

            rBottom--;
            cRight--;
        }
        
        if (rBottom - rTop >= 0 && cRight - cLeft == 0)
        {
            for (int i = rTop; i <= rBottom; i ++)
            {
                list.set(index++ , matrix[i][cLeft]);
            }
        }
        else if (cRight - cLeft >= 0 && rBottom - rTop == 0)
        {
            for (int i = cLeft; i <= cRight; i++)
            {
                list.set(index++ , matrix[rTop][ i]);
            }
        }

        return list;
    }
	
	
	public void merge(int[] nums1, int m, int[] nums2, int n)
    {
        MoveToEnd(nums1, m);
        int i = nums1.length - m;
        int j = 0;
        int k = 0;
        while(i < nums1.length && j < n)
        {
            if(nums1[i] <= nums2[j])
            {
                nums1[k++] = nums1[i ++];
            }else
            {
                nums1[k++] = nums2[j++];
            }
        }
        while(i < nums1.length)
        {
            nums1[k++] = nums1[i++];
        }
        while(j < n)
        {
            nums1[k++] = nums2[j++];
        }
    }
    void MoveToEnd(int[] nums1, int m)
    {
        int i = nums1.length - 1;
        while(m > 0)
        {
            nums1[i--] = nums1[--m];
        }
    }
    
    
	public int guessNumber(int n) {
		
		int low = 1;
		int high = n;
		while(low <= high)
		{
			int mid = low+((high-low)/2);
			int guessN = guess(mid);
			if(guessN < 0) {
				
				high = mid - 1;
			}
			else if(guessN > 0) {
				
				low = mid + 1;
			}
			else
				return mid;
		}
		return 0;
    }
	int finalNum = 6;
	int guess(int num)
	{
		if(num < finalNum) return -1;
		if(num > finalNum) return 1;
		
		return 0;
	}
	public int[][] reconstructQueue(int[][] people) {
    
        if (people == null) return people;
        int pos = 0;
        int len = people.length;
        if (len == 0) return people;

        int[][] result = new int[len][ 2];
        qSort(people,0, len - 1);
        HashSet<Integer> hsAdded = new HashSet<Integer>();
        for (; pos < len; pos++)
        {
            for (int i = 0; i < len; i++)
            {
                if (!hsAdded.contains(i))
                {
                    if (IsFit(people[i][ 0], people[i][ 1], result, pos))
                    {
                        result[pos][ 0] = people[i][ 0];
                        result[pos][ 1] = people[i][ 1];
                        hsAdded.add(i);
                        break;
                    }
                }
            }
        }
        return result;
    
	}
    public void qSort(int[][] elements, int left, int right)
    {
        int i = left, j = right;
        int pivot = elements[(left + right) / 2][0];

        while (i <= j)
        {
            while (elements[i][0] < pivot)
            {
                i++;
            }

            while (elements[j][0] > pivot)
            {
                j--;
            }

            if (i <= j)
            {
                // Swap
                Swap(elements, i, j);
                i++;
                j--;
            }
        }

        // Recursive calls
        if (left < j)
        {
            qSort(elements, left, j);
        }

        if (i < right)
        {
            qSort(elements, i, right);
        }
    }
    void Swap(int [][] elements,int i, int j)
    {
        int tmp = elements[i][ 0];
        elements[i][ 0] = elements[j][ 0];
        elements[j][ 0] = tmp;

        tmp = elements[i][1];
        elements[i][ 1] = elements[j][ 1];
        elements[j][ 1] = tmp;
    }
    boolean IsFit(int h, int numHigher, int[][] result, int size)
    {
        int count = 0;
        for (int i = 0; i < size; i++)
        {
            if (result[i][0] >= h)
            {
                count++;
                if (count > numHigher) return false;
            }
        }
        return count == numHigher;
    }

}
