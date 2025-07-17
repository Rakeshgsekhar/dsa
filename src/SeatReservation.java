import java.util.PriorityQueue;

class PairSeat{
    int number;
    boolean isReserved;
    PairSeat(int number){
        this.number = number;
        isReserved = false;
    }
    public void reserve(int number){
        this.number = number;
        isReserved = true;
    }
}
class SeatManager {
    int availableSeats ;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public SeatManager(int n) {
        this.availableSeats = n;
        for(int i = 1;i<this.availableSeats;i++){
            pq.offer(i);
        }
    }

    public int reserve() {
        if(pq.size()==0)return -1;
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
public class SeatReservation {
}
