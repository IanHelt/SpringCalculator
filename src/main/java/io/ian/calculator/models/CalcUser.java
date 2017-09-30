package io.ian.calculator.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "calcusers")
public class CalcUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String name;

    @OneToMany(mappedBy = "calcUser")
    private List<OperationClass> operations;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OperationClass> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationClass> operations) {
        this.operations = operations;
    }
}
