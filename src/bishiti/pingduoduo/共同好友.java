package bishiti.pingduoduo;

import java.util.*;

public class 共同好友 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        String[] arrCount = str.split("\\s+");

        int userCount = Integer.parseInt(arrCount[0]);
        int targetUser = Integer.parseInt(arrCount[1]);


        ArrayList<HashSet<Integer>> arrList = new ArrayList<>();

        for (int i = 0; i < userCount; i++) {
            str = scanner.nextLine();
            String[] userList = str.split("\\s+");
            HashSet<Integer> set = new HashSet<>();
            for (int j = 0; j < userList.length; j++) {
                set.add(Integer.parseInt(userList[j]));
            }
            arrList.add(set);
        }

        findFriend(arrList, userCount, targetUser);

        scanner.close();
    }

    private static void findFriend(ArrayList<HashSet<Integer>> arrList, int userCount, int targetUser) {
        //目标用户的朋友
        HashSet<Integer> targerSet = arrList.get(targetUser);
        int max = -1;
        int u = -1;//寄存最可能认识的用户id

        //依次与他朋友求交集.交集数量最多的就是
        for (int i = 0; i < userCount; i++) {
            if (i == targetUser)
                continue;

            //当前的用户朋友
            HashSet<Integer> curSet = arrList.get(i);
            curSet.retainAll(targerSet);

            /*HashSet<Integer> jiaoji = new HashSet<>();
            jiaoji.addAll(targerSet);

            //求交集targerSet  curSet
            jiaoji.retainAll(curSet);*/

            int sum = curSet.size();
            if (sum > max) {
                max = sum;
                u = i;
            }

        }
        if (max == -1)
            System.out.println(-1);
        else
            System.out.println(u);

    }
}
