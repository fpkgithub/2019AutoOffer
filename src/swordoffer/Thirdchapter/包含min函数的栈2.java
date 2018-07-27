package swordoffer.Thirdchapter;

import java.util.ArrayList;

/**
 * 使用Arraylist实现
 */
public class 包含min函数的栈2
{
    private ArrayList<Integer> dataList = new ArrayList<>();
    //只存最小的  例如： 3 6 8 1 2   只存 3 1
    private ArrayList<Integer> minList = new ArrayList<>();
    private int min = Integer.MAX_VALUE;


    public void push(int data)
    {
        dataList.add(data);
        if (min >= data)
        {
            minList.add(data);
            min = data;
        }
        else
        {
            //即使大于存min 起到占位符的作用
            minList.add(min);
        }
    }

    public void pop()
    {
        dataList.remove(dataList.size() - 1);
        minList.remove(minList.size() - 1);
        min = minList.get(minList.size() - 1);
    }

    public int top()
    {
        return dataList.get(dataList.size() - 1);
    }

    public int min()
    {
        return min;
    }
}
