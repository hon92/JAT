package tables;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "UserTable")

public class User implements Serializable
{

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Employe provider;

    @OneToMany(mappedBy = "owner")
    private List<Account> accounts;

    private String name;
    private String lastName;
    private String email;
    private String passWord;

    public User()
    {
    }

    public Employe getProvider()
    {
        return provider;
    }

    public void setProvider(Employe provider)
    {
        this.provider = provider;
    }

    public List<Account> getAccounts()
    {
        return accounts;
    }

    public void setAccounts(List<Account> accounts)
    {
        this.accounts = accounts;
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

    public String getEmail()
    {
        return this.email;
    }

    public void setEmail(String aEmail)
    {
        this.email = aEmail;
    }

    public String getPassWord()
    {
        return this.passWord;
    }

    public void setPassWord(String aPassWord)
    {
        this.passWord = aPassWord;
    }

    public long getId()
    {
        return this.id;
    }

    public void setId(long aId)
    {
        this.id = aId;
    }
}
