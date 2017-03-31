package practice.algos;


public class UniqueIdGenerator {

    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        long machineid = 34434343243L;
        int sequence = 3;

        System.out.println("currentTime:" + currentTime);

        //Twitter snowflake : 41 bits (timestamp) + 10 bits (configurable machine id) + 12 bits (Sequence number)
        //k-ordered unique ids
        long uniqueId = currentTime << 22
                        | machineid << 12
                        | sequence;

        System.out.println(uniqueId);


    }
}
