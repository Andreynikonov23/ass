package ru.sapteh.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "warehouse")
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String adress;

    @OneToMany(mappedBy = "warehouse")
    private Set<Product> products;

    @Override
    public String toString() {
        return "Warehouse{" +
                "id=" + id +
                ", adress='" + adress + '\'' +
                '}';
    }
}
