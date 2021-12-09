import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Algorithm {
    public static void main(String[] args) {

        List<int[][]> testCaseList = new LinkedList<>();
        testCaseList.add(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        testCaseList.add(new int[][]{{9798, 0}, {178, 0}, {87, 1}, {86, 2},
                {78, 2}, {75, 2}, {64, 0}, {64, 7}, {53, 3}, {53, 6}, {42, 9},
                {34, 3}, {24, 2}, {24, 9}, {24, 14}, {8, 12}, {7, 11}});
        testCaseList.add(new int[][]{{554, 0}, {5245, 0}, {7354, 0}, {41, 1},
                {92, 1}, {3645, 1}, {5487, 1}, {478, 2}, {4123, 2}, {4435, 2},
                {4553, 2}, {4123, 3}, {746, 4}, {4125, 4}, {635, 5}, {645, 6},
                {325, 7}, {62, 8}, {67, 8}, {513, 9}, {83, 11}, {61, 13}, {73, 13},
                {78, 13}, {95, 13}, {458, 14}, {67, 15}, {84, 19}, {35, 26}, {13, 28}});

        for (int[][] testCase : testCaseList) {
            int[][] result = algorithm2(testCase);
            System.out.println(Arrays.deepToString(result));
        }

    }

    /**
     * 무작위한(random) 사람들의 대기열(queue)가 있습니다. 각각의 사람들은 (h, k)과 같은
     * 자연수의 쌍으로 표현이 됩니다. 여기서 h는 그 사람의 키이며, k는 이 사람보다 앞에있는 (h보다)
     * 키가 크거나 같은 사람들의 숫자입니다. 이 대기열(queue)를 다시 구성하는 알고리즘을
     * 작성해주십시오.
     * ● 대기열의 사람은 1,100명을 넘지 않습니다.
     *
     * @param queue
     * @return
     */
    private static int[][] algorithm2(int[][] queue) {

        // 조건을 기준으로 정렬
        Arrays.sort(queue, (i1, i2) -> {
            // 키가 같지 않으면 키를 기준으로 내림차순 비교
            if (i1[0] != i2[0]) {
                return i2[0] - i1[0];
            }
            // 키가 같으면 앞사람 숫자로 오름차순
            else {
                return i1[1] - i2[1];
            }
        });

        // 결과를 저장할 List (삽입에 용이한 LinkedList 선택)
        List<int[]> res = new LinkedList<>();

        // [1]값이 앞에 있는 사람의 숫자이기 때문에 해당 인덱스로 add
        for (int[] people : queue) {
            res.add(people[1], people);
        }

        // 다시 int[][]로 변환
        return res.toArray(new int[queue.length][]);
    }
}
