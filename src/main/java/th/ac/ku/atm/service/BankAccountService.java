package th.ac.ku.atm.service;

import org.springframework.stereotype.Service;
import th.ac.ku.atm.model.BankAccount;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BankAccountService {

    private List<BankAccount> bankAccountsList;

    @PostConstruct
    public void postConstruct() {
        this.bankAccountsList = new ArrayList<>();
    }

    public List<BankAccount> getBankAccounts() {
        return new ArrayList<>(this.bankAccountsList);
    }

    public void createBankAccount(BankAccount bankAccount) {
        bankAccountsList.add(bankAccount);
    }
}
