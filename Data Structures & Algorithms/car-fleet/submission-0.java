
class Car {
    int position;
    double timetotarget;

    Car(int position, double timetotarget) {
        this.position = position;
        this.timetotarget = timetotarget;
    }
}

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            double time = (target - position[i]) * 1.0 / speed[i];
            cars[i] = new Car(position[i], time);
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a.position, b.position));

        int fleets = 1;

        for (int i = n - 1; i > 0; i--) {
            if (cars[i].timetotarget >= cars[i - 1].timetotarget) {
                // Left car joins the fleet ahead
                cars[i - 1] = cars[i];
            } else {
                // New fleet
                fleets++;
            }
        }

        return fleets;
    }
}