package org.example;

import jakarta.persistence.*;

import java.util.List;

//@Entity(name="SmartCoders") it will create a new table with SmartCoders
//@Table(name="code") it will create a new table with name code
@Entity
public class Coders {
    @Id
    private int cId;
    private int cRollNo;
//    @Column(name="names") it will change the column name from cName --> names
    private String cName;
//    There is an annotation called @Transient it will help us to not store in the table or database
//    @Transient
//    private String cAddress;

    // Now we are to know about embeddable
    //@OneToOne
    @OneToMany//@OneToMany(fetch = FetchType.EAGER)
    private List<Laptop> laptop;

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getcRollNo() {
        return cRollNo;
    }

    public void setcRollNo(int cRollNo) {
        this.cRollNo = cRollNo;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Coders{" +
                "cId=" + cId +
                ", cRollNo=" + cRollNo +
                ", cName='" + cName + '\'' +
                ", laptop=" + laptop +
                '}';
    }
}
