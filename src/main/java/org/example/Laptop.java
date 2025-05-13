package org.example;

import jakarta.persistence.*;

//@Embeddable
//if we don't mention it we will get the JDBC Type error or Exception
// in thread "main" org.hibernate.type.descriptor.java.spi.JdbcTypeRecommendationException: Could not determine recommended JdbcType for Java type 'org.example.Laptop'
//Now we are going to see mapping
@Entity
@Cacheable
public class Laptop {
    @Id
    private int id;
    private String brand;
    private String name;
    private int ram;
//    @ManyToOne
//    private Coders coder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

//    public Coders getCoder() {
//        return coder;
//    }
//
//    public void setCoder(Coders coder) {
//        this.coder = coder;
//    }

    @Override
    public String toString() {
        return "Laptop{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", ram=" + ram +
                '}';
    }
}
