package io.ian.calculator.models;

import javax.persistence.*;

@Entity
@Table(name = "operations")
public class OperationClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String equation;

    @ManyToOne
    @JoinColumn(name = "userid")
    private CalcUser calcUser;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }

    public CalcUser getCalcUser() {
        return calcUser;
    }

    public void setCalcUser(CalcUser calcUser) {
        this.calcUser = calcUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
