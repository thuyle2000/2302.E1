/*  mo ta cau truc bang tbBatch  */
package entity;

public class Batch {
    public String batchno, description;
    public int fee;

    public Batch() {
    }

    public Batch(String batchno, String description, int fee) {
        this.batchno = batchno;
        this.description = description;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %d", batchno, description, fee);
    }
}
