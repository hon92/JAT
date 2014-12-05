package tables;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EmployeTable")
@NamedQueries(
        {
            @NamedQuery(name = "Employe.loginAndPassword", query = "SELECT e FROM Employe e WHERE e.name = :login AND e.passWord = :password")

        })

public class Employe implements Serializable
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "provider")
    public List<User> customers;

    private String name;
    private String lastName;
    private Integer salary;
    private Date startDate;
    private String passWord;

    public Employe()
    {
    }

    public String getPassWord()
    {
        return passWord;
    }

    public void setPassWord(String passWord)
    {
        this.passWord = passWord;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public List<User> getCustomers()
    {
        return customers;
    }

    public void setCustomers(List<User> customers)
    {
        this.customers = customers;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String aName)
    {
        this.name = aName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setLastName(String aLastName)
    {
        this.lastName = aLastName;
    }

    public Integer getSalary()
    {
        return this.salary;
    }

    public void setSalary(Integer aSalary)
    {
        this.salary = aSalary;
    }

    public Date getStartDate()
    {
        return this.startDate;
    }

    public void addUser(User aNewUser)
    {
        throw new UnsupportedOperationException();
    }

    public void removeUser(User aUserToRemove)
    {
        throw new UnsupportedOperationException();
    }

    public void setId(long aId)
    {
        this.id = aId;
    }
}
