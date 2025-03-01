package net.dvt32;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
@NamedQuery(query = "select e from Employee e where e.age > :age order by e.name", name = "emp name and age asc")
@NamedQuery(query = "select e from Employee e order by e.name", name = "emp name asc")
public class Employee {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "employeename", length = 120)
    private String name;

    private int age;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Temporal(TemporalType.TIME)
    private Date dob;

    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;

    @Transient
    private String debugString;

    @OneToOne
    private AccessCard card;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE)
    private List<PayStub> payStub = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "EMAIL_GROUP_SUBSCRIPTIONS",
        joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
        inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_EMAIL_ID")
    )
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public List<PayStub> getPayStub() {
        return payStub;
    }

    public void setPayStub(List<PayStub> payStub) {
        this.payStub = payStub;
    }

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public void addPayStub(PayStub payStub) {
        this.payStub.add(payStub);
    }

    public void addEmailSubscription(EmailGroup group) {
        this.emailGroups.add(group);
    }

    @Override
    public String toString() {
        return "Employee{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", type=" + type +
            ", dob=" + dob +
            ", ssn='" + ssn + '\'' +
            ", card=" + card +
            '}';
    }
}
