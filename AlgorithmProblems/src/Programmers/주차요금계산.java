package Programmers;

import java.util.*;

class 주차요금계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer, Car> cars = new HashMap<>();
        List<Integer> carNums = new ArrayList<>();

        for (String record : records) {
            String[] re = record.split(" ");
            int[] time = Arrays.stream(re[0].split(":")).mapToInt(Integer::parseInt).toArray();
            int t = time[0] * 60 + time[1];
            int carNum = Integer.parseInt(re[1]);

            if (!cars.containsKey(carNum)) {
                cars.put(carNum, new Car());
                carNums.add(carNum);
            }

            Car car = cars.get(carNum);

            if (car.in) {
                car.time += t;
                car.in = false;
            } else {
                car.time -= t;
                car.in = true;
            }
        }

        for (int carNum : carNums) {
            if (cars.get(carNum).in) {
                cars.get(carNum).time += 23 * 60 + 59;
            }
        }

        int[] result = new int[carNums.size()];
        Collections.sort(carNums);

        for (int i = 0; i < carNums.size(); i++) {
            result[i] = totalFee(cars.get(carNums.get(i)).time, fees);
        }

        return result;
    }

    class Car {
        int time = 0;
        boolean in = false;
    }

    int totalFee(int time, int[] fees) {

        int totalFee = fees[1];
        time -= fees[0];

        while (time > 0) {
            totalFee += fees[3];
            time -= fees[2];
        }

        return totalFee;
    }
}